package nextgen.st.model.neo;

public class STArgumentKVNeo {

	private final org.neo4j.graphdb.Node node;

	public STArgumentKVNeo(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STArgumentKVNeo other = (STArgumentKVNeo) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	public STArgumentKVNeo setUuid(String value) { 
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

	public STArgumentKVNeo removeUuid() { 
		node.removeProperty("uuid");
		return this;
	}

	public STArgumentKVNeo setStParameterKey(String value) { 
		if (value == null) node.removeProperty("stParameterKey"); 
		else node.setProperty("stParameterKey", value);
		return this;
	}

	public String getStParameterKey() { 
		if (node.hasProperty("stParameterKey")) return (String) node.getProperty("stParameterKey");
		return null;
	}

	public String getStParameterKey(String defaultValue) { 
		if (node.hasProperty("stParameterKey")) return (String) node.getProperty("stParameterKey");
		return defaultValue;
	}

	public boolean hasStParameterKey() { 
		return node.hasProperty("stParameterKey");
	}

	public STArgumentKVNeo removeStParameterKey() { 
		node.removeProperty("stParameterKey");
		return this;
	}

	public STArgumentKVNeo setValue(STValueNeo dst) { 
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

	public STArgumentKVNeo removeValue() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getValueRelation());
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public org.neo4j.graphdb.Relationship getValueRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("value"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public java.util.stream.Stream<STArgumentNeo> getIncomingKeyValues() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("keyValues")).spliterator(), false).map((relationship) -> new STArgumentNeo(relationship.getOtherNode(node)));
	}

	@Override
	public String toString() {
		return "";
	}

	public io.vertx.core.json.JsonObject toJsonObject() {
		io.vertx.core.json.JsonObject jsonObject = new io.vertx.core.json.JsonObject();
		if (node.hasProperty("uuid")) jsonObject.put("uuid", node.getProperty("uuid"));
		if (node.hasProperty("uuid")) jsonObject.put("uuid", node.getProperty("uuid"));
		if (node.hasProperty("stParameterKey")) jsonObject.put("stParameterKey", node.getProperty("stParameterKey"));
		final STValueNeo _value = getValue();
		if (_value != null) jsonObject.put("value", _value.toJsonObject());

		return jsonObject;
	}

	public void deleteTree() {
		final STValueNeo _value = getValue();
		if (_value != null) _value.deleteTree();

		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();
	}
}