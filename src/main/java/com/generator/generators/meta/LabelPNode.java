package com.generator.generators.meta;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.domain.DomainPNode;
import com.generator.generators.templates.domain.GeneratedFile;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;
import org.stringtemplate.v4.ST;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created 30.01.17.
 */
public class LabelPNode extends DomainPNode<PText> {

   public LabelPNode(Node node, NeoEditor editor) {
      super(node, MetaDomain.LABELS.LABEL, "name", "153, 52, 4".split(", "), editor);
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

      pop.add(new NeoEditor.TransactionAction("Render PNode", editor.getGraph(), editor.canvas) {
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
            "      super(node, ~domain~.LABELS.~nodetype~, \"~property~\", \"153, 52, 4\".split(\", \"), editor);\n" +
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