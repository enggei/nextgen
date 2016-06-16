package com.generator.editors.domain.actions.d2;

import com.generator.editors.graph.d2.GraphEditor2D;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.d2.GraphNode2D;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

/**
* goe on 3/4/15.
*/
public class LoadLayout<E extends Enum<E>, R extends Enum<R >, G extends GraphNode2D<E>, D extends GraphEditor2D<E,R,G>> extends GraphEditorAction<E, R, G, D>  {

    private final Node node;

    public LoadLayout(Node node, D editor) {
        super(node.hasProperty("name") ? (node.getProperty("name") + "") : "?", editor);
        this.node = node;
    }

    @Override
    public void doAction(Transaction tx) {
        for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) {
            final Node otherNode = relationship.getOtherNode(node);
            final G g = editor.getOrAdd(otherNode);

            if(g==null) {
                System.out.println(otherNode.getLabels() + " has no graph node");
                return;
            }

            final GraphNode2D<E> graphNode = g.
                    setCenterX(Integer.valueOf(relationship.getProperty("x").toString())).
                    setCenterY(Integer.valueOf(relationship.getProperty("y").toString()));
            editor.selectNode(graphNode.uuid());
        }
    }
}
