package nextgen.st.model;

public class Script {

	private final java.beans.PropertyChangeSupport pcs = new java.beans.PropertyChangeSupport(this);
	private final org.neo4j.graphdb.Node node;

	public Script(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Script other = (Script) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	private static final String _uuid = "uuid";

	public Script setUuid(String value) { 
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

	public Script removeUuid() { 
		node.removeProperty(_uuid);
		this.pcs.firePropertyChange("remove.uuid", true, false);
		return this;
	}

	private static final String _name = "name";

	public Script setName(String value) { 
		if (value == null) node.removeProperty(_name); 
		else node.setProperty(_name, value);
		this.pcs.firePropertyChange("set.name", null, value);
		return this;
	}

	public String getName() { 
		if (node.hasProperty(_name)) return (String) node.getProperty(_name);
		return null;
	}

	public String getName(String defaultValue) { 
		if (node.hasProperty(_name)) return (String) node.getProperty(_name);
		return defaultValue;
	}

	public boolean hasName() { 
		return node.hasProperty(_name);
	}

	public Script removeName() { 
		node.removeProperty(_name);
		this.pcs.firePropertyChange("remove.name", true, false);
		return this;
	}

	public Script setScript(STValue dst) { 
		final org.neo4j.graphdb.Relationship relationship = getScriptRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("script"));
		this.pcs.firePropertyChange("set.script", null, dst);
		return this;
	}

	public STValue getScript() { 
		final org.neo4j.graphdb.Relationship relationship = getScriptRelation();
		return relationship == null ? null : new STValue(relationship.getOtherNode(node));
	}

	public Script removeScript() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getScriptRelation());
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		this.pcs.firePropertyChange("remove.script", true, false);
		return this;
	}

	public org.neo4j.graphdb.Relationship getScriptRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("script"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	@Override
	public String toString() {
		return "";
	}

	public io.vertx.core.json.JsonObject toJsonObject() {
		io.vertx.core.json.JsonObject jsonObject = new io.vertx.core.json.JsonObject();
		if (node.hasProperty("uuid")) jsonObject.put("uuid", node.getProperty("uuid"));
		if (node.hasProperty("uuid")) jsonObject.put("uuid", node.getProperty("uuid"));
		if (node.hasProperty("name")) jsonObject.put("name", node.getProperty("name"));
		final STValue _script = getScript();
		if (_script != null) jsonObject.put("script", _script.toJsonObject());

		return jsonObject;
	}

	public void deleteTree() {
		final STValue _script = getScript();
		if (_script != null) _script.deleteTree();

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