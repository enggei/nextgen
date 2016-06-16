package com.generator.editors.domain.actions;

import com.generator.editors.domain.MetaNode;
import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import org.neo4j.graphdb.Transaction;

import java.awt.event.MouseEvent;
import java.util.UUID;

/**
 * goe on 3/4/15.
 */
public class AddNodeWithLabel<E extends Enum<E>, R extends Enum<R>, G extends GraphNode<E>, D extends GraphEditor<E, R, G>> extends GraphEditorAction<E, R, G, D> {

    private final MetaNode<E> rootNode;
    private final MouseEvent mouseEvent;

    public AddNodeWithLabel(MetaNode<E> rootNode, MouseEvent mouseEvent, D editor) {
        super("Add " + rootNode.getLabel().name(), editor);
        this.rootNode = rootNode;
        this.mouseEvent = mouseEvent;
    }

    @Override
    public void doAction(Transaction tx) {
        editor.clearSelection();
        editor.newGraphNode(editor.getDomain().newNode(rootNode.getLabel(), UUID.randomUUID()), mouseEvent);
    }
}