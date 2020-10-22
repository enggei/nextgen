package nextgen.st.canvas.layout;

public class Layout {

	private final org.neo4j.graphdb.Node node;

	public Layout(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Layout other = (Layout) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	private static final String _uuid = "uuid";

	public Layout setUuid(String value) { 
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

	public Layout removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}

	private static final String _name = "name";

	public Layout setName(String value) { 
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

	public Layout removeName() { 
		node.removeProperty(_name);
		return this;
	}

	private static final org.neo4j.graphdb.RelationshipType _nodes = org.neo4j.graphdb.RelationshipType.withName("nodes");

	public Layout addNodes(LayoutNode dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _nodes).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _nodes);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<LayoutNode> getNodes() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _nodes).spliterator(), false).map((relationship) -> new LayoutNode(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<LayoutNode> getNodesSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _nodes).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> new LayoutNode(relationship.getOtherNode(node)));
	}

	public Layout removeNodes(LayoutNode dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _nodes).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public Layout removeAllNodes() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _nodes).forEach(org.neo4j.graphdb.Relationship::delete);
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
		final io.vertx.core.json.JsonArray _nodes = new io.vertx.core.json.JsonArray();
		getNodes().forEach(element -> _nodes.add(element.toJsonObject()));
		if (!_nodes.isEmpty()) jsonObject.put("nodes", _nodes);

		return jsonObject;
	}

	public void delete() {

		final String uuid = node.hasProperty("uuid") ? node.getProperty("uuid").toString() : null;

		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();

	}

}