package com.generator.editors.domain.actions;

import com.generator.editors.domain.MetaNode;
import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import org.neo4j.graphdb.Transaction;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * goe on 3/4/15.
 */
public class SelectAllWithSameLabel<E extends Enum<E>,R extends Enum<R >, G extends GraphNode<E>, D extends GraphEditor<E,R,G>> extends GraphEditorAction<E, R, G, D>  {

    public SelectAllWithSameLabel(D editor) {
        super("Select all same", editor);
    }

    @Override
    public void doAction(Transaction tx) {

        final Set<E> nodeLabels = new LinkedHashSet<>();
        for (G graphNode : editor.getSelectedGraphNodes())
            nodeLabels.add((E) editor.getDomain().getMetaNode(graphNode.node()).getLabel());

        for (G graphNode : editor.visibleNodes()) {
            final MetaNode<E> metaNode = editor.getDomain().getMetaNode(graphNode.node());
            if (metaNode == null) continue;    //  no meta node for node
            if (nodeLabels.contains(metaNode.getLabel()))
                editor.selectNode(graphNode.uuid());
        }
    }
}
