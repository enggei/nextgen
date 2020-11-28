package nextgen.workflow;

public class ConditionalFlow {

	private final org.neo4j.graphdb.Node node;

	public ConditionalFlow(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ConditionalFlow other = (ConditionalFlow) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	private static final String _uuid = "uuid";

	public ConditionalFlow setUuid(String value) { 
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

	public ConditionalFlow removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}

	private static final String _name = "name";

	public ConditionalFlow setName(String value) { 
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

	public ConditionalFlow removeName() { 
		node.removeProperty(_name);
		return this;
	}

	public ConditionalFlow setExecute(WorkInstance dst) { 
		final org.neo4j.graphdb.Relationship relationship = getExecuteRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("execute"));
		return this;
	}

	public WorkInstance getExecute() { 
		final org.neo4j.graphdb.Relationship relationship = getExecuteRelation();
		return relationship == null ? null : new WorkInstance(relationship.getOtherNode(node));
	}

	public ConditionalFlow removeExecute() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getExecuteRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getExecuteRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("execute"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public ConditionalFlow setThen(WorkInstance dst) { 
		final org.neo4j.graphdb.Relationship relationship = getThenRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("then"));
		return this;
	}

	public WorkInstance getThen() { 
		final org.neo4j.graphdb.Relationship relationship = getThenRelation();
		return relationship == null ? null : new WorkInstance(relationship.getOtherNode(node));
	}

	public ConditionalFlow removeThen() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getThenRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getThenRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("then"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public ConditionalFlow setOtherwise(WorkInstance dst) { 
		final org.neo4j.graphdb.Relationship relationship = getOtherwiseRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("otherwise"));
		return this;
	}

	public WorkInstance getOtherwise() { 
		final org.neo4j.graphdb.Relationship relationship = getOtherwiseRelation();
		return relationship == null ? null : new WorkInstance(relationship.getOtherNode(node));
	}

	public ConditionalFlow removeOtherwise() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getOtherwiseRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getOtherwiseRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("otherwise"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public java.util.stream.Stream<WorkInstance> getIncomingConditionalWorkInstance() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("conditional")).spliterator(), false).map((relationship) -> new WorkInstance(relationship.getOtherNode(node)));
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
		final WorkInstance _execute = getExecute();
		if (_execute != null) jsonObject.put("execute", _execute.toJsonObject());

		final WorkInstance _then = getThen();
		if (_then != null) jsonObject.put("then", _then.toJsonObject());

		final WorkInstance _otherwise = getOtherwise();
		if (_otherwise != null) jsonObject.put("otherwise", _otherwise.toJsonObject());

		return jsonObject;
	}

	public void delete() {

		final String uuid = node.hasProperty("uuid") ? node.getProperty("uuid").toString() : null;

		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();

	}

}