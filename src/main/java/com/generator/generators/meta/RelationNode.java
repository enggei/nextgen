package com.generator.generators.meta;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.domain.DomainPNode;
import org.neo4j.graphdb.Node;
import org.piccolo2d.nodes.PText;

/**
 * Created 30.01.17.
 */
public class RelationNode extends DomainPNode<PText> {

   public RelationNode(Node node, NeoEditor editor) {
      super(node, MetaDomain.LABELS.RELATION, "name", "153, 52, 4".split(", "), editor);
   }

}