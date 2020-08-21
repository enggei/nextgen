package nextgen.domains.meta;

public class RelationVisitorMethod {

	private final org.neo4j.graphdb.Node node;

	public RelationVisitorMethod(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final RelationVisitorMethod other = (RelationVisitorMethod) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	private static final String _uuid = "uuid";

	public RelationVisitorMethod setUuid(String value) { 
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

	public RelationVisitorMethod removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}

	public RelationVisitorMethod set_meta(MetaRelation dst) { 
		final org.neo4j.graphdb.Relationship relationship = get_metaRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("_meta"));
		return this;
	}

	public MetaRelation get_meta() { 
		final org.neo4j.graphdb.Relationship relationship = get_metaRelation();
		return relationship == null ? null : new MetaRelation(relationship.getOtherNode(node));
	}

	public RelationVisitorMethod remove_meta() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(get_metaRelation());
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public org.neo4j.graphdb.Relationship get_metaRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("_meta"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	private static final String _statements = "statements";

	public RelationVisitorMethod setStatements(String value) { 
		if (value == null) node.removeProperty(_statements); 
		else node.setProperty(_statements, value);
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

	public RelationVisitorMethod removeStatements() { 
		node.removeProperty(_statements);
		return this;
	}

	public java.util.stream.Stream<DomainVisitor> getIncomingRelationVisitorsDomainVisitor() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("relationVisitors")).spliterator(), false).map((relationship) -> new DomainVisitor(relationship.getOtherNode(node)));
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
		if (node.hasProperty("statements")) jsonObject.put("statements", node.getProperty("statements"));
		final MetaRelation __meta = get_meta();
		if (__meta != null) jsonObject.put("_meta", __meta.toJsonObject());

		return jsonObject;
	}

	public void delete() {
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();
	}

}