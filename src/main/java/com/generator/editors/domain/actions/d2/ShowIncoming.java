package com.generator.editors.domain.actions.d2;

import com.generator.editors.graph.d2.GraphEditor2D;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.d2.GraphNode2D;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import java.util.Random;

import static com.generator.editors.domain.NeoModel.uuidOf;

/**
* goe on 3/4/15.
*/
public class ShowIncoming<E extends Enum<E>, R extends Enum<R >, G extends GraphNode2D<E>, D extends GraphEditor2D<E,R,G>> extends GraphEditorAction<E, R, G, D>  {

    private final Random random = new Random();

    public ShowIncoming(D editor) {
        super("Show incoming", editor);
    }

    @Override
    public void doAction(Transaction tx) {
        for (GraphNode2D<E> graphNode : editor.getSelectedGraphNodes()) {
            for (Relationship relationship : graphNode.node().getRelationships(Direction.INCOMING)) {

                // ignore 'POSITION'
                if ("POSITION".equals(relationship.getType().name())) continue;


                final Node otherNode = relationship.getOtherNode(graphNode.node());


                if (editor.getNode(uuidOf(otherNode)) != null) {
                    editor.selectNode(uuidOf(otherNode));
                    continue;
                }

                editor.getOrAdd(otherNode).
                        setCenterX(Math.max(0, Math.min(editor.getWidth(), graphNode.centerX() + ((random.nextBoolean() ? (-1) : 1) * random.nextInt(200))))).
                        setCenterY(Math.max(0, Math.min(editor.getHeight(), graphNode.centerY() + ((random.nextBoolean() ? (-1) : 1) * random.nextInt(200)))));

                new LayoutInCircle<>(false,editor,true).circleSelectedNodes();
            }
        }
    }
}
