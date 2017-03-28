package com.generator.generators.java;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.QualifiedNameExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Node;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.StringReader;
import java.util.*;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.java.JavaDomain.Relations.*;
import static com.generator.generators.java.JavaVisitor.visitClass;
import static org.neo4j.graphdb.Direction.INCOMING;
import static org.neo4j.graphdb.Direction.OUTGOING;


/**
 * Created 23.02.17.
 */
public class JavaDomain {

   public enum Entities implements Label {
      Package, Class, Field, Method
   }

   public enum Properties implements Label {
      name, type, scope, returnValue, comment, value, getter, setter
   }

   public enum Relations implements RelationshipType {
      PACKAGE, FIELD, METHOD, INNER_CLASS
   }

   public static void addToMenu(JPopupMenu pop, PInputEvent event, NeoEditor editor) {
      final JMenu domainMenu = new JMenu("JavaDomain");
      domainMenu.add(new NewPackage(event, editor));
      editor.getGraph().getGraphDb().getAllLabelsInUse().forEach(label -> {
         for (Entities entities : Entities.values())
            if (entities.name().equals(label.name())) domainMenu.add(editor.showAllNodesByLabel(label, event));
      });
      pop.add(domainMenu);
   }

   public static NeoPNode newPNode(Node node, String nodetype, NeoEditor neoEditor) {
      switch (JavaDomain.Entities.valueOf(nodetype)) {
         case Package:
            return new JavaDomain.PackagePNode(node, neoEditor);
         case Class:
            return new JavaDomain.ClassPNode(node, neoEditor);
         case Field:
            return new JavaDomain.FieldPNode(node, neoEditor);
         case Method:
            return new JavaDomain.MethodPNode(node, neoEditor);
      }

      throw new IllegalArgumentException("unsupported TemplateDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
   }

   public static void deleteNode(Node node) throws NeoEditor.ReferenceException {
      // todo enforce constraints
      final Set<Relationship> constraints = new LinkedHashSet<>();
      final Consumer<Relationship> constraintVisitor = relationship -> {
         if (NeoEditor.isAppRelated(relationship)) return;
         constraints.add(relationship);
      };

      if (node.hasLabel(Entities.Package)) {
         node.getRelationships(INCOMING, PACKAGE).forEach(constraintVisitor);
         if (!constraints.isEmpty())
            throw new NeoEditor.ReferenceException(node, constraints);

         // delete all imports
         node.getRelationships(OUTGOING, PACKAGE).forEach(Relationship::delete);
      }

      // delete from layouts:
      NeoEditor.removeFromLayouts(node);

      node.delete();
   }

   public static class PackagePNode extends JavaDomainPNode {

      PackagePNode(Node node, NeoEditor editor) {
         super(node, Entities.Package, JavaDomain.Properties.name.name(), "64, 64, 64".split(", "), editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         for (Relationship relationship : incoming(node, Relations.PACKAGE)) {
            final Node other = other(node, relationship);
            if (hasLabel(other, Entities.Class.name())) {
               pNodes.put(uuidOf(other(node, relationship)), Entities.Class);
            } else if (hasLabel(other, Entities.Package.name())) {
               pNodes.put(uuidOf(other(node, relationship)), Entities.Package);
            }
         }
         editor.showAndLayout(pNodes, pNode);
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         pop.add(new NeoEditor.TransactionAction("Add Package", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Name", canvas);
               if (name == null) return;

               final String[] split = name.split("[. ]");
               final Map<UUID, Label> pNodes = new LinkedHashMap<>();
               Node parentNode = node;
               for (String n : split) {
                  final Node newNode = graph.newNode(Entities.Package);
                  newNode.setProperty(Properties.name.name(), n);
                  if (parentNode != null)
                     newNode.createRelationshipTo(parentNode, PACKAGE);
                  pNodes.put(uuidOf(newNode), Entities.Package);
                  parentNode = newNode;
               }
               editor.showAndLayout(pNodes, pNode);
            }
         });

         pop.add(new NeoEditor.TransactionAction("Add Class", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Name", canvas);
               if (name == null) return;

               final Node newNode = graph.newNode(Entities.Class);
               newNode.setProperty(Properties.name.name(), name);
               newNode.createRelationshipTo(node, PACKAGE);

               editor.show(NeoModel.uuidOf(newNode), Entities.Class.name()).setOffset(event);
            }
         });

         pop.add(new NeoEditor.TransactionAction("Parse Class", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final JTextArea textArea = new JTextArea(50, 80);

               SwingUtil.showTextInput("Java", textArea, editor.getCanvas(), new SwingUtil.OnSave() {
                  @Override
                  public void verifyAndSave() throws Exception {

                     graph.doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {

                           final CompilationUnit compilationUnit = JavaParser.parse(new StringReader(textArea.getText().trim()));

                           // refactor package to this package
                           final Stack<String> packagePath = new Stack<>();
                           Node currentPackageNode = node;
                           Relationship parentRelation;
                           do {
                              packagePath.push(getString(currentPackageNode, Properties.name.name()));
                              parentRelation = singleOutgoing(currentPackageNode, Relations.PACKAGE);
                              currentPackageNode = other(currentPackageNode, parentRelation);
                           } while (parentRelation != null);
                           compilationUnit.setPackage(new PackageDeclaration(new NameExpr(StringUtil.list(packagePath, "."))));

                           for (TypeDeclaration typeDeclaration : compilationUnit.getTypes()) {

                              final String name = typeDeclaration.getName();

                              final Node newNode = graph.newNode(Entities.Class);
                              newNode.setProperty(Properties.name.name(), name);
                              newNode.createRelationshipTo(node, PACKAGE); // set package here

                              for (BodyDeclaration declaration : typeDeclaration.getMembers()) {

                              }

                              editor.show(NeoModel.uuidOf(newNode), Entities.Class.name()).setOffset(event);
                           }
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showMessage("Error " + throwable.getMessage(), editor.getCanvas());
                        }
                     });
                  }
               });
            }
         });

         super.showNodeActions(pop, event);
      }


   }

   public static class ClassPNode extends JavaDomainPNode {

      ClassPNode(Node node, NeoEditor editor) {
         super(node, Entities.Class, JavaDomain.Properties.name.name(), "64, 64, 64".split(", "), editor);
      }

      @Override
      public void renderTo(JTextComponent textArea) {

         // todo improve this with a new java-group better suited for java-domain ?
         final JavaGroup javaGroup = new JavaGroup();
         final JavaGroup.classST classST = javaGroup.newclass();

         editor.doInTransaction(tx -> {
            visitClass(node, new JavaVisitor() {
               @Override
               public void onClass(String name, Node node) {
                  classST.setName(name);
               }

               @Override
               public void onField(String scope, String type, String name, String value, Boolean getter, Boolean setter, Node node) {
                  classST.addPropertiesValue(null, null, null, false, null, false, null, null, name, scope, type, value);

                  // todo: add custom getters and setters- template ?
                  if (getter)
                     classST.addMethodsValue(javaGroup.newmethod().setName("get" + StringUtil.capitalize(name)).setReturnVal(type).setScope("public"));
                  if (setter)
                     classST.addMethodsValue(javaGroup.newmethod().setName("set" + StringUtil.capitalize(name)).setScope("public"));
               }

               @Override
               public void onMethod(String scope, String name, String returnValue, Node node) {

               }
            });

            textArea.setText(classST.toString());
            textArea.setCaretPosition(0);
         });
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         for (Relationship relationship : outgoing(node, Relations.FIELD))
            pNodes.put(uuidOf(other(node, relationship)), Entities.Field);
         for (Relationship relationship : outgoing(node, Relations.METHOD))
            pNodes.put(uuidOf(other(node, relationship)), Entities.Method);
         for (Relationship relationship : outgoing(node, Relations.INNER_CLASS))
            pNodes.put(uuidOf(other(node, relationship)), Entities.Class);
         editor.showAndLayout(pNodes, pNode);
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         pop.add(new NeoEditor.TransactionAction("Set Name", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Name", canvas, node.hasProperty(Properties.name.name()) ? getString(node, Properties.name.name()) : "");
               if (name == null) return;

               node.setProperty(Properties.name.name(), name);
               updateView();
            }
         });

         pop.add(new NeoEditor.TransactionAction("Add Field", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("[name] OR [type] [name] OR [scope] [type] [name]", canvas);
               if (name == null) return;

               final Node newNode = graph.newNode(Entities.Field);

               final String[] split = name.split(" ");
               if (split.length == 1) {
                  newNode.setProperty(Properties.name.name(), split[0]);
               } else if (split.length == 2) {
                  newNode.setProperty(Properties.scope.name(), "private");
                  newNode.setProperty(Properties.type.name(), split[0]);
                  newNode.setProperty(Properties.name.name(), split[1]);
               } else if (split.length == 3) {
                  newNode.setProperty(Properties.scope.name(), split[0]);
                  newNode.setProperty(Properties.type.name(), split[1]);
                  newNode.setProperty(Properties.name.name(), split[2]);
               } else {
                  SwingUtil.showMessage("Use format as described", canvas);
               }
               node.createRelationshipTo(newNode, FIELD);

               editor.show(NeoModel.uuidOf(newNode), Entities.Field.name()).setOffset(event);
            }
         });

         pop.add(new NeoEditor.TransactionAction("Add Method", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("[name] OR [name] [returnType]", canvas);
               if (name == null) return;

               final Node newNode = graph.newNode(Entities.Method);

               final String[] split = name.split(" ");
               if (split.length == 1) {
                  newNode.setProperty(Properties.returnValue.name(), "void");
                  newNode.setProperty(Properties.name.name(), split[0]);
               } else if (split.length == 2) {
                  newNode.setProperty(Properties.returnValue.name(), split[1]);
                  newNode.setProperty(Properties.name.name(), split[0]);
               } else {
                  SwingUtil.showMessage("Use format as described", canvas);
               }
               node.createRelationshipTo(newNode, METHOD);

               editor.show(NeoModel.uuidOf(newNode), Entities.Method.name()).setOffset(event);
            }
         });

         pop.add(new NeoEditor.TransactionAction("Add Equals", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            }
         });

         pop.add(new NeoEditor.TransactionAction("Add toString", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            }
         });

         super.showNodeActions(pop, event);
      }
   }

   public static class FieldPNode extends JavaDomainPNode {

      FieldPNode(Node node, NeoEditor editor) {
         super(node, Entities.Field, JavaDomain.Properties.name.name(), "64, 255, 64".split(", "), editor);
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         pop.add(new NeoEditor.TransactionAction("Edit", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final FieldEditor form = new FieldEditor(node);
               SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Field", () -> {
                  editor.doInTransaction(tx1 -> {
                     form.commit(node);
                     editor.show(uuidOf(node), Entities.Field.name()).setOffset(event);
                  });
               });
            }
         });

         super.showNodeActions(pop, event);
      }
   }

   public static class MethodPNode extends JavaDomainPNode {

      MethodPNode(Node node, NeoEditor editor) {
         super(node, Entities.Method, JavaDomain.Properties.name.name(), "64, 125, 64".split(", "), editor);
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         pop.add(new NeoEditor.TransactionAction("Edit", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final MethodEditor form = new MethodEditor(node);
               SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Method", () -> {
                  editor.doInTransaction(tx1 -> {
                     form.commit(node);
                     editor.show(uuidOf(node), Entities.Method.name()).setOffset(event);
                  });
               });
            }
         });

         super.showNodeActions(pop, event);
      }
   }

   private static class JavaDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      private final Color defaultColor;
      private final String property;
      private final JavaDomain.Entities nodeType;

      JavaDomainPNode(Node node, JavaDomain.Entities nodeType, String property, String[] defaultColor, NeoEditor editor) {
         super(node, new PText(node.getProperty(property).toString()), nodeType.name(), editor);
         this.defaultColor = new Color(Integer.valueOf(defaultColor[0]), Integer.valueOf(defaultColor[1]), Integer.valueOf(defaultColor[2]));
         this.property = property;
         this.nodeType = nodeType;
         pNode.setTextPaint(this.defaultColor);
         pNode.setFont(new Font("Hack", Font.BOLD, 12));
      }

      JavaDomainPNode(Node node, PText representation, JavaDomain.Entities nodeType, String[] defaultColor, NeoEditor editor) {
         super(node, representation, nodeType.name(), editor);
         this.defaultColor = new Color(Integer.valueOf(defaultColor[0]), Integer.valueOf(defaultColor[1]), Integer.valueOf(defaultColor[2]));
         this.property = null;
         this.nodeType = nodeType;
         pNode.setTextPaint(this.defaultColor);
         pNode.setFont(new Font("Hack", Font.PLAIN, 12));
      }

      @Override
      public String getNodeType() {
         return nodeType.name();
      }

      @Override
      public void expand() {

      }

      @Override
      public void showDependents() {

      }

      @Override
      public void keyPressed(PInputEvent event) {
         super.keyPressed(event);
      }

      @Override
      public void updateView() {
         if (property == null) System.out.println("override updateView: property not set");
         pNode.setText(property == null ? "?" : node.getProperty(property).toString());
      }

      @Override
      public void onSelect() {
         pNode.setTextPaint(selectedColor);
      }

      @Override
      public void onUnselect() {
         pNode.setTextPaint(defaultColor);
      }

      @Override
      public void onStartHighlight() {
         pNode.setTextPaint(Color.ORANGE);
      }

      @Override
      public void onEndHighlight() {
         pNode.setTextPaint(selected.get() ? selectedColor : defaultColor);
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         pop.add(new NeoEditor.TransactionAction("Select all " + nodeType, editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               editor.getAllNodes().forEach(neoPNode -> {
                  if (neoPNode.getNodeType().equals(nodeType.name()) && !neoPNode.selected.get())
                     neoPNode.select();
               });
            }
         });
         pop.add(new NeoEditor.TransactionAction("Hide all " + nodeType, editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final Set<UUID> hide = new LinkedHashSet<>();
               editor.getAllNodes().forEach(pNode -> {
                  if (pNode.getNodeType().equals(nodeType.name())) hide.add(pNode.uuid);
               });
               hide.forEach(editor::removeNodeFromCanvas);
            }
         });

         pop.add(retainNode());
         pop.add(hideNode());
         pop.add(deleteNode());
      }
   }

   private static class NewPackage extends NeoEditor.TransactionAction {

      private final PInputEvent event;

      NewPackage(PInputEvent event, NeoEditor editor) {
         super("New Package", editor);
         this.event = event;
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

         final String name = SwingUtil.showInputDialog("Name", canvas);
         if (name == null) return;

         final String[] split = name.split("[. ]");
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         Node parentNode = null;
         for (String n : split) {
            final Node newNode = graph.newNode(Entities.Package);
            newNode.setProperty(Properties.name.name(), n);
            if (parentNode != null)
               newNode.createRelationshipTo(parentNode, PACKAGE);
            pNodes.put(uuidOf(newNode), Entities.Package);
            parentNode = newNode;
         }
         editor.showAndLayout(pNodes, event.getCanvasPosition());
      }
   }

   static class FieldEditor extends SwingUtil.FormPanel {

      private final JTextField txtName = new JTextField();
      private final JTextField txtType = new JTextField();
      private final JComboBox<String> cboScope = new JComboBox<>();
      private final JTextField txtComment = new JTextField();
      private final JTextField txtValue = new JTextField();
      private final JCheckBox chkGetter = new JCheckBox("Getter");
      private final JCheckBox chkSetter = new JCheckBox("Setter");

      FieldEditor(Node node) {
         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");

         int row = 1;
         addLabel(Properties.name.name(), 1, row);
         add(txtName, 3, row);
         txtName.setText(node.hasProperty(Properties.name.name()) ? getString(node, Properties.name.name()) : "");

         row += 2;
         addLabel(Properties.type.name(), 1, row);
         add(txtType, 3, row);
         txtType.setText(node.hasProperty(Properties.type.name()) ? getString(node, Properties.type.name()) : "");

         row += 2;
         addLabel(Properties.scope.name(), 1, row);
         add(cboScope, 3, row);
         setModifier(cboScope, node);

         row += 2;
         addLabel(Properties.comment.name(), 1, row);
         add(txtComment, 3, row);
         txtComment.setText(node.hasProperty(Properties.comment.name()) ? getString(node, Properties.comment.name()) : "");

         row += 2;
         addLabel(Properties.value.name(), 1, row);
         add(txtValue, 3, row);
         txtValue.setText(node.hasProperty(Properties.value.name()) ? getString(node, Properties.value.name()) : "");

         row += 2;
         addLabel(Properties.getter.name(), 1, row);
         add(chkGetter, 3, row);
         chkGetter.setSelected(Boolean.valueOf(BaseDomainVisitor.get(node, Properties.getter.name(), "false")));

         row += 2;
         addLabel(Properties.getter.name(), 1, row);
         add(chkSetter, 3, row);
         chkSetter.setSelected(Boolean.valueOf(BaseDomainVisitor.get(node, Properties.setter.name(), "false")));
      }

      private void setModifier(JComboBox<String> cboModifier, Node node) {
         final String[] items = {"", "private", "protected", "public"};
         cboModifier.setModel(new DefaultComboBoxModel<>(items));
         if (node.hasProperty(Properties.scope.name()))
            cboModifier.setSelectedItem(getString(node, Properties.scope.name()));
      }

      private void commit(Node node) throws Exception {
         node.setProperty(Properties.name.name(), txtName.getText().trim());
         node.setProperty(Properties.type.name(), txtType.getText().trim());
         node.setProperty(Properties.scope.name(), cboScope.getSelectedItem().toString());
         node.setProperty(Properties.value.name(), txtValue.getText().trim());
         node.setProperty(Properties.comment.name(), txtComment.getText().trim());
         node.setProperty(Properties.getter.name(), chkGetter.isSelected() ? "true" : "false");
         node.setProperty(Properties.setter.name(), chkSetter.isSelected() ? "true" : "false");
      }
   }

   static class MethodEditor extends SwingUtil.FormPanel {

      private final JTextField txtName = new JTextField();
      private final JTextField txtType = new JTextField();
      private final JComboBox<String> cboScope = new JComboBox<>();
      private final JTextField txtComment = new JTextField();

      MethodEditor(Node node) {
         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");

         int row = 1;
         addLabel(Properties.name.name(), 1, row);
         add(txtName, 3, row);
         txtName.setText(node.hasProperty(Properties.name.name()) ? getString(node, Properties.name.name()) : "");

         row += 2;
         addLabel(Properties.type.name(), 1, row);
         add(txtType, 3, row);
         txtType.setText(node.hasProperty(Properties.type.name()) ? getString(node, Properties.type.name()) : "");

         row += 2;
         addLabel(Properties.scope.name(), 1, row);
         add(cboScope, 3, row);
         setModifier(cboScope, node);

         row += 2;
         addLabel(Properties.comment.name(), 1, row);
         add(txtComment, 3, row);
         txtComment.setText(node.hasProperty(Properties.comment.name()) ? getString(node, Properties.comment.name()) : "");

      }

      private void setModifier(JComboBox<String> cboModifier, Node node) {
         final String[] items = {"", "private", "protected", "public"};
         cboModifier.setModel(new DefaultComboBoxModel<>(items));
         if (node.hasProperty(Properties.scope.name()))
            cboModifier.setSelectedItem(getString(node, Properties.scope.name()));
      }

      private void commit(Node node) throws Exception {
         node.setProperty(Properties.name.name(), txtName.getText().trim());
         node.setProperty(Properties.type.name(), txtType.getText().trim());
         node.setProperty(Properties.scope.name(), cboScope.getSelectedItem().toString());
         node.setProperty(Properties.comment.name(), txtComment.getText().trim());
      }
   }
}