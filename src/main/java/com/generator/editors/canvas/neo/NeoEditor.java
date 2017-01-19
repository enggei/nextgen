package com.generator.editors.canvas.neo;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import com.generator.editors.canvas.BaseEditor;
import com.generator.editors.canvas.BasePNode;
import com.generator.editors.canvas.RelationPath;
import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.event.TransactionData;
import org.neo4j.graphdb.event.TransactionEventHandler;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.factory.GraphDatabaseSettings;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import java.io.*;
import java.util.*;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.NeoModel.getNameOrLabelFrom;
import static com.generator.editors.NeoModel.uuidOf;

/**
 * goe on 11/16/16.
 */
public abstract class NeoEditor extends BaseEditor<NeoPNode, NeoRelationshipPath> implements TransactionEventHandler<Object> {

   // model-state
   protected NeoModel graph;

   private final Properties properties = new Properties();
   private final File propertiesFile = new File(System.getProperty("user.home"), "/.nextgen/app.properties");
   private String currentDir = System.getProperty("user.home");

   private Node lastLayoutSaved = null;
   private final Map<Long, UUID> neoRelationPaths = new LinkedHashMap<>();
   public static final RelationshipType layoutMember = RelationshipType.withName("_layoutMember");

   private final Set<Long> deletedNodes = new LinkedHashSet<>();
   private final Set<Long> deletedRelations = new LinkedHashSet<>();
   private final Map<Long, Map<String, UUID>> addedRelations = new LinkedHashMap<>();

   public NeoEditor() {

      FileUtil.tryToCreateFileIfNotExists(propertiesFile);
      if (propertiesFile != null && propertiesFile.exists()) {
         try {
            this.properties.load(new BufferedReader(new FileReader(propertiesFile)));
         } catch (IOException e) {
            System.out.println("Could not open properties file " + propertiesFile);
         }
      }

      for (Map.Entry<Object, Object> property : properties.entrySet()) {
         System.out.println(property.getKey() + " = " + property.getValue());
      }

      final String database = this.properties.getProperty("database", null);
      if (database != null && new File(database).exists()) {

         setGraph(newEmbeddedDatabase(database));

         final String lastLayout = properties.getProperty("last.layout");
         if (lastLayout != null) {
            doInTransaction(tx -> {
               final Node layoutNode = getGraph().getNode(UUID.fromString(lastLayout));
               if (layoutNode != null) loadLayout(layoutNode, "autoload").actionPerformed(null);
            });
         }
      }
   }

   public void setGraph(NeoModel graph) {

      if (this.graph != null) this.graph.getGraphDb().unregisterTransactionEventHandler(this);

      reset();

      this.graph = graph;
      this.graph.getGraphDb().registerTransactionEventHandler(this);
   }

   public NeoModel getGraph() {
      return graph;
   }

   @Override
   public Object beforeCommit(TransactionData transactionData) throws Exception {

      transactionData.deletedNodes().forEach(node -> deletedNodes.add(node.getId()));

      transactionData.deletedRelationships().forEach(relationship -> deletedRelations.add(relationship.getId()));

      transactionData.createdRelationships().forEach(relationship -> {
         final Map<String, UUID> pair = new LinkedHashMap<>();
         pair.put("src", uuidOf(relationship.getStartNode()));
         pair.put("dst", uuidOf(relationship.getEndNode()));
         addedRelations.put(relationship.getId(), pair);
      });

      return null;
   }

   @Override
   public void afterCommit(TransactionData transactionData, Object o) {

      deletedNodes.forEach(id -> {
         final Collection<NeoPNode> values = new ArrayList<>(layerNodes.values());
         values.stream().filter(t -> t.neoId.equals(id)).forEach(t -> {
            System.out.println("removing from canvas " + t);
            removeNodeFromCanvas(t.uuid);
         });
      });
      deletedNodes.clear();

      deletedRelations.forEach(relationshipId -> {

         final UUID removed = neoRelationPaths.remove(relationshipId);
         final RelationPath neoRelationshipPath = layerRelations.remove(removed);

         if (neoRelationshipPath != null) {
            relationLayer.removeChild(neoRelationshipPath.path());
            neoRelationshipPath.path().removeFromParent();
         }
      });
      deletedRelations.clear();

      addedRelations.forEach((aLong, stringUUIDMap) -> System.out.println("relation " + aLong + " " + stringUUIDMap.get("src") + " -> " + stringUUIDMap.get("dst")));
      addedRelations.clear();

      SwingUtilities.invokeLater(canvas::repaint);
   }

   @Override
   public void afterRollback(TransactionData transactionData, Object o) {
      deletedNodes.clear();
   }

