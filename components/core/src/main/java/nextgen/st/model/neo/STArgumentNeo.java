package nextgen.st.model.neo;

public class STArgumentNeo {

	private final org.neo4j.graphdb.Node node;

	public STArgumentNeo(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STArgumentNeo other = (STArgumentNeo) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	public STArgumentNeo setUuid(String value) { 
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

	public STArgumentNeo removeUuid() { 
		node.removeProperty("uuid");
		return this;
	}

	public STArgumentNeo setStParameter(String value) { 
		if (value == null) node.removeProperty("stParameter"); 
		else node.setProperty("stParameter", value);
		return this;
	}

	public String getStParameter() { 
		if (node.hasProperty("stParameter")) return (String) node.getProperty("stParameter");
		return null;
	}

	public String getStParameter(String defaultValue) { 
		if (node.hasProperty("stParameter")) return (String) node.getProperty("stParameter");
		return defaultValue;
	}

	public boolean hasStParameter() { 
		return node.hasProperty("stParameter");
	}

	public STArgumentNeo removeStParameter() { 
		node.removeProperty("stParameter");
		return this;
	}

	public STArgumentNeo setValue(STValueNeo dst) { 
		final org.neo4j.graphdb.Relationship relationship = getValueRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("value"));
		return this;
	}

	public STValueNeo getValue() { 
		final org.neo4j.graphdb.Relationship relationship = getValueRelation();
		return relationship == null ? null : new STValueNeo(relationship.getOtherNode(node));
	}

	public STArgumentNeo removeValue() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getValueRelation());
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public org.neo4j.graphdb.Relationship getValueRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("value"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public STArgumentNeo addKeyValues(STArgumentKVNeo dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("keyValues")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("keyValues"));
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STArgumentKVNeo> getKeyValues() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("keyValues")).spliterator(), false).map((relationship) -> new STArgumentKVNeo(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STArgumentKVNeo> getKeyValuesSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("keyValues")).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t", o.getId()))).map((relationship) -> new STArgumentKVNeo(relationship.getOtherNode(node)));
	}

	public STArgumentNeo removeKeyValues(STArgumentKVNeo dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("keyValues")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public STArgumentNeo removeAllKeyValues() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("keyValues")).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public java.util.stream.Stream<STArgumentKVNeo> getIncomingKeyValues() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("keyValues")).spliterator(), false).map((relationship) -> new STArgumentKVNeo(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STModelNeo> getIncomingArguments() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("arguments")).spliterator(), false).map((relationship) -> new STModelNeo(relationship.getOtherNode(node)));
	}

	@Override
	public String toString() {
		return "";
	}

	public io.vertx.core.json.JsonObject toJsonObject() {
		io.vertx.core.json.JsonObject jsonObject = new io.vertx.core.json.JsonObject();
		if (node.hasProperty("uuid")) jsonObject.put("uuid", node.getProperty("uuid"));
		if (node.hasProperty("uuid")) jsonObject.put("uuid", node.getProperty("uuid"));
		if (node.hasProperty("stParameter")) jsonObject.put("stParameter", node.getProperty("stParameter"));
		final STValueNeo _value = getValue();
		if (_value != null) jsonObject.put("value", _value.toJsonObject());

		final io.vertx.core.json.JsonArray _keyValues = new io.vertx.core.json.JsonArray();
		getKeyValues().forEach(element -> _keyValues.add(element.toJsonObject()));
		if (!_keyValues.isEmpty()) jsonObject.put("keyValues", _keyValues);

		return jsonObject;
	}

	public void deleteTree() {
		final STValueNeo _value = getValue();
		if (_value != null) _value.deleteTree();

		getKeyValues().forEach(element -> element.deleteTree());

		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();
	}
}