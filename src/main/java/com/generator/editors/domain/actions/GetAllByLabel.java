package com.generator.editors.domain.actions;

import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import java.util.UUID;

import static com.generator.editors.domain.NeoModel.uuidOf;

/**
* goe on 3/4/15.
*/
public class GetAllByLabel<E extends Enum<E>, R extends Enum<R >, G extends GraphNode<E>, D extends GraphEditor<E,R,G>> extends GraphEditorAction<E, R, G, D>  {

    private final String label;

    public GetAllByLabel(String label, D editor) {
        super(label, editor);
        this.label = label;
    }

    @Override
    public void doAction(Transaction tx) {
        for (Node node : editor.getModel().getAll(label)) {
            final UUID key = uuidOf(node);
            if (editor.getNode(key) != null) {
                editor.selectNode(key);
                continue;
            }

            editor.getOrAdd(node);
        }
    }
}
