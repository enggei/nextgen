package com.generator.editors.domain.actions;

import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import static com.generator.editors.domain.NeoModel.uuidOf;

/**
* goe on 3/4/15.
*/
public class GetAllBySameLabel<E extends Enum<E>, R extends Enum<R >, G extends GraphNode<E>, D extends GraphEditor<E,R,G>> extends GraphEditorAction<E, R, G, D>  {

    public GetAllBySameLabel(D editor) {
        super("Get all of same label", editor);
    }

    @Override
    public void doAction(Transaction tx) {
        final Set<String> labels = new TreeSet<>();
        for (GraphNode<E> graphNode : editor.getSelectedGraphNodes()) {
            for (Label label : graphNode.node().getLabels()) {
                labels.add(label.name());
            }
        }

        for (String label : labels) {
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
}