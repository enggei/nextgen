package com.generator.generators.project;

import com.generator.editors.canvas.neo.NeoEditor;
import org.neo4j.graphdb.Node;

import java.awt.*;

/**
 * Created 19.01.17.
 */
public class ResourcesPNode extends ProjectDomainPNode {

   ResourcesPNode(Node node, NeoEditor editor) {
      super(node, ProjectDomain.LABELS.Resources, "name", "153, 52, 4".split(", "), editor);
      pNode.setFont(new Font("Hack", Font.BOLD, 12));
   }
}
