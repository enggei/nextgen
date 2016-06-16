package com.generator.editors.domain.actions;

import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import org.neo4j.graphdb.Transaction;

/**
 * goe on 5/14/15.
 */
public class SelectAllAction<E extends Enum<E>, R extends Enum<R >, G extends GraphNode<E>, D extends GraphEditor<E,R,G>> extends GraphEditorAction<E, R, G, D>  {

    public SelectAllAction(D editor) {
        super("Select All", editor);
    }

    @Override
    public void doAction(Transaction tx) {
        editor.selectAllVisibleNodes();
    }
}