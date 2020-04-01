package com.generator.generators.maven;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.NodeRenderPanel;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.project.ProjectPlugin;
import com.generator.neo.NeoModel;
import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import com.generator.util.ThreadUtil;
import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.*;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.zeroturnaround.exec.ProcessExecutor;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import static com.generator.util.NeoUtil.getString;
import static com.generator.util.NeoUtil.relate;

/**
 * Created 03.08.17.
 */
public class MavenPlugin extends MavenDomainPlugin {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MavenPlugin.class);

   private static final MavenGroup mavenGroup = new MavenGroup();

   public MavenPlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.POM);

      menu.add(new AbstractAction("Import from Maven") {
         @Override
         public void actionPerformed(ActionEvent e) {

            final JTextArea txtXml = new JTextArea(30, 30);

            final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("200dlu:grow", "100:grow");
            editor.add(new JScrollPane(txtXml), 1, 1);

            SwingUtil.showDialog(editor, app, "Paste any element from pom", new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {
                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {
                        fireNodesLoaded(traverse(parseXml(txtXml.getText().trim()), null));
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showExceptionNoStack(app, throwable);
                     }
                  });
               }
            });
         }
      });
   }

   @Override
   protected void handlePOM(JPopupMenu pop, NeoNode pOMNode, Set<NeoNode> selectedNodes) {

      final Node directoryNode = ProjectPlugin.singleIncomingRENDERER(pOMNode.getNode());
      if (directoryNode != null) {
         final File directory = ProjectPlugin.getFile(directoryNode);
         if (directory != null && directory.exists()) {
            FileUtil.write(MavenPlugin.renderPOM(pOMNode.getNode()), new File(directory, "pom.xml"));
            pop.add(createPomLifecycleMenu(directory, app));
         }
      }

      pop.add(new App.TransactionAction("Import Dependencies", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final JTextArea textArea = SwingUtil.newTextArea();

            SwingUtil.showTextInput("Dependencies", textArea, app, new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {

                  final String trim = textArea.getText().trim();
                  if (trim.length() == 0) return;

                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {
                        final Set<Node> dependencies = createDependencies(parseXml("<dependencies>" + trim + "</dependencies>"));
                        for (Node dependency : dependencies)
                           relateDEPENDENCIES(pOMNode.getNode(), dependency);
                        fireNodesLoaded(dependencies);
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showExceptionNoStack(app, throwable);
                     }
                  });
               }
            });
         }
      });
   }

   @NotNull
   public static JMenu createPomLifecycleMenu(File directory, App app) {
      final JMenu lifecycleMenu = new JMenu("Run Maven Lifecycle");
      final JMenu debuglifeCycleMenu = new JMenu("Debug");
      final String[] cycles = {"clean", "validate", "compile", "test", "package", "verify", "install", "site", "deploy"};
      for (String cycle : cycles) {


         lifecycleMenu.add(new App.TransactionAction("Run " + cycle, app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               ThreadUtil.runTask(new ThreadUtil.ThreadTask<Throwable>() {
                  @Override
                  public Throwable run() {
                     try {


                        new ProcessExecutor().
                              directory(directory).
                              command("mvn", cycle)
                              .redirectOutput(app.logWindow.getLogOutputStream()).execute();
                     } catch (Throwable t) {
                        return t;
                     }

                     return null;
                  }

                  @Override
                  public void onComplete(Throwable throwable) {
                     if (throwable != null) SwingUtil.showException(app, throwable);
                  }
               });
            }
         });

         debuglifeCycleMenu.add(new App.TransactionAction("Debug Run " + cycle, app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               ThreadUtil.runTask(new ThreadUtil.ThreadTask<Throwable>() {
                  @Override
                  public Throwable run() {
                     try {
                        new ProcessExecutor().
                              directory(directory).
                              command("mvn", "-X", "-e", cycle)
                              .redirectOutput(app.logWindow.getLogOutputStream()).execute();
                     } catch (Throwable t) {
                        return t;
                     }

                     return null;
                  }

                  @Override
                  public void onComplete(Throwable throwable) {
                     if (throwable != null) SwingUtil.showException(app, throwable);
                  }
               });
            }
         });
      }

      lifecycleMenu.add(debuglifeCycleMenu);

      return lifecycleMenu;
   }

   @Override
   protected JComponent newPOMEditor(NeoNode pOMNode) {
      return new NodeRenderPanel(pOMNode) {
         @Override
         protected String render(Node node) {
            return renderPOM(node);
         }
      };
   }

   @Override
   protected JComponent newDependencyEditor(NeoNode dependencyNode) {
      return new NodeRenderPanel(dependencyNode) {
         @Override
         protected String render(Node node) {
            return renderDependency(node);
         }
      };
   }

   public static String renderPOM(Node pomNode) {

      final MavenGroup.PomST pomST = mavenGroup.newPom().
            setName(getNameProperty(pomNode)).
            setArtifactId(getArtifactIdProperty(pomNode)).
            setGroupId(getGroupIdProperty(pomNode)).
            setPackaging(getPackagingProperty(pomNode)).
            setVersion(getVersionProperty(pomNode));

      outgoingPROPERTIES(pomNode, (relationship, propertyNode) -> pomST.addPropertiesValue(getNameProperty(propertyNode), getValueProperty(propertyNode)));

      outgoingDEPENDENCIES(pomNode, (relationship, dependencyNode) -> {
         pomST.addDependenciesValue(renderDependency(dependencyNode));
      });

      final Node baseBuildNode = singleOutgoingBASEBUILD(pomNode);
      if (baseBuildNode != null) {
         final MavenGroup.buildST buildST = mavenGroup.newbuild();
         outgoingPLUGINS(baseBuildNode, (relationship, pluginNode) -> {

            final MavenGroup.pluginST pluginST = mavenGroup.newplugin().
                  setArtifactId(getArtifactIdProperty(pluginNode)).
                  setGroupId(getGroupIdProperty(pluginNode)).
                  setVersion(getVersionProperty(pluginNode));

            outgoingCONFIGURATION(pluginNode, (relationship1, configurationNode) -> pluginST.addConfigurationValue(getNameProperty(configurationNode), getValueProperty(configurationNode)));

            buildST.addPluginValue(pluginST);
         });

         outgoingTEST_RESOURCE(baseBuildNode, (relationship, testResourceNode) -> {
            final MavenGroup.testResourceST testResourceST = mavenGroup.newtestResource();
            outgoingKEYVALUE(testResourceNode, (relationship12, keyValueNode) -> testResourceST.addKeyValuesValue(getKeyProperty(keyValueNode), getValueProperty(keyValueNode)));
            buildST.addTestResourcesValue(testResourceST);
         });

         pomST.setBaseBuild(buildST);
      }

      return pomST.toString();
   }

   public static String renderDependency(Node dependencyNode) {
      return mavenGroup.newdependency().
            setArtifactId(getArtifactIdProperty(dependencyNode)).
            setGroupId(getGroupIdProperty(dependencyNode)).
            setScope(getScopeProperty(dependencyNode)).
            setVersion(getVersionProperty(dependencyNode)).toString();
   }

   public static Element parseXml(String xml) throws ParserConfigurationException, SAXException, IOException {
      final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
      documentBuilderFactory.setIgnoringElementContentWhitespace(true);
      final DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
      final InputSource is = new InputSource();
      is.setCharacterStream(new StringReader(xml));
      return db.parse(is).getDocumentElement();
   }

   private Set<Node> createDependencies(org.w3c.dom.Node node) {
      final Set<Node> nodes = new LinkedHashSet<>();

      final Element dependenciesElement = (Element) node;
      final NodeList dependencyElements = dependenciesElement.getChildNodes();
      for (int i = 0; i < dependencyElements.getLength(); i++) {
         final org.w3c.dom.Node dependency = dependencyElements.item(i);
         switch (dependency.getNodeType()) {

            case org.w3c.dom.Node.ELEMENT_NODE: {
               final Element childElement = (Element) dependency;
               final NodeList dependencyChildren = childElement.getChildNodes();
               final Map<String, String> dependencyKeyValues = new HashMap<>();
               for (int j = 0; j < dependencyChildren.getLength(); j++) {

                  final org.w3c.dom.Node child = dependencyChildren.item(j);
                  switch (child.getNodeType()) {
                     case org.w3c.dom.Node.ELEMENT_NODE: {
                        final String tagName = ((Element) child).getTagName();
                        final String tagValue = child.getTextContent();
                        dependencyKeyValues.put(tagName, tagValue);
                        break;
                     }
                  }
               }

               // todo look for dependency first
               final Set<Node> foundDependency = new LinkedHashSet<>();
               getGraph().findNodes(Entities.Dependency).forEachRemaining(dependencyNode -> {

                  final String groupId = getGroupIdProperty(dependencyNode, "");
                  final String artifactId = getArtifactIdProperty(dependencyNode, "");
                  final String versionProperty = getVersionProperty(dependencyNode, "");
                  final String type = getTypeProperty(dependencyNode, "");
                  final String scope = getScopeProperty(dependencyNode, "");
                  final String optional = getOptionalProperty(dependencyNode, "");

                  if (groupId.equals(dependencyKeyValues.get(Properties.groupId.name())) && artifactId.equals(dependencyKeyValues.get(Properties.artifactId.name())) && versionProperty.equals(dependencyKeyValues.get(Properties.version.name())) && type.equals(dependencyKeyValues.get(Properties.type.name())) && scope.equals(dependencyKeyValues.get(Properties.scope.name())) && optional.equals(dependencyKeyValues.get(Properties.optional.name())))
                     foundDependency.add(dependencyNode);
               });

               if (foundDependency.isEmpty()) {
                  log.info("MavenPlugin.relateDEPENDENCIES(pomNode, MavenPlugin.newDependency(getGraph(), " + asString(dependencyKeyValues.get(Properties.groupId.name())) + "," + asString(dependencyKeyValues.get(Properties.artifactId.name())) + "," + asString(dependencyKeyValues.get(Properties.version.name())) + "," + asString(dependencyKeyValues.get(Properties.type.name())) + "," + asString(dependencyKeyValues.get(Properties.scope.name())) + "," + asString(dependencyKeyValues.get(Properties.optional.name())) + "));");
                  final Node newDependency = newDependency(dependencyKeyValues.get(Properties.groupId.name()), dependencyKeyValues.get(Properties.artifactId.name()), dependencyKeyValues.get(Properties.version.name()), dependencyKeyValues.get(Properties.type.name()), dependencyKeyValues.get(Properties.scope.name()), dependencyKeyValues.get(Properties.optional.name()));
                  nodes.add(newDependency);
               } else {
                  nodes.add(foundDependency.iterator().next());
               }

               break;
            }
         }
      }

      return nodes;
   }

   private String asString(String s) {
      return s == null ? "null" : "\"" + s + "\"";
   }

   private Node traverse(org.w3c.dom.Node node, Node parentNode) {
      switch (node.getNodeType()) {

         case org.w3c.dom.Node.ELEMENT_NODE: {
            final Element element = (Element) node;

            final Node newNode = getGraph().newNode(Label.label(element.getTagName()), AppMotif.Properties.name.name(), element.getTagName());
            if (parentNode != null) relate(parentNode, newNode, RelationshipType.withName(element.getTagName()));

            final NodeList childNodes = element.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++)
               traverse(childNodes.item(i), newNode);
            return newNode;
         }

         case org.w3c.dom.Node.TEXT_NODE: {
            final Text text = (Text) node;
            if (text.getWholeText().trim().length() == 0) break;

            final Node valueNode = getGraph().newNode(DomainPlugin.Entities.Value, AppMotif.Properties.name.name(), text.getWholeText());
            relate(parentNode, valueNode, RelationshipType.withName(getString(parentNode, AppMotif.Properties.name.name())));
            return valueNode;
         }
      }

      return null;
   }
}