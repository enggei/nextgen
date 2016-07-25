package com.generator.editors.domain;

import com.generator.editors.graph.GraphEditor;
import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;

import java.awt.*;
import java.io.File;
import java.util.*;

import static org.neo4j.graphdb.Direction.INCOMING;
import static org.neo4j.graphdb.Direction.OUTGOING;

/**
 * goe on 4/23/15.
 */
public abstract class BaseDomainVisitor<E extends Enum<E>> {

	private final String name;

	protected final Component component;
	protected File targetFile = null;   // common-pattern: usually the target is a file

	protected BaseDomainVisitor(Component component, String name) {
		this.component = component;
		this.name = name;
	}

	/**
	 * allows to visit any node (both inside and outside domain
	 *
	 * @param node the node to visit
	 * @param <T>  the return value (if any)
	 * @return result or null
	 */
	public abstract <T> T visit(Node node, MetaNode<E> entity);

	/**
	 * process the end- result
	 *
	 * @param result the object produced by visitor
	 * @param <T>    type of object, often a String when code is produced, but can be any object
	 */
	public abstract <T> void done(T result);

	public final String getName() {
		return name;
	}

	public static UUID uuidOf(Node node) {
		return NeoModel.uuidOf(node);
	}

	public static boolean hasOutgoing(Node node, RelationshipType type) {
		return node != null && node.hasRelationship(type, OUTGOING);
	}

	public static boolean hasLabel(Node node, String label) {
		for (org.neo4j.graphdb.Label lbl : node.getLabels())
			if (lbl.name().equals(label)) return true;
		return false;
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

	public static Node otherIncoming(Node node, RelationshipType type) {
		return other(node, singleIncoming(node, type));
	}

	public static Node otherOutgoing(Node node, RelationshipType type) {
		return other(node, singleOutgoing(node, type));
	}

	protected static java.util.List<String> split(Node node, String propertyName, String delim) {
		final String deps = getString(node, propertyName);
		if (deps != null) return Arrays.asList(deps.split(delim));
		return Collections.emptyList();
	}

	public static boolean isType(Relationship relationship, Enum type) {
		return relationship != null && type.name().equals(relationship.getProperty("type"));
	}

	public static boolean isType(Node node, Enum type) {
		return node != null && type.name().equals(node.getLabels().iterator().next().name());
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

	public static <T> T getOtherProperty(Node node, Relationship relationship, String otherProperty) {
		return get(other(node, relationship), otherProperty);
	}

	public static Object getOtherProperty(Node node, RelationshipType relationshipType, String otherProperty) {
		return get(other(node, singleOutgoing(node, relationshipType)), otherProperty);
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

	public static boolean isTrue(Node node, String property) {
		return has(node, property) && Boolean.valueOf(node.getProperty(property) + "");
	}

	public static void validateHasProperty(Node node, String propertyName) {
		if (!node.hasProperty(propertyName))
			throw new IllegalStateException("Node " + NeoModel.getNameOrLabelFrom(node) + " (" + NeoModel.uuidOf(node) + ") is missing required '" + propertyName + "' property");
	}

	public static void notNull(Node rootModuleNode, String error) {
		if (rootModuleNode == null) {
			throw new IllegalStateException(error);
		}
	}

	public static String reverseString(java.util.List<String> qualifiedName) {
		final StringBuilder out = new StringBuilder();

		Collections.reverse(qualifiedName);

		boolean first = true;
		for (String s : qualifiedName) {
			if (!first) out.append(".");
			out.append(s);
			first = false;
		}

		return out.toString();
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

	public final void showOutput(Object content) {
		if (this.targetFile != null)
			FileUtil.write(content == null ? "NULL" : content.toString(), this.targetFile);
		else {
			if (component instanceof GraphEditor) ((GraphEditor) component).disableKeyEvents();
			SwingUtil.showTextResult("Generator", content == null ? "NULL" : content.toString(), component);
			if (component instanceof GraphEditor) ((GraphEditor) component).enableKeyEvents();
		}
	}

	protected static Iterable<Relationship> sort(Iterable<Relationship> relationships) {

		final Set<Relationship> relations = new TreeSet<>(new Comparator<Relationship>() {
			@Override
			public int compare(Relationship o1, Relationship o2) {
				return Long.compare(o1.getId(), o2.getId());
			}
		});

		for (Relationship relationship : relationships)
			relations.add(relationship);

		return relations;
	}
}