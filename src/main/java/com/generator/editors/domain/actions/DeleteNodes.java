package com.generator.editors.domain.actions;

import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 * goe on 3/4/15.
 */
public class DeleteNodes<E extends Enum<E>, R extends Enum<R>, G extends GraphNode<E>, D extends GraphEditor<E,R,G>> extends GraphEditorAction<E, R, G, D> {

    public DeleteNodes(D editor) {
        super("Delete", editor);
    }

    @Override
    public void doAction(Transaction tx) {

        if (!SwingUtil.confirm("Confirm delete " + editor.getSelectedGraphNodes().size() + " node(s) and their relationships", editor))
            return;

        final Set<UUID> deleted = new LinkedHashSet<>();
        for (G graphNode : editor.getSelectedGraphNodes()) {

            // check if domain has defined this nodes as constrained (e.g. like default field-types in protobuf: 'required' / 'optional' / 'repeated'
            if (editor.getDomain().isConstrained(graphNode.node()))
                continue;

            for (Relationship relationship : graphNode.node().getRelationships())
                relationship.delete();
            graphNode.node().delete();
            deleted.add(graphNode.uuid());
        }

        for (UUID del : deleted)
            editor.removeNode(del);
    }
}