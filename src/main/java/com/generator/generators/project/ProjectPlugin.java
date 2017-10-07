package com.generator.generators.project;

import com.generator.app.*;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.domain.DomainVisitor;
import com.generator.generators.easyFlow.EasyFlowPlugin;
import com.generator.generators.mobx.MobXAppVisitor;
import com.generator.generators.mobx.MobXModelVisitor;
import com.generator.generators.stringtemplate.StringTemplatePlugin;
import com.generator.generators.stringtemplate.domain.GeneratedFile;
import com.generator.neo.NeoModel;
import com.generator.util.FileUtil;
import com.generator.util.NeoUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.*;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.stream.LogOutputStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Set;

import static com.generator.app.DomainMotif.getPropertyValue;
import static com.generator.app.DomainMotif.hasPropertyValue;
import static com.generator.util.NeoUtil.*;

/**
 * Created 06.08.17.
 */
public class ProjectPlugin extends Plugin {

   public enum Entities implements Label {
      Project, Directory, File
   }

   public enum Relations implements RelationshipType {
      RENDERER, DIRECTORY, CHILD, FILE
   }

   public enum Properties {
      path, fileType, file, filename, dir, extension, className
   }

   private enum Filetype {
      java, plain, namedFile, groupFile
   }

   public ProjectPlugin(App app) {
      super(app, "Project");
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.Project);
      addShowMenu(menu, Entities.Directory);

