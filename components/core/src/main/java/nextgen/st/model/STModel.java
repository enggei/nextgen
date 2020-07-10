package nextgen.st.model;

public class STModel {

	private final org.neo4j.graphdb.Node node;

	public STModel(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STModel other = (STModel) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	public STModel setUuid(String value) { 
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

	public STModel removeUuid() { 
		node.removeProperty("uuid");
		return this;
	}

	public STModel setStTemplate(String value) { 
		if (value == null) node.removeProperty("stTemplate"); 
		else node.setProperty("stTemplate", value);
		return this;
	}

	public String getStTemplate() { 
		if (node.hasProperty("stTemplate")) return (String) node.getProperty("stTemplate");
		return null;
	}

	public String getStTemplate(String defaultValue) { 
		if (node.hasProperty("stTemplate")) return (String) node.getProperty("stTemplate");
		return defaultValue;
	}

	public boolean hasStTemplate() { 
		return node.hasProperty("stTemplate");
	}

	public STModel removeStTemplate() { 
		node.removeProperty("stTemplate");
		return this;
	}

	public STModel addFiles(STFile dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("files")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("files"));
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STFile> getFiles() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("files")).spliterator(), false).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STFile> getFilesSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("files")).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t", o.getId()))).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}

	public STModel removeFiles(STFile dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("files")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public STModel removeAllFiles() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("files")).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public java.util.stream.Stream<STFile> getIncomingFiles() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("files")).spliterator(), false).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}

	public STModel addArguments(STArgument dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("arguments")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("arguments"));
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STArgument> getArguments() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("arguments")).spliterator(), false).map((relationship) -> new STArgument(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STArgument> getArgumentsSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("arguments")).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t", o.getId()))).map((relationship) -> new STArgument(relationship.getOtherNode(node)));
	}

	public STModel removeArguments(STArgument dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("arguments")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public STModel removeAllArguments() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("arguments")).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public java.util.stream.Stream<STArgument> getIncomingArguments() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("arguments")).spliterator(), false).map((relationship) -> new STArgument(relationship.getOtherNode(node)));
	}

	@Override
	public String toString() {
		return "";
	}

	public io.vertx.core.json.JsonObject toJsonObject() {
		io.vertx.core.json.JsonObject jsonObject = new io.vertx.core.json.JsonObject();
		if (node.hasProperty("uuid")) jsonObject.put("uuid", node.getProperty("uuid"));
		if (node.hasProperty("uuid")) jsonObject.put("uuid", node.getProperty("uuid"));
		if (node.hasProperty("stTemplate")) jsonObject.put("stTemplate", node.getProperty("stTemplate"));
		final io.vertx.core.json.JsonArray _files = new io.vertx.core.json.JsonArray();
		getFiles().forEach(element -> _files.add(element.toJsonObject()));
		if (!_files.isEmpty()) jsonObject.put("files", _files);

		final io.vertx.core.json.JsonArray _arguments = new io.vertx.core.json.JsonArray();
		getArguments().forEach(element -> _arguments.add(element.toJsonObject()));
		if (!_arguments.isEmpty()) jsonObject.put("arguments", _arguments);

		return jsonObject;
	}

	public void deleteTree() {
		getFiles().forEach(element -> element.deleteTree());

		getArguments().forEach(element -> element.deleteTree());

		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();
	}
}