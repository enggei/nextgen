package nextgen.model;

public class STGroupFile {

	private final org.neo4j.graphdb.Node node;
	private final String uuid;

	public STGroupFile(org.neo4j.graphdb.Node node) { 
		this.node = node;
		if (!node.hasProperty("uuid")) this.node.setProperty("uuid", this.uuid = java.util.UUID.randomUUID().toString());
		else this.uuid = node.getProperty("uuid").toString();}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}


	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STGroupFile other = (STGroupFile) o;
		return uuid.equals(other.uuid);
	}

	@Override
	public int hashCode() { 
		return uuid.hashCode();
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
	public java.util.stream.Stream<STGroupModel> getIncomingFilesSTGroupModel() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("files")).spliterator(), false).map((relationship) -> new STGroupModel(relationship.getOtherNode(node)));
	}  

	public STGroupFile setPackageName(STValue dst) { 
		final org.neo4j.graphdb.Relationship relationship = getPackageNameRelation();
		if (relationship != null)  { 
			if (dst != null && relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("packageName"));
		return this;
	}

	public STValue getPackageName() { 
		final org.neo4j.graphdb.Relationship relationship = getPackageNameRelation();
		return relationship == null ? null : new STValue(relationship.getOtherNode(node));
	}

	public STGroupFile removePackageName() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getPackageNameRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getPackageNameRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("packageName"), org.neo4j.graphdb.Direction.OUTGOING);
	}  

	public STGroupFile setPath(STValue dst) { 
		final org.neo4j.graphdb.Relationship relationship = getPathRelation();
		if (relationship != null)  { 
			if (dst != null && relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("path"));
		return this;
	}

	public STValue getPath() { 
		final org.neo4j.graphdb.Relationship relationship = getPathRelation();
		return relationship == null ? null : new STValue(relationship.getOtherNode(node));
	}

	public STGroupFile removePath() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getPathRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getPathRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("path"), org.neo4j.graphdb.Direction.OUTGOING);
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

	public void delete() {
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();	
	}


} 