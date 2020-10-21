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

	private static final String _uuid = "uuid";

	public STModel setUuid(String value) { 
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

	public STModel removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}

	private static final String _stTemplate = "stTemplate";

	public STModel setStTemplate(String value) { 
		if (value == null) 
			removeStTemplate(); 
		else {
		 	node.setProperty(_stTemplate, value);
		}
		return this;
	}

	public String getStTemplate() { 
		if (node.hasProperty(_stTemplate)) return (String) node.getProperty(_stTemplate);
		return null;
	}

	public String getStTemplate(String defaultValue) { 
		if (node.hasProperty(_stTemplate)) return (String) node.getProperty(_stTemplate);
		return defaultValue;
	}

	public boolean hasStTemplate() { 
		return node.hasProperty(_stTemplate);
	}

	public STModel removeStTemplate() { 
		node.removeProperty(_stTemplate);
		return this;
	}

	private static final String _stGroup = "stGroup";

	public STModel setStGroup(String value) { 
		if (value == null) 
			removeStGroup(); 
		else {
		 	node.setProperty(_stGroup, value);
		}
		return this;
	}

	public String getStGroup() { 
		if (node.hasProperty(_stGroup)) return (String) node.getProperty(_stGroup);
		return null;
	}

	public String getStGroup(String defaultValue) { 
		if (node.hasProperty(_stGroup)) return (String) node.getProperty(_stGroup);
		return defaultValue;
	}

	public boolean hasStGroup() { 
		return node.hasProperty(_stGroup);
	}

	public STModel removeStGroup() { 
		node.removeProperty(_stGroup);
		return this;
	}

	private static final org.neo4j.graphdb.RelationshipType _files = org.neo4j.graphdb.RelationshipType.withName("files");

	public STModel addFiles(STFile dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _files).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _files);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STFile> getFiles() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _files).spliterator(), false).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STFile> getFilesSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _files).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}

	public STModel removeFiles(STFile dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _files).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public STModel removeAllFiles() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _files).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public java.util.stream.Stream<STValue> getIncomingStModelSTValue() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("stModel")).spliterator(), false).map((relationship) -> new STValue(relationship.getOtherNode(node)));
	}

	private static final org.neo4j.graphdb.RelationshipType _arguments = org.neo4j.graphdb.RelationshipType.withName("arguments");

	public STModel addArguments(STArgument dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _arguments).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _arguments);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STArgument> getArguments() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _arguments).spliterator(), false).map((relationship) -> new STArgument(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STArgument> getArgumentsSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _arguments).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> new STArgument(relationship.getOtherNode(node)));
	}

	public STModel removeArguments(STArgument dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _arguments).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public STModel removeAllArguments() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _arguments).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public java.util.stream.Stream<STProject> getIncomingModelsSTProject() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("models")).spliterator(), false).map((relationship) -> new STProject(relationship.getOtherNode(node)));
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
		if (node.hasProperty("stTemplate")) jsonObject.put("stTemplate", node.getProperty("stTemplate"));
		if (node.hasProperty("stGroup")) jsonObject.put("stGroup", node.getProperty("stGroup"));
		final io.vertx.core.json.JsonArray _files = new io.vertx.core.json.JsonArray();
		getFiles().forEach(element -> _files.add(element.toJsonObject()));
		if (!_files.isEmpty()) jsonObject.put("files", _files);

		final io.vertx.core.json.JsonArray _arguments = new io.vertx.core.json.JsonArray();
		getArguments().forEach(element -> _arguments.add(element.toJsonObject()));
		if (!_arguments.isEmpty()) jsonObject.put("arguments", _arguments);

		return jsonObject;
	}

	public void delete() {

		final String uuid = node.hasProperty("uuid") ? node.getProperty("uuid").toString() : null;

		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();

	}

}