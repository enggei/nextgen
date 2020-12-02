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

	public STGroupAction removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}

	private static final String _name = "name";

	public STGroupAction setName(String value) { 
		if (value == null) {
			removeName(); 
		} else {
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

	public STGroupAction setStatements(STValue dst) { 
		final org.neo4j.graphdb.Relationship relationship = getStatementsRelation();
		if (relationship != null)  { 
			if (dst != null && relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("statements"));
		return this;
	}

	public STValue getStatements() { 
		final org.neo4j.graphdb.Relationship relationship = getStatementsRelation();
		return relationship == null ? null : new STValue(relationship.getOtherNode(node));
	}

	public STGroupAction removeStatements() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getStatementsRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getStatementsRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("statements"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public STGroupAction setImports(STValue dst) { 
		final org.neo4j.graphdb.Relationship relationship = getImportsRelation();
		if (relationship != null)  { 
			if (dst != null && relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("imports"));
		return this;
	}

	public STValue getImports() { 
		final org.neo4j.graphdb.Relationship relationship = getImportsRelation();
		return relationship == null ? null : new STValue(relationship.getOtherNode(node));
	}

	public STGroupAction removeImports() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getImportsRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getImportsRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("imports"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public STGroupAction setMethods(STValue dst) { 
		final org.neo4j.graphdb.Relationship relationship = getMethodsRelation();
		if (relationship != null)  { 
			if (dst != null && relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("methods"));
		return this;
	}

	public STValue getMethods() { 
		final org.neo4j.graphdb.Relationship relationship = getMethodsRelation();
		return relationship == null ? null : new STValue(relationship.getOtherNode(node));
	}

	public STGroupAction removeMethods() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getMethodsRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getMethodsRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("methods"), org.neo4j.graphdb.Direction.OUTGOING);
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
		final STValue _statements = getStatements();
		if (_statements != null) jsonObject.put("statements", _statements.toJsonObject());

		final STValue _imports = getImports();
		if (_imports != null) jsonObject.put("imports", _imports.toJsonObject());

		final STValue _methods = getMethods();
		if (_methods != null) jsonObject.put("methods", _methods.toJsonObject());

		return jsonObject;
	}

	public void delete() {
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();

	}

}