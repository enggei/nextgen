package com.generator.editors.domain.actions;

import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

/**
 * goe on 3/4/15.
 */
public class DeleteLayout<E extends Enum<E>, R extends Enum<R>, G extends GraphNode<E>, D extends GraphEditor<E,R,G>> extends GraphEditorAction<E, R, G, D> {

    private final Node node;

    public DeleteLayout(Node node, D editor) {
        super(node.hasProperty("name") ? (node.getProperty("name") + "") : "?", editor);
        this.node = node;
    }

    @Override
    public void doAction(Transaction tx) {
        for (Relationship relationship : node.getRelationships()) relationship.delete();
        node.delete();
    }
}