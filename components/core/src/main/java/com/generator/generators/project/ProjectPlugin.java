package com.generator.generators.project;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.DomainMotif;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.domain.DomainVisitor;
import com.generator.generators.easyFlow.EasyFlowPlugin;
import com.generator.generators.excel.ExcelPlugin;
import com.generator.generators.gradle.GradlePlugin;
import com.generator.generators.java.JavaPlugin;
import com.generator.generators.javapoet.JavaPoetPlugin;
import com.generator.generators.json.JsonGroup;
import com.generator.generators.maven.MavenPlugin;
import com.generator.generators.mysql.MySQLPlugin;
import com.generator.generators.ssh.SSHPlugin;
import com.generator.util.GeneratedFile;
import com.generator.generators.stringtemplate.StringTemplateDomainPlugin;
import com.generator.generators.stringtemplate.StringTemplatePlugin;
import com.generator.neo.NeoModel;
import com.generator.util.*;
import com.jcraft.jsch.Session;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.stream.LogOutputStream;
import org.zeroturnaround.zip.ZipUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import static com.generator.app.DomainMotif.getEntityProperty;
import static com.generator.util.NeoUtil.*;

/**
 * Created 06.08.17.
 */
public class ProjectPlugin extends ProjectDomainPlugin {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ProjectPlugin.class);

   private final ProjectGroup projectGroup = new ProjectGroup();

   public enum Filetype {
      java, plain, namedFile, groupFile
   }

   public ProjectPlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.Project);
      addShowMenu(menu, Entities.Directory);

      menu.add(new App.TransactionAction("New Project", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            final String input = SwingUtil.showInputDialog("Project name groupId artifactId version", app);
            if (input == null || input.length() == 0) return;

            final String[] split = input.split(" ");
            final String name = split[0];
            final String groupId = split.length > 1 ? split[1] : null;
            final String artifactId = split.length > 2 ? split[2] : null;
            final String version = split.length > 3 ? split[3] : null;

            final Node projectNode = newProject(name, groupId, artifactId, version, null, false);
            fireNodesLoaded(projectNode);
            relateGENERATOR_ROOT(projectNode, newDirectory(name + "-root", "/home/goe/projects/nextgen/components/core/src/main/java"));
         }
      });
   }

   @Override
   protected void handleProject(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
      pop.add(new App.TransactionAction("Add Directory", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final File dir = SwingUtil.showOpenDir(app, System.getProperty("user.home"));
            if (dir == null) return;

            final Node fileNode = setPathProperty(newDirectory(), dir.getPath());
            relateDIRECTORY(neoNode.getNode(), fileNode);
            fireNodesLoaded(fileNode);
         }
      });

      if (hasOutgoing(neoNode.getNode(), Relations.DIRECTORY)) {
         pop.add(new App.TransactionAction("Render All directories", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               app.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
               outgoingDIRECTORY(neoNode.getNode(), (relationship, other) -> renderDirectory(other));
               app.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
         });
      }

      if (hasOutgoing(neoNode.getNode(), Relations.GENERATOR_ROOT)) {

         final Node directoryNode = singleOutgoingGENERATOR_ROOT(neoNode.getNode());

         pop.add(new App.TransactionAction("Generate generator", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               app.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

               final Node projectNode = neoNode.getNode();

               final File outputDirectory = projectNode.hasProperty("outputDir") ? new File(projectNode.getProperty("outputDir").toString()) : selectOutputDir(projectNode);
               if (outputDirectory == null) return;

               final String projectName = getNameProperty(projectNode, "").replaceAll("-", "_");
               final String packageName = "projects." + projectName.toLowerCase();
               final File path = getFile(directoryNode);

               final GeneratedFile configFile = GeneratedFile.newPlainFile(path.getAbsolutePath(), GeneratedFile.packageToPath(packageName), projectName + ".json");
               if (!configFile.exists()) {
                  final JsonGroup jsonGroup = new JsonGroup();
                  final JsonGroup.documentST defaultConfigJson = jsonGroup.newdocument().
                        addContentValue(jsonGroup.newobject().
                              addPairsValue("root", "\"" + outputDirectory.getAbsolutePath() + "\"").
                              addPairsValue("main.src", "\"" + new File(outputDirectory, "src" + File.separatorChar + "main" + File.separatorChar + "java").getAbsolutePath() + "\"").
                              addPairsValue("test.src", "\"" + new File(outputDirectory, "src" + File.separatorChar + "test" + File.separatorChar + "java").getAbsolutePath() + "\"").
                              addPairsValue("web.src", "\"" + new File(outputDirectory, "src" + File.separatorChar + "main" + File.separatorChar + "web").getAbsolutePath() + "\"").
                              addPairsValue("test.resources", "\"" + new File(outputDirectory, "src" + File.separatorChar + "main" + File.separatorChar + "resources").getAbsolutePath() + "\"").
                              addPairsValue("main.resources", "\"" + new File(outputDirectory, "src" + File.separatorChar + "main" + File.separatorChar + "resources").getAbsolutePath() + "\"")
                        );

                  configFile.write(defaultConfigJson);
               }

               final ProjectGroup.ProjectST projectST = projectGroup.newProject().
                     setPackageName(packageName).
                     setName(projectName).
                     setConfigPath(configFile.getFile().getAbsolutePath()).
                     setDescription(getDescriptionProperty(projectNode)).
                     setVersion(getVersionProperty(projectNode)).
                     setGroupId(getGroupIdProperty(projectNode)).
                     setArtifactId(getArtifactIdProperty(projectNode)).
                     setVerticleTests(getIsVertxProjectProperty(projectNode, false));

               outgoingGENERATOR(projectNode, (relationship, stGroupNode) -> incomingRENDERER(stGroupNode, (rendererRelation, other) -> {
                  final String groupPackage = getPackageNameProperty(rendererRelation);
                  projectST.addGeneratorsValue(StringUtil.capitalize(getNameProperty(stGroupNode)) + "Group", groupPackage);
               }));

               GeneratedFile.newJavaFile(path, packageName, projectName).write(projectST);

               app.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

            private File selectOutputDir(Node node) {
               final File file = FileUtil.selectDirectory(app, new File(System.getProperty("user.home")));
               if (file != null) node.setProperty("outputDir", file.getAbsolutePath());
               return file;
            }
         });
      }

      for (NeoNode selectedNode : selectedNodes) {
         if (hasLabel(selectedNode.getNode(), StringTemplateDomainPlugin.Entities.STGroup)) {

            pop.add(new App.TransactionAction("Render All directories", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  app.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                  outgoingDIRECTORY(neoNode.getNode(), (relationship, other) -> renderDirectory(other));
                  app.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
               }
            });
         }
      }
   }

   @Override
   protected void handleDirectory(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      if (DomainMotif.hasEntityProperty(neoNode.getNode(), Properties.path.name())) {
         pop.add(new App.TransactionAction("Render " + getPathProperty(neoNode.getNode()), app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               app.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
               renderDirectory(neoNode.getNode());
               app.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
         });
      }

      final File dir = getFile(neoNode.getNode());
      if (dir != null && dir.exists()) {

         pop.add(new App.TransactionAction("Open gnome-terminal here", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               new ProcessExecutor().
                     directory(dir).
                     command("gnome-terminal", "--working-directory=" + dir.getAbsolutePath())
                     .redirectOutput(app.logWindow.getLogOutputStream()).execute();
            }
         });


         final File[] files = dir.listFiles();
         if (files != null) {
            for (File file : files) {
               if ("pom.xml".equals(file.getName()))
                  pop.add(MavenPlugin.createPomLifecycleMenu(file.getParentFile(), app));
               else if ("gradlew".equals(file.getName())) {
                  pop.add(GradlePlugin.createGradlewBuild(file.getParentFile(), app));
               }
            }
         }

         pop.add(new App.TransactionAction("Add File", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final JTextField txtName = new JTextField();
               final JTextField txtExtension = new JTextField();

               SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu, 100dlu", "pref, 4dlu, pref");
               editor.addLabel("Name", 1, 1);
               editor.add(txtName, 3, 1);
               editor.addLabel("Extension", 1, 3);
               editor.add(txtExtension, 3, 3);
               editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

               SwingUtil.showDialog(editor, app, "New File", new SwingUtil.ConfirmAction() {
                  @Override
                  public void verifyAndCommit() throws Exception {

                     final String name = txtName.getText();
                     final String extension = (txtExtension.getText().startsWith(".") ? txtExtension.getText() : ("." + txtExtension.getText()));
                     if (name.length() == 0 || extension.length() == 0) return;

                     final File newFile = FileUtil.tryToCreateFileIfNotExists(new File(dir, name + extension));

                     if (newFile.exists()) {
                        getGraph().doInTransaction(new NeoModel.Committer() {
                           @Override
                           public void doAction(Transaction tx) throws Throwable {
                              final Node fileNode = setExtensionProperty(newFile(null, name, null), extension);
                              relateFILE(neoNode.getNode(), fileNode);
                              fireNodesLoaded(fileNode);
                           }

                           @Override
                           public void exception(Throwable throwable) {
                              SwingUtil.showException(app, throwable);
                           }
                        });
                     }
                  }
               });
            }
         });

         pop.add(new App.TransactionAction("Zip Directory", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final File openDir = SwingUtil.showOpenDir(app, System.getProperty("user.home"));
               if (openDir == null || !openDir.exists()) return;

               new Thread(() -> {
                  log.info("Zipping " + dir.getAbsolutePath());
                  final File zipFile = new File(openDir, dir.getName() + ".zip");
                  ZipUtil.pack(dir, zipFile);
                  log.info("Zip complete : " + zipFile.getAbsolutePath());
               }).start();

            }
         });
      }

      for (NeoNode selectedNode : selectedNodes) {

         if (StringTemplatePlugin.isSTGroup(selectedNode.getNode())) {

            if (isRelated(neoNode.getNode(), selectedNode.getNode(), Relations.RENDERER))
               return;

            pop.add(new App.TransactionAction("Add renderer for STGroup " + getNameOrLabelFrom(selectedNode.getNode()), app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final String packageName = SwingUtil.showInputDialog("Package", app);
                  if (packageName == null) return;

                  final String className = getEntityProperty(neoNode.getNode(), AppMotif.Properties.name.name());

                  final Relationship rendererRelationship = neoNode.getNode().createRelationshipTo(selectedNode.getNode(), Relations.RENDERER);
                  rendererRelationship.setProperty(Properties.fileType.name(), Filetype.groupFile.name());
                  rendererRelationship.setProperty(Properties.packageName.name(), packageName);
                  rendererRelationship.setProperty(Properties.className.name(), className + "Group");
               }
            });

         } else if (MySQLPlugin.isDatabase(selectedNode.getNode())) {

            if (isRelated(neoNode.getNode(), selectedNode.getNode(), Relations.RENDERER))
               return;

            MySQLPlugin.showAddDAORenderer(neoNode, selectedNode, pop, app);

         } else if (JavaPoetPlugin.isJavaFile(selectedNode.getNode())) {

            if (isRelated(neoNode.getNode(), selectedNode.getNode(), Relations.RENDERER))
               return;

            JavaPoetPlugin.showAddJavaFileRenderer(neoNode, selectedNode, pop, app);

         } else if (ExcelPlugin.isWorkbook(selectedNode.getNode())) {

            if (isRelated(neoNode.getNode(), selectedNode.getNode(), Relations.RENDERER))
               return;

            pop.add(new App.TransactionAction("Add Renderer for " + getNameOrLabelFrom(selectedNode.getNode()), app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  relateRENDERER(selectedNode.getNode(), neoNode.getNode());
               }
            });

         } else if (JavaPlugin.isClass(selectedNode.getNode())) {

            if (isRelated(neoNode.getNode(), selectedNode.getNode(), Relations.RENDERER))
               return;

            pop.add(new App.TransactionAction("Add Renderer for " + getNameOrLabelFrom(selectedNode.getNode()), app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  relateRENDERER(selectedNode.getNode(), neoNode.getNode());
               }
            });

         } else if (SSHPlugin.isPath(selectedNode.getNode())) {

            pop.add(new App.TransactionAction("Download file from host", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final String hostPath = getNameProperty(selectedNode.getNode());
                  final String target = SwingUtil.showInputDialog("File relative to " + hostPath, app);
                  if (target == null || target.length() == 0) return;

                  final File localDirectory = getFile(neoNode.getNode());

                  final Session session = SSHPlugin.getSession(other(selectedNode.getNode(), singleIncoming(selectedNode.getNode(), SSHPlugin.Relations.PATHS)));

                  SSHPlugin.download(session, localDirectory.getAbsolutePath(), hostPath + target);
                  session.disconnect();
               }
            });
         }

         if (NeoUtil.hasLabel(selectedNode.getNode(), EasyFlowPlugin.Entities.Flow)) {

            if (isRelated(neoNode.getNode(), selectedNode.getNode(), Relations.RENDERER))
               return;

            pop.add(new App.TransactionAction("Add renderer for FSM", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final String packageName = SwingUtil.showInputDialog("Package", app);
                  if (packageName == null) return;

                  final String className = getEntityProperty(neoNode.getNode(), AppMotif.Properties.name.name());

                  final Relationship rendererRelationship = neoNode.getNode().createRelationshipTo(selectedNode.getNode(), Relations.RENDERER);
                  rendererRelationship.setProperty(Properties.fileType.name(), Filetype.java.name());
                  rendererRelationship.setProperty(Properties.packageName.name(), packageName);
                  rendererRelationship.setProperty(Properties.className.name(), className);
               }
            });
         }

         if (hasLabel(selectedNode.getNode(), DomainPlugin.Entities.Domain)) {

            if (isRelated(neoNode.getNode(), selectedNode.getNode(), Relations.RENDERER))
               return;

            pop.add(new App.TransactionAction("Add renderer for visitor " + getNameOrLabelFrom(selectedNode.getNode()), app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final String packageName = SwingUtil.showInputDialog("Package", app);
                  if (packageName == null) return;

                  final String className = getEntityProperty(neoNode.getNode(), AppMotif.Properties.name.name());

                  final Relationship rendererRelationship = neoNode.getNode().createRelationshipTo(selectedNode.getNode(), Relations.RENDERER);
                  rendererRelationship.setProperty(Properties.fileType.name(), Filetype.groupFile.name());
                  rendererRelationship.setProperty(Properties.packageName.name(), packageName);
                  rendererRelationship.setProperty(Properties.className.name(), className + "Group");
               }
            });
         }

         final Relationship selectedNodeInstanceRelation = singleIncoming(selectedNode.getNode(), DomainPlugin.Relations.INSTANCE);
         if (selectedNodeInstanceRelation == null) continue;

         final Node entityNode = other(selectedNode.getNode(), selectedNodeInstanceRelation);

         if (StringTemplatePlugin.isSTTemplate(entityNode)) {

            if (isRelated(neoNode.getNode(), selectedNode.getNode(), Relations.RENDERER))
               return;

            pop.add(new App.TransactionAction("Add renderer for " + getNameOrLabelFrom(selectedNode.getNode()), app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final Object[] properties = asArray(entityNode);

                  final JRadioButton radJavaFile = new JRadioButton("Java file");
                  final JComboBox<Object> cboPackageProperty = new JComboBox<>(properties);
                  SwingUtil.selectByLevensthein(cboPackageProperty, properties, Properties.packageName.name());
                  final JComboBox<Object> cboClassnameProperty = new JComboBox<>(properties);
                  SwingUtil.selectByLevensthein(cboClassnameProperty, properties, "name");

                  final JRadioButton radPlainFile = new JRadioButton("Plain file");
                  final JTextField txtPlainFileDir = new JTextField();
                  final JTextField txtPlainFileExtension = new JTextField();
                  final JTextField txtFilename = new JTextField();

                  final JRadioButton radNamedFile = new JRadioButton("Plain file");
                  final JComboBox<Object> cboFilenameProperty = new JComboBox<>(properties);
                  final JTextField txtNamedFileDir = new JTextField();
                  final JTextField txtExtension = new JTextField();

                  final ButtonGroup group = new ButtonGroup();
                  group.add(radJavaFile);
                  group.add(radPlainFile);
                  group.add(radNamedFile);

                  final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu,4dlu,100dlu", "pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref");
                  editor.add(radJavaFile, 1, 1);
                  editor.addLabel("Package", 3, 1);
                  editor.add(cboPackageProperty, 5, 1);
                  editor.addLabel(Properties.className.name(), 3, 3);
                  editor.add(cboClassnameProperty, 5, 3);
                  editor.add(radPlainFile, 1, 5);
                  editor.addLabel(Properties.filename.name(), 3, 5);
                  editor.add(txtFilename, 5, 5);
                  editor.addLabel(Properties.extension.name(), 3, 7);
                  editor.add(txtPlainFileExtension, 5, 7);
                  editor.addLabel("Path", 3, 9);
                  editor.add(txtPlainFileDir, 5, 9);
                  editor.add(radNamedFile, 1, 11);
                  editor.addLabel(Properties.filename.name(), 3, 11);
                  editor.add(cboFilenameProperty, 5, 11);
                  editor.addLabel("Path", 3, 13);
                  editor.add(txtNamedFileDir, 5, 13);
                  editor.addLabel("Filetype", 3, 15);
                  editor.add(txtExtension, 5, 15);

                  editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
                  SwingUtil.showDialog(editor, app, "Renderer", new SwingUtil.ConfirmAction() {
                     @Override
                     public void verifyAndCommit() throws Exception {

                        getGraph().doInTransaction(new NeoModel.Committer() {
                           @Override
                           public void doAction(Transaction tx1) throws Throwable {
                              final Relationship rendererRelationship = neoNode.getNode().createRelationshipTo(selectedNode.getNode(), Relations.RENDERER);

                              if (radJavaFile.isSelected()) {
                                 if (cboPackageProperty.getSelectedItem().toString().equals(cboClassnameProperty.getSelectedItem().toString()))
                                    throw new IllegalStateException("package and classname are using same parameter.");
                                 rendererRelationship.setProperty(Properties.fileType.name(), Filetype.java.name());
                                 rendererRelationship.setProperty(Properties.packageName.name(), cboPackageProperty.getSelectedItem().toString());
                                 rendererRelationship.setProperty(Properties.className.name(), cboClassnameProperty.getSelectedItem().toString());

                              } else if (radPlainFile.isSelected()) {
//                              if (txtPlainFileExtension.getText().trim().length() == 0)
//                                 throw new IllegalStateException("file must have an extension");
                                 if (txtFilename.getText().trim().length() == 0)
                                    throw new IllegalStateException("file must be set");
//                                 if (txtPlainFileDir.getText().trim().length() == 0)
//                                    throw new IllegalStateException("file must have a path");
                                 rendererRelationship.setProperty(Properties.fileType.name(), Filetype.plain.name());
                                 rendererRelationship.setProperty(Properties.dir.name(), txtPlainFileDir.getText().trim());
                                 rendererRelationship.setProperty(Properties.file.name(), txtFilename.getText().trim());
                                 rendererRelationship.setProperty(Properties.extension.name(), txtPlainFileExtension.getText().trim());

                              } else if (radNamedFile.isSelected()) {
                                 if (txtExtension.getText().trim().length() == 0)
                                    throw new IllegalStateException("file must have an extension");
                                 if (txtNamedFileDir.getText().trim().length() == 0)
                                    throw new IllegalStateException("file must have a path");
                                 rendererRelationship.setProperty(Properties.fileType.name(), Filetype.namedFile.name());
                                 rendererRelationship.setProperty(Properties.filename.name(), cboFilenameProperty.getSelectedItem().toString());
                                 rendererRelationship.setProperty(Properties.dir.name(), txtNamedFileDir.getText().trim());
                                 rendererRelationship.setProperty(Properties.extension.name(), txtExtension.getText().trim());
                              }
                           }

                           @Override
                           public void exception(Throwable throwable) {
                              SwingUtil.showException(editor, throwable);
                           }
                        });
                     }
                  });
               }

               private Object[] asArray(Node templateNode) {
                  final java.util.List<Object> array = new ArrayList<>();
                  new DomainPlugin.EntityRelationVisitor() {
                     @Override
                     public void onSingle(Node relationNode, Node dstNode) {
                        if (!hasLabel(dstNode, DomainPlugin.Entities.Property)) return;
                        array.add(getNameProperty(dstNode));
                     }

                     @Override
                     public void onList(Node relationNode, Node dstNode) {

                     }
                  }.visit(templateNode);

                  return array.toArray();
               }
            });
         }
      }


      pop.add(new JSeparator());

      final File getDir = getFile(neoNode.getNode());
      if (getDir != null && getDir.exists()) {
         pop.add(new App.TransactionAction("List directory", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final StringBuilder out = new StringBuilder();
               new ProcessExecutor().directory(getDir).command("ls", "-ltr")
                     .redirectOutput(new LogOutputStream() {
                        @Override
                        protected void processLine(String line) {
                           out.append(line).append("\n");
                        }
                     }).execute();
               SwingUtil.showTextResult("List", out.toString().trim(), app);
            }
         });
      }
   }

   @Override
   protected void handleFile(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
      pop.add(new App.TransactionAction("Change name", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String oldFilename = getNameProperty(neoNode.getNode());
            final String newFilename = SwingUtil.showInputDialog("Filename", app, oldFilename);
            if (newFilename == null || newFilename.length() == 0) return;

            final Node directoryNode = other(neoNode.getNode(), singleIncoming(neoNode.getNode(), Relations.FILE));
            final File getDir = getFile(directoryNode);

            final String extension = getExtensionProperty(neoNode.getNode());
            final File file = new File(getDir, oldFilename + extension);

            if (file.renameTo(new File(getDir, newFilename + extension))) {
               neoNode.getNode().setProperty(AppMotif.Properties.name.name(), newFilename);
               fireNodeChanged(neoNode.getNode());
            }
         }
      });

      pop.add(new App.TransactionAction("Change type", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String oldExtension = getExtensionProperty(neoNode.getNode());
            final String newExtension = SwingUtil.showInputDialog("Type", app, oldExtension);
            if (newExtension == null || newExtension.length() == 0) return;

            final Node directoryNode = other(neoNode.getNode(), singleIncoming(neoNode.getNode(), Relations.FILE));
            final File getDir = getFile(directoryNode);

            final String filename = getNameProperty(neoNode.getNode());
            final File file = new File(getDir, filename + oldExtension);

            if (file.renameTo(new File(getDir, filename + newExtension))) {
               neoNode.getNode().setProperty(Properties.extension.name(), newExtension);
               fireNodeChanged(neoNode.getNode());
            }
         }
      });
   }

   private void renderDirectory(Node node) {

      outgoingRENDERER(node, (rendererRelationship, nodeToRender) -> {
         if (hasLabel(nodeToRender, StringTemplatePlugin.Entities.STGroup)) {
            new StringTemplatePlugin.STGGroupRenderer(rendererRelationship).visit(nodeToRender);
         } else if (hasLabel(nodeToRender, DomainPlugin.Entities.Domain)) {
            DomainPlugin.renderDomainVisitor(rendererRelationship, nodeToRender);
         } else if (hasLabel(nodeToRender, EasyFlowPlugin.Entities.Flow)) {
            EasyFlowPlugin.renderEasyFlow(rendererRelationship, nodeToRender);
         } else {

            final Node templateNode = other(nodeToRender, singleIncoming(nodeToRender, DomainPlugin.Relations.INSTANCE));
            if (StringTemplatePlugin.isSTTemplate(templateNode))
               renderToFile(rendererRelationship, nodeToRender, StringTemplatePlugin.renderStatement(nodeToRender, templateNode), node);

            // visitors:
            incoming(nodeToRender, DomainPlugin.Relations.VISITOR).forEach(visitorRelation -> {
               final Node visitorNode = other(nodeToRender, visitorRelation);

               try {
                  final DomainVisitor visitor = (DomainVisitor) Class.forName(DomainPlugin.getVisitorClassProperty(visitorNode)).
                        getConstructor(Node.class, App.class).
                        newInstance(visitorNode, app);
                  visitor.visit(nodeToRender);
               } catch (Exception e) {
                  e.printStackTrace();
               }
            });
         }
      });

      outgoing(node, Relations.CHILD).forEach(relationship -> renderDirectory(other(node, relationship)));
   }

   @Override
   protected JComponent newProjectEditor(NeoNode projectNode) {
      return new ProjectEditor(projectNode);
   }

   @Override
   protected JComponent newDirectoryEditor(NeoNode neoNode) {
      return new DirectoryEditor(neoNode);
   }

   @Override
   protected JComponent newFileEditor(NeoNode neoNode) {
      return new PlainFileEditor(neoNode);
   }

   public static void renderToFile(Relationship rendererRelationship, Node statementNode, String content, Node dirNode) {
      final File targetDir = FileUtil.tryToCreateDirIfNotExists(getFile(dirNode));
      switch (Filetype.valueOf(getFileTypeProperty(rendererRelationship))) {

         case java: {
            final String packageName = getEntityProperty(statementNode, getPackageNameProperty(rendererRelationship));
            final String className = getEntityProperty(statementNode, getClassNameProperty(rendererRelationship));
            try {
               GeneratedFile.newJavaFile(targetDir.getPath(), packageName, className).write(content);
            } catch (IOException e) {
               log.info("Could not generate java file for " + packageName + " " + className);
            }
            break;
         }

         case plain: {
            final String dir = getDirProperty(rendererRelationship);
            final String filename = getFileProperty(rendererRelationship);
            final String extension = getExtensionProperty(rendererRelationship);
            final String fullFilename = filename + (extension == null || extension.length() == 0 ? "" : (extension.startsWith("[.]") ? extension : ("." + extension)));
            FileUtil.write(content, dir == null || dir.length() == 0 ? new File(targetDir, fullFilename) : new File(new File(targetDir, dir), fullFilename));
            break;
         }

         case namedFile: {
            final String filename = getEntityProperty(statementNode, getFilenameProperty(rendererRelationship));
            final String dir = getDirProperty(rendererRelationship);
            final String extension = getExtensionProperty(rendererRelationship);
            final String fullFilename = filename + (extension == null || extension.length() == 0 ? "" : (extension.startsWith("[.]") ? extension : ("." + extension)));
            FileUtil.write(content, dir == null || dir.length() == 0 ? new File(targetDir, fullFilename) : new File(new File(targetDir, dir), fullFilename));
            break;
         }
      }
   }

   public static File getFile(Node node) {
      final Node parentNode = other(node, singleIncoming(node, Relations.CHILD));
      final String path = getPathProperty(node);
      return path == null ? null : (parentNode == null ? new File(path) : new File(getFile(parentNode), path));
   }

   private final class DirectoryEditor extends JPanel {
      DirectoryEditor(NeoNode node) {
         super(new BorderLayout());

         final JTextArea txtEditor = SwingUtil.newTextArea();

         final StringBuilder out = new StringBuilder();
         final File getDir = getFile(node.getNode());
         if (getDir != null) listDirectory(getDir, out);
         txtEditor.setText(out.toString().trim());
         txtEditor.setCaretPosition(0);

         txtEditor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if (SwingUtilities.isRightMouseButton(e))
                  SwingUtilities.invokeLater(() -> {
                     final TextProcessingPanel processingPanel = new TextProcessingPanel(txtEditor.getText(), Collections.emptySet());
                     SwingUtil.showDialog(processingPanel, app, "Process Text", new SwingUtil.ConfirmAction() {
                        @Override
                        public void verifyAndCommit() throws Exception {
                           final String outputText = processingPanel.getOutputText();
                           if (outputText.trim().length() == 0) return;
                           SwingUtil.toClipboard(outputText);
                        }
                     });
                  });
            }
         });

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }

      private void listDirectory(File getDir, StringBuilder out) {
         out.append("\n").append(getDir.getPath()).append("\n");
         final File[] files = getDir.listFiles();
         if (files == null) return;
         for (File file : files) {
            if (file.isFile()) out.append(file.getPath()).append("\n");
            else listDirectory(file, out);
         }
      }
   }

   private final class ProjectEditor extends JPanel {
      ProjectEditor(NeoNode node) {
         super(new BorderLayout());

         final JTextArea txtEditor = SwingUtil.newTextArea();

         final StringBuilder out = new StringBuilder();
         listDirectories(node.getNode(), out);
         txtEditor.setText(out.toString().trim());
         txtEditor.setCaretPosition(0);

         txtEditor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if (SwingUtilities.isRightMouseButton(e))
                  SwingUtilities.invokeLater(() -> {
                     final TextProcessingPanel processingPanel = new TextProcessingPanel(txtEditor.getText(), Collections.emptySet());
                     SwingUtil.showDialog(processingPanel, app, "Process Text", new SwingUtil.ConfirmAction() {
                        @Override
                        public void verifyAndCommit() throws Exception {
                           final String outputText = processingPanel.getOutputText();
                           if (outputText.trim().length() == 0) return;
                           SwingUtil.toClipboard(outputText);
                        }
                     });
                  });
            }
         });

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }

      private void listDirectories(Node projectNode, StringBuilder out) {
         out.append("Project \"").append(getNameProperty(projectNode, "")).append("\" : \n");
         outgoingDIRECTORY(projectNode, (relationship, directoryNode) -> out.append("\n\t").append(getNameProperty(directoryNode, "")).append(" : ").append(getPathProperty(directoryNode, "")));
      }
   }

   private final class PlainFileEditor extends JPanel {
      PlainFileEditor(NeoNode node) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtEditor.setTabSize(3);

         final Node directoryNode = other(node.getNode(), singleIncoming(node.getNode(), Relations.FILE));
         final File getDir = getFile(directoryNode);
         final File file = new File(getDir, getNameProperty(node.getNode()) + "" + getExtensionProperty(node.getNode()));
         final String text = ""; // FileUtil.readIntact(file).trim();

         final Color uneditedColor = txtEditor.getBackground();
         final Color editedColor = Color.decode("#fc8d59");

         txtEditor.setText(text);
         txtEditor.setCaretPosition(0);
         txtEditor.addKeyListener(new KeyAdapter() {

            String startText = text;

            public void keyPressed(KeyEvent ke) {

               if (ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                  final int oldCaret = txtEditor.getCaretPosition();
                  final String newText = txtEditor.getText().trim();
                  FileUtil.write(newText, file);
                  txtEditor.setCaretPosition(Math.min(newText.length(), Math.max(0, oldCaret)));
                  startText = txtEditor.getText().trim();
                  txtEditor.setBackground(uneditedColor);
               } else {
                  SwingUtilities.invokeLater(() -> txtEditor.setBackground(startText.equals(txtEditor.getText().trim()) ? uneditedColor : editedColor));
               }
            }
         });

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }
   }
}