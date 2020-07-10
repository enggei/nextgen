package nextgen.st.model;

public class STFile {

	private final org.neo4j.graphdb.Node node;

	public STFile(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STFile other = (STFile) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	public STFile setUuid(String value) { 
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

	public STFile removeUuid() { 
		node.removeProperty("uuid");
		return this;
	}

	public STFile setName(String value) { 
		if (value == null) node.removeProperty("name"); 
		else node.setProperty("name", value);
		return this;
	}

	public String getName() { 
		if (node.hasProperty("name")) return (String) node.getProperty("name");
		return null;
	}

	public String getName(String defaultValue) { 
		if (node.hasProperty("name")) return (String) node.getProperty("name");
		return defaultValue;
	}

	public boolean hasName() { 
		return node.hasProperty("name");
	}

	public STFile removeName() { 
		node.removeProperty("name");
		return this;
	}

	public STFile setType(String value) { 
		if (value == null) node.removeProperty("type"); 
		else node.setProperty("type", value);
		return this;
	}

	public String getType() { 
		if (node.hasProperty("type")) return (String) node.getProperty("type");
		return null;
	}

	public String getType(String defaultValue) { 
		if (node.hasProperty("type")) return (String) node.getProperty("type");
		return defaultValue;
	}

	public boolean hasType() { 
		return node.hasProperty("type");
	}

	public STFile removeType() { 
		node.removeProperty("type");
		return this;
	}

	public STFile setPackageName(String value) { 
		if (value == null) node.removeProperty("packageName"); 
		else node.setProperty("packageName", value);
		return this;
	}

	public String getPackageName() { 
		if (node.hasProperty("packageName")) return (String) node.getProperty("packageName");
		return null;
	}

	public String getPackageName(String defaultValue) { 
		if (node.hasProperty("packageName")) return (String) node.getProperty("packageName");
		return defaultValue;
	}

	public boolean hasPackageName() { 
		return node.hasProperty("packageName");
	}

	public STFile removePackageName() { 
		node.removeProperty("packageName");
		return this;
	}

	public STFile setPath(String value) { 
		if (value == null) node.removeProperty("path"); 
		else node.setProperty("path", value);
		return this;
	}

	public String getPath() { 
		if (node.hasProperty("path")) return (String) node.getProperty("path");
		return null;
	}

	public String getPath(String defaultValue) { 
		if (node.hasProperty("path")) return (String) node.getProperty("path");
		return defaultValue;
	}

	public boolean hasPath() { 
		return node.hasProperty("path");
	}

	public STFile removePath() { 
		node.removeProperty("path");
		return this;
	}

	public java.util.stream.Stream<STModel> getIncomingFiles() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("files")).spliterator(), false).map((relationship) -> new STModel(relationship.getOtherNode(node)));
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
		if (node.hasProperty("type")) jsonObject.put("type", node.getProperty("type"));
		if (node.hasProperty("packageName")) jsonObject.put("packageName", node.getProperty("packageName"));
		if (node.hasProperty("path")) jsonObject.put("path", node.getProperty("path"));
		return jsonObject;
	}

	public void deleteTree() {
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();
	}
}