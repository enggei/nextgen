package com.generator.app;

import com.generator.NeoModel;
import com.generator.generators.antlr.ANTLRPlugin;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.easyFlow.EasyFlowPlugin;
import com.generator.generators.java.JavaPlugin;
import com.generator.generators.maven.MavenPlugin;
import com.generator.generators.mysql.MySQLPlugin;
import com.generator.generators.project.ProjectPlugin;
import com.generator.generators.ssh.SSHPlugin;
import com.generator.generators.stringtemplate.StringTemplatePlugin;
import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.event.LabelEntry;
import org.neo4j.graphdb.event.TransactionData;
import org.neo4j.graphdb.event.TransactionEventHandler;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.factory.GraphDatabaseSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.app.AppEvents.*;
import static com.generator.BaseDomainVisitor.getString;
import static com.generator.BaseDomainVisitor.incoming;
import static com.generator.BaseDomainVisitor.outgoing;

/**
 * Created 06.07.17.
 */
public class App extends JFrame {

   final AppEvents events = new AppEvents(new PropertyChangeSupport(this));
   final AppModel model = new AppModel();
   final Workspace workspace = new Workspace(this);
   final Set<Plugin> plugins = new LinkedHashSet<>();

   private final Stack<AppModel.TransactionHistory> transactionHistory = new Stack<>();

   public App() throws HeadlessException {
      super("App");

      addComponentListener(new ComponentAdapter() {
         @Override
         public void componentResized(ComponentEvent e) {
            SwingUtilities.invokeLater(() -> model.onAppResized(e.getComponent().getWidth(), e.getComponent().getHeight()));
         }

         @Override
         public void componentMoved(ComponentEvent e) {
            SwingUtilities.invokeLater(() -> model.onAppMoved(e.getComponent().getX(), e.getComponent().getY()));
         }
      });

      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {

            getRootPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            model.graph().doInTransaction(new NeoModel.Committer() {
               @Override
               public void doAction(Transaction tx) throws Throwable {
                  final Node layoutNode = AppMotif.getLayoutNode(App.this, AppMotif.Properties._lastLayout.name());
                  if (workspace.nodeCanvas.getAllNodes().isEmpty() && layoutNode == null) return;
                  AppMotif.saveLayout(App.this, AppMotif.Properties._lastLayout.name(), workspace.nodeCanvas.getAllNodes());
               }

               @Override
               public void exception(Throwable throwable) {
                  throwable.printStackTrace();
               }
            });

            model.closeDatabase();
            getRootPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
         }
      });

      final MenuBar menuBar = new MenuBar();
      setJMenuBar(menuBar);

      final InformationPanel informationPanel = new InformationPanel(this);

      final JScrollPane newLeftComponent = new JScrollPane(informationPanel);
      newLeftComponent.getViewport().setPreferredSize(model.getInformationPanelSize());
      newLeftComponent.getViewport().setSize(model.getInformationPanelSize());

      final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, newLeftComponent, workspace);
      splitPane.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, pce -> SwingUtilities.invokeLater(() -> model.onAppSplitPaneMoved(((JSplitPane) pce.getSource()))));

      getContentPane().setLayout(new BorderLayout());
      getContentPane().add(splitPane, BorderLayout.CENTER);
      setPreferredSize(model.getAppSize());
      setLocation(model.getAppLocation());

      addWindowListener(new WindowAdapter() {
         @Override
         public void windowOpened(WindowEvent e) {
            if (!model.getCurrentDatabaseDir().equals(System.getProperty("user.home"))) {
               SwingUtilities.invokeLater(() -> model.setDatabase(model.getCurrentDatabaseDir()));
            }
         }
      });
   }

   void undoLastTransaction() {
      if (this.transactionHistory.isEmpty()) return;
      events.firePropertyChange(UNDO_LAST_DELETE, this.transactionHistory.pop());
   }

   private final class MenuBar extends JMenuBar {

      MenuBar() {

         final JMenu projectMenu = new JMenu("Project");
         projectMenu.add(new AbstractAction("Set database") {
            @Override
            public void actionPerformed(ActionEvent e) {
               final File dir = SwingUtil.showOpenDir(App.this, model.getCurrentDatabaseDir());
               if (dir == null) return;
               SwingUtilities.invokeLater(() -> model.setDatabase(dir.getAbsolutePath()));
            }
         });

         projectMenu.add(new AbstractAction("Set Generator root") {
            @Override
            public void actionPerformed(ActionEvent e) {
               final File dir = SwingUtil.showOpenDir(App.this, model.getAppStringProperty("generator.path"));
               if (dir == null) return;
               model.setAppProperty("generator.path", dir.getAbsolutePath());
            }
         });
         add(projectMenu);

         final JMenu utilsMenu = new JMenu("Utilities");
         utilsMenu.add(new AbstractAction("Regexp") {
            @Override
            public void actionPerformed(ActionEvent e) {
               SwingUtilities.invokeLater(() -> showTextProcessor(""));
            }
         });
         add(utilsMenu);

         events.addPropertyChangeListener(AppEvents.GRAPH_NEW, new AppEvents.TransactionalPropertyChangeListener(App.this) {
            @Override
            protected void propertyChange(Object oldValue, Object newValue) {
               if (plugins.isEmpty()) {
                  plugins.add(new StringTemplatePlugin(App.this));
                  plugins.add(new ProjectPlugin(App.this));
                  plugins.add(new JavaPlugin(App.this));
                  plugins.add(new MySQLPlugin(App.this));
                  plugins.add(new EasyFlowPlugin(App.this));
                  plugins.add(new MavenPlugin(App.this));
                  plugins.add(new ANTLRPlugin(App.this));
                  plugins.add(new SSHPlugin(App.this));
                  plugins.add(new DomainPlugin(App.this));
               }
            }
         });
      }
   }

   Set<Plugin> getPlugins() {
      return plugins;
   }

   public void showTextProcessor(String content) {
      final Set<String> patterns = new LinkedHashSet<>();
      model.graph().doInTransaction(new NeoModel.Committer() {
         @Override
         public void doAction(Transaction tx) throws Throwable {
            model.graph().findNodes(AppMotif.Entities._RegexpPattern).forEachRemaining(node -> patterns.add(getString(node, AppMotif.Properties.name.name())));
         }

         @Override
         public void exception(Throwable throwable) {
            SwingUtil.showExceptionNoStack(App.this, throwable);
         }
      });

      final TextProcessingPanel processingPanel = new TextProcessingPanel(content, patterns);
      SwingUtil.showCloseDialog(processingPanel, App.this, "Text Processor", () -> {
         final String pattern = processingPanel.getPattern();
         if (patterns.contains(pattern) || pattern.trim().length() == 0) return;

         SwingUtilities.invokeLater(() -> model.graph().doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               model.graph().newNode(AppMotif.Entities._RegexpPattern, AppMotif.Properties.name.name(), pattern.trim());
            }

            @Override
            public void exception(Throwable throwable) {
               SwingUtil.showExceptionNoStack(App.this, throwable);
            }
         }));
      });
   }

   final class AppModel {

      private final Properties properties = new Properties();
      private final File propertiesFile = new File(System.getProperty("user.home"), "/.nextgen/app.properties");

      private NeoModel graph;
      private TransactionEventHandler<Object> transactionEventHandler;

      private Map<String, String> defaultPropertyValues = new TreeMap<String, String>() {{
         put("generator.path", "src/main/java/com/generator/generators");
      }};

      AppModel() {
         FileUtil.tryToCreateFileIfNotExists(propertiesFile);
         if (propertiesFile != null && propertiesFile.exists()) {
            try {
               this.properties.load(new BufferedReader(new FileReader(propertiesFile)));
            } catch (IOException e) {
               System.out.println("Could not open properties file " + propertiesFile);
            }
         }

         events.addPropertyChangeListener(RELATION_PAINTSTRATEGY_CHANGED, new AppEvents.TransactionalPropertyChangeListener<Object, AppMotif.RelationPaintStrategy>(AppModel.class, App.this, App.this) {
            @Override
            protected void propertyChange(Object oldValue, AppMotif.RelationPaintStrategy newValue) {
               properties.put("relation.paint.strategy", newValue.name());
               saveProperties();
            }
         });

         events.addPropertyChangeListener(RELATION_PATHSTRATEGY_CHANGED, evt -> {
            final AppMotif.RelationPathStrategy strategy = (AppMotif.RelationPathStrategy) evt.getNewValue();
            properties.put("relation.path.strategy", strategy.name());
            saveProperties();
         });
      }

      void onAppResized(int width, int height) {
         properties.put("app.width", Integer.toString(width));
         properties.put("app.height", Integer.toString(height));
         saveProperties();
      }

      void onAppMoved(int x, int y) {
         properties.put("app.x", Integer.toString(x));
         properties.put("app.y", Integer.toString(y));
         saveProperties();
      }

      void onAppSplitPaneMoved(JSplitPane splitPane) {
         properties.put("informationPanel.width", Integer.toString(splitPane.getLeftComponent().getWidth()));
         properties.put("informationPanel.height", Integer.toString(splitPane.getLeftComponent().getHeight()));
         saveProperties();
      }

      void onWorkspaceSplitPaneMoved(JSplitPane splitPane) {
         properties.put("canvas.width", Integer.toString(splitPane.getLeftComponent().getWidth()));
         properties.put("canvas.height", Integer.toString(splitPane.getLeftComponent().getHeight()));
         saveProperties();
      }

      Dimension getAppSize() {
         return new Dimension(Integer.valueOf(properties.getProperty("app.width", "1024")), Integer.valueOf(properties.getProperty("app.height", "768")));
      }

      Point getAppLocation() {
         return new Point(Integer.valueOf(properties.getProperty("app.x", "10")), Integer.valueOf(properties.getProperty("app.y", "10")));
      }

      Dimension getInformationPanelSize() {
         return new Dimension(Integer.valueOf(properties.getProperty("informationPanel.width", "1024")), Integer.valueOf(properties.getProperty("informationPanel.height", "768")));
      }

      Dimension getCanvasSize() {
         return new Dimension(Integer.valueOf(properties.getProperty("canvas.width", "1024")), Integer.valueOf(properties.getProperty("canvas.height", "768")));
      }

      String getCurrentDatabaseDir() {
         return properties.getProperty("current.database", System.getProperty("user.home"));
      }

      AppMotif.RelationPaintStrategy getRelationPaintStrategy() {
         return AppMotif.RelationPaintStrategy.valueOf(properties.getProperty("relation.paint.strategy", AppMotif.RelationPaintStrategy.showLinesAndLabels.name()));
      }

      AppMotif.RelationPathStrategy getRelationPathStrategy() {
         return AppMotif.RelationPathStrategy.valueOf(properties.getProperty("relation.path.strategy", AppMotif.RelationPathStrategy.straightLines.name()));
      }

      AppMotif.NodePaintStrategy getNodePaintStrategy() {
         return AppMotif.NodePaintStrategy.valueOf(properties.getProperty("node.paint.strategy", AppMotif.NodePaintStrategy.showNameAndLabels.name()));
      }

      String getCurrentCanvasColor() {
         return properties.getProperty("canvas.color", "#edf8fb");
      }

      void setCanvasColor(String color) {
         properties.put("canvas.color", color);
         saveProperties();
      }

      AppMotif.PropertiesToShow getPropertiesFilter() {
         return AppMotif.PropertiesToShow.valueOf(properties.getProperty("properties.filter", AppMotif.PropertiesToShow.all.name()));
      }

      void setPropertiesFilter(AppMotif.PropertiesToShow propertiesToShow) {
         properties.put("properties.filter", propertiesToShow.name());
         saveProperties();
      }

      void closeDatabase() {
         if (graph != null) {
            if (transactionEventHandler != null)
               graph.getGraphDb().unregisterTransactionEventHandler(transactionEventHandler);
            graph.close();
         }
      }

      void setDatabase(String dir) {

         getRootPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

         closeDatabase();

         transactionHistory.clear();

         GraphDatabaseSettings.BoltConnector bolt = GraphDatabaseSettings.boltConnector("0");

         graph = new NeoModel(new GraphDatabaseFactory()
            .newEmbeddedDatabaseBuilder(new File(dir))
            .setConfig(bolt.type, "BOLT")
            .setConfig(bolt.enabled, "true")
            .setConfig(bolt.address, "localhost:7687")
            .setConfig(GraphDatabaseSettings.allow_store_upgrade, "true")
            .newGraphDatabase(),
            model -> System.out.println("graph closed"));

         graph.getGraphDb().registerTransactionEventHandler(transactionEventHandler = new TransactionEventHandler<Object>() {

            private final Set<Long> deletedNodes = new LinkedHashSet<>();
            private final Set<Long> deletedRelations = new LinkedHashSet<>();
            private final Set<Node> addedNodes = new LinkedHashSet<>();
            private final Set<Relationship> addedRelations = new LinkedHashSet<>();
            private final Set<LabelEntry> assignedLabels = new LinkedHashSet<>();

            @Override
            public Object beforeCommit(TransactionData transactionData) throws Exception {
               transactionData.deletedNodes().forEach(node -> deletedNodes.add(node.getId()));
               transactionData.deletedRelationships().forEach(relationship -> deletedRelations.add(relationship.getId()));
               transactionData.createdNodes().forEach(addedNodes::add);
               transactionData.createdRelationships().forEach(addedRelations::add);
               transactionData.assignedLabels().forEach(assignedLabels::add);
               return null;
            }

            @Override
            public void afterCommit(TransactionData transactionData, Object o) {

               if (!deletedNodes.isEmpty()) {
                  events.firePropertyChange(NODES_DELETED, new LinkedHashSet<>(deletedNodes));
                  deletedNodes.clear();
               }

               if (!deletedRelations.isEmpty()) {
                  events.firePropertyChange(RELATIONS_DELETED, new LinkedHashSet<>(deletedRelations));
                  deletedRelations.clear();
               }

               if (!addedNodes.isEmpty()) {
                  events.firePropertyChange(NODES_ADDED, new LinkedHashSet<>(addedNodes));
                  addedNodes.clear();
               }

               if (!addedRelations.isEmpty()) {
                  events.firePropertyChange(RELATIONS_ADDED, new LinkedHashSet<>(addedRelations));
                  addedRelations.clear();
               }

               if (!assignedLabels.isEmpty()) {
                  events.firePropertyChange(LABELS_ASSIGNED, new LinkedHashSet<>(assignedLabels));
                  assignedLabels.clear();
               }
            }

            @Override
            public void afterRollback(TransactionData transactionData, Object o) {
               System.out.println("rollback");
            }
         });
         properties.setProperty("current.database", dir);
         saveProperties();

         events.firePropertyChange(AppEvents.GRAPH_NEW, dir);
         getRootPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }

      public NeoModel graph() {
         return graph;
      }

      String getAppStringProperty(String property) {
         return properties.getProperty(property, defaultPropertyValues.get(property));
      }

      void setAppProperty(String property, String value) {
         properties.put(property, value);
         saveProperties();
      }

      private void saveProperties() {
         try {
            properties.store(new FileWriter(propertiesFile), "auto-save");
         } catch (IOException e1) {
            System.err.println("Could not save properties file " + propertiesFile.getAbsolutePath());
         }
      }

      void deleteRelations(Set<Relationship> relations) {
         transactionHistory.push(new TransactionHistory().addRelations(relations));
         for (Relationship relation : relations)
            relation.delete();
      }

      void deleteNodes(Set<Node> nodes) {

         transactionHistory.push(new TransactionHistory().
               addNodes(nodes));

         for (Node node : nodes) {
            incoming(node).forEach(Relationship::delete);
            outgoing(node).forEach(Relationship::delete);
            node.delete();
         }
      }

      public class TransactionHistory {

         public final Set<NodeHistory> nodes = new LinkedHashSet<>();
         public final Set<RelationHistory> relations = new LinkedHashSet<>();

         TransactionHistory addNodes(Set<Node> nodes) {
            for (Node node : nodes)
               this.nodes.add(new NodeHistory(node));

            for (Node node : nodes) {
               incoming(node).forEach(relationship -> relations.add(new RelationHistory(relationship)));
               outgoing(node).forEach(relationship -> relations.add(new RelationHistory(relationship)));
            }

            return this;
         }

         TransactionHistory addRelations(Set<Relationship> relationships) {
            for (Relationship rel : relationships)
               this.relations.add(new RelationHistory(rel));
            return this;
         }

         Set<Node> restore() {
            final Set<Node> restored = new LinkedHashSet<>();

            for (NodeHistory node : nodes)
               restored.add(node.restore());
            for (RelationHistory relation : relations)
               relation.restore();

            return restored;
         }

         final class NodeHistory {

            private final Set<String> labels = new LinkedHashSet<>();
            private final Map<String, Object> properties = new LinkedHashMap<>();

            NodeHistory(Node node) {
               for (Label label : node.getLabels())
                  labels.add(label.name());
               for (String s : node.getPropertyKeys())
                  properties.put(s, node.getProperty(s));

               if (labels.isEmpty())
                  System.out.println("warning unrestorable node (no labels)");
            }

            Node restore() {
               Node node = null;
               for (String label : labels) {
                  if (node == null) node = graph().createNode(Label.label(label));
                  else node.addLabel(Label.label(label));
               }

               for (Map.Entry<String, Object> entry : properties.entrySet()) {
                  assert node != null;
                  node.setProperty(entry.getKey(), entry.getValue());
               }

               return node;
            }
         }

         final class RelationHistory {

            private final String source;
            private final String dst;
            private final String relationshipType;
            private final Map<String, Object> properties = new LinkedHashMap<>();

            RelationHistory(Relationship relationship) {

               if (!relationship.getEndNode().hasProperty(NeoModel.TAG_UUID) || !relationship.getStartNode().hasProperty(NeoModel.TAG_UUID)) {
                  source = null;
                  dst = null;
                  relationshipType = null;
                  return;
               }

               this.source = relationship.getStartNode().getProperty(NeoModel.TAG_UUID).toString();
               this.dst = relationship.getEndNode().getProperty(NeoModel.TAG_UUID).toString();
               for (String s : relationship.getPropertyKeys())
                  properties.put(s, relationship.getProperty(s));
               this.relationshipType = relationship.getType().name();
            }

            void restore() {

               if (source == null) return;

               final Node source = graph().getNode(UUID.fromString(this.source));
               final Node dst = graph().getNode(UUID.fromString(this.dst));
               if (source == null || dst == null) {
                  System.out.println("Cannot restore relation : source " + source + " dst " + dst);
                  return;
               }

               final Relationship relationshipTo = source.createRelationshipTo(dst, RelationshipType.withName(relationshipType));
               for (Map.Entry<String, Object> entry : properties.entrySet())
                  relationshipTo.setProperty(entry.getKey(), entry.getValue());
            }
         }
      }
   }

   public abstract static class TransactionAction extends AbstractAction {

      private final App app;

      public TransactionAction(String name, App app) {
         super(name);
         this.app = app;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         SwingUtilities.invokeLater(() -> {

            app.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            final AtomicBoolean success = new AtomicBoolean(true);
            try (Transaction tx = app.model.graph().beginTx()) {
               actionPerformed(e, tx);
               tx.success();
               app.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            } catch (Throwable throwable) {
               app.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
               success.set(false);
               exception(throwable);
            }

            if (success.get()) onSuccess(e);
         });
      }

      protected abstract void actionPerformed(ActionEvent e, Transaction tx) throws Exception;

      protected void onSuccess(ActionEvent e) {
      }

      void exception(Throwable throwable) {
         SwingUtil.showException(SwingUtilities.getWindowAncestor(app), throwable);
      }
   }

   public static void main(String[] args) {
      SwingUtil.setLookAndFeel_Nimbus();
      SwingUtilities.invokeLater(() -> {
         final App frame = new App();
         frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         frame.pack();
         frame.setVisible(true);
      });
   }
}