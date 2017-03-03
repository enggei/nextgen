package com.generator.generators.meta;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.generators.GeneratorEditor;
import com.generator.generators.templates.domain.GeneratedFile;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.*;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;
import org.stringtemplate.v4.ST;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.meta.MetaDomain.RELATIONS.DOMAIN;
import static com.generator.generators.meta.MetaDomain.RELATIONS.LABEL;

/**
 * Created 30.01.17.
 */
public class MetaDomain {

   public static NeoPNode newPNode(Node node, String nodetype, NeoEditor neoEditor) {
      switch (Entities.valueOf(nodetype)) {
         case DOMAIN:
            return new MetaDomainPNode(node, neoEditor);
         case LABEL:
            return new LabelPNode(node, neoEditor);
         case RELATION:
            return new RelationNode(node, neoEditor);
         default:
            return null;
      }
   }

   public static void addToMenu(JPopupMenu pop, PInputEvent event, NeoEditor editor) {
         final JMenu newMenu = new JMenu("MetaDomain");
//         newMenu.add(new NewFlow(event, editor));
         pop.add(newMenu);
   }

   public enum Entities implements Label {
      DOMAIN, LABEL, RELATION
   }

   public enum RELATIONS implements RelationshipType {
      DOMAIN, LABEL, RELATIONS
   }

   public static void deleteNode(Node node) {
      // todo enforce constraints
   }

   public static Node newDomainNode(NeoModel db, File root, Node projectNode) {
      final Node newNode = db.newNode(Entities.DOMAIN);
      newNode.setProperty("root", root.getAbsolutePath());
      newNode.setProperty("name", root.getName());

      projectNode.createRelationshipTo(newNode, DOMAIN);
      return newNode;
   }

   public static Node newLabelNode(NeoModel db, String name, Node domainNode) {
      final Node newNode = db.newNode(Entities.LABEL);
      newNode.setProperty("name", name);

      domainNode.createRelationshipTo(newNode, LABEL);
      return newNode;
   }

   public static class DomainPNode<T extends PNode> extends NeoPNode<T> {

      protected final Color selectedColor = Color.RED;
      protected final Color defaultColor;
      private final String property;
      private final org.neo4j.graphdb.Label nodeType;

      public DomainPNode(Node node, Label nodeType, String property, String[] defaultColor, NeoEditor editor) {
         super(node, (T) new PText(node.getProperty(property).toString()), nodeType.name(), editor);
         this.defaultColor = new Color(Integer.valueOf(defaultColor[0]), Integer.valueOf(defaultColor[1]), Integer.valueOf(defaultColor[2]));
         this.property = property;
         this.nodeType = nodeType;
//      pNode.setTextPaint(this.defaultColor);
//      pNode.setFont(new Font("Hack", Font.BOLD, 12));
      }

      public DomainPNode(Node node, PText representation, Label nodeType, String[] defaultColor, NeoEditor editor) {
         super(node, (T) representation, nodeType.name(), editor);
         this.defaultColor = new Color(Integer.valueOf(defaultColor[0]), Integer.valueOf(defaultColor[1]), Integer.valueOf(defaultColor[2]));
         this.property = null;
         this.nodeType = nodeType;
//      pNode.setTextPaint(this.defaultColor);
//      pNode.setFont(new Font("Hack", Font.PLAIN, 12));
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
//      pNode.setText(property == null ? "?" : node.getProperty(property).toString());
      }

      @Override
      public void onSelect() {
//      pNode.setTextPaint(selectedColor);
      }

      @Override
      public void onUnselect() {
//      pNode.setTextPaint(defaultColor);
      }

      @Override
      public void onStartHighlight() {
//      pNode.setTextPaint(Color.ORANGE);
      }

      @Override
      public void onEndHighlight() {
//      pNode.setTextPaint(selected.get() ? selectedColor : defaultColor);
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

   public static class LabelPNode extends DomainPNode<PText> {

      public LabelPNode(Node node, NeoEditor editor) {
         super(node, MetaDomain.Entities.LABEL, "name", "153, 52, 4".split(", "), editor);
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
      public void renderTo(JTextComponent textArea) {
         editor.doInTransaction(tx -> {
            final RenderValues renderValues = new RenderValues().invoke();
            textArea.setText(renderValues.getContent());
            textArea.setCaretPosition(0);
         });
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         pop.add(new NeoEditor.TransactionAction("Render PNode", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final RenderValues renderValues = new RenderValues().invoke();
               final GeneratedFile generatedFile = GeneratedFile.newJavaFile(renderValues.getRoot(), renderValues.getPackageName(), renderValues.getpNodeName());
               generatedFile.write(renderValues.getContent());
            }
         });

         super.showNodeActions(pop, event);
      }

      private static ST newPNode() {
         return new ST("package ~package~;\n" +
               "\n" +
               "import com.generator.editors.canvas.neo.NeoEditor;\n" +
               "import com.generator.editors.canvas.neo.domain.DomainPNode;\n" +
               "import org.neo4j.graphdb.Node;\n" +
               "\n" +
               "import java.awt.*;\n" +
               "\n" +
               "\n" +
               "class ~name~ extends DomainPNode<PText> {\n" +
               "\n" +
               "   ~name~(Node node, NeoEditor editor) {\n" +
               "      super(node, ~domain~.Entities.~nodetype~, \"~property~\", \"153, 52, 4\".split(\", \"), editor);\n" +
               "      pNode.setFont(new Font(\"Hack\", Font.BOLD, 12));\n" +
               "   }\n" +
               "}", '~', '~');
      }

      private class RenderValues {
         private String root;
         private String packageName;
         private String pNodeName;
         private String content;

         public String getRoot() {
            return root;
         }

         public String getPackageName() {
            return packageName;
         }

         public String getpNodeName() {
            return pNodeName;
         }

         public String getContent() {
            return content;
         }

         public RenderValues invoke() {
            final Relationship domainRelation = BaseDomainVisitor.singleIncoming(node, MetaDomain.RELATIONS.LABEL);
            final Node domainNode = BaseDomainVisitor.other(node, domainRelation);

            root = BaseDomainVisitor.getString(domainNode, "root");

            final String domainName = BaseDomainVisitor.getString(domainNode, "name");
            packageName = "com.generator.generators." + domainName;

            final String nodetype = BaseDomainVisitor.getString(node, "name");
            pNodeName = nodetype + "PNode";

            final ST newPNode = newPNode();
            newPNode.add("package", packageName);
            newPNode.add("name", pNodeName);
            newPNode.add("domain", domainName);
            newPNode.add("nodetype", nodetype);
            newPNode.add("property", "name");
            content = newPNode.render();
            return this;
         }
      }
   }

   public static class MetaDomainPNode extends DomainPNode<PText> {

      private final File root = new File("/home/goe/projects/nextgen/src/main/java");

      public MetaDomainPNode(Node node, NeoEditor editor) {
         super(node, MetaDomain.Entities.DOMAIN, "name", "153, 52, 4".split(", "), editor);
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         pop.add(new NeoEditor.TransactionAction("Add Label", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Name", editor.canvas);
               if (name == null || name.length() == 0) return;

               final Node newNode = MetaDomain.newLabelNode(editor.getGraph(), name, node);

               editor.show(uuidOf(newNode), MetaDomain.Entities.LABEL.name()).
                     setOffset(event);

               updateView();
            }
         });

         pop.add(new NeoEditor.TransactionAction("Render Domain", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

//            final RenderValues renderValues = new RenderValues().invoke();
//            final GeneratedFile generatedFile = GeneratedFile.newJavaFile(renderValues.getRoot(), renderValues.getPackageName(), renderValues.getpNodeName());
//            generatedFile.write(renderValues.getContent());
            }
         });

         super.showNodeActions(pop, event);
      }

      private static ST newDomain() {
         return new ST("package ~package~;\n" +
               "\n" +
               "import com.generator.editors.NeoModel;\n" +
               "import com.generator.editors.canvas.neo.NeoEditor;\n" +
               "import com.generator.editors.canvas.neo.NeoPNode;\n" +
               "import org.neo4j.graphdb.Label;\n" +
               "import org.neo4j.graphdb.Node;\n" +
               "import org.neo4j.graphdb.RelationshipType;\n" +
               "\n" +
               "import java.io.File;\n" +
               "\n" +
               "import static com.generator.generators.meta.~name~.RELATIONS.DOMAIN;\n" +
               "import static com.generator.generators.meta.~name~.RELATIONS.LABEL;\n" +
               "\n" +
               "public class ~name~ {\n" +
               "\n" +
               "   public static NeoPNode newPNode(Node node, String nodetype, NeoEditor neoEditor) {\n" +
               "      switch (~name~.Entities.valueOf(nodetype)) {\n" +
               "         case DOMAIN:\n" +
               "            return new MetaDomainPNode(node, neoEditor);\n" +
               "         case LABEL:\n" +
               "            return new LabelPNode(node, neoEditor);\n" +
               "         case RELATION:\n" +
               "            return new RelationNode(node, neoEditor);\n" +
               "         default:\n" +
               "            return null;\n" +
               "      }\n" +
               "   }\n" +
               "\n" +
               "   public enum Entities implements Label {\n" +
               "      DOMAIN, LABEL, RELATION\n" +
               "   }\n" +
               "\n" +
               "   public enum RELATIONS implements RelationshipType {\n" +
               "      DOMAIN, LABEL, RELATIONS\n" +
               "   }\n" +
               "\n" +
               "   public static Node newDomainNode(NeoModel db, File root, Node projectNode) {\n" +
               "      final Node newNode = db.newNode(Entities.DOMAIN);\n" +
               "      newNode.setProperty(\"root\", root.getAbsolutePath());\n" +
               "      newNode.setProperty(\"name\", root.getName());\n" +
               "\n" +
               "      projectNode.createRelationshipTo(newNode, DOMAIN);\n" +
               "      return newNode;\n" +
               "   }\n" +
               "\n" +
               "   public static Node newLabelNode(NeoModel db, String name, Node domainNode) {\n" +
               "      final Node newNode = db.newNode(Entities.LABEL);\n" +
               "      newNode.setProperty(\"name\", name);\n" +
               "\n" +
               "      domainNode.createRelationshipTo(newNode, LABEL);\n" +
               "      return newNode;\n" +
               "   }\n" +
               "\n" +
               "}", '~', '~');
      }
   }

   public static class RelationNode extends DomainPNode<PText> {

      public RelationNode(Node node, NeoEditor editor) {
         super(node, MetaDomain.Entities.RELATION, "name", "153, 52, 4".split(", "), editor);
      }

   }
}