package com.generator.editors.domain.actions;

import com.generator.editors.domain.MetaNode;
import com.generator.editors.domain.NeoModel;
import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import java.awt.event.MouseEvent;
import java.util.*;

/**
 * goe on 3/4/15.
 */
public class CloneNodes<E extends Enum<E>, R extends Enum<R>, G extends GraphNode<E>, D extends GraphEditor<E,R,G>> extends GraphEditorAction<E, R, G, D> {

    private final Set<G> nodes;
    private final MouseEvent mouseEvent;

    public CloneNodes(Set<G> nodes, MouseEvent mouseEvent, D editor) {
        super("Clone", editor);
        this.nodes = nodes;
        this.mouseEvent = mouseEvent;
    }

    @Override
    public void doAction(Transaction tx) {

        if (!SwingUtil.confirm("Clone selected nodes?", editor))
            return;

        final Set<Node> domainNodes = new LinkedHashSet<>();
        for (G node : nodes) {
            final MetaNode<E> metaNode = editor.getDomain().getMetaNode(node.node());
            if (metaNode == null) return;   // don't clone nodes we don't know how to clone
            domainNodes.add(node.node());
        }

        final Map<UUID, Node> oldToNew = new LinkedHashMap<>();
        final Set<G> newGraphNodes = new LinkedHashSet<>();
        for (Node node : domainNodes) {

            final MetaNode<E> metaNode = editor.getDomain().getMetaNode(node);
            final Node newNode = editor.getDomain().newNode(metaNode.getLabel(), UUID.randomUUID());

            final Map<String, Object> from = metaNode.getPropertiesFrom(node);
            for (Map.Entry<String, Object> entry : from.entrySet())
                newNode.setProperty(entry.getKey(), entry.getValue());

            newGraphNodes.add(editor.newGraphNode(newNode, mouseEvent));
            oldToNew.put(NeoModel.uuidOf(node), newNode);
        }

        for (Node node : domainNodes) {
            for (Relationship outgoing : node.getRelationships(Direction.OUTGOING)) {
                if (!domainNodes.contains(outgoing.getOtherNode(node)))
                    continue;    // only clone relationships between selected nodes

                final Node oldTarget = outgoing.getOtherNode(node);

                final Node newSource = oldToNew.get(NeoModel.uuidOf(node));
                final Node newTarget = oldToNew.get(NeoModel.uuidOf(oldTarget));

                final Relationship newRelationship = newSource.createRelationshipTo(newTarget, outgoing.getType());
                for (String property : outgoing.getPropertyKeys())
                    newRelationship.setProperty(property, outgoing.getProperty(property));
            }
        }

        for (G newGraphNode : newGraphNodes) {
            editor.updateRelationships(newGraphNode);
        }

        editor.clearSelection();
        for (G newGraphNode : newGraphNodes)
            editor.selectNode(newGraphNode.uuid());
    }
}