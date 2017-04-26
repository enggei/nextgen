package com.generator.editors.canvas.neo;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import com.generator.editors.canvas.BaseEditor;
import com.generator.editors.canvas.BasePNode;
import com.generator.editors.canvas.RelationPath;
import com.generator.generators.cypher.CypherGroup;
import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.event.TransactionData;
import org.neo4j.graphdb.event.TransactionEventHandler;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.factory.GraphDatabaseSettings;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.*;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.NeoModel.TAG_UUID;
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
   private static final RelationshipType layoutMember = RelationshipType.withName("_layoutMember");

   private final Set<Long> deletedNodes = new LinkedHashSet<>();
   private final Set<Long> deletedRelations = new LinkedHashSet<>();
   private final Map<Long, Map<String, UUID>> addedRelations = new LinkedHashMap<>();

   public NeoEditor() {
      super();

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
      if (node == null) {
         System.out.println("null node for graph.getNode(" + uuid + ")");
         return null;
      }

      NeoPNode newInstance = newNode(node, nodetype);
      if (newInstance == null) {
         System.out.println("unknown nodetype: " + nodetype);
         return null;
      }
      layerNodes.put(uuid, newInstance);

      newInstance.addPropertyChangeListener(this);
      nodeLayer.addChild(newInstance.pNode);
      return newInstance;
   }

   protected abstract NeoPNode newNode(Node node, String nodetype);

   public abstract void deleteNode(Node node) throws ReferenceException;

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
               doInTransaction(tx -> addToMenu(pop, event));

            pop.show(canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
         });
      }
   }

   @Override
   protected void addToMenu(JPopupMenu pop, PInputEvent event) {

      final JMenu hideMenu = new JMenu("Hide");
      for (Map.Entry<String, Set<UUID>> entry : nodesByLabel.entrySet()) {
         if (entry.getValue().isEmpty()) continue;
         hideMenu.add(new NeoEditor.HideByLabels(entry.getKey(), this));
      }
      if (hideMenu.getMenuComponentCount() > 0) pop.add(hideMenu);

      if (!selectedNodes.isEmpty()) {
         pop.add(retainSelected());
         pop.add(hideSelected());
         pop.add(unselectAll());
      }
      if (!layerNodes.isEmpty())
         pop.add(selectAll());

      pop.add(importFromExport());

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

      pop.add(new ToggleRelationLabels(this));
      pop.add(new HideUnconnectedNodes());

      super.addToMenu(pop, event);
   }

   public static void removeFromLayouts(Node node) {
      for (Relationship layout : incoming(node, layoutMember))
         layout.delete();
   }


   private class ToggleRelationLabels extends TransactionAction {
      ToggleRelationLabels(NeoEditor editor) {
         super("Toggle relation names", editor);
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
         toggleRelationLabels();
      }
   }

   public class HideByLabels extends NeoEditor.TransactionAction {

      private final org.neo4j.graphdb.Label label;

      HideByLabels(String label, NeoEditor editor) {
         super("Hide " + label, editor);
         this.label = () -> label;
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

         final Set<UUID> hide = new LinkedHashSet<>();
         editor.layerNodes.values().forEach(pNode -> {
            if (pNode.node.hasLabel(label)) hide.add(pNode.uuid);
         });
         hide.forEach(editor::removeNodeFromCanvas);
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
               addRelationToCanvas(new NeoRelationshipPath(source, instanceNode, relationship, paintRelationStatus));
            }
         }

         for (Relationship relationship : instanceNode.node.getRelationships(Direction.OUTGOING)) {
            if (layerNodes.containsKey(uuidOf(other(instanceNode.node, relationship))) && !neoRelationPaths.containsKey(relationship.getId())) {
               final NeoPNode target = layerNodes.get(uuidOf(other(instanceNode.node, relationship)));
               addRelationToCanvas(new NeoRelationshipPath(instanceNode, target, relationship, paintRelationStatus));
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
      return new TransactionAction("Show all " + label, this) {
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
      return new TransactionAction("New", this) {
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
      return new TransactionAction(actionName == null ? name : actionName, this) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            // delete old members
            outgoing(node, layoutMember).forEach(Relationship::delete);

            // add visible nodes as members
            for (BasePNode neoPNode : layerNodes.values()) {
               final Node graphNode = graph.mergeNode(neoPNode.uuid);
               final Relationship layoutMembership = node.createRelationshipTo(graphNode, layoutMember);
               final Rectangle2D rectangle2D = neoPNode.pNode.getFullBoundsReference().getBounds2D();
               layoutMembership.setProperty("x", rectangle2D.getX());
               layoutMembership.setProperty("y", rectangle2D.getY());
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
      return new TransactionAction(name, this) {
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
      return new TransactionAction(name, this) {
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
         addRelationToCanvas(new NeoRelationshipPath(layerNodes.get(sourceUUID), layerNodes.get(uuidOf(target)), newRelation, paintRelationStatus));

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

      protected final NeoModel graph;
      protected final JComponent canvas;
      protected final NeoEditor editor;

      public TransactionAction(String name, NeoEditor editor) {
         super(name);
         this.graph = editor.getGraph();
         this.canvas = editor.getCanvas();
         this.editor = editor;
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

   public NeoEditor.TransactionAction newAddNodeAction(Label label, String property, final PInputEvent event) {
      return new NeoEditor.TransactionAction("New " + label.name(), this) {

         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog(property, canvas);
            if (name == null) return;

            final Node node = graph.newNode(label);
            node.setProperty(property, name);

            editor.show(NeoModel.uuidOf(node), label.name()).setOffset(event);
         }
      };
   }

   public Action newAddNodeAction(Label entity, String aliasName, String property, RelationshipType relation, NeoPNode pNode, PInputEvent event) {
      return new NeoEditor.TransactionAction("Add " + aliasName, this) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = property == null ? null : SwingUtil.showInputDialog(property, editor.canvas);
            if (property != null && name == null) return;

            final Node newNode = editor.getGraph().newNode(entity);
            if (property != null) newNode.setProperty(property, name);
            pNode.node.createRelationshipTo(newNode, relation);

            editor.show(uuidOf(newNode), entity.name()).
                  setOffset(event);

            pNode.updateView();
         }
      };
   }

   public Action newAddNodeAction(Label entity, String property, RelationshipType relation, NeoPNode pNode, PInputEvent event) {
      return newAddNodeAction(entity, entity.name(), property, relation, pNode, event);
   }

   public Action newAddNodeAction(Label entity, RelationshipType relation, NeoPNode pNode, PInputEvent event) {
      return newAddNodeAction(entity, entity.name(), null, relation, pNode, event);
   }

   public Action newSetNodePropertyAction(String property, NeoPNode<PText> pNode) {
      return new NeoEditor.TransactionAction("Set " + property, this) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String existing = getString(pNode.node, property);
            final String value = SwingUtil.showInputDialog(property, canvas, existing == null ? "" : existing);
            if (value == null) return;

            pNode.node.setProperty(property, value);
            pNode.updateView();
         }
      };
   }

   public Action exportAction(final Node node) {
      return new NeoEditor.TransactionAction("Export", this) {

         final CypherGroup cypherGroup = new CypherGroup();

         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final CypherGroup.createNodesST createNodesST = cypherGroup.newcreateNodes();

            final LinkedHashSet<Relationship> relationships = new LinkedHashSet<>();
            exportNode(createNodesST, cypherGroup, node, new LinkedHashSet<>(), relationships);

            // add relations at end, using node-uuids:
            final CypherGroup.createRelationshipsST createRelationshipsST = cypherGroup.newcreateRelationships();
            for (Relationship relationship : relationships) {
               final Object src = relationship.getStartNode().getProperty(TAG_UUID).toString().replaceAll("-","_");
               final Object dst = relationship.getEndNode().getProperty(TAG_UUID).toString().replaceAll("-","_");
               final CypherGroup.createRelationshipST createRelationshipST = cypherGroup.newcreateRelationship().
                     setSrc(src).
                     setType(relationship.getType().name()).
                     setDst(dst);

               for (String key : relationship.getPropertyKeys())
                  createRelationshipST.addPropertiesValue(cypherGroup.newstringProperty().setName(key).setValue(relationship.getProperty(key)));
               createRelationshipsST.addRelationshipsValue(createRelationshipST.toString());
            }

            SwingUtil.showTextResult("Export", createNodesST + (createRelationshipsST.toString().length() == 0 ? "" : ("\n" + createRelationshipsST)), editor.getCanvas());
         }

         // todo consider creating a clone version of this
         private void exportNode(CypherGroup.createNodesST export, CypherGroup neoGroup, Node node, Set<Node> visitedNodes, Set<Relationship> relationships) {

            if (visitedNodes.contains(node)) return;
            visitedNodes.add(node);

            final Object id = node.getProperty(TAG_UUID).toString().replaceAll("-","_");
            final CypherGroup.createNodeST createNodeST = neoGroup.newcreateNode().
                  setId(id);
            for (Label label : node.getLabels()) createNodeST.addLabelsValue(label);

            for (String key : node.getPropertyKeys())
               createNodeST.addPropertiesValue(neoGroup.newstringProperty().setName(key).setValue(node.getProperty(key)));
            export.addNodesValue(createNodeST.toString());

            final Set<Node> unvisitedNodes = new LinkedHashSet<>();
            for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) {
               if (relationships.contains(relationship)) continue;
               relationships.add(relationship);

               final Node endNode = relationship.getEndNode();
               if (!visitedNodes.contains(endNode)) unvisitedNodes.add(endNode);
            }

            for (Node unvisitedNode : unvisitedNodes) {
               if (visitedNodes.contains(unvisitedNode)) continue;
               exportNode(export, neoGroup, unvisitedNode, visitedNodes, relationships);
            }
         }
      };
   }

   public Action importFromExport() {
      return new NeoEditor.TransactionAction("Import", this) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final JTextArea textArea = new JTextArea("");

            SwingUtil.showTextInput("Cypher-import", textArea, editor.getCanvas(), () -> {
               final String query = textArea.getText().trim();
               if (query.length() == 0) return;
               editor.getGraph().query(query);
            });
         }
      };
   }

   public Action newSetNodePropertyAction(String property, NeoPNode<PText> pNode, String... values) {
      return new NeoEditor.TransactionAction("Set " + property, this) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String existing = getString(pNode.node, property);
            final String value = SwingUtil.showSelectDialog(editor.canvas, values, existing);
            if (value == null) return;

            pNode.node.setProperty(property, value);
            pNode.updateView();
         }
      };
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

   public static boolean isAppRelated(Relationship relationship) {
      return layoutMember.equals(relationship.getType());
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
}