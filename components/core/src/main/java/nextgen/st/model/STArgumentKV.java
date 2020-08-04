package nextgen.st.model;

public class STArgumentKV {

	private final java.beans.PropertyChangeSupport pcs = new java.beans.PropertyChangeSupport(this);
	private final org.neo4j.graphdb.Node node;

	public STArgumentKV(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STArgumentKV other = (STArgumentKV) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	private static final String _uuid = "uuid";

	public STArgumentKV setUuid(String value) { 
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

	public STArgumentKV removeUuid() { 
		node.removeProperty(_uuid);
		this.pcs.firePropertyChange("remove.uuid", true, false);
		return this;
	}

	private static final String _stParameterKey = "stParameterKey";

	public STArgumentKV setStParameterKey(String value) { 
		if (value == null) node.removeProperty(_stParameterKey); 
		else node.setProperty(_stParameterKey, value);
		this.pcs.firePropertyChange("set.stParameterKey", null, value);
		return this;
	}

	public String getStParameterKey() { 
		if (node.hasProperty(_stParameterKey)) return (String) node.getProperty(_stParameterKey);
		return null;
	}

	public String getStParameterKey(String defaultValue) { 
		if (node.hasProperty(_stParameterKey)) return (String) node.getProperty(_stParameterKey);
		return defaultValue;
	}

	public boolean hasStParameterKey() { 
		return node.hasProperty(_stParameterKey);
	}

	public STArgumentKV removeStParameterKey() { 
		node.removeProperty(_stParameterKey);
		this.pcs.firePropertyChange("remove.stParameterKey", true, false);
		return this;
	}

	public STArgumentKV setValue(STValue dst) { 
		final org.neo4j.graphdb.Relationship relationship = getValueRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("value"));
		this.pcs.firePropertyChange("set.value", null, dst);
		return this;
	}

	public STValue getValue() { 
		final org.neo4j.graphdb.Relationship relationship = getValueRelation();
		return relationship == null ? null : new STValue(relationship.getOtherNode(node));
	}

	public STArgumentKV removeValue() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getValueRelation());
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		this.pcs.firePropertyChange("remove.value", true, false);
		return this;
	}

	public org.neo4j.graphdb.Relationship getValueRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("value"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public java.util.stream.Stream<STArgument> getIncomingKeyValues() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("keyValues")).spliterator(), false).map((relationship) -> new STArgument(relationship.getOtherNode(node)));
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
		final STValue _value = getValue();
		if (_value != null) jsonObject.put("value", _value.toJsonObject());

		return jsonObject;
	}

	public void deleteTree() {
		final STValue _value = getValue();
		if (_value != null) _value.deleteTree();

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