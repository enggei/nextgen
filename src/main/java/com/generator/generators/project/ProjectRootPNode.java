package com.generator.generators.project;

import com.generator.editors.canvas.neo.NeoEditor;
import org.neo4j.graphdb.Node;

import java.awt.*;


/**
 * Created 19.01.17.
 */
class ProjectRootPNode extends ProjectDomainPNode {

   ProjectRootPNode(Node node, NeoEditor editor) {
      super(node, ProjectDomain.LABELS.ProjectRoot, "name", "153, 52, 4".split(", "), editor);
      pNode.setFont(new Font("Hack", Font.BOLD, 12));
   }
}