package nextgen.st.canvas.layout;

public class LayoutNode {

	private final org.neo4j.graphdb.Node node;

	public LayoutNode(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final LayoutNode other = (LayoutNode) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	public LayoutNode setUuid(String value) { 
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

	public LayoutNode removeUuid() { 
		node.removeProperty("uuid");
		return this;
	}

	public LayoutNode setX(Double value) { 
		if (value == null) node.removeProperty("x"); 
		else node.setProperty("x", value);
		return this;
	}

	public Double getX() { 
		if (node.hasProperty("x")) return (Double) node.getProperty("x");
		return null;
	}

	public Double getX(Double defaultValue) { 
		if (node.hasProperty("x")) return (Double) node.getProperty("x");
		return defaultValue;
	}

	public boolean hasX() { 
		return node.hasProperty("x");
	}

	public LayoutNode removeX() { 
		node.removeProperty("x");
		return this;
	}

	public LayoutNode setY(Double value) { 
		if (value == null) node.removeProperty("y"); 
		else node.setProperty("y", value);
		return this;
	}

	public Double getY() { 
		if (node.hasProperty("y")) return (Double) node.getProperty("y");
		return null;
	}

	public Double getY(Double defaultValue) { 
		if (node.hasProperty("y")) return (Double) node.getProperty("y");
		return defaultValue;
	}

	public boolean hasY() { 
		return node.hasProperty("y");
	}

	public LayoutNode removeY() { 
		node.removeProperty("y");
		return this;
	}

	public java.util.stream.Stream<Layout> getIncomingNodes() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("nodes")).spliterator(), false).map((relationship) -> new Layout(relationship.getOtherNode(node)));
	}

	@Override
	public String toString() {
		return "";
	}

	public io.vertx.core.json.JsonObject toJsonObject() {
		io.vertx.core.json.JsonObject jsonObject = new io.vertx.core.json.JsonObject();
		if (node.hasProperty("uuid")) jsonObject.put("uuid", node.getProperty("uuid"));
		if (node.hasProperty("uuid")) jsonObject.put("uuid", node.getProperty("uuid"));
		if (node.hasProperty("x")) jsonObject.put("x", node.getProperty("x"));
		if (node.hasProperty("y")) jsonObject.put("y", node.getProperty("y"));
		return jsonObject;
	}

	public void deleteTree() {
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();
	}
}