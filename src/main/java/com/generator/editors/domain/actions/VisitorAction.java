package com.generator.editors.domain.actions;

import com.generator.editors.domain.BaseDomainVisitor;
import com.generator.editors.domain.MetaDomain;
import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import org.neo4j.graphdb.Transaction;

/**
 * goe on 4/24/15.
 */
public class VisitorAction<E extends Enum<E>, R extends Enum<R >, G extends GraphNode<E>, D extends GraphEditor<E,R,G>> extends GraphEditorAction<E, R, G, D>  {

    private final GraphNode<E> targetNode;
    private final BaseDomainVisitor<E> visitor;
    private final MetaDomain<E, R> domain;

    public VisitorAction(String name, D editor, GraphNode<E> targetNode, BaseDomainVisitor<E> visitor, MetaDomain<E, R> domain) {
        super(name, editor);
        this.targetNode = targetNode;
        this.visitor = visitor;
        this.domain = domain;
    }

    @Override
    public void doAction(Transaction tx) {
        visitor.done(visitor.visit(targetNode.node(), domain.getMetaNode(targetNode.node())));
    }
}