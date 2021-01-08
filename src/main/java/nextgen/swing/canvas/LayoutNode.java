package nextgen.swing.canvas;

public class LayoutNode {

	private final org.neo4j.graphdb.Node node;
	private final String uuid;

	public LayoutNode(org.neo4j.graphdb.Node node) { 
		this.node = node;
		if (!node.hasProperty("uuid")) this.node.setProperty("uuid", this.uuid = java.util.UUID.randomUUID().toString());
		else this.uuid = node.getProperty("uuid").toString();
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}


	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final LayoutNode other = (LayoutNode) o;
		return uuid.equals(other.uuid);
	}

	@Override
	public int hashCode() { 
		return uuid.hashCode();
	}

	private static final String _uuid = "uuid";

	public LayoutNode setUuid(String value) { 
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

	public LayoutNode removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}
	private static final String _x = "x";

	public LayoutNode setX(Double value) { 
		if (value == null) {
			removeX(); 
		} else {
		 	node.setProperty(_x, value);
		}
		return this;
	}

	public Double getX() { 
		if (node.hasProperty(_x)) return (Double) node.getProperty(_x);
		return null;
	}

	public Double getX(Double defaultValue) { 
		if (node.hasProperty(_x)) return (Double) node.getProperty(_x);
		return defaultValue;
	}

	public boolean hasX() { 
		return node.hasProperty(_x);
	}

	public LayoutNode removeX() { 
		node.removeProperty(_x);
		return this;
	}

	private static final String _y = "y";

	public LayoutNode setY(Double value) { 
		if (value == null) {
			removeY(); 
		} else {
		 	node.setProperty(_y, value);
		}
		return this;
	}

	public Double getY() { 
		if (node.hasProperty(_y)) return (Double) node.getProperty(_y);
		return null;
	}

	public Double getY(Double defaultValue) { 
		if (node.hasProperty(_y)) return (Double) node.getProperty(_y);
		return defaultValue;
	}

	public boolean hasY() { 
		return node.hasProperty(_y);
	}

	public LayoutNode removeY() { 
		node.removeProperty(_y);
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

	public void delete() {
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();	
	}


}