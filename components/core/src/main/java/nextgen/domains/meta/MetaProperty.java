package nextgen.domains.meta;

public class MetaProperty {

	private final org.neo4j.graphdb.Node node;

	public MetaProperty(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final MetaProperty other = (MetaProperty) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	private static final String _uuid = "uuid";

	public MetaProperty setUuid(String value) { 
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

	public MetaProperty removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}

	private static final String _name = "name";

	public MetaProperty setName(String value) { 
		if (value == null) node.removeProperty(_name); 
		else node.setProperty(_name, value);
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

	public MetaProperty removeName() { 
		node.removeProperty(_name);
		return this;
	}

	private static final String _type = "type";

	public MetaProperty setType(String value) { 
		if (value == null) node.removeProperty(_type); 
		else node.setProperty(_type, value);
		return this;
	}

	public String getType() { 
		if (node.hasProperty(_type)) return (String) node.getProperty(_type);
		return null;
	}

	public String getType(String defaultValue) { 
		if (node.hasProperty(_type)) return (String) node.getProperty(_type);
		return defaultValue;
	}

	public boolean hasType() { 
		return node.hasProperty(_type);
	}

	public MetaProperty removeType() { 
		node.removeProperty(_type);
		return this;
	}

	private static final String _defaultValue = "defaultValue";

	public MetaProperty setDefaultValue(String value) { 
		if (value == null) node.removeProperty(_defaultValue); 
		else node.setProperty(_defaultValue, value);
		return this;
	}

	public String getDefaultValue() { 
		if (node.hasProperty(_defaultValue)) return (String) node.getProperty(_defaultValue);
		return null;
	}

	public String getDefaultValue(String defaultValue) { 
		if (node.hasProperty(_defaultValue)) return (String) node.getProperty(_defaultValue);
		return defaultValue;
	}

	public boolean hasDefaultValue() { 
		return node.hasProperty(_defaultValue);
	}

	public MetaProperty removeDefaultValue() { 
		node.removeProperty(_defaultValue);
		return this;
	}

	public java.util.stream.Stream<MetaDomain> getIncomingPropertiesMetaDomain() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("properties")).spliterator(), false).map((relationship) -> new MetaDomain(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<MetaEntity> getIncomingPropertiesMetaEntity() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("properties")).spliterator(), false).map((relationship) -> new MetaEntity(relationship.getOtherNode(node)));
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
		if (node.hasProperty("name")) jsonObject.put("name", node.getProperty("name"));
		if (node.hasProperty("type")) jsonObject.put("type", node.getProperty("type"));
		if (node.hasProperty("defaultValue")) jsonObject.put("defaultValue", node.getProperty("defaultValue"));
		return jsonObject;
	}

	public void delete() {
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();
	}

}