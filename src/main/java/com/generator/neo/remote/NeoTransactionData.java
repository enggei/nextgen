package com.generator.neo.remote;

import org.jetbrains.annotations.NotNull;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.event.LabelEntry;
import org.neo4j.graphdb.event.PropertyEntry;
import org.neo4j.graphdb.event.TransactionData;

import java.util.*;

public class NeoTransactionData implements TransactionData {

	private final org.neo4j.driver.v1.Transaction tx;

	private final Collection<Node> createdNodes = new LinkedHashSet<>();
	private final Collection<Node> deletedNodes = new LinkedHashSet<>();
	private final Collection<PropertyEntry<Node>> assignedNodeProperties = new LinkedHashSet<>();
	private final Collection<PropertyEntry<Node>> removedNodeProperties = new LinkedHashSet<>();
	private final Collection<LabelEntry> assignedLabels = new LinkedHashSet<>();
	private final Collection<LabelEntry> removedLabels = new LinkedHashSet<>();
	private final Collection<Relationship> createdRelationships = new LinkedHashSet<>();
	private final Collection<Relationship> deletedRelationships = new LinkedHashSet<>();
	private final Collection<PropertyEntry<Relationship>> assignedRelationshipProperties = new LinkedHashSet<>();
	private final Collection<PropertyEntry<Relationship>> removedRelationshipProperties = new LinkedHashSet<>();

	NeoTransactionData(@NotNull org.neo4j.driver.v1.Transaction tx) {
		if (!tx.isOpen()) {
			throw new IllegalStateException("Transaction is not open!");
		}
		this.tx = tx;
	}

	@Override
	public Iterable<Node> createdNodes() {
		return createdNodes;
	}

	@Override
	public Iterable<Node> deletedNodes() {
		return deletedNodes;
	}

	@Override
	public boolean isDeleted(Node node) {
		return deletedNodes.contains(node);
	}

	@Override
	public Iterable<PropertyEntry<Node>> assignedNodeProperties() {
		return assignedNodeProperties;
	}

	@Override
	public Iterable<PropertyEntry<Node>> removedNodeProperties() {
		return removedNodeProperties;
	}

	@Override
	public Iterable<LabelEntry> assignedLabels() {
		return assignedLabels;
	}

	@Override
	public Iterable<LabelEntry> removedLabels() {
		return removedLabels;
	}

	@Override
	public Iterable<Relationship> createdRelationships() {
		return createdRelationships;
	}

	@Override
	public Iterable<Relationship> deletedRelationships() {
		return deletedRelationships;
	}

	@Override
	public boolean isDeleted(Relationship relationship) {
		return deletedRelationships.contains(relationship);
	}

	@Override
	public Iterable<PropertyEntry<Relationship>> assignedRelationshipProperties() {
		return assignedRelationshipProperties;
	}

	@Override
	public Iterable<PropertyEntry<Relationship>> removedRelationshipProperties() {
		return removedRelationshipProperties;
	}

	@Override
	public String username() {
		return "";
	}

	@Override
	public Map<String, Object> metaData() {
		return new HashMap<>();
	}

	Transaction getTx() {
		return tx;
	}

	void nodeCreated(final Node node) {
		if (node == null) return;
		createdNodes.add(node);
	}

	void nodeDeleted(final Node node) {
		if (node == null) return;
		deletedNodes.add(node);
	}

	void labelAssigned(final String label, final Node node) {
		if (node == null) return;
		assignedLabels.add(newLabelEntry(label, node));
	}

	void labelRemoved(final String label, final Node node) {
		if (node == null) return;
		removedLabels.add(newLabelEntry(label, node));
	}

	void relationshipCreated(final Relationship relationship) {
		if (relationship == null) return;
		createdRelationships.add(relationship);
	}

	void relationshipDeleted(final Relationship relationship) {
		if (relationship == null) return;
		deletedRelationships.add(relationship);
	}

	void nodePropertyAssigned(final String name, final Object value, final Node node) {
		nodePropertyAssigned(name, value, null, node);
	}

	void nodePropertyAssigned(final String name, final Object value, final Object old, final Node node) {
		propertyAssigned(name, value, old, node, assignedNodeProperties);
	}

	void nodePropertyRemoved(final String name, final Object old, final Node node) {
		propertyRemoved(name, old, node, removedNodeProperties);
	}

	void relationshipPropertyAssigned(final String name, final Object value, final Relationship relationship) {
		relationshipPropertyAssigned(name, value, null, relationship);
	}

	void relationshipPropertyAssigned(final String name, final Object value, final Object old, final Relationship relationship) {
		propertyAssigned(name, value, old, relationship, assignedRelationshipProperties);
	}

	void relationshipPropertyRemoved(final String name, final Object old, final Relationship relationship) {
		propertyRemoved(name, old, relationship, removedRelationshipProperties);
	}

	private static <T extends Entity> void propertyAssigned(final String name, final Object value, final Object old, final T entity, final Collection<PropertyEntry<T>> collection) {
		if (entity == null || name == null) return;

		Object previous = clearOldPropertyEntry(name, old, entity, collection);

		collection.add(newAssignedPropertyEntry(name, value, previous, entity));
	}

	private static <T extends Entity> void propertyRemoved(final String name, final Object old, final T entity, final Collection<PropertyEntry<T>> collection) {
		if (entity == null || name == null) return;

		Object previous = clearOldPropertyEntry(name, old, entity, collection);

		collection.add(newRemovedPropertyEntry(name, previous, entity));
	}

	private static <T extends Entity> Object clearOldPropertyEntry(final String name, final Object old, final T entity, final Collection<PropertyEntry<T>> collection) {
		// TODO: Refine this - we do not want O(N). Override hash method in newRemovedPropertyEntry f.ex.
		Optional<PropertyEntry<T>> propertyEntry = collection
			.stream()
			.filter(entry -> entry.entity().getId() == entity.getId() && entry.key().equals(name))
			.findFirst();

		Object previous = old;

		if (propertyEntry.isPresent()) {
			previous = propertyEntry.get().previouslyCommitedValue();
			collection.remove(propertyEntry.get());
		}

		return previous;
	}

	private static LabelEntry newLabelEntry(final String label, final Node node) {
		return new LabelEntry() {
			@Override
			public Label label() {
				return Label.label(label);
			}

			@Override
			public Node node() {
				return node;
			}
		};
	}

	private static <T extends PropertyContainer> PropertyEntry<T> newAssignedPropertyEntry(final String name, final Object value, final Object old, final T propertyContainer) {
		return newPropertyEntry(name, value, old, propertyContainer, false);
	}

	private static <T extends PropertyContainer> PropertyEntry<T> newRemovedPropertyEntry(final String name, final Object old, final T propertyContainer) {
		return newPropertyEntry(name, null, old, propertyContainer, true);
	}

	private static <T extends PropertyContainer> PropertyEntry<T> newPropertyEntry(final String name, final Object value, final Object old, final T propertyContainer, final boolean shouldThrow) {

		if (propertyContainer == null || name == null || !(propertyContainer instanceof Node || propertyContainer instanceof Relationship))
			throw new IllegalArgumentException("propertyContainer is " + (propertyContainer != null ? propertyContainer.getClass().getName() : "NULL") + ", expecting Node or Relationship");

		return new PropertyEntry<T>() {
			@Override
			public T entity() {
				return propertyContainer;
			}

			@Override
			public String key() {
				return name;
			}

			@Override
			public Object previouslyCommitedValue() {
				return old;
			}

			@Override
			public Object value() {
				// Ref. method contract org.neo4j.graphdb.event.PropertyEntry
				if (shouldThrow)
					throw new IllegalStateException(name + " was removed");

				return value;
			}
		};
	}
}
