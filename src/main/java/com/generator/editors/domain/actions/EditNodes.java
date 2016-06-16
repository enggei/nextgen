package com.generator.editors.domain.actions;

import com.generator.editors.domain.MetaNode;
import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.util.Set;

/**
 * goe on 3/4/15.
 */
public class EditNodes<E extends Enum<E>, R extends Enum<R>, G extends GraphNode<E>, D extends GraphEditor<E, R, G>> extends GraphEditorAction<E, R, G, D> {

    public EditNodes(D editor) {
        super("Edit", editor);
    }

    @Override
    public void doAction(Transaction tx) {

        final Set<G> selectedNodes = editor.getSelectedGraphNodes();
        if (selectedNodes.isEmpty()) return;

        if (selectedNodes.size() == 1) {
            final G node = selectedNodes.iterator().next();
            final MetaNode<E> metaNode = editor.getDomain().getMetaNode(node.node());
            JDialog dialog = editor.getNodeEditor(metaNode, node, editor);
            SwingUtil.showDialog(dialog, editor);
            editor.clearButtonsPressed();
        }
    }
}