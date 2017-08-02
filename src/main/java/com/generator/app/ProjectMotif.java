package com.generator.app;

import com.generator.editors.NeoModel;
import com.generator.generators.templates.domain.GeneratedFile;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import static com.generator.app.TemplateMotif.render;
import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.NeoModel.getNameOrLabelFrom;

/**
 * Created 28.07.17.
 */
class ProjectMotif {

   static void onRightClick(JPopupMenu pop, Workspace.NodeCanvas.NeoNode node, Set<Workspace.NodeCanvas.NeoNode> selectedNodes, App app) {

      if (hasLabel(node.getNode(), Entities._Directory)) {

         for (Workspace.NodeCanvas.NeoNode selectedNode : selectedNodes) {
            selectedNode.getNode().getLabels().forEach(label -> app.model.graph().findNodes(TemplateMotif.Entities._STTemplate, AppMotif.Properties.name.name(), label.name()).forEachRemaining(templateNode -> {

               if (isRelated(node.getNode(), selectedNode.getNode(), Relations.RENDERER))
                  return;

               pop.add(new App.TransactionAction("Add renderer for " + getNameOrLabelFrom(selectedNode.getNode()), app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     final Object[] properties = asArray(templateNode);

                     final JRadioButton radJavaFile = new JRadioButton("Java file");
                     final JComboBox<Object> cboPackageProperty = new JComboBox<>(properties);
                     SwingUtil.setClosestSelected(cboPackageProperty, properties, "package");
                     final JComboBox<Object> cboClassnameProperty = new JComboBox<>(properties);
                     SwingUtil.setClosestSelected(cboClassnameProperty, properties, "name");

                     final JRadioButton radPlainFile = new JRadioButton("Plain file");
                     final JTextField txtFilename = new JTextField();

                     final JRadioButton radNamedFile = new JRadioButton("Plain file");
                     final JComboBox<Object> cboFilenameProperty = new JComboBox<>(properties);
                     final JTextField txtExtension = new JTextField();

                     final ButtonGroup group = new ButtonGroup();
                     group.add(radJavaFile);
                     group.add(radPlainFile);
                     group.add(radNamedFile);

                     final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu,4dlu,100dlu", "pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref");
                     editor.add(radJavaFile, 1, 1);
                     editor.addLabel("Package", 3, 1);
                     editor.add(cboPackageProperty, 5, 1);
                     editor.addLabel("Classname", 3, 3);
                     editor.add(cboClassnameProperty, 5, 3);
                     editor.add(radPlainFile, 1, 5);
                     editor.addLabel("Filename", 3, 5);
                     editor.add(txtFilename, 5, 5);
                     editor.add(radNamedFile, 1, 7);
                     editor.addLabel("Filename", 3, 7);
                     editor.add(cboFilenameProperty, 5, 7);
                     editor.addLabel("Filetype", 3, 9);
                     editor.add(txtExtension, 5, 9);

                     editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
                     SwingUtil.showDialog(editor, app, "Renderer", new SwingUtil.OnSave() {
                        @Override
                        public void verifyAndSave() throws Exception {
                           app.model.graph().doInTransaction(new NeoModel.Committer() {
                              @Override
                              public void doAction(Transaction tx) throws Throwable {
                                 final Relationship rendererRelationship = node.getNode().createRelationshipTo(selectedNode.getNode(), Relations.RENDERER);

                                 if (radJavaFile.isSelected()) {
                                    if (cboPackageProperty.getSelectedItem().toString().equals(cboClassnameProperty.getSelectedItem().toString()))
                                       throw new IllegalStateException("package and classname are using same parameter.");
                                    rendererRelationship.setProperty(ProjectMotif.Properties._filetype.name(), ProjectMotif.Filetype.java.name());
                                    rendererRelationship.setProperty("package", cboPackageProperty.getSelectedItem().toString());
                                    rendererRelationship.setProperty("className", cboClassnameProperty.getSelectedItem().toString());

                                 } else if (radPlainFile.isSelected()) {
                                    if (txtFilename.getText().trim().length() == 0)
                                       throw new IllegalStateException("file must be set");
                                    rendererRelationship.setProperty(ProjectMotif.Properties._filetype.name(), ProjectMotif.Filetype.plain.name());
                                    rendererRelationship.setProperty("file", txtFilename.getText().trim());

                                 } else if (radNamedFile.isSelected()) {
                                    if (txtExtension.getText().trim().length() == 0)
                                       throw new IllegalStateException("file must have an extension");
                                    rendererRelationship.setProperty(ProjectMotif.Properties._filetype.name(), ProjectMotif.Filetype.namedFile.name());
                                    rendererRelationship.setProperty("filename", cboFilenameProperty.getSelectedItem().toString());
                                    rendererRelationship.setProperty("extension", txtExtension.getText().trim());
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
                     outgoing(templateNode, TemplateMotif.Relations.TEMPLATE_PARAMETER).forEach(relationship -> {
                        final Node parameterNode = other(templateNode, relationship);
                        final String parameterName = getString(parameterNode, AppMotif.Properties.name.name());
                        // do not use if its deprecated
                        if (parameterNode.hasProperty(TemplateMotif.Properties._deprecated.name()))
                           return;
                        if (hasLabel(parameterNode, TemplateMotif.Entities._Single))
                           array.add(parameterName);
                     });
                     return array.toArray();
                  }
               });
            }));
         }

         pop.add(new App.TransactionAction("Render", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               app.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
               outgoing(node.getNode(), Relations.RENDERER).forEach(rendererRelationship -> {
                  final Node statementNode = other(node.getNode(), rendererRelationship);
                  final Node templateNode = other(statementNode, singleIncoming(statementNode, TemplateMotif.Relations.TEMPLATE));
                  final String content = render(statementNode, templateNode, app.model.graph());
                  renderToFile(rendererRelationship, statementNode, content, node.getNode(), app);
               });
               app.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
         });

         pop.add(new JSeparator());

         final File getDir = getFile(node.getNode());

         if (getDir.exists()) {
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

         pop.add(new App.TransactionAction("Add directory", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Name", app);
               if (name == null || name.trim().length() == 0) return;

               final Node newNode = app.model.graph().newNode(Entities._Directory, Properties._path.name(), name, AppMotif.Properties.name.name(), name);
               node.getNode().createRelationshipTo(newNode, Relations.CHILD);
               app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(newNode));
            }
         });
      }
   }

   static void renderToFile(Relationship rendererRelationship, Node statementNode, String content, Node dirNode, App app) {
      try {
         final File targetDir = FileUtil.tryToCreateDirIfNotExists(getFile(dirNode));
         switch (Filetype.valueOf(getString(rendererRelationship, Properties._filetype.name()))) {
            case java:
               final String packageName = TemplateMotif.getValue(statementNode, getString(rendererRelationship, "package"));
               final String className = TemplateMotif.getValue(statementNode, getString(rendererRelationship, "className"));
               GeneratedFile.newJavaFile(targetDir.getAbsolutePath(), packageName, className).write(content);
               break;
            case plain:
               FileUtil.write(content, new File(targetDir, getString(rendererRelationship, "file")));
               break;
            case namedFile:
               final String filename = TemplateMotif.getValue(statementNode, getString(rendererRelationship, "filename"));
               final String extension = getString(rendererRelationship, "extension");
               FileUtil.write(content, new File(targetDir, filename + (extension.startsWith("[.]") ? extension : ("." + extension))));
               break;
         }

      } catch (IOException t) {
         app.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
   }

   static File getFile(Node node) {
      final Node parentNode = other(node, singleIncoming(node, Relations.CHILD));
      return parentNode == null ? new File(getString(node, Properties._path.name())) : new File(getFile(parentNode), getString(node, Properties._path.name()));
   }

   enum Entities implements Label {
      _Directory, _Renderer
   }

   enum Relations implements RelationshipType {
      CHILD, RENDERER, DIRECTORY
   }

   enum Properties {
      _path, _filetype
   }

   enum Filetype {
      java, plain, namedFile
   }
}