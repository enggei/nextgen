package com.generator.editors;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;

import java.util.*;

import static java.util.Comparator.*;
import static org.neo4j.graphdb.Direction.INCOMING;
import static org.neo4j.graphdb.Direction.OUTGOING;

/**
 * goe on 4/23/15.
 */
public abstract class BaseDomainVisitor {

	protected static java.util.List<String> split(Node node, String propertyName, String delim) {
		final String deps = getString(node, propertyName);
		if (deps != null) return Arrays.asList(deps.split(delim));
		return Collections.emptyList();
	}

	public static UUID uuidOf(Node node) {
		return NeoModel.uuidOf(node);
	}

	public static void tryToDeleteNode(Node node) throws IllegalStateException {

		final UUID uuid = uuidOf(node);

		if (node.hasRelationship(Direction.INCOMING))
			throw new IllegalStateException(uuid + " has dependencies. Remove these first!");

		System.out.println("deleting node " + uuid);
		for (Relationship nodeRelationship : node.getRelationships(Direction.OUTGOING)) {
			final Node other = other(node, nodeRelationship);
			System.out.println("deleting relationship " + uuid + " -> (" + nodeRelationship.getType() + ") -> " + uuidOf(other));
			nodeRelationship.delete();
			try {
				tryToDeleteNode(other);
			} catch (IllegalStateException ignored) {
				// the other node cannot be deleted, it has other dependencies
			}
		}
		node.delete();
	}

	public static boolean isRelated(Node node, Node target, RelationshipType relationshipType) {
		final Object targetUUID = uuidOf(target);
		for (Relationship relationship : outgoing(node, relationshipType)) {
			if (targetUUID.equals(uuidOf(other(node, relationship)))) return true;
		}
		return false;
	}

	public static Relationship getRelationship(Node node, Node target, RelationshipType relationshipType) {
		final Object targetUUID = uuidOf(target);
		for (Relationship relationship : outgoing(node, relationshipType)) {
			if (targetUUID.equals(uuidOf(other(node, relationship)))) return relationship;
		}
		return null;
	}

	public static boolean hasOutgoing(Node node, RelationshipType type) {
		return node != null && node.hasRelationship(type, OUTGOING);
	}

	public static boolean hasLabel(Node node, String label) {
		for (org.neo4j.graphdb.Label lbl : node.getLabels())
			if (lbl.name().equals(label)) return true;
		return false;
	}

	public static String labelsFor(Node node) {
		final StringBuilder lbl = new StringBuilder();
		for (org.neo4j.graphdb.Label label : node.getLabels()) lbl.append(label).append(" ");
		return lbl.toString().trim();
	}

	public static Iterable<Relationship> outgoing(Node node, RelationshipType type) {
		return node == null ? Collections.emptyList() : sort(node.getRelationships(OUTGOING, type));
	}

	public static Relationship singleOutgoing(Node node, RelationshipType type) {
		return node.hasRelationship(type) ? node.getSingleRelationship(type, OUTGOING) : null;
	}

	public static Iterable<Relationship> incoming(Node node, RelationshipType type) {
		return sort(node.getRelationships(INCOMING, type));
	}

	public static boolean hasIncoming(Node node, RelationshipType type) {
		return node != null && node.hasRelationship(type, INCOMING);
	}

	public static Relationship singleIncoming(Node node, RelationshipType type) {
		return node == null ? null : (node.hasRelationship(type) ? node.getSingleRelationship(type, INCOMING) : null);
	}

	public static Iterable<Relationship> all(Node node, RelationshipType type) {
		return node.getRelationships(type);
	}

	public static Node other(Node node, Relationship relationship) {
		return relationship == null ? null : relationship.getOtherNode(node);
	}

	@SuppressWarnings("unchecked")
	public static <T> T get(Node node, String property) {
		return (T) (has(node, property) ? node.getProperty(property) : null);
	}

	public static Object get(Relationship relationship, String property) {
		return has(relationship, property) ? relationship.getProperty(property) : null;
	}

	public static String getString(Node node, String property) {
		return has(node, property) ? String.valueOf(node.getProperty(property)) : null;
	}

	public static String getString(Relationship relationship, String property) {
		return has(relationship, property) ? String.valueOf(relationship.getProperty(property)) : null;
	}

	public static <T> T getOtherProperty(Node node, Relationship relationship, String otherProperty) {
		return get(other(node, relationship), otherProperty);
	}

	public static String get(Node nodePropertyNode, String property, String defaultValue) {
		return has(nodePropertyNode, property) ? nodePropertyNode.getProperty(property).toString() : defaultValue;
	}

	public static boolean has(Node node, String property) {
		return node != null && node.hasProperty(property) && (!"[]".equals(node.getProperty(property)) && (!"null".equals(node.getProperty(property))));
	}

	public static boolean has(Relationship relationship, String property) {
		return relationship != null && relationship.hasProperty(property) && (!"[]".equals(relationship.getProperty(property)) && (!"null".equals(relationship.getProperty(property))));
	}

	public static String types(Iterable<Relationship> relationships) {
		final StringBuilder out = new StringBuilder();
		boolean first = true;
		for (Relationship item : relationships) {
			if (!first) out.append(",");
			first = false;
			out.append(item.getType().name());
		}
		return out.toString();
	}

	public static String printPropertiesFor(Node node) {
		return printPropertiesFor(node, " ");
	}

	public static String printPropertiesFor(Node node, String delimiter) {
		final StringBuilder out = new StringBuilder();
		boolean first = true;
		for (String k : node.getPropertyKeys()) {
			if (!first) out.append(delimiter);
			out.append(k).append("=").append(node.getProperty(k));
			first = false;
		}
		return out.toString().trim();
	}

	private static Iterable<Relationship> sort(Iterable<Relationship> relationships) {

		final Set<Relationship> relations = new TreeSet<>(comparingLong(Relationship::getId));

		for (Relationship relationship : relationships)
			relations.add(relationship);

		return relations;
	}
}