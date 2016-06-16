package com.generator.editors.domain.actions;

import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Transaction;

import java.awt.event.MouseEvent;
import java.util.UUID;

/**
 * goe on 3/4/15.
 */
public class AddNode<E extends Enum<E>, R extends Enum<R>, G extends GraphNode<E>, D extends GraphEditor<E,R,G>> extends GraphEditorAction<E, R, G, D> {

    private final MouseEvent mouseEvent;

    public AddNode(MouseEvent mouseEvent, D editor) {
        super("New Node", editor);
        this.mouseEvent = mouseEvent;
    }

    @Override
    public void doAction(Transaction tx) {

        editor.clearButtonsPressed();

        final String name = SwingUtil.showInputDialog("name", editor);
        if (name == null || name.length() == 0) return;

        editor.newGraphNode(editor.getModel().newNode(UUID.randomUUID(), "name", name), mouseEvent);
    }
}