package com.generator.editors.domain.actions.d2;

import com.generator.editors.graph.d2.GraphEditor2D;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.d2.GraphNode2D;
import org.neo4j.graphdb.Transaction;

import java.util.Set;

/**
 * goe on 5/14/15.
 */
public class SingleActionAction<E extends Enum<E>, R extends Enum<R>, G extends GraphNode2D<E>, D extends GraphEditor2D<E, R, G>> extends GraphEditorAction<E, R, G, D> {

    public SingleActionAction(D editor) {
        super("Show Query", editor);
    }

    @Override
    public void doAction(Transaction tx) {
        final G selectedNode = editor.getSelectedGraphNodes().iterator().next();
        final Set<GraphEditorAction> allowedAddActions = editor.getAllowedAddActions(selectedNode.centerX() + selectedNode.width() + 10, selectedNode.centerY() + selectedNode.height() + 10, selectedNode.node());
        if (allowedAddActions.size() == 1) allowedAddActions.iterator().next().actionPerformed(null);
    }
}
