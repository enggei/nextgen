package com.generator.editors.domain.actions.d2;

import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.d2.GraphNode2D;
import org.neo4j.graphdb.Transaction;

/**
 * goe on 3/26/15.
 */
public class UnpinAction<E extends Enum<E>, R extends Enum<R>, G extends GraphNode2D<E>, D extends GraphEditor<E, R, G>> extends GraphEditorAction<E, R, G, D> {

    public UnpinAction(D editor) {
        super("Unpin", editor);
    }

    @Override
    public void doAction(Transaction tx) {
        for (G graphNode : editor.getSelectedGraphNodes()) graphNode.pin(false);
    }
}