package com.generator.editors.domain;

import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Label;

import java.awt.*;
import java.util.*;

import static com.generator.editors.domain.MetaDomain.MetaLabels.LAYOUT;

/**
 * User: goe
 * Date: 20.05.14
 * todo: ideas: http://jsplumbtoolkit.com/demo/draggableConnectors/jquery.html
 * http://jsbin.com/domek/6/edit
 */
public abstract class MetaDomain<E extends Enum<E>, R extends Enum<R>> {

	protected static final Random random = new Random();
	protected final NeoModel model;
	protected final String name;
	private final Map<E, MetaNode<E>> nodes = new LinkedHashMap<>();
	private final Map<R, MetaRelation<E, R>> relations = new LinkedHashMap<>();

	//todo deprecated
	protected final Map<E, Color> colorMap = new LinkedHashMap<>();

	public boolean isConstrained(Node node) {
		// override this in domains with
		return false;
	}

	public String toString(Iterable<Relationship> relationships) {
		final StringBuilder out = new StringBuilder();
		boolean first = true;
		for (Relationship item : relationships) {
			if (!first) out.append(",");
			first = false;
			out.append(item.getType().name());
		}
		return out.toString();
	}

	public interface Committer {

		void doAction(Transaction tx) throws Throwable;

		void exception(Throwable throwable);
	}

	public void commit(Committer committer) {
		try (Transaction tx = getModel().beginTx()) {
			try {
				committer.doAction(tx);
				tx.success();
			} catch (Throwable throwable) {
				committer.exception(throwable);
				tx.failure();
			}
		}
	}

	// internal relation-structures
	public enum MetaLabels {
		LAYOUT
	}

	public enum MetaRelations implements RelationshipType {
		DefaultValue
	}

	public MetaDomain(NeoModel model, String name) {
		this.model = model;
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	protected Object getProperty(Node node, String property, Object defaultValue) {
		return hasProperty(node, property) ? node.getProperty(property) : defaultValue;
	}

	protected Object getProperty(Node node, String property) {
		final Object value = getProperty(node, property, null);
		if (value == null) {
			final MetaNode<E> metaNode = getMetaNode(node);
			if (metaNode == null)
				throw new IllegalStateException("Cannot find '" + property + "' in unknown node " + node.getProperty(NeoModel.TAG_UUID) + " for this domain");
			throw new IllegalStateException("Cannot find '" + property + "' in " + metaNode.getLabel() + " node " + metaNode.getUuid());
		}
		return value;
	}

	protected static boolean hasProperty(Relationship relation, String property) {
		return relation.hasProperty(property) && !"[]".equals(relation.getProperty(property));
	}

	@SuppressWarnings("unchecked")
	protected <T> T getProperty(Relationship relation, String property, T defaultValue) {
		return (T) (hasProperty(relation, property) ? relation.getProperty(property) : defaultValue);
	}

	public boolean is(Node node, E entities) {
		return getMetaNode(node).getLabel().equals(entities);
	}

	// todo IMPORTANT: utilities for merging templates and node-properties directly without Template-group:
//    public void mapProperty(ST template, String templateProperty, Node node, String nodeProperty) {
//        if (hasProperty(node, nodeProperty)) template.add(templateProperty, node.getProperty(nodeProperty).toString());
//    }

//    public void mapAggregate(ST template, String templateProperty, Node node, String... kv) {
//        final STGenerator.KeyedValue keyedValue = new STGenerator.KeyedValue(templateProperty);
//        for (int i = 0; i < kv.length; i += 2) {
//            String templatePropertyName = kv[i];
//            String nodePropertyName = kv[i + 1];
//            if (hasProperty(node, nodePropertyName))
//                keyedValue.add(templatePropertyName, node.getProperty(nodePropertyName));
//        }
//        keyedValue.addToTemplate(template);
//    }

	protected boolean hasProperty(Node node, String property) {
		return node.hasProperty(property) && !"[]".equals(node.getProperty(property));
	}

//    public static boolean hasProperty(Node node, String propertyName) {
//        return !"[]".equals(NeoModel.getProperty(propertyName, node, "[]"));
//    }

	public Node getNode(final UUID uuid) {
		return model.getNode(uuid);
	}

	protected Boolean is(Relationship relationship, String property) {
		return Boolean.valueOf(getProperty(relationship, property, "false"));
	}

	protected Object getProperty(Relationship relation, String property) {
		final Object value = getProperty(relation, property, null);
		if (value == null) {
			final MetaRelation<E, R> metaRelation = getMetaRelation(relation);
			if (metaRelation == null)
				throw new IllegalStateException("Cannot find '" + property + "' in unknown relation " + relation.getProperty(NeoModel.TAG_UUID) + " for this domain");
			throw new IllegalStateException("Cannot find '" + property + "' in " + metaRelation.getType() + " relation " + metaRelation.getName());
		}
		return value;
	}

	public NeoModel getModel() {
		return model;
	}

	public Set<MetaNode<E>> getAllNodes() {
		return new LinkedHashSet<>(nodes.values());
	}

	public Set<MetaRelation<E, R>> getAllRelations() {
		return new LinkedHashSet<>(relations.values());
	}

	public MetaRelation<E, R> getMetaRelation(Relationship relationship) {

		final String type = relationship.getType().name();
		for (R key : this.relations.keySet()) {
			if (type.equals(key.name())) return this.relations.get(key);
		}
		//System.out.println("Could not find meta relation for '" + type + "' amongs " + this.relations.keySet());
		return null;
	}

	public Set<MetaRelation<E, R>> getRelationsBetween(MetaNode source, MetaNode target) {
		final Set<MetaRelation<E, R>> set = new LinkedHashSet<>();
		for (MetaRelation<E, R> metaRelation : relations.values())
			if (metaRelation.isSource(source) && metaRelation.isTarget(target)) set.add(metaRelation);
		return set;
	}

	public Relationship relate(Enum<R> relation, Node source, Node target, String... properties) {
		if (source == null)
			throw new IllegalArgumentException("Relation '" + name + "." + relation.name() + "' could not create relationship since source is null");
		if (target == null)
			throw new IllegalArgumentException("Relation '" + name + "." + relation.name() + "' could not create relationship since target is null");

		// check if already exists
		for (Relationship relationship : source.getRelationships(Direction.OUTGOING, type(relation.name())))
			if (relationship.getOtherNode(source).equals(target)) return relationship;

		final MetaRelation<E, R> metaRelation = getRelation(relation);
		metaRelation.validate(source, target);
		metaRelation.validate(properties);  // new; validating values in properties

		final Set<E> sourceLabels = new TreeSet<>();
		for (Label label : source.getLabels()) sourceLabels.add(entity(label.name()));
		final Set<E> targetLabels = new TreeSet<>();
		for (Label label : target.getLabels()) targetLabels.add(entity(label.name()));

		for (E sourceLabel : sourceLabels) {
			if (!metaRelation.sources().contains(sourceLabel)) continue;
			for (E targetLabel : targetLabels) {
				for (E targetEntry : metaRelation.targets()) {
					if (targetEntry.equals(targetLabel)) {
						final Relationship relationshipTo = source.createRelationshipTo(target, type(metaRelation.getName()));
						relationshipTo.setProperty("type", targetEntry.name());

						// adding properties to relationship
						for (int i = 0; i < (properties.length - 1); i += 2)
							relationshipTo.setProperty(properties[i], properties[i + 1]);
						return relationshipTo;
					}
				}
			}
		}
		throw new IllegalArgumentException("Relation '" + name + "." + relation.name() + "' could not create relationship " + sourceLabels + " -> " + targetLabels + ".");
	}

	public RelationshipType type(Enum<R> type) {
		return DynamicRelationshipType.withName(type.name());
	}

	public RelationshipType type(String type) {
		return DynamicRelationshipType.withName(type);
	}

	public Node newNode(E nodeType, UUID uuid, String... kv) {
		final MetaNode metaNode = getNode(nodeType);
		metaNode.validate(kv);
		return model.newNode(nodeType.name(), uuid == null ? UUID.randomUUID() : uuid, kv);
	}

	public String listLabelsFor(Node node) {
		final StringBuilder labels = new StringBuilder();
		boolean first = true;
		for (Label label : node.getLabels()) {
			if (!first) labels.append(", ");
			labels.append(label);
			first = false;
		}
		return labels.toString();
	}

	public MetaNode<E> getMetaNode(Node node) {
		for (Label label : node.getLabels()) {

			try {

				if (this.nodes.containsKey(entity(label.name()))) {
					return this.nodes.get(entity(label.name()));
				}

			} catch (Exception e) {
				continue;   // the node-label is not recognized by this.domain. Ignore
			}
		}

		return null;
	}

	public void validate() {

		for (MetaNode metaNode : nodes.values()) {
			boolean isRelated = false;
			for (Map.Entry<R, MetaRelation<E, R>> relationEntry : relations.entrySet()) {
				if (relationEntry.getValue().isSource(metaNode) || relationEntry.getValue().isTarget(metaNode)) {
					isRelated = true;
				}
			}

			if (!isRelated)
				throw new IllegalStateException("'" + metaNode.getLabel() + "' is not attached to any other node in domain. This is not allowed.");
		}

		for (Map.Entry<R, MetaRelation<E, R>> relationEntry : relations.entrySet())
			relationEntry.getValue().validate(nodes.values());
	}

	public MetaNode<E> getNode(E label) {
		if (!this.nodes.containsKey(label))
			throw new IllegalArgumentException("Cannot get node '" + label + "'. It is unknown to this domain.");
		return this.nodes.get(label);
	}

	public Set<MetaNode<E>> getNodes(Iterable<Label> labels) {
		final Set<MetaNode<E>> set = new LinkedHashSet<>();
		for (Label label : labels) {
			if (this.name.equals(label.name())) continue;
			set.add(getNode(entity(label.name())));
		}
		return set;
	}

	public MetaRelation<E, R> getRelation(Enum<R> label) {
		if (!this.relations.containsKey(label))
			throw new IllegalArgumentException("Cannot get relation '" + label + "'. It is unknown to this domain.");
		return this.relations.get(label);
	}

	protected abstract E entity(String s);

	protected abstract R relation(String s);

	protected MetaNode<E> addMetaNode(E label, UUID uuid) {
		if (this.nodes.keySet().contains(label))
			throw new IllegalArgumentException("Node '" + label + "' already exists.");

		final MetaNode<E> node = new MetaNode<>(model.newNode(this.name, uuid, "name", label.name()), this.name, label, uuid);
		this.nodes.put(label, node);
		return node;
	}

	// todo: refactor this to take in a GraphNode<E> as a representation/symbol
	protected MetaNode<E> addMetaNode(E label, UUID uuid, Color gBackground, Color gSelBackground, Color gLabelColor, Color gSelLabelColor, int width, int height) {
		final MetaNode<E> metaNode = addMetaNode(label, uuid);
		System.out.println("Domain " + getClass().getName() + " 'addMetaNode' need refactoring ! MetaDomain 298");
//        this.graphNodeParams.put(metaNode, new GraphNodeParameters(gBackground, gSelBackground, gLabelColor, gSelLabelColor, "name", width, height));
		return metaNode;
	}

	protected MetaRelation<E, R> addMetaRelation(R name, E source, E target, MetaRelation.Cardinality cardinality, MetaRelation.Direction direction) {
		return addMetaRelation(name, Collections.singleton(source), Collections.singleton(target), cardinality, direction);
	}

	protected MetaRelation<E, R> addMetaRelation(R name, Set<E> source, Set<E> target, MetaRelation.Cardinality cardinality, MetaRelation.Direction direction) {

		if (this.relations.keySet().contains(name))
			throw new IllegalArgumentException("Relation '" + name + "' already exists.");

		final MetaRelation<E, R> relation = new MetaRelation<>(name, source, target, cardinality, direction);
		this.relations.put(name, relation);

		for (E src : relation.sources()) {
			final MetaNode<E> metaSrc = this.nodes.get(src);
			if (metaSrc == null)
				throw new IllegalArgumentException("Relation '" + name + "' cannot find source-node with name '" + src + "'.");

			for (E dst : relation.targets()) {
				final MetaNode<E> metaDst = this.nodes.get(dst);
				if (metaDst == null)
					throw new IllegalArgumentException("Relation '" + name + "' cannot find target-node with name '" + dst + "'.");

				metaSrc.getNode().createRelationshipTo(metaDst.getNode(), type(name));
			}
		}

		return relation;
	}

	@SafeVarargs
	protected final Set<E> newNodeSet(E... entity) {
		final Set<E> set = new LinkedHashSet<>();
		Collections.addAll(set, entity);
		return set;
	}

	public Set<MetaRelation<E, R>> getMetaRelations(Set<MetaNode<E>> sourceMetaNodes, Set<MetaNode<E>> targetMetaNodes) {
		final Set<MetaRelation<E, R>> relations = new TreeSet<>(new Comparator<MetaRelation<E, R>>() {
			@Override
			public int compare(MetaRelation<E, R> o1, MetaRelation<E, R> o2) {
				return o1.getName().name().compareTo(o2.getName().name());
			}
		});
		for (MetaNode<E> sourceMetaNode : sourceMetaNodes) {
			for (MetaNode<E> targetMetaNode : targetMetaNodes) {
				relations.addAll(getRelationsBetween(sourceMetaNode, targetMetaNode));
			}
		}
		return relations;
	}

	public Set<MetaNode<E>> getMetaNodes(Set<Node> sourceNodes) {
		final Set<MetaNode<E>> sourceMetaNodes = new LinkedHashSet<>();
		for (Node sourceNode : sourceNodes) sourceMetaNodes.addAll(getNodes(sourceNode.getLabels()));
		return sourceMetaNodes;
	}

	public MetaNode<E> getRootNode() {
		return null;
	}

	public Node saveLayoutWithName(String name) {
		final Set<Node> newSearch = getModel().getAll(layoutKey(), "name", name);
		if (newSearch.isEmpty()) {
			return model.newNode(layoutKey(), UUID.randomUUID(), "name", name);
		} else {
			return newSearch.iterator().next();
		}
	}

	public String layoutKey() {
		return this.name + "_" + LAYOUT;
	}
}