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

	private static final String _uuid = "uuid";

	public STFile setUuid(String value) { 
		if (value == null) 
			removeUuid(); 
		else {
		 	node.setProperty(_uuid, value);
		 	nextgen.events.STFileUpdated.post(this);
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

	public STFile removeUuid() { 
		node.removeProperty(_uuid);
		nextgen.events.STFileUpdated.post(this);
		return this;
	}

	public STFile setName(STValue dst) { 
		final org.neo4j.graphdb.Relationship relationship = getNameRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("name"));
		nextgen.events.STFileUpdated.post(this);
		return this;
	}

	public STValue getName() { 
		final org.neo4j.graphdb.Relationship relationship = getNameRelation();
		return relationship == null ? null : new STValue(relationship.getOtherNode(node));
	}

	public STFile removeName() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getNameRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
			nextgen.events.STFileUpdated.post(this);
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getNameRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("name"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public STFile setType(STValue dst) { 
		final org.neo4j.graphdb.Relationship relationship = getTypeRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("type"));
		nextgen.events.STFileUpdated.post(this);
		return this;
	}

	public STValue getType() { 
		final org.neo4j.graphdb.Relationship relationship = getTypeRelation();
		return relationship == null ? null : new STValue(relationship.getOtherNode(node));
	}

	public STFile removeType() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getTypeRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
			nextgen.events.STFileUpdated.post(this);
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getTypeRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("type"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public STFile setPackageName(STValue dst) { 
		final org.neo4j.graphdb.Relationship relationship = getPackageNameRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("packageName"));
		nextgen.events.STFileUpdated.post(this);
		return this;
	}

	public STValue getPackageName() { 
		final org.neo4j.graphdb.Relationship relationship = getPackageNameRelation();
		return relationship == null ? null : new STValue(relationship.getOtherNode(node));
	}

	public STFile removePackageName() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getPackageNameRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
			nextgen.events.STFileUpdated.post(this);
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getPackageNameRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("packageName"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public STFile setPath(STValue dst) { 
		final org.neo4j.graphdb.Relationship relationship = getPathRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("path"));
		nextgen.events.STFileUpdated.post(this);
		return this;
	}

	public STValue getPath() { 
		final org.neo4j.graphdb.Relationship relationship = getPathRelation();
		return relationship == null ? null : new STValue(relationship.getOtherNode(node));
	}

	public STFile removePath() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getPathRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
			nextgen.events.STFileUpdated.post(this);
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getPathRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("path"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public java.util.stream.Stream<STModel> getIncomingFilesSTModel() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("files")).spliterator(), false).map((relationship) -> new STModel(relationship.getOtherNode(node)));
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
		final STValue _name = getName();
		if (_name != null) jsonObject.put("name", _name.toJsonObject());

		final STValue _type = getType();
		if (_type != null) jsonObject.put("type", _type.toJsonObject());

		final STValue _packageName = getPackageName();
		if (_packageName != null) jsonObject.put("packageName", _packageName.toJsonObject());

		final STValue _path = getPath();
		if (_path != null) jsonObject.put("path", _path.toJsonObject());

		return jsonObject;
	}

	public void delete() {

		final String uuid = node.hasProperty("uuid") ? node.getProperty("uuid").toString() : null;

		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();

		nextgen.events.STFileDeleted.post(uuid);
	}

}