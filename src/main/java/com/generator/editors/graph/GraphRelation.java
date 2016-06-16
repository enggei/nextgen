package com.generator.editors.graph;

import org.neo4j.graphdb.Relationship;

import java.awt.*;

/**
 * goe on 5/12/15.
 */
public class GraphRelation<S extends GraphNode<E>, T extends GraphNode<E>, E extends Enum<E>> {

    protected final long id;
    protected final Relationship relationship;
    protected String type = null;
    protected String label = null;

    private final S source;
    private final T target;

    public GraphRelation(Relationship relationship, S source, T target) {
        this.id = relationship.getId();
        this.relationship = relationship;
        this.source = source;
        this.target = target;
    }

    // can be overridden for visual purposes
    public void paint(Graphics2D g1, boolean selected) {
    }

    Relationship getRelationship() {
        return relationship;
    }

    public S getSource() {
        return source;
    }

    public T getTarget() {
        return target;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String getType() {
        return type;
    }

    void delete() {
        getRelationship().delete();
        this.source.removeOutgoing(this.relationship);
        this.target.removeIncoming(this.relationship);
    }

    public boolean is(Relationship relationship) {
        return relationship != null && this.relationship.equals(relationship);
    }

    public GraphNode<E> getOther(GraphNode<E> node) {
        return this.source.equals(node) ? this.target : this.source;
    }

    @Override
    public String toString() {
        return source + " -> " + target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraphRelation that = (GraphRelation) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    public void update(GraphRelation graphRelation) {
        this.label = graphRelation.getLabel();
    }
}