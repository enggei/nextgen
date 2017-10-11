package com.generator.generators.csv.parser;

import org.neo4j.graphdb.*;

public abstract class CSVDomainVisitor {

	protected final java.util.Set<Node> visited = new java.util.LinkedHashSet<>();

   public void visit(Node node) {
		if(hasLabel(node, "Row")) visitRow(node);
		else if(hasLabel(node, "CsvFile")) visitCsvFile(node);
		else if(hasLabel(node, "Hdr")) visitHdr(node);
		else if(hasLabel(node, "Field")) visitField(node);
   }

	public void visitRow(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitCsvFile(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitHdr(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	public void visitField(Node node) {
		if (visited.contains(node)) return;
	   visited.add(node);
		outgoing(node).forEach(relationship -> visit(other(node, relationship)));
	}

	private boolean hasLabel(Node node, String label) {
   	for (org.neo4j.graphdb.Label lbl : node.getLabels())
      	if (lbl.name().equals(label)) return true;
      return false;
   }

	protected Iterable<Relationship> outgoing(Node node, RelationshipType type) {
     	return node == null ? java.util.Collections.emptyList() : sort(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, type));
   }

	protected Iterable<Relationship> outgoing(Node node) {
     	return node == null ? java.util.Collections.emptyList() : sort(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING));
   }

	protected static Iterable<Relationship> sort(Iterable<Relationship> relationships) {
		final java.util.Set<Relationship> relations = new java.util.TreeSet<>(java.util.Comparator.comparingLong(Relationship::getId));
		for (Relationship relationship : relationships)
			relations.add(relationship);
		return relations;
	}

	protected Node other(Node node, Relationship relationship) {
     	return relationship == null ? null : relationship.getOtherNode(node);
   }
}