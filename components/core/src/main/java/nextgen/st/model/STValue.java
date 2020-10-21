package nextgen.st.model;

public class STValue {

	private final org.neo4j.graphdb.Node node;

	public STValue(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STValue other = (STValue) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	private static final String _uuid = "uuid";

	public STValue setUuid(String value) { 
		if (value == null) 
			removeUuid(); 
		else {
		 	node.setProperty(_uuid, value);
		}
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

	public STValue removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}

	private static final String _value = "value";

	public STValue setValue(String value) { 
		if (value == null) 
			removeValue(); 
		else {
		 	node.setProperty(_value, value);
		}
		return this;
	}

	public String getValue() { 
		if (node.hasProperty(_value)) return (String) node.getProperty(_value);
		return null;
	}

	public String getValue(String defaultValue) { 
		if (node.hasProperty(_value)) return (String) node.getProperty(_value);
		return defaultValue;
	}

	public boolean hasValue() { 
		return node.hasProperty(_value);
	}

	public STValue removeValue() { 
		node.removeProperty(_value);
		return this;
	}

	public STValue setType(STValueType value) {
		if (value == null) 
			removeType(); 
		else {
		 	node.setProperty("type", value.name());
		} 
		return this;
	}

	public STValueType getType() { 
		if (node.hasProperty("type")) return STValueType.valueOf((java.lang.String) node.getProperty("type"));
		return null;
	}

	public STValueType getType(STValueType defaultValue) { 
		if (node.hasProperty("type")) return STValueType.valueOf((java.lang.String) node.getProperty("type"));
		return defaultValue;
	}

	public boolean hasType() { 
		return node.hasProperty("type");
	}

	public STValue removeType() { 
		node.removeProperty("type");
		return this;
	}

	public STValue setStModel(STModel dst) { 
		final org.neo4j.graphdb.Relationship relationship = getStModelRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("stModel"));
		return this;
	}

	public STModel getStModel() { 
		final org.neo4j.graphdb.Relationship relationship = getStModelRelation();
		return relationship == null ? null : new STModel(relationship.getOtherNode(node));
	}

	public STValue removeStModel() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getStModelRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getStModelRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("stModel"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public java.util.stream.Stream<STFile> getIncomingNameSTFile() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("name")).spliterator(), false).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STFile> getIncomingTypeSTFile() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("type")).spliterator(), false).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STFile> getIncomingPackageNameSTFile() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("packageName")).spliterator(), false).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STFile> getIncomingPathSTFile() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("path")).spliterator(), false).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STArgument> getIncomingValueSTArgument() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("value")).spliterator(), false).map((relationship) -> new STArgument(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STArgumentKV> getIncomingValueSTArgumentKV() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("value")).spliterator(), false).map((relationship) -> new STArgumentKV(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STProject> getIncomingValuesSTProject() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("values")).spliterator(), false).map((relationship) -> new STProject(relationship.getOtherNode(node)));
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
		if (node.hasProperty("value")) jsonObject.put("value", node.getProperty("value"));
		if (node.hasProperty("type")) jsonObject.put("type", node.getProperty("type"));
		final STModel _stModel = getStModel();
		if (_stModel != null) jsonObject.put("stModel", _stModel.toJsonObject());

		return jsonObject;
	}

	public void delete() {

		final String uuid = node.hasProperty("uuid") ? node.getProperty("uuid").toString() : null;

		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();

	}

}