      menu.add(new App.TransactionAction("New Project", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            final String name = SwingUtil.showInputDialog("Project name", app);
            if (name == null || name.length() == 0) return;

            final Node newNode = getGraph().newNode(Entities.Project);

            // set name-property = name
            relate(newNode, DomainMotif.newValueNode(getGraph(), name), RelationshipType.withName(AppMotif.Properties.name.name()));

            fireNodesLoaded(newNode);
         }
      });
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

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

         final File dir = getFile(neoNode.getNode());
         if (dir != null && dir.exists()) {
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
                                 final Node fileNode = getGraph().newNode(Entities.File, AppMotif.Properties.name.name(), name, Properties.extension.name(), extension);
                                 relate(neoNode.getNode(), fileNode, Relations.FILE);
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
         }

         for (NeoNode selectedNode : selectedNodes) {

            if (NeoUtil.hasLabel(selectedNode.getNode(), StringTemplatePlugin.Entities.STGroup)) {

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

            if (NeoUtil.hasLabel(selectedNode.getNode(), EasyFlowPlugin.Entities.Flow)) {

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

            if (hasLabel(selectedNode.getNode(), DomainPlugin.Entities.Entity)) {

               // todo: using Entity.Renderer, try to make a pattern which puts Renderers in apropriate domains (instead of Project-hasLabel(..))

               pop.add(new App.TransactionAction("Add MobX-Model renderer for " + getNameOrLabelFrom(selectedNode.getNode()), app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     final String packageName = SwingUtil.showInputDialog("Package", app);
                     if (packageName == null) return;
//
                     final String className = getString(selectedNode.getNode(), AppMotif.Properties.name.name());

                     final Node visitorNode = getGraph().newNode(DomainPlugin.Entities.Visitor, AppMotif.Properties.name.name(), "MobX Model", DomainPlugin.Properties.visitorClass.name(), MobXModelVisitor.class.getCanonicalName());
                     relate(visitorNode, selectedNode.getNode(), DomainPlugin.Relations.VISITOR);

                     final Relationship rendererRelationship = visitorNode.createRelationshipTo(neoNode.getNode(), Relations.RENDERER);
                     rendererRelationship.setProperty(Properties.fileType.name(), Filetype.plain.name());
                     rendererRelationship.setProperty(Properties.dir.name(), GeneratedFile.packageToPath(packageName));
                     rendererRelationship.setProperty(Properties.file.name(), className);
                     rendererRelationship.setProperty(Properties.extension.name(), "js");

                     fireNodesLoaded(visitorNode);
                  }
               });

               pop.add(new App.TransactionAction("Add MobX-App renderer for " + getNameOrLabelFrom(selectedNode.getNode()), app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     final String packageName = SwingUtil.showInputDialog("Package", app);
                     if (packageName == null) return;
//
                     final String className = getString(selectedNode.getNode(), AppMotif.Properties.name.name());

                     final Node visitorNode = getGraph().newNode(DomainPlugin.Entities.Visitor, AppMotif.Properties.name.name(), "MobX App", DomainPlugin.Properties.visitorClass.name(), MobXAppVisitor.class.getCanonicalName());
                     relate(visitorNode, selectedNode.getNode(), DomainPlugin.Relations.VISITOR);

                     final Relationship rendererRelationship = visitorNode.createRelationshipTo(neoNode.getNode(), Relations.RENDERER);
                     rendererRelationship.setProperty(Properties.fileType.name(), Filetype.plain.name());
                     rendererRelationship.setProperty(Properties.dir.name(), GeneratedFile.packageToPath(packageName));
                     rendererRelationship.setProperty(Properties.file.name(), className);
                     rendererRelationship.setProperty(Properties.extension.name(), "js");

                     fireNodesLoaded(visitorNode);
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
                                    rendererRelationship.setProperty("package", cboPackageProperty.getSelectedItem().toString());
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

      } else if (hasLabel(neoNode.getNode(), Entities.File)) {

         pop.add(new App.TransactionAction("Change name", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String oldFilename = getString(neoNode.getNode(), AppMotif.Properties.name.name());
               final String newFilename = SwingUtil.showInputDialog("Filename", app, oldFilename);
               if (newFilename == null || newFilename.length() == 0) return;

               final Node directoryNode = other(neoNode.getNode(), singleIncoming(neoNode.getNode(), Relations.FILE));
               final File getDir = getFile(directoryNode);

               final String extension = getString(neoNode.getNode(), Properties.extension.name());
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

               final String oldExtension = getString(neoNode.getNode(), Properties.extension.name());
               final String newExtension = SwingUtil.showInputDialog("Type", app, oldExtension);
               if (newExtension == null || newExtension.length() == 0) return;

               final Node directoryNode = other(neoNode.getNode(), singleIncoming(neoNode.getNode(), Relations.FILE));
               final File getDir = getFile(directoryNode);

               final String filename = getString(neoNode.getNode(), AppMotif.Properties.name.name());
               final File file = new File(getDir, filename + oldExtension);

               if (file.renameTo(new File(getDir, filename + newExtension))) {
                  neoNode.getNode().setProperty(Properties.extension.name(), newExtension);
                  fireNodeChanged(neoNode.getNode());
               }
            }
         });
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
            if (hasLabel(templateNode, StringTemplatePlugin.Entities.STTemplate))
               renderToFile(rendererRelationship, nodeToRender, StringTemplatePlugin.renderStatement(nodeToRender, templateNode), node, app);

            // visitors:
            incoming(nodeToRender, DomainPlugin.Relations.VISITOR).forEach(visitorRelation -> {
               final Node visitorNode = other(nodeToRender, visitorRelation);

               try {
                  final DomainVisitor visitor = (DomainVisitor) Class.forName(getString(visitorNode, DomainPlugin.Properties.visitorClass.name())).
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
   public JComponent getEditorFor(NeoNode neoNode) {
      if (hasLabel(neoNode.getNode(), Entities.Directory))
         return new DirectoryEditor(neoNode);
      if (hasLabel(neoNode.getNode(), Entities.File))
         return new PlainFileEditor(neoNode);
      return null;
   }

   public static void renderToFile(Relationship rendererRelationship, Node statementNode, String content, Node dirNode, App app) {
      try {
         final File targetDir = FileUtil.tryToCreateDirIfNotExists(getFile(dirNode));
         switch (Filetype.valueOf(getString(rendererRelationship, Properties.fileType.name()))) {

            case java: {
               final String packageName = getPropertyValue(statementNode, getString(rendererRelationship, "package"));
               final String className = getPropertyValue(statementNode, getString(rendererRelationship, Properties.className.name()));
               GeneratedFile.newJavaFile(targetDir.getPath(), packageName, className).write(content);
               break;
            }

            case plain: {
               final String dir = getString(rendererRelationship, Properties.dir.name());
               final String filename = getString(rendererRelationship, Properties.file.name());
               final String extension = getString(rendererRelationship, Properties.extension.name());
               final String fullFilename = filename + (extension == null || extension.length() == 0 ? "" : (extension.startsWith("[.]") ? extension : ("." + extension)));
               FileUtil.write(content, dir == null || dir.length() == 0 ? new File(targetDir, fullFilename) : new File(new File(targetDir, dir), fullFilename));
               break;
            }

            case namedFile: {
               final String filename = getPropertyValue(statementNode, getString(rendererRelationship, Properties.filename.name()));
               final String dir = getString(rendererRelationship, Properties.dir.name());
               final String extension = getString(rendererRelationship, Properties.extension.name());
               final String fullFilename = filename + (extension == null || extension.length() == 0 ? "" : (extension.startsWith("[.]") ? extension : ("." + extension)));
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
      DirectoryEditor(NeoNode node) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtEditor.setTabSize(3);

         final StringBuilder out = new StringBuilder();
         final File getDir = getFile(node.getNode());
         if (getDir != null) listDirectory(getDir, out);
         txtEditor.setText(out.toString().trim());
         txtEditor.setCaretPosition(0);

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

   private final class PlainFileEditor extends JPanel {
      PlainFileEditor(NeoNode node) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtEditor.setTabSize(3);

         final Node directoryNode = other(node.getNode(), singleIncoming(node.getNode(), Relations.FILE));
         final File getDir = getFile(directoryNode);
         final File file = new File(getDir, getString(node.getNode(), AppMotif.Properties.name.name()) + "" + getString(node.getNode(), Properties.extension.name()));
         final String text = FileUtil.readIntact(file).trim();

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