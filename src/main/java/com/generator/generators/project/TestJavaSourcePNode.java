package com.generator.generators.project;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import org.neo4j.graphdb.Node;

import java.awt.*;

/**
 * Created 19.01.17.
 */
public class TestJavaSourcePNode extends ProjectDomainPNode {

   TestJavaSourcePNode(Node node, NeoEditor editor) {
      super(node, ProjectDomain.LABELS.TestResources, "name", "153, 52, 4".split(", "), editor);
      pNode.setFont(new Font("Hack", Font.BOLD, 12));
   }
}
