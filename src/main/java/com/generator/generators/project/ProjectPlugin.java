package com.generator.generators.project;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.DomainMotif;
import com.generator.app.Workspace;
import com.generator.generators.easyFlow.EasyFlowPlugin;
import com.generator.generators.stringtemplate.StringTemplatePlugin;
import com.generator.BaseDomainVisitor;
import com.generator.NeoModel;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.stringtemplate.domain.GeneratedFile;
import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.*;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.stream.LogOutputStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Set;

import static com.generator.app.DomainMotif.getPropertyValue;
import static com.generator.app.DomainMotif.hasPropertyValue;
import static com.generator.generators.domain.DomainPlugin.Entities.Domain;
import static com.generator.generators.domain.DomainPlugin.Entities.Entity;
import static com.generator.BaseDomainVisitor.*;
import static com.generator.NeoModel.getNameAndLabelsFrom;
import static com.generator.NeoModel.getNameOrLabelFrom;
import static com.generator.NeoModel.relate;

/**
 * Created 06.08.17.
 */
public class ProjectPlugin extends DomainPlugin {

   enum Entities implements Label {
      Project, Directory
   }

   public enum Relations implements RelationshipType {
      RENDERER, DIRECTORY, CHILD
   }

   public enum Properties {
      path, fileType, file, filename, dir, extension, className
   }

   private enum Filetype {
      java, plain, namedFile, groupFile
   }

   private final Node domainNode;
   private final Node projectNode;
   private final Node directoryNode;

   public ProjectPlugin(App app) {
      super(app, "Project");

      domainNode = getGraph().findOrCreate(Domain, AppMotif.Properties.name.name(), "Project");
      // use domain-node outgoing to merge here, not findOrCreate
      projectNode = getGraph().findOrCreate(Entity, AppMotif.Properties.name.name(), Entities.Project.name());
      directoryNode = getGraph().findOrCreate(Entity, AppMotif.Properties.name.name(), Entities.Directory.name());

      relate(domainNode, projectNode, DomainPlugin.Relations.ENTITY);
      newEntityProperty(projectNode, AppMotif.Properties.name.name());
      newEntityRelation(projectNode, Relations.DIRECTORY.name(), RelationCardinality.LIST, directoryNode);

      newEntityProperty(directoryNode, AppMotif.Properties.name.name());
      newEntityProperty(directoryNode, Properties.path.name());
      newEntityRelation(directoryNode, Relations.CHILD.name(), RelationCardinality.LIST, directoryNode);
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      final JMenu showMenu = new JMenu("Projects");
      getGraph().findNodes(Entities.Project).forEachRemaining(node -> showMenu.add(new App.TransactionAction("Show " + getNameAndLabelsFrom(node), app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            fireNodesLoaded(true, node);
         }
      }));
      menu.add(showMenu);

