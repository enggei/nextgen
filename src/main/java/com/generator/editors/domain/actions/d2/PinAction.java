package com.generator.editors.domain.actions.d2;

import com.generator.editors.graph.d2.GraphEditor2D;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.d2.GraphNode2D;
import org.neo4j.graphdb.Transaction;

/**
 * goe on 3/26/15.
 */
public class PinAction<E extends Enum<E>, R extends Enum<R>, G extends GraphNode2D<E>, D extends GraphEditor2D<E,R,G>> extends GraphEditorAction<E, R, G, D> {

    public PinAction(D editor) {
        super("Pin", editor);
    }

    @Override
    public void doAction(Transaction tx) {
        for (G graphNode : editor.getSelectedGraphNodes()) graphNode.pin(true);
    }
}