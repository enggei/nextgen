package com.generator.generators.meta;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.domain.DomainPNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;
import org.stringtemplate.v4.ST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

import static com.generator.editors.NeoModel.uuidOf;

/**
 * Created 30.01.17.
 */
public class MetaDomainPNode extends DomainPNode<PText> {

   private final File root = new File("/home/goe/projects/nextgen/src/main/java");

   public MetaDomainPNode(Node node, NeoEditor editor) {
      super(node, MetaDomain.LABELS.DOMAIN, "name", "153, 52, 4".split(", "), editor);
   }

   @Override
   public void showNodeActions(JPopupMenu pop, PInputEvent event) {

      pop.add(new NeoEditor.TransactionAction("Add Label", editor.getGraph(), editor.canvas) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", editor.canvas);
            if (name == null || name.length() == 0) return;

            final Node newNode = MetaDomain.newLabelNode(editor.getGraph(), name, node);

            editor.show(uuidOf(newNode), MetaDomain.LABELS.LABEL.name()).
                  setOffset(event);

            updateView();
         }
      });

      pop.add(new NeoEditor.TransactionAction("Render Domain", editor.getGraph(), editor.canvas) {
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
            "      switch (~name~.LABELS.valueOf(nodetype)) {\n" +
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
            "   public enum LABELS implements Label {\n" +
            "      DOMAIN, LABEL, RELATION\n" +
            "   }\n" +
            "\n" +
            "   public enum RELATIONS implements RelationshipType {\n" +
            "      DOMAIN, LABEL, RELATIONS\n" +
            "   }\n" +
            "\n" +
            "   public static Node newDomainNode(NeoModel db, File root, Node projectNode) {\n" +
            "      final Node newNode = db.newNode(LABELS.DOMAIN);\n" +
            "      newNode.setProperty(\"root\", root.getAbsolutePath());\n" +
            "      newNode.setProperty(\"name\", root.getName());\n" +
            "\n" +
            "      projectNode.createRelationshipTo(newNode, DOMAIN);\n" +
            "      return newNode;\n" +
            "   }\n" +
            "\n" +
            "   public static Node newLabelNode(NeoModel db, String name, Node domainNode) {\n" +
            "      final Node newNode = db.newNode(LABELS.LABEL);\n" +
            "      newNode.setProperty(\"name\", name);\n" +
            "\n" +
            "      domainNode.createRelationshipTo(newNode, LABEL);\n" +
            "      return newNode;\n" +
            "   }\n" +
            "\n" +
            "}", '~', '~');
   }
}