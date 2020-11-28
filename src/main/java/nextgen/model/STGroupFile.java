package nextgen.model;

public class STGroupFile {

	private final org.neo4j.graphdb.Node node;

	public STGroupFile(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STGroupFile other = (STGroupFile) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	private static final String _uuid = "uuid";

	public STGroupFile setUuid(String value) { 
		if (value == null) {
			removeUuid(); 
		} else {
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

	public STGroupFile removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}

	private static final String _packageName = "packageName";

	public STGroupFile setPackageName(String value) { 
		if (value == null) {
			removePackageName(); 
		} else {
		 	node.setProperty(_packageName, value);
		}
		return this;
	}

	public String getPackageName() { 
		if (node.hasProperty(_packageName)) return (String) node.getProperty(_packageName);
		return null;
	}

	public String getPackageName(String defaultValue) { 
		if (node.hasProperty(_packageName)) return (String) node.getProperty(_packageName);
		return defaultValue;
	}

	public boolean hasPackageName() { 
		return node.hasProperty(_packageName);
	}

	public STGroupFile removePackageName() { 
		node.removeProperty(_packageName);
		return this;
	}

	private static final String _path = "path";

	public STGroupFile setPath(String value) { 
		if (value == null) {
			removePath(); 
		} else {
		 	node.setProperty(_path, value);
		}
		return this;
	}

	public String getPath() { 
		if (node.hasProperty(_path)) return (String) node.getProperty(_path);
		return null;
	}

	public String getPath(String defaultValue) { 
		if (node.hasProperty(_path)) return (String) node.getProperty(_path);
		return defaultValue;
	}

	public boolean hasPath() { 
		return node.hasProperty(_path);
	}

	public STGroupFile removePath() { 
		node.removeProperty(_path);
		return this;
	}

	public java.util.stream.Stream<STGroupModel> getIncomingFilesSTGroupModel() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("files")).spliterator(), false).map((relationship) -> new STGroupModel(relationship.getOtherNode(node)));
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
		return jsonObject;
	}

	public void delete() {
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();

	}

}