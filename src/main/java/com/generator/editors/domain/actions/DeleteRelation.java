package com.generator.editors.domain.actions;

import com.generator.editors.domain.NeoModel;
import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

/**
 * goe on 3/20/15.
 */
public class DeleteRelation<E extends Enum<E>, R extends Enum<R >, G extends GraphNode<E>, D extends GraphEditor<E,R,G>> extends GraphEditorAction<E, R, G, D>  {

    private final GraphNode<E> node;
    private final Relationship relationship;
    private final Node otherNode;

    public DeleteRelation(GraphNode<E> source, Relationship relationship, Node target, D editor) {
        super((source.node().hasProperty("name") ? "'" + source.node().getProperty("name").toString() + "'" : editor.getDomain().getMetaNode(source.node())) + " -> " + (relationship.hasProperty("name") ? relationship.getProperty("name") : relationship.getType().name()) + " -> " + (target.hasProperty("name") ? "'" + target.getProperty("name").toString() + "'" : editor.getDomain().getMetaNode(target)), editor);
        this.node = source;
        this.relationship = relationship;
        this.otherNode = target;
    }

    @Override
    public void doAction(Transaction tx) {

        // todo: consider adding a view which allows to see more information to user (perhaps a sub-view of the graph with the nodes)

        if (SwingUtil.confirm("Delete relation between " + NeoModel.uuidOf(node.node()) + " and " + NeoModel.uuidOf(otherNode), editor)) {
            node.removeOutgoing(relationship);
            relationship.delete();
        }
    }
}
