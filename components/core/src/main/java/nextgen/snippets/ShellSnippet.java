package nextgen.snippets;

public class ShellSnippet {

	private final org.neo4j.graphdb.Node node;

	public ShellSnippet(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ShellSnippet other = (ShellSnippet) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	private static final String _id = "id";

	public ShellSnippet setId(String value) { 
		if (value == null) node.removeProperty(_id); 
		else node.setProperty(_id, value);
		return this;
	}

	public String getId() { 
		if (node.hasProperty(_id)) return (String) node.getProperty(_id);
		return null;
	}

	public String getId(String defaultValue) { 
		if (node.hasProperty(_id)) return (String) node.getProperty(_id);
		return defaultValue;
	}

	public boolean hasId() { 
		return node.hasProperty(_id);
	}

	public ShellSnippet removeId() { 
		node.removeProperty(_id);
		return this;
	}

	private static final String _source = "source";

	public ShellSnippet setSource(String value) { 
		if (value == null) node.removeProperty(_source); 
		else node.setProperty(_source, value);
		return this;
	}

	public String getSource() { 
		if (node.hasProperty(_source)) return (String) node.getProperty(_source);
		return null;
	}

	public String getSource(String defaultValue) { 
		if (node.hasProperty(_source)) return (String) node.getProperty(_source);
		return defaultValue;
	}

	public boolean hasSource() { 
		return node.hasProperty(_source);
	}

	public ShellSnippet removeSource() { 
		node.removeProperty(_source);
		return this;
	}

	public java.util.stream.Stream<ShellScript> getIncomingSnippetsShellScript() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("snippets")).spliterator(), false).map((relationship) -> new ShellScript(relationship.getOtherNode(node)));
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
		if (node.hasProperty("id")) jsonObject.put("id", node.getProperty("id"));
		if (node.hasProperty("source")) jsonObject.put("source", node.getProperty("source"));
		return jsonObject;
	}

	public void delete() {
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();
	}

}