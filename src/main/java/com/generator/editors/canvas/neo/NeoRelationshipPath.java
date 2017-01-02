package com.generator.editors.canvas.neo;

import com.generator.editors.canvas.RelationPath;
import org.neo4j.graphdb.Relationship;

import java.util.UUID;

/**
 * goe on 11/16/16.
 */
public final class NeoRelationshipPath extends RelationPath<NeoPNode, NeoPNode> {

	protected final Relationship relationship;

	public NeoRelationshipPath(NeoPNode source, NeoPNode destination, Relationship relationship, boolean showLabel) {
		super(UUID.randomUUID(), source, destination, relationship.getType().name());
		this.relationship = relationship;
		if (showLabel) showLabel();
	}
}