   @Override
   public NeoPNode show(UUID uuid, String nodetype) {

      if (layerNodes.containsKey(uuid)) {
         layerNodes.get(uuid).updateView();
         return layerNodes.get(uuid);
      }

      final Node node = graph.getNode(uuid);
      if (node == null) return null;

      NeoPNode newInstance;
      layerNodes.put(uuid, newInstance = newNode(node, nodetype));

      newInstance.addPropertyChangeListener(this);
      nodeLayer.addChild(newInstance.pNode);
      return newInstance;
   }

   @SuppressWarnings("unchecked")
   public NeoPNode newNode(Node node, String nodetype) {
      return new NeoPTextNode(node, NeoEditor.this);
   }

   public abstract void deleteNode(Node node) throws NeoEditor.ReferenceException;

   @Override
   public void mouseClicked(PInputEvent event) {
      super.mouseClicked(event);

      if (event.isRightMouseButton()) {
         SwingUtilities.invokeLater(() -> {
            final JPopupMenu pop = new JPopupMenu();
            pop.add(new AbstractAction("Database") {
               @Override
               public void actionPerformed(ActionEvent e) {

                  final File dir = SwingUtil.showOpenDir(SwingUtilities.getWindowAncestor(canvas), currentDir);
                  if (dir == null) return;

                  SwingUtilities.invokeLater(() -> {
                     canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                     if (graph != null) {
                        System.out.println("shutting down existing graph");
                        graph.close();
                     }

                     System.out.println("opening database " + dir.getAbsolutePath());

                     currentDir = dir.getAbsolutePath();
                     setGraph(newEmbeddedDatabase(currentDir));
                     properties.setProperty("database", currentDir);
                     saveProperties();

                     canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                  });
               }
            });

            if (graph != null)
               doInTransaction(tx -> {
                  addToMenu(pop, event);
               });

            pop.show(canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
         });
      }
   }

   private void saveProperties() {
      try {
         properties.store(new FileWriter(propertiesFile), "autosave");
      } catch (IOException e) {
         System.out.println("Could not save properties to " + propertiesFile.getAbsolutePath());
      }
   }

   private static NeoModel newEmbeddedDatabase(String dir) {
      return new NeoModel(new GraphDatabaseFactory().
            newEmbeddedDatabaseBuilder(new File(dir)).
            setConfig(GraphDatabaseSettings.allow_store_upgrade, "true").
            newGraphDatabase(),
            model -> System.out.println("graph closed"));
   }

   @Override
   protected void addToMenu(JPopupMenu pop, PInputEvent event) {

      if (!selectedNodes.isEmpty()) {
         pop.add(retainSelected());
         pop.add(hideSelected());
         pop.add(unselectAll());
      }
      if (!layerNodes.isEmpty())
         pop.add(selectAll());

      final JMenu layoutMenu = new JMenu("Layout");
      final JMenu loadLayoutsMenu = new JMenu("Load ");
      final JMenu saveLayoutsMenu = new JMenu("Save ");
      final JMenu deleteLayoutsMenu = new JMenu("Delete ");
      graph.findNodes(() -> NeoModel.TAG_LAYOUT).
            forEachRemaining(node -> {
               final String name = getString(node, "name");
               loadLayoutsMenu.add(loadLayout(node, name));
               saveLayoutsMenu.add(saveLayout(node, name));
               deleteLayoutsMenu.add(deleteLayout(node, name));
            });
      if (!layerNodes.isEmpty()) layoutMenu.add(saveNewLayout());
      if (loadLayoutsMenu.getMenuComponentCount() > 0) layoutMenu.add(loadLayoutsMenu);
      if (!layerNodes.isEmpty() && saveLayoutsMenu.getMenuComponentCount() > 0) layoutMenu.add(saveLayoutsMenu);
      if (deleteLayoutsMenu.getMenuComponentCount() > 0) layoutMenu.add(deleteLayoutsMenu);
      if (layoutMenu.getMenuComponentCount() <= 0) return;
      pop.add(layoutMenu);

      if (lastLayoutSaved != null) {
         final String name = getString(lastLayoutSaved, "name");
         pop.add(saveLayout("Save '" + name + "'", lastLayoutSaved, name));
      }

      pop.add(new ToggleRelationLabels());
      pop.add(new HideUnconnectedNodes());

      super.addToMenu(pop, event);
   }

   private class ToggleRelationLabels extends TransactionAction {
      ToggleRelationLabels() {
         super("Toggle relation names", graph, canvas);
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
         toggleRelationLabels();
      }
   }

   private class HideUnconnectedNodes extends AbstractAction {
      HideUnconnectedNodes() {
         super("Hide unconnected nodes");
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         SwingUtilities.invokeLater(() -> {

            final Set<NeoPNode> nodesToRemove = new LinkedHashSet<>(layerNodes.values());
            for (NeoRelationshipPath path : layerRelations.values()) {
               nodesToRemove.remove(path.source);
               nodesToRemove.remove(path.target);
            }

            for (NeoPNode pTextNeoPNode : nodesToRemove)
               removeNodeFromCanvas(pTextNeoPNode.uuid);

            canvas.repaint();
         });
      }
   }

   @Override
   protected void removeRelationFromCanvas(NeoRelationshipPath relation) {
      neoRelationPaths.remove(relation.relationship.getId());

      super.removeRelationFromCanvas(relation);
   }

   @Override
   protected void nodeAdded(NeoPNode instanceNode) {
      super.nodeAdded(instanceNode);

      SwingUtilities.invokeLater(() -> doInTransaction(tx -> {

         for (Relationship relationship : instanceNode.node.getRelationships(Direction.INCOMING)) {
            if (layerNodes.containsKey(uuidOf(other(instanceNode.node, relationship))) && !neoRelationPaths.containsKey(relationship.getId())) {
               final NeoPNode source = layerNodes.get(uuidOf(other(instanceNode.node, relationship)));
               addRelationToCanvas(new NeoRelationshipPath(source, instanceNode, relationship, showRelationLabels.get()));
            }
         }

         for (Relationship relationship : instanceNode.node.getRelationships(Direction.OUTGOING)) {
            if (layerNodes.containsKey(uuidOf(other(instanceNode.node, relationship))) && !neoRelationPaths.containsKey(relationship.getId())) {
               final NeoPNode target = layerNodes.get(uuidOf(other(instanceNode.node, relationship)));
               addRelationToCanvas(new NeoRelationshipPath(instanceNode, target, relationship, showRelationLabels.get()));
            }
         }

         canvas.repaint();
      }));
   }

   @Override
   public void addRelationToCanvas(NeoRelationshipPath relationshipPPath) {
      neoRelationPaths.put(relationshipPPath.relationship.getId(), relationshipPPath.uuid());
      super.addRelationToCanvas(relationshipPPath);
   }

   public Action showAllNodesByLabel(final Label label, PInputEvent event) {
      return new TransactionAction("Show all " + label, graph, canvas) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            graph.findNodes(label).forEachRemaining(node -> {

               if (uuidOf(node) == null) {
                  System.out.println("No uuid for Node (" + labelsFor(node) + ") [" + BaseDomainVisitor.printPropertiesFor(node) + "]");
                  return;
               }

               pNodes.put(uuidOf(node), label);
            });
            showAndLayout(pNodes, event.getCanvasPosition());
         }
      };
   }

   private Action saveNewLayout() {
      return new TransactionAction("New", graph, canvas) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String layoutName = SwingUtil.showInputDialog("Name", canvas);
            if (layoutName == null) return;

            final Node node = graph.newNode(NeoModel.TAG_LAYOUT, UUID.randomUUID(), "name", layoutName);

            for (BasePNode neoPNode : layerNodes.values()) {
               final Node graphNode = graph.mergeNode(neoPNode.uuid);
               final Point2D center2D = neoPNode.pNode.getFullBoundsReference().getCenter2D();
               final Relationship layoutMembership = node.createRelationshipTo(graphNode, layoutMember);
               layoutMembership.setProperty("x", center2D.getX());
               layoutMembership.setProperty("y", center2D.getY());
               layoutMembership.setProperty("nodeType", neoPNode.getNodeType());

               System.out.println("saving " + NeoModel.uuidOf(graphNode) + " : " + neoPNode.getClass().getSimpleName());
            }

            lastLayoutSaved = node;
         }
      };
   }

   @Override
   public void nodeMoved(UUID uuid) {
      super.nodeMoved(uuid);
      // todo make an auto-save for a default-layout
   }

   private Action saveLayout(final Node node, final String name) {
      return saveLayout(null, node, name);
   }

   private Action saveLayout(final String actionName, final Node node, final String name) {
      return new TransactionAction(actionName == null ? name : actionName, graph, canvas) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            // delete old members
            outgoing(node, layoutMember).forEach(Relationship::delete);

            // add visible nodes as members
            for (BasePNode neoPNode : layerNodes.values()) {
               final Node graphNode = graph.mergeNode(neoPNode.uuid);
               final Relationship layoutMembership = node.createRelationshipTo(graphNode, layoutMember);
               final Point2D center2D = neoPNode.pNode.getFullBoundsReference().getCenter2D();
               layoutMembership.setProperty("x", center2D.getX());
               layoutMembership.setProperty("y", center2D.getY());
               layoutMembership.setProperty("nodeType", neoPNode.getNodeType());

               System.out.println("saving " + NeoModel.uuidOf(graphNode) + " : " + neoPNode.getClass().getSimpleName());
            }

            lastLayoutSaved = node;
            properties.setProperty("last.layout", uuidOf(lastLayoutSaved).toString());
            saveProperties();
         }
      };
   }

   private Action loadLayout(final Node node, final String name) {
      return new TransactionAction(name, graph, canvas) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            properties.setProperty("last.layout", uuidOf(node).toString());
            saveProperties();

            outgoing(node, layoutMember).forEach(relationship -> {
               final Double x = Double.valueOf(relationship.getProperty("x").toString());
               final Double y = Double.valueOf(relationship.getProperty("y").toString());
               final String nodetype = relationship.getProperty("nodeType").toString();
               final Node otherNode = other(node, relationship);

               show(uuidOf(otherNode), nodetype).
                     setOffset(new Point2D.Double(x, y));
            });
         }
      };
   }

   private Action deleteLayout(final Node node, final String name) {
      return new TransactionAction(name, graph, canvas) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            outgoing(node, layoutMember).forEach(Relationship::delete);

            node.delete();
         }
      };
   }

   public void addRelation(Relationship newRelation) {

      final Node source = newRelation.getStartNode();
      final Node target = newRelation.getEndNode();

      final UUID sourceUUID = uuidOf(source);
      final UUID targetUUID = uuidOf(target);

      if (layerNodes.containsKey(sourceUUID) && layerNodes.containsKey(targetUUID) && !neoRelationPaths.containsKey(newRelation.getId()))
         addRelationToCanvas(new NeoRelationshipPath(layerNodes.get(sourceUUID), layerNodes.get(uuidOf(target)), newRelation, showRelationLabels.get()));

      SwingUtilities.invokeLater(canvas::repaint);
   }

   public interface Committer {

      void doAction(Transaction tx) throws Throwable;

   }

   public void doInTransaction(Committer committer) {

      graph.doInTransaction(new NeoModel.Committer() {
         @Override
         public void doAction(Transaction tx) throws Throwable {
            committer.doAction(tx);
         }

         @Override
         public void exception(Throwable throwable) {
            SwingUtil.showExceptionNoStack(SwingUtilities.getWindowAncestor(canvas), throwable);
         }
      });
   }

   public static abstract class TransactionAction extends AbstractAction {

      private final NeoModel graph;
      private final JComponent canvas;

      public TransactionAction(String name, NeoModel graph, JComponent canvas) {
         super(name);
         this.graph = graph;
         this.canvas = canvas;
      }

      @Override
      public void actionPerformed(ActionEvent e) {

         SwingUtilities.invokeLater(() -> {

            canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            if (graph == null) {

               try {
                  actionPerformed(e, null);
                  canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                  canvas.repaint();
               } catch (Exception throwable) {
                  canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                  exception(throwable);
               }

            } else {

               try (Transaction tx = graph.beginTx()) {
                  actionPerformed(e, tx);
                  tx.success();
                  canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                  canvas.repaint();
               } catch (ConstraintException throwable) {
                  canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                  JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(canvas), throwable, throwable.getMessage(), JOptionPane.ERROR_MESSAGE);
               } catch (Throwable throwable) {
                  canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                  exception(throwable);
               }
            }
         });
      }

      public abstract void actionPerformed(ActionEvent e, Transaction tx) throws Exception;

      void exception(Throwable throwable) {
         SwingUtil.showException(SwingUtilities.getWindowAncestor(canvas), throwable);
      }
   }

   static class ConstraintException extends Exception {

      ConstraintException(String message) {
         super(message);
      }
   }

   public static final class ReferenceException extends ConstraintException {

      final Node node;
      final Set<Relationship> constraints;
      final StringBuilder out = new StringBuilder();

      public ReferenceException(Node node, final Set<Relationship> constraints) {
         super("Constraint enforced for " + uuidOf(node));
         this.node = node;
         this.constraints = constraints;

         out.append("Node has ").append(constraints.size()).append(" references:");
         for (Relationship constraint : constraints) {
            out.append("\n").append(getNameOrLabelFrom(other(node, constraint))).append(" -> '").append(constraint.getType()).append("' -> ").append(getNameOrLabelFrom(node));
         }
      }

      @Override
      public String toString() {
         return out.toString();
      }
   }

   public static final class CircularStatementException extends ConstraintException {

      final Node node;
      final StringBuilder out = new StringBuilder();

      public CircularStatementException(Node node, Node referencedNode) {
         super("Circular reference constrained");
         this.node = node;
         out.append("Cannot have circular relations:\n");
         out.append("Referred node is already referring to this node:\n");
         out.append(NeoModel.debugNode(referencedNode)).append(" -> ").append(NeoModel.debugNode(node));
      }

      @Override
      public String toString() {
         return out.toString();
      }
   }


}