      menu.add(new App.TransactionAction("New Project", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            final String name = SwingUtil.showInputDialog("Project name", app);
            if (name == null || name.length() == 0) return;

            final Node newNode = getGraph().newNode(Label.label(getString(projectNode, AppMotif.Properties.name.name())));
            projectNode.createRelationshipTo(newNode, DomainPlugin.Relations.INSTANCE);

            // set name-property = name
            relate(newNode, newValueNode(name), RelationshipType.withName(AppMotif.Properties.name.name()));

            fireNodesLoaded(newNode);
         }
      });
   }

   @Override
   protected void handleNodeRightClick(JPopupMenu pop, Workspace.NodeCanvas.NeoNode neoNode, Set<Workspace.NodeCanvas.NeoNode> selectedNodes) {

      if (hasLabel(neoNode.getNode(), Entities.Project)) {

         pop.add(new App.TransactionAction("Render All directories", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               app.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
               outgoing(neoNode.getNode(), Relations.DIRECTORY).forEach(relationship -> renderDirectory(other(neoNode.getNode(), relationship)));
               app.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
         });


      } else if (hasLabel(neoNode.getNode(), Entities.Directory)) {

         if (hasPropertyValue(neoNode.getNode(), Properties.path.name())) {
            pop.add(new App.TransactionAction("Render " + getPropertyValue(neoNode.getNode(), Properties.path.name()), app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  app.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                  renderDirectory(neoNode.getNode());
                  app.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
               }
            });
         }

         for (Workspace.NodeCanvas.NeoNode selectedNode : selectedNodes) {

            if (BaseDomainVisitor.hasLabel(selectedNode.getNode(), StringTemplatePlugin.Entities.STGroup)) {

               if (isRelated(neoNode.getNode(), selectedNode.getNode(), Relations.RENDERER))
                  return;

               pop.add(new App.TransactionAction("Add renderer for STGroup " + getNameOrLabelFrom(selectedNode.getNode()), app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     final String packageName = SwingUtil.showInputDialog("Package", app);
                     if (packageName == null) return;

                     final String className = DomainMotif.getPropertyValue(neoNode.getNode(), AppMotif.Properties.name.name());

                     final Relationship rendererRelationship = neoNode.getNode().createRelationshipTo(selectedNode.getNode(), Relations.RENDERER);
                     rendererRelationship.setProperty(Properties.fileType.name(), Filetype.groupFile.name());
                     rendererRelationship.setProperty("package", packageName);
                     rendererRelationship.setProperty(Properties.className.name(), className + "Group");
                  }
               });
            }

            if (BaseDomainVisitor.hasLabel(selectedNode.getNode(), EasyFlowPlugin.Entities.Flow)) {

               if (isRelated(neoNode.getNode(), selectedNode.getNode(), Relations.RENDERER))
                  return;

               pop.add(new App.TransactionAction("Add renderer for FSM", app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     final String packageName = SwingUtil.showInputDialog("Package", app);
                     if (packageName == null) return;

                     final String className = DomainMotif.getPropertyValue(neoNode.getNode(), AppMotif.Properties.name.name());

                     final Relationship rendererRelationship = neoNode.getNode().createRelationshipTo(selectedNode.getNode(), Relations.RENDERER);
                     rendererRelationship.setProperty(Properties.fileType.name(), Filetype.java.name());
                     rendererRelationship.setProperty("package", packageName);
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

                     final String className = DomainMotif.getPropertyValue(neoNode.getNode(), AppMotif.Properties.name.name());

                     final Relationship rendererRelationship = neoNode.getNode().createRelationshipTo(selectedNode.getNode(), Relations.RENDERER);
                     rendererRelationship.setProperty(Properties.fileType.name(), Filetype.groupFile.name());
                     rendererRelationship.setProperty("package", packageName);
                     rendererRelationship.setProperty(Properties.className.name(), className + "Group");
                  }
               });
            }

            final Relationship selectedNodeInstanceRelation = singleIncoming(selectedNode.getNode(), DomainPlugin.Relations.INSTANCE);
            if (selectedNodeInstanceRelation == null) continue;

            final Node entityNode = other(selectedNode.getNode(), selectedNodeInstanceRelation);

            if (hasLabel(entityNode, StringTemplatePlugin.Entities.STTemplate)) {

               if (isRelated(neoNode.getNode(), selectedNode.getNode(), Relations.RENDERER))
                  return;

               pop.add(new App.TransactionAction("Add renderer for " + getNameOrLabelFrom(selectedNode.getNode()), app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     final Object[] properties = asArray(entityNode);

                     final JRadioButton radJavaFile = new JRadioButton("Java file");
                     final JComboBox<Object> cboPackageProperty = new JComboBox<>(properties);
                     SwingUtil.selectByLevensthein(cboPackageProperty, properties, "package");
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
                     SwingUtil.showDialog(editor, app, "Renderer", () -> getGraph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx1) throws Throwable {
                           final Relationship rendererRelationship = neoNode.getNode().createRelationshipTo(selectedNode.getNode(), Relations.RENDERER);

                           if (radJavaFile.isSelected()) {
                              if (cboPackageProperty.getSelectedItem().toString().equals(cboClassnameProperty.getSelectedItem().toString()))
                                 throw new IllegalStateException("package and classname are using same parameter.");
                              rendererRelationship.setProperty(Properties.fileType.name(), Filetype.java.name());
                              rendererRelationship.setProperty("package", cboPackageProperty.getSelectedItem().toString());
                              rendererRelationship.setProperty(Properties.className.name(), cboClassnameProperty.getSelectedItem().toString());

                           } else if (radPlainFile.isSelected()) {
                              if (txtPlainFileExtension.getText().trim().length() == 0)
                                 throw new IllegalStateException("file must have an extension");
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
                     }));
                  }

                  private Object[] asArray(Node templateNode) {
                     final java.util.List<Object> array = new ArrayList<>();
                     new DomainPlugin.EntityRelationVisitor() {
                        @Override
                        public void onSingle(Node relationNode, Node dstNode) {
                           if (!hasLabel(dstNode, DomainPlugin.Entities.Property)) return;
                           array.add(getString(dstNode, AppMotif.Properties.name.name()));
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
   }

   private void renderDirectory(Node node) {
      outgoing(node, Relations.RENDERER).forEach(rendererRelationship -> {
         final Node nodeToRender = other(node, rendererRelationship);
         if (hasLabel(nodeToRender, StringTemplatePlugin.Entities.STGroup)) {
            StringTemplatePlugin.renderSTGGroup(nodeToRender, rendererRelationship);
         } else if (hasLabel(nodeToRender, DomainPlugin.Entities.Domain)) {
            DomainPlugin.renderDomainVisitor(rendererRelationship, nodeToRender);
         } else if (hasLabel(nodeToRender, EasyFlowPlugin.Entities.Flow)) {
            EasyFlowPlugin.renderEasyFlow(rendererRelationship, nodeToRender);
         } else {
            final Node templateNode = other(nodeToRender, singleIncoming(nodeToRender, DomainPlugin.Relations.INSTANCE));
            if (hasLabel(templateNode, StringTemplatePlugin.Entities.STTemplate)) {
               renderToFile(rendererRelationship, nodeToRender, StringTemplatePlugin.renderStatement(nodeToRender, templateNode), node, app);
            }
         }
      });

      outgoing(node, Relations.CHILD).forEach(relationship -> renderDirectory(other(node, relationship)));
   }

   @Override
   public void showEditorFor(Workspace.NodeCanvas.NeoNode neoNode, JTabbedPane tabbedPane) {
      incoming(neoNode.getNode(), DomainPlugin.Relations.INSTANCE).forEach(instanceRelation -> {
         final Node instanceNode = other(neoNode.getNode(), instanceRelation);
         if (hasLabel(instanceNode, Entities.Directory)) {
            tabbedPane.add(getString(neoNode.getNode(), AppMotif.Properties.name.name()), new DirectoryEditor(neoNode));
         }
      });
   }

   public static void renderToFile(Relationship rendererRelationship, Node statementNode, String content, Node dirNode, App app) {
      try {
         final File targetDir = FileUtil.tryToCreateDirIfNotExists(getFile(dirNode));
         switch (Filetype.valueOf(getString(rendererRelationship, Properties.fileType.name()))) {

            case java: {
               final String packageName = getPropertyValue(statementNode, getString(rendererRelationship, "package"));
               final String className = getPropertyValue(statementNode, getString(rendererRelationship, Properties.className.name()));
               GeneratedFile.newJavaFile(targetDir.getAbsolutePath(), packageName, className).write(content);
               break;
            }

            case plain: {
               final String dir = getString(rendererRelationship, Properties.dir.name());
               final String filename = getString(rendererRelationship, Properties.file.name());
               final String extension = getString(rendererRelationship, Properties.extension.name());
               final String fullFilename = filename + (extension.startsWith("[.]") ? extension : ("." + extension));
               FileUtil.write(content, dir == null || dir.length() == 0 ? new File(targetDir, fullFilename) : new File(new File(targetDir, dir), fullFilename));
               break;
            }

            case namedFile: {
               final String filename = getPropertyValue(statementNode, getString(rendererRelationship, Properties.filename.name()));
               final String dir = getString(rendererRelationship, Properties.dir.name());
               final String extension = getString(rendererRelationship, Properties.extension.name());
               final String fullFilename = filename + (extension.startsWith("[.]") ? extension : ("." + extension));
               FileUtil.write(content, dir == null || dir.length() == 0 ? new File(targetDir, fullFilename) : new File(new File(targetDir, dir), fullFilename));
               break;
            }
         }

      } catch (Throwable t) {
         app.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
   }

   public static File getFile(Node node) {
      final Node parentNode = other(node, singleIncoming(node, Relations.CHILD));
      final String path = getPropertyValue(node, Properties.path.name());
      return path == null ? null : (parentNode == null ? new File(path) : new File(getFile(parentNode), path));
   }

   private final class DirectoryEditor extends JPanel {
      DirectoryEditor(Workspace.NodeCanvas.NeoNode node) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(new Font("Hack", Font.PLAIN, 10));
         txtEditor.setTabSize(3);
         txtEditor.setCaretPosition(0);

         final StringBuilder out = new StringBuilder();
         final File getDir = ProjectPlugin.getFile(node.getNode());
         if (getDir != null) listDirectory(getDir, out);
         txtEditor.setText(out.toString().trim());

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }

      private void listDirectory(File getDir, StringBuilder out) {
         out.append("\n").append(getDir.getAbsolutePath()).append("\n");
         final File[] files = getDir.listFiles();
         if (files == null) return;
         for (File file : files) {
            if (file.isFile()) out.append(file.getAbsolutePath()).append("\n");
            else listDirectory(file, out);
         }
      }
   }
}