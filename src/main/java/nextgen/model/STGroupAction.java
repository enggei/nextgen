package nextgen.model;

public class STGroupAction {

	private final org.neo4j.graphdb.Node node;

	public STGroupAction(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STGroupAction other = (STGroupAction) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	private static final String _uuid = "uuid";

	public STGroupAction setUuid(String value) { 
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

	public STGroupAction removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}

	private static final String _name = "name";

	public STGroupAction setName(String value) { 
		if (value == null) 
			removeName(); 
		else {
		 	node.setProperty(_name, value);
		}
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

	public STGroupAction removeName() { 
		node.removeProperty(_name);
		return this;
	}

	private static final String _crc = "crc";

	public STGroupAction setCrc(String value) { 
		if (value == null) 
			removeCrc(); 
		else {
		 	node.setProperty(_crc, value);
		}
		return this;
	}

	public String getCrc() { 
		if (node.hasProperty(_crc)) return (String) node.getProperty(_crc);
		return null;
	}

	public String getCrc(String defaultValue) { 
		if (node.hasProperty(_crc)) return (String) node.getProperty(_crc);
		return defaultValue;
	}

	public boolean hasCrc() { 
		return node.hasProperty(_crc);
	}

	public STGroupAction removeCrc() { 
		node.removeProperty(_crc);
		return this;
	}

	private static final String _statements = "statements";

	public STGroupAction setStatements(String value) { 
		if (value == null) 
			removeStatements(); 
		else {
		 	node.setProperty(_statements, value);
		}
		return this;
	}

	public String getStatements() { 
		if (node.hasProperty(_statements)) return (String) node.getProperty(_statements);
		return null;
	}

	public String getStatements(String defaultValue) { 
		if (node.hasProperty(_statements)) return (String) node.getProperty(_statements);
		return defaultValue;
	}

	public boolean hasStatements() { 
		return node.hasProperty(_statements);
	}

	public STGroupAction removeStatements() { 
		node.removeProperty(_statements);
		return this;
	}

	private static final String _methods = "methods";

	public STGroupAction setMethods(String value) { 
		if (value == null) 
			removeMethods(); 
		else {
		 	node.setProperty(_methods, value);
		}
		return this;
	}

	public String getMethods() { 
		if (node.hasProperty(_methods)) return (String) node.getProperty(_methods);
		return null;
	}

	public String getMethods(String defaultValue) { 
		if (node.hasProperty(_methods)) return (String) node.getProperty(_methods);
		return defaultValue;
	}

	public boolean hasMethods() { 
		return node.hasProperty(_methods);
	}

	public STGroupAction removeMethods() { 
		node.removeProperty(_methods);
		return this;
	}

	public java.util.stream.Stream<STGroupModel> getIncomingActionsSTGroupModel() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("actions")).spliterator(), false).map((relationship) -> new STGroupModel(relationship.getOtherNode(node)));
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