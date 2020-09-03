package nextgen.st.model;

public class STArgument {

	private final org.neo4j.graphdb.Node node;

	public STArgument(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STArgument other = (STArgument) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	private static final String _uuid = "uuid";

	public STArgument setUuid(String value) { 
		if (value == null) node.removeProperty(_uuid); 
		else node.setProperty(_uuid, value);
		return this;
	}

	public String getUuid() { 
		if (node.hasProperty(_uuid)) return (String) node.getProperty(_uuid);
		return null;
	}

	public String getUuid(String defaultValue) { 
		if (node.hasProperty(_uuid)) return (String) node.getProperty(_uuid);
		return defaultValue;
	}

	public boolean hasUuid() { 
		return node.hasProperty(_uuid);
	}

	public STArgument removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}

	private static final String _stParameter = "stParameter";

	public STArgument setStParameter(String value) { 
		if (value == null) node.removeProperty(_stParameter); 
		else node.setProperty(_stParameter, value);
		return this;
	}

	public String getStParameter() { 
		if (node.hasProperty(_stParameter)) return (String) node.getProperty(_stParameter);
		return null;
	}

	public String getStParameter(String defaultValue) { 
		if (node.hasProperty(_stParameter)) return (String) node.getProperty(_stParameter);
		return defaultValue;
	}

	public boolean hasStParameter() { 
		return node.hasProperty(_stParameter);
	}

	public STArgument removeStParameter() { 
		node.removeProperty(_stParameter);
		return this;
	}

	public STArgument setValue(STValue dst) { 
		final org.neo4j.graphdb.Relationship relationship = getValueRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("value"));
		return this;
	}

	public STValue getValue() { 
		final org.neo4j.graphdb.Relationship relationship = getValueRelation();
		return relationship == null ? null : new STValue(relationship.getOtherNode(node));
	}

	public STArgument removeValue() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getValueRelation());
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public org.neo4j.graphdb.Relationship getValueRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("value"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	private static final org.neo4j.graphdb.RelationshipType _keyValues = org.neo4j.graphdb.RelationshipType.withName("keyValues");

	public STArgument addKeyValues(STArgumentKV dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _keyValues).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _keyValues);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STArgumentKV> getKeyValues() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _keyValues).spliterator(), false).map((relationship) -> new STArgumentKV(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STArgumentKV> getKeyValuesSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _keyValues).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t", o.getId()))).map((relationship) -> new STArgumentKV(relationship.getOtherNode(node)));
	}

	public STArgument removeKeyValues(STArgumentKV dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _keyValues).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public STArgument removeAllKeyValues() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _keyValues).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public java.util.stream.Stream<STArgumentKV> getIncomingKeyValuesSTArgumentKV() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("keyValues")).spliterator(), false).map((relationship) -> new STArgumentKV(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STModel> getIncomingArgumentsSTModel() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("arguments")).spliterator(), false).map((relationship) -> new STModel(relationship.getOtherNode(node)));
	}

	@Override
	public String toString() {
		final StringBuilder out = new StringBuilder();
		out.append("Node : ").append(node.getId()).append(" ");
		node.getLabels().forEach(label -> out.append(label.name()).append(" "));
		out.append("(");
		node.getPropertyKeys().forEach(s -> out.append(" ").append(s).append(":").append(node.getProperty(s)));
		out.append(")");
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(relationship -> {
			out.append("\n\t -> ").append(relationship.getType()).append(" (");
			relationship.getPropertyKeys().forEach(s -> out.append(" ").append(s).append(":").append(relationship.getProperty(s)));
			out.append(")");
		});
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(relationship -> {
			out.append("\n\t <- ").append(relationship.getType()).append(" (");
			relationship.getPropertyKeys().forEach(s -> out.append(" ").append(s).append(":").append(relationship.getProperty(s)));
			out.append(")");
		});
		return out.toString().trim();
	}

	public io.vertx.core.json.JsonObject toJsonObject() {
		io.vertx.core.json.JsonObject jsonObject = new io.vertx.core.json.JsonObject();
		if (node.hasProperty("uuid")) jsonObject.put("uuid", node.getProperty("uuid"));
		if (node.hasProperty("stParameter")) jsonObject.put("stParameter", node.getProperty("stParameter"));
		final STValue _value = getValue();
		if (_value != null) jsonObject.put("value", _value.toJsonObject());

		final io.vertx.core.json.JsonArray _keyValues = new io.vertx.core.json.JsonArray();
		getKeyValues().forEach(element -> _keyValues.add(element.toJsonObject()));
		if (!_keyValues.isEmpty()) jsonObject.put("keyValues", _keyValues);

		return jsonObject;
	}

	public void delete() {
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();
	}

}