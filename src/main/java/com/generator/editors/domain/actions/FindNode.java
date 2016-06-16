package com.generator.editors.domain.actions;

import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import java.awt.event.MouseEvent;
import java.util.UUID;

import static com.generator.editors.domain.NeoModel.uuidOf;

/**
* goe on 3/4/15.
*/
public class FindNode<E extends Enum<E>, R extends Enum<R >, G extends GraphNode<E>, D extends GraphEditor<E,R,G>> extends GraphEditorAction<E, R, G, D>  {

    private final MouseEvent mouseEvent;

    public FindNode(MouseEvent mouseEvent, D editor) {
        super("Find node", editor);
        this.mouseEvent = mouseEvent;
    }

    @Override
    public void doAction(Transaction tx) {

        editor.clearButtonsPressed();

        String name = SwingUtil.showInputDialog("name", editor);
        if (name == null || name.length() == 0) return;

        // search in lower-case
        name = name.toLowerCase();

        //look first in visible nodes:
        boolean found = false;
        for (GraphNode<E> graphNode : editor.visibleNodes()) {
            if (graphNode.node().hasProperty("name") && graphNode.node().getProperty("name").toString().toLowerCase().equals(name)) {
                editor.selectNode(graphNode.uuid());
                found = true;
            }
        }

        //if not found in visible nodes, look in db
        if (!found) {
            for (Node node : editor.getModel().getAll("name", name)) {
                final UUID nodeUUID = uuidOf(node);
                if (editor.getNode(nodeUUID) == null)
                    editor.newGraphNode(node, mouseEvent);
                else editor.selectNode(nodeUUID);
                found = true;
            }
        }

        if (!found && SwingUtil.confirm("'" + name + "' not found. Do you want to make a new node with name '" + name + "' ?", editor)) {
            editor.newGraphNode(editor.getModel().newNode(UUID.randomUUID(), "name", name), mouseEvent);
        }
    }
}
