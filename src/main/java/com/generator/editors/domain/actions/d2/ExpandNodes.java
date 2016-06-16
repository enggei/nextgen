package com.generator.editors.domain.actions.d2;

import com.generator.editors.graph.d2.GraphEditor2D;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.d2.GraphNode2D;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import static com.generator.editors.domain.NeoModel.uuidOf;

/**
 * goe on 3/4/15.
 */
public class ExpandNodes<E extends Enum<E>, R extends Enum<R >, G extends GraphNode2D<E>, D extends GraphEditor2D<E,R,G>> extends GraphEditorAction<E, R, G, D>  {

    public ExpandNodes(D editor) {
        super("Expand", editor);
    }

    @Override
    public void doAction(Transaction tx) {
        for (GraphNode2D<E> graphNode : editor.getSelectedGraphNodes()) {
            for (Relationship relationship : graphNode.node().getRelationships(Direction.OUTGOING)) {
                final Node otherNode = relationship.getOtherNode(graphNode.node());
                if (editor.getNode(uuidOf(otherNode)) != null) {
                    editor.selectNode(uuidOf(otherNode));
                    continue;
                }

                final GraphNode2D<E> otherGraphNode = editor.getOrAdd(otherNode);
                if(otherGraphNode==null) return;

                final int newX = graphNode.centerX() + graphNode.width() + 20 + otherGraphNode.width();
                final int newY = graphNode.centerY();

                otherGraphNode.setCenterX(Math.max(0, Math.min(editor.getWidth(), newX))).
                        setCenterY(Math.max(0, Math.min(editor.getHeight(), newY)));

                //circleSelectedNodes(true, editor);
            }
        }
    }
}