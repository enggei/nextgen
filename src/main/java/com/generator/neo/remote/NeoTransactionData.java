package com.generator.neo.remote;

import com.generator.generators.domain.DomainPlugin;
import com.sun.istack.internal.NotNull;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.event.LabelEntry;
import org.neo4j.graphdb.event.PropertyEntry;
import org.neo4j.graphdb.event.TransactionData;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

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
	private final Collection<PropertyEntry<Relationship>> assignedRelationships = new LinkedHashSet<>();
	private final Collection<PropertyEntry<Relationship>> removedRelationships = new LinkedHashSet<>();

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
		return assignedRelationships;
	}

	@Override
	public Iterable<PropertyEntry<Relationship>> removedRelationshipProperties() {
		return removedRelationships;
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

	static LabelEntry newLabelEntry(final String label, final Node node) {
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

	static boolean assertNode(final Object o) {
		if (o == null) return true;

		if (!(o instanceof Node))
			throw new IllegalArgumentException("Expected object of type Node, but got " + o.getClass().getName());

		return false;
	}

	static boolean assertId(final Object o) {
		if (o == null) return true;

		if (!(o instanceof Long))
			throw new IllegalArgumentException("Expected object of type Long, but got " + o.getClass().getName());

		return false;
	}

	static boolean assertRelationship(final Object o) {
		if (o == null) return true;

		if (!(o instanceof Relationship))
			throw new IllegalArgumentException("Expected object of type Relationship, but got " + o.getClass().getName());

		return false;
	}

	static boolean assertLabelEntry(final Object o) {
		if (o == null) return true;

		if (!(o instanceof LabelEntry))
			throw new IllegalArgumentException("Expected object of type LabelEntry, but got " + o.getClass().getName());

		return false;
	}
}
