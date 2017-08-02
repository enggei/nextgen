package com.generator.app;

import com.generator.editors.NeoModel;
import com.generator.generators.templates.domain.TemplateEntities;
import com.generator.generators.templates.domain.TemplateFile;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.generators.templates.parser.TemplateFileParser;
import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.event.LabelEntry;
import org.neo4j.graphdb.event.TransactionData;
import org.neo4j.graphdb.event.TransactionEventHandler;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.factory.GraphDatabaseSettings;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.app.TemplateMotif.getLabelFor;
import static com.generator.editors.BaseDomainVisitor.getString;

/**
 * Created 06.07.17.
 */
public class App extends JFrame {

   final AppEvents events = new AppEvents(new PropertyChangeSupport(this));
   final AppModel model = new AppModel();
   final Workspace workspace = new Workspace(this);

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

      final JLabel status = new JLabel("Ready");
      status.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
      events.addGraphNewListener(evt -> status.setText(evt.getOldValue().toString()));

      getContentPane().setLayout(new BorderLayout());
      getContentPane().add(splitPane, BorderLayout.CENTER);
      getContentPane().add(status, BorderLayout.SOUTH);
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

   private final class MenuBar extends JMenuBar {

      private final JMenu parsingMenu = new JMenu("Parsing");

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
               final File dir = SwingUtil.showOpenDir(App.this, model.getGeneratorPath());
               if (dir == null) return;
               model.setGeneratorPath(dir.getAbsolutePath());
            }
         });
         add(projectMenu);

         parsingMenu.setEnabled(false);
         parsingMenu.add(new AbstractAction("Parse STG file") {
            @Override
            public void actionPerformed(ActionEvent e) {

               final File file = SwingUtil.showOpenFile(App.this, model.getGeneratorPath());
               if (file == null || !file.getName().toLowerCase().endsWith(".stg")) return;

               final TemplateFile templateFile = new TemplateFileParser().parse(file);
               if (templateFile == null) {
                  SwingUtil.showMessage("Could not parse " + file.getAbsolutePath(), App.this);
                  return;
               }
               getRootPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
               model.graph().doInTransaction(new NeoModel.Committer() {
                  @Override
                  public void doAction(Transaction tx) throws Throwable {
                     final String name = templateFile.getName().replaceAll(".stg", "");
                     final Node stGroupNode = model.graph().newNode(TemplateMotif.Entities._STGroup, AppMotif.Properties.name.name(), name);
                     for (TemplateStatement templateStatement : templateFile.getStatements()) {
                        final Node stNode = model.graph().newNode(TemplateMotif.Entities._STTemplate, AppMotif.Properties.name.name(), templateStatement.getName());
                        stNode.setProperty(TemplateMotif.Properties._text.name(), templateStatement.getText());
                        stNode.createRelationshipTo(stGroupNode, TemplateMotif.Relations.STTEMPLATE);

                        final List<TemplateParameter> parameters = templateStatement.getParameters();
                        for (TemplateParameter templateParameter : parameters) {
                           final String parameterType = getLabelFor(templateParameter.getDomainEntityType());
                           final Node node = model.graph().newNode(parameterType);
                           node.setProperty(AppMotif.Properties.name.name(), templateParameter.getPropertyName());
                           if (templateParameter.getDomainEntityType().equals(TemplateEntities.KEYVALUELISTPROPERTY))
                              templateParameter.getKvNames().forEach(s -> node.setProperty("key_" + s, s));
                           stNode.createRelationshipTo(node, TemplateMotif.Relations.TEMPLATE_PARAMETER);
                        }
                     }
                     getRootPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                     events.fireNodeLoad(new AppEvents.NodeLoadEvent(stGroupNode));
                  }

                  @Override
                  public void exception(Throwable throwable) {
                     getRootPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                     SwingUtil.showException(App.this, throwable);
                  }
               });
            }
         });
         add(parsingMenu);

         final JMenu settingsMenu = new JMenu("Settings");
         settingsMenu.add(new AbstractAction("Rendering") {
            @Override
            public void actionPerformed(ActionEvent e) {

               final JComboBox<Object> cboAntialiasing = new JComboBox<>(new Object[]{
                     RenderingHints.VALUE_ANTIALIAS_ON,
                     RenderingHints.VALUE_ANTIALIAS_OFF,
                     RenderingHints.VALUE_ANTIALIAS_DEFAULT});
               cboAntialiasing.setSelectedItem(model.hints.get(RenderingHints.KEY_ANTIALIASING));

               final JComboBox<Object> cboAlphaInterpolation = new JComboBox<>(new Object[]{
                     RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY,
                     RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED,
                     RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT});
               cboAlphaInterpolation.setSelectedItem(model.hints.get(RenderingHints.KEY_ALPHA_INTERPOLATION));

               final JComboBox<Object> cboColorRendering = new JComboBox<>(new Object[]{
                     RenderingHints.VALUE_COLOR_RENDER_DEFAULT,
                     RenderingHints.VALUE_COLOR_RENDER_QUALITY,
                     RenderingHints.VALUE_COLOR_RENDER_SPEED});
               cboColorRendering.setSelectedItem(model.hints.get(RenderingHints.KEY_COLOR_RENDERING));

               final JComboBox<Object> cboDithering = new JComboBox<>(new Object[]{
                     RenderingHints.VALUE_DITHER_DISABLE,
                     RenderingHints.VALUE_DITHER_ENABLE,
                     RenderingHints.VALUE_DITHER_DEFAULT});
               cboDithering.setSelectedItem(model.hints.get(RenderingHints.KEY_DITHERING));

               final JComboBox<Object> cboFractionalMetrics = new JComboBox<>(new Object[]{
                     RenderingHints.VALUE_FRACTIONALMETRICS_ON,
                     RenderingHints.VALUE_FRACTIONALMETRICS_OFF,
                     RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT});
               cboFractionalMetrics.setSelectedItem(model.hints.get(RenderingHints.KEY_FRACTIONALMETRICS));

               final JComboBox<Object> cboImageInterpolation = new JComboBox<>(new Object[]{
                     RenderingHints.VALUE_INTERPOLATION_BICUBIC,
                     RenderingHints.VALUE_INTERPOLATION_BILINEAR,
                     RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR});
               cboImageInterpolation.setSelectedItem(model.hints.get(RenderingHints.KEY_INTERPOLATION));

               final JComboBox<Object> cboRendering = new JComboBox<>(new Object[]{
                     RenderingHints.VALUE_RENDER_QUALITY,
                     RenderingHints.VALUE_RENDER_SPEED,
                     RenderingHints.VALUE_RENDER_DEFAULT});
               cboRendering.setSelectedItem(model.hints.get(RenderingHints.KEY_RENDERING));

               final JComboBox<Object> cboKeyStrokeControl = new JComboBox<>(new Object[]{
                     RenderingHints.VALUE_STROKE_NORMALIZE,
                     RenderingHints.VALUE_STROKE_DEFAULT,
                     RenderingHints.VALUE_STROKE_PURE});
               cboKeyStrokeControl.setSelectedItem(model.hints.get(RenderingHints.KEY_STROKE_CONTROL));

               final JComboBox<Object> cboTextAntialiasing = new JComboBox<>(new Object[]{
                     RenderingHints.VALUE_TEXT_ANTIALIAS_ON,
                     RenderingHints.VALUE_TEXT_ANTIALIAS_OFF,
                     RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT,
                     RenderingHints.VALUE_TEXT_ANTIALIAS_GASP,
                     RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB,
                     RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR,
                     RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VRGB,
                     RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VBGR});
               cboTextAntialiasing.setSelectedItem(model.hints.get(RenderingHints.KEY_TEXT_ANTIALIASING));

               final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu:grow,4dlu,175dlu:grow", "pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref");
               editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

               editor.addLabel("Antialiasing", 1, 1);
               editor.add(cboAntialiasing, 3, 1);
               editor.addLabel("Alpha interpolation", 1, 3);
               editor.add(cboAlphaInterpolation, 3, 3);
               editor.addLabel("Color rendering", 1, 5);
               editor.add(cboColorRendering, 3, 5);
               editor.addLabel("Dithering", 1, 7);
               editor.add(cboDithering, 3, 7);
               editor.addLabel("Fractional text metrics", 1, 9);
               editor.add(cboFractionalMetrics, 3, 9);
               editor.addLabel("Image Interpolation", 1, 11);
               editor.add(cboImageInterpolation, 3, 11);
               editor.addLabel("Rendering", 1, 13);
               editor.add(cboRendering, 3, 13);
               editor.addLabel("Stroke Normalization Control", 1, 15);
               editor.add(cboKeyStrokeControl, 3, 15);
               editor.addLabel("Text Antialiasing", 1, 17);
               editor.add(cboTextAntialiasing, 3, 17);

               SwingUtil.showDialog(editor, workspace, "Rendering hints", () -> {

                  model.hints.clear();
                  if (cboAntialiasing.getSelectedItem() != null)
                     model.hints.put(RenderingHints.KEY_ANTIALIASING, cboAntialiasing.getSelectedItem());
                  if (cboAlphaInterpolation.getSelectedItem() != null)
                     model.hints.put(RenderingHints.KEY_ALPHA_INTERPOLATION, cboAlphaInterpolation.getSelectedItem());
                  if (cboColorRendering.getSelectedItem() != null)
                     model.hints.put(RenderingHints.KEY_COLOR_RENDERING, cboColorRendering.getSelectedItem());
                  if (cboDithering.getSelectedItem() != null)
                     model.hints.put(RenderingHints.KEY_DITHERING, cboDithering.getSelectedItem());
                  if (cboFractionalMetrics.getSelectedItem() != null)
                     model.hints.put(RenderingHints.KEY_FRACTIONALMETRICS, cboFractionalMetrics.getSelectedItem());
                  if (cboImageInterpolation.getSelectedItem() != null)
                     model.hints.put(RenderingHints.KEY_INTERPOLATION, cboImageInterpolation.getSelectedItem());
                  if (cboRendering.getSelectedItem() != null)
                     model.hints.put(RenderingHints.KEY_RENDERING, cboRendering.getSelectedItem());
                  if (cboKeyStrokeControl.getSelectedItem() != null)
                     model.hints.put(RenderingHints.KEY_STROKE_CONTROL, cboKeyStrokeControl.getSelectedItem());
                  if (cboTextAntialiasing.getSelectedItem() != null)
                     model.hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, cboTextAntialiasing.getSelectedItem());

                  SwingUtilities.invokeLater(() -> {
                     workspace.invalidate();
                     workspace.repaint();
                  });
               });

            }
         });
         add(settingsMenu);

         final JMenu utilsMenu = new JMenu("Utilities");
         utilsMenu.add(new AbstractAction("TextProcessor") {
            @Override
            public void actionPerformed(ActionEvent e) {
               SwingUtilities.invokeLater(() -> showTextProcessor(""));
            }
         });
         utilsMenu.add(new AbstractAction("Maven dependency") {
            @Override
            public void actionPerformed(ActionEvent e) {

               final JTextArea txtDependency = new JTextArea(30, 30);

               final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("200dlu:grow", "100:grow");
               editor.add(new JScrollPane(txtDependency), 1, 1);

               SwingUtil.showDialog(editor, App.this, "Import Maven dependency", new SwingUtil.OnSave() {
                  @Override
                  public void verifyAndSave() throws Exception {

                     final String xml = "<dependencies>" + txtDependency.getText().trim() + "</dependencies>";

                     final DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                     final InputSource is = new InputSource();
                     is.setCharacterStream(new StringReader(xml));
                     final NodeList elements = db.parse(is).getElementsByTagName("dependency");

                     model.graph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {

                           final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();

                           for (int i = 0; i < elements.getLength(); i++) {
                              final Element dependencyNode = (Element) elements.item(i);

                              final Node dependencies = model.graph().newNode(TemplateMotif.Entities._KeyValue, AppMotif.Properties.name.name(), "dependencies");
                              nodes.add(new AppEvents.NodeLoadEvent(dependencies));

                              final Node groupId = model.graph.newNode(TemplateMotif.Entities._Value, AppMotif.Properties.name.name(), ((CharacterData) dependencyNode.getElementsByTagName("groupId").item(0).getFirstChild()).getData());
                              final Relationship groupRelationship = dependencies.createRelationshipTo(groupId, RelationshipType.withName("groupId"));
                              groupRelationship.setProperty(TemplateMotif.Properties._referenceType.name(), TemplateMotif.ReferenceType.PROPERTY.name());
                              groupRelationship.setProperty(TemplateMotif.Properties._referenceProperty.name(), AppMotif.Properties.name.name());
                              nodes.add(new AppEvents.NodeLoadEvent(groupId));

                              final Node artifactId = model.graph.newNode(TemplateMotif.Entities._Value, AppMotif.Properties.name.name(), ((CharacterData) dependencyNode.getElementsByTagName("artifactId").item(0).getFirstChild()).getData());
                              final Relationship artifactIdRelationship = dependencies.createRelationshipTo(artifactId, RelationshipType.withName("artifactId"));
                              artifactIdRelationship.setProperty(TemplateMotif.Properties._referenceType.name(), TemplateMotif.ReferenceType.PROPERTY.name());
                              artifactIdRelationship.setProperty(TemplateMotif.Properties._referenceProperty.name(), AppMotif.Properties.name.name());
                              nodes.add(new AppEvents.NodeLoadEvent(artifactId));

                              final Node version = model.graph.newNode(TemplateMotif.Entities._Value, AppMotif.Properties.name.name(), ((CharacterData) dependencyNode.getElementsByTagName("version").item(0).getFirstChild()).getData());
                              final Relationship versionRelationship = dependencies.createRelationshipTo(version, RelationshipType.withName("version"));
                              versionRelationship.setProperty(TemplateMotif.Properties._referenceType.name(), TemplateMotif.ReferenceType.PROPERTY.name());
                              versionRelationship.setProperty(TemplateMotif.Properties._referenceProperty.name(), AppMotif.Properties.name.name());
                              nodes.add(new AppEvents.NodeLoadEvent(version));

                              final NodeList scopeElement = dependencyNode.getElementsByTagName("scope");
                              if(scopeElement.getLength()==1) {
                                 final Node scope = model.graph.newNode(TemplateMotif.Entities._Value, AppMotif.Properties.name.name(), ((CharacterData) dependencyNode.getElementsByTagName("scope").item(0).getFirstChild()).getData());
                                 final Relationship scopeRelationship = dependencies.createRelationshipTo(version, RelationshipType.withName("scope"));
                                 scopeRelationship.setProperty(TemplateMotif.Properties._referenceType.name(), TemplateMotif.ReferenceType.PROPERTY.name());
                                 scopeRelationship.setProperty(TemplateMotif.Properties._referenceProperty.name(), AppMotif.Properties.name.name());
                                 nodes.add(new AppEvents.NodeLoadEvent(scope));
                              }
                           }

                           events.fireNodeLoad(nodes);
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showExceptionNoStack(App.this, throwable);
                        }
                     });
                  }
               });
            }
         });

         add(utilsMenu);

         events.addGraphNewListener(evt -> parsingMenu.setEnabled(true));
      }
   }

   void showTextProcessor(String content) {
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

      private Map<RenderingHints.Key, Object> hints = new LinkedHashMap<>();

      AppModel() {
         FileUtil.tryToCreateFileIfNotExists(propertiesFile);
         if (propertiesFile != null && propertiesFile.exists()) {
            try {
               this.properties.load(new BufferedReader(new FileReader(propertiesFile)));
            } catch (IOException e) {
               System.out.println("Could not open properties file " + propertiesFile);
            }
         }

         events.addRelationPaintStrategyChangedListener(evt -> {
            final AppMotif.RelationPaintStrategy strategy = (AppMotif.RelationPaintStrategy) evt.getNewValue();
            properties.put("relation.paint.strategy", strategy.name());
            saveProperties();
         });

         events.addRelationPathStrategyChangedListener(evt -> {
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

      String getGeneratorPath() {
         return properties.getProperty("generator.path", "src/main/java/com/generator/generators");
      }

      void setGeneratorPath(String dir) {
         properties.put("generator.path", dir);
         saveProperties();
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
               model.graph().getGraphDb().unregisterTransactionEventHandler(transactionEventHandler);
            model.graph().close();
         }
      }

      void setDatabase(String dir) {

         getRootPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

         closeDatabase();

         graph = new NeoModel(new GraphDatabaseFactory().
               newEmbeddedDatabaseBuilder(new File(dir)).
               setConfig(GraphDatabaseSettings.allow_store_upgrade, "true").
               newGraphDatabase(),
               model -> System.out.println("graph closed"));

         model.graph().getGraphDb().registerTransactionEventHandler(transactionEventHandler = new TransactionEventHandler<Object>() {

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
                  events.fireNodesDeleted(new LinkedHashSet<>(deletedNodes));
                  deletedNodes.clear();
               }

               if (!deletedRelations.isEmpty()) {
                  events.fireRelationsDeleted(new LinkedHashSet<>(deletedRelations));
                  deletedRelations.clear();
               }

               if (!addedNodes.isEmpty()) {
                  events.fireNodesAdded(new LinkedHashSet<>(addedNodes));
                  addedNodes.clear();
               }

               if (!addedRelations.isEmpty()) {
                  events.fireRelationsAdded(new LinkedHashSet<>(addedRelations));
                  addedRelations.clear();
               }

               if (!assignedLabels.isEmpty()) {
                  events.fireLabelsAssigned(new LinkedHashSet<>(assignedLabels));
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

         events.fireGraphNew(dir, graph);
         getRootPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }

      private void saveProperties() {
         try {
            properties.store(new FileWriter(propertiesFile), "auto-save");
         } catch (IOException e1) {
            System.err.println("Could not save properties file " + propertiesFile.getAbsolutePath());
         }
      }

      public NeoModel graph() {
         return graph;
      }

      Map<RenderingHints.Key, Object> getRenderingHints() {
         return hints;
      }
   }

   abstract static class TransactionAction extends AbstractAction {

      private final App app;

      TransactionAction(String name, App app) {
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