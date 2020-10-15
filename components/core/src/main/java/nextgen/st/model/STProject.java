package nextgen.st.model;

public class STProject {

	private final org.neo4j.graphdb.Node node;

	public STProject(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STProject other = (STProject) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	private static final String _uuid = "uuid";

	public STProject setUuid(String value) { 
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

	public STProject removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}

	private static final String _name = "name";

	public STProject setName(String value) { 
		if (value == null) node.removeProperty(_name); 
		else node.setProperty(_name, value);
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

	public STProject removeName() { 
		node.removeProperty(_name);
		return this;
	}

	private static final org.neo4j.graphdb.RelationshipType _models = org.neo4j.graphdb.RelationshipType.withName("models");

	public STProject addModels(STModel dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _models).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _models);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STModel> getModels() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _models).spliterator(), false).map((relationship) -> new STModel(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STModel> getModelsSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _models).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> new STModel(relationship.getOtherNode(node)));
	}

	public STProject removeModels(STModel dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _models).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public STProject removeAllModels() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _models).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	private static final org.neo4j.graphdb.RelationshipType _values = org.neo4j.graphdb.RelationshipType.withName("values");

	public STProject addValues(STValue dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _values).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _values);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STValue> getValues() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _values).spliterator(), false).map((relationship) -> new STValue(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STValue> getValuesSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _values).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> new STValue(relationship.getOtherNode(node)));
	}

	public STProject removeValues(STValue dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _values).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public STProject removeAllValues() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _values).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
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
		final io.vertx.core.json.JsonArray _models = new io.vertx.core.json.JsonArray();
		getModels().forEach(element -> _models.add(element.toJsonObject()));
		if (!_models.isEmpty()) jsonObject.put("models", _models);

		final io.vertx.core.json.JsonArray _values = new io.vertx.core.json.JsonArray();
		getValues().forEach(element -> _values.add(element.toJsonObject()));
		if (!_values.isEmpty()) jsonObject.put("values", _values);

		return jsonObject;
	}

	public void delete() {
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();
	}

}