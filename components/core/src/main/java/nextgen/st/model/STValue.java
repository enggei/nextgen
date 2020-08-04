package nextgen.st.model;

public class STValue {

	private final java.beans.PropertyChangeSupport pcs = new java.beans.PropertyChangeSupport(this);
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
		if (value == null) node.removeProperty(_uuid); 
		else node.setProperty(_uuid, value);
		this.pcs.firePropertyChange("set.uuid", null, value);
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
		this.pcs.firePropertyChange("remove.uuid", true, false);
		return this;
	}

	private static final String _value = "value";

	public STValue setValue(String value) { 
		if (value == null) node.removeProperty(_value); 
		else node.setProperty(_value, value);
		this.pcs.firePropertyChange("set.value", null, value);
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
		this.pcs.firePropertyChange("remove.value", true, false);
		return this;
	}

	public STValue setType(STValueType value) { 
		if (value == null) node.removeProperty("type"); 
		else node.setProperty("type", value.name());
		this.pcs.firePropertyChange("set.type", null, value);
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
		this.pcs.firePropertyChange("remove.type", true, false);
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
		this.pcs.firePropertyChange("set.stModel", null, dst);
		return this;
	}

	public STModel getStModel() { 
		final org.neo4j.graphdb.Relationship relationship = getStModelRelation();
		return relationship == null ? null : new STModel(relationship.getOtherNode(node));
	}

	public STValue removeStModel() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getStModelRelation());
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		this.pcs.firePropertyChange("remove.stModel", true, false);
		return this;
	}

	public org.neo4j.graphdb.Relationship getStModelRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("stModel"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public java.util.stream.Stream<STFile> getIncomingName() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("name")).spliterator(), false).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STFile> getIncomingType() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("type")).spliterator(), false).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STFile> getIncomingPackageName() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("packageName")).spliterator(), false).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STFile> getIncomingPath() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("path")).spliterator(), false).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}

	@Override
	public String toString() {
		return "";
	}

	public io.vertx.core.json.JsonObject toJsonObject() {
		io.vertx.core.json.JsonObject jsonObject = new io.vertx.core.json.JsonObject();
		if (node.hasProperty("uuid")) jsonObject.put("uuid", node.getProperty("uuid"));
		if (node.hasProperty("uuid")) jsonObject.put("uuid", node.getProperty("uuid"));
		if (node.hasProperty("value")) jsonObject.put("value", node.getProperty("value"));
		if (node.hasProperty("type")) jsonObject.put("type", node.getProperty("type"));
		final STModel _stModel = getStModel();
		if (_stModel != null) jsonObject.put("stModel", _stModel.toJsonObject());

		return jsonObject;
	}

	public void deleteTree() {
		final STModel _stModel = getStModel();
		if (_stModel != null) _stModel.deleteTree();

		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();
	}

	public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}
}