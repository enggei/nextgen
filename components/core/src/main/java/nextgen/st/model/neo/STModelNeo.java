package nextgen.st.model.neo;

public class STModelNeo {

	private final org.neo4j.graphdb.Node node;

	public STModelNeo(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STModelNeo other = (STModelNeo) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	public STModelNeo setUuid(String value) { 
		if (value == null) node.removeProperty("uuid"); 
		else node.setProperty("uuid", value);
		return this;
	}

	public String getUuid() { 
		if (node.hasProperty("uuid")) return (String) node.getProperty("uuid");
		return null;
	}

	public String getUuid(String defaultValue) { 
		if (node.hasProperty("uuid")) return (String) node.getProperty("uuid");
		return defaultValue;
	}

	public boolean hasUuid() { 
		return node.hasProperty("uuid");
	}

	public STModelNeo removeUuid() { 
		node.removeProperty("uuid");
		return this;
	}

	public STModelNeo setStTemplate(String value) { 
		if (value == null) node.removeProperty("stTemplate"); 
		else node.setProperty("stTemplate", value);
		return this;
	}

	public String getStTemplate() { 
		if (node.hasProperty("stTemplate")) return (String) node.getProperty("stTemplate");
		return null;
	}

	public String getStTemplate(String defaultValue) { 
		if (node.hasProperty("stTemplate")) return (String) node.getProperty("stTemplate");
		return defaultValue;
	}

	public boolean hasStTemplate() { 
		return node.hasProperty("stTemplate");
	}

	public STModelNeo removeStTemplate() { 
		node.removeProperty("stTemplate");
		return this;
	}

	public STModelNeo addArguments(STArgumentNeo dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("arguments")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("arguments"));
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STArgumentNeo> getArguments() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("arguments")).spliterator(), false).map((relationship) -> new STArgumentNeo(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STArgumentNeo> getArgumentsSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("arguments")).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t", o.getId()))).map((relationship) -> new STArgumentNeo(relationship.getOtherNode(node)));
	}

	public STModelNeo removeArguments(STArgumentNeo dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("arguments")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public STModelNeo removeAllArguments() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("arguments")).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public java.util.stream.Stream<STArgumentNeo> getIncomingArguments() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("arguments")).spliterator(), false).map((relationship) -> new STArgumentNeo(relationship.getOtherNode(node)));
	}

	@Override
	public String toString() {
		return "";
	}

	public io.vertx.core.json.JsonObject toJsonObject() {
		io.vertx.core.json.JsonObject jsonObject = new io.vertx.core.json.JsonObject();
		if (node.hasProperty("uuid")) jsonObject.put("uuid", node.getProperty("uuid"));
		if (node.hasProperty("uuid")) jsonObject.put("uuid", node.getProperty("uuid"));
		if (node.hasProperty("stTemplate")) jsonObject.put("stTemplate", node.getProperty("stTemplate"));
		final io.vertx.core.json.JsonArray _arguments = new io.vertx.core.json.JsonArray();
		getArguments().forEach(element -> _arguments.add(element.toJsonObject()));
		if (!_arguments.isEmpty()) jsonObject.put("arguments", _arguments);

		return jsonObject;
	}

	public void deleteTree() {
		getArguments().forEach(element -> element.deleteTree());

		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();
	}
}