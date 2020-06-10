package tmp.ucs.domain.neo4j;

public class Screen {

	private final org.neo4j.graphdb.Node node;

	public Screen(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Screen other = (Screen) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	public Screen setName(String value) { 
		if (value == null) node.removeProperty("name"); 
		else node.setProperty("name", value);
		return this;
	}

	public String getName() { 
		if (node.hasProperty("name")) return (String) node.getProperty("name");
		return null;
	}

	public String getName(String defaultValue) { 
		if (node.hasProperty("name")) return (String) node.getProperty("name");
		return defaultValue;
	}

	public boolean hasName() { 
		return node.hasProperty("name");
	}

	public Screen removeName() { 
		node.removeProperty("name");
		return this;
	}

	public Screen setStatus(ScreenStatus value) { 
		if (value == null) node.removeProperty("status"); 
		else node.setProperty("status", value.name());
		return this;
	}

	public ScreenStatus getStatus() { 
		if (node.hasProperty("status")) return ScreenStatus.valueOf((java.lang.String) node.getProperty("status"));
		return null;
	}

	public ScreenStatus getStatus(ScreenStatus defaultValue) { 
		if (node.hasProperty("status")) return ScreenStatus.valueOf((java.lang.String) node.getProperty("status"));
		return defaultValue;
	}

	public boolean hasStatus() { 
		return node.hasProperty("status");
	}

	public Screen removeStatus() { 
		node.removeProperty("status");
		return this;
	}

	public Screen setActive(Boolean value) { 
		if (value == null) node.removeProperty("active"); 
		else node.setProperty("active", value);
		return this;
	}

	public Boolean getActive() { 
		if (node.hasProperty("active")) return (Boolean) node.getProperty("active");
		return null;
	}

	public Boolean getActive(Boolean defaultValue) { 
		if (node.hasProperty("active")) return (Boolean) node.getProperty("active");
		return defaultValue;
	}

	public boolean hasActive() { 
		return node.hasProperty("active");
	}

	public Screen removeActive() { 
		node.removeProperty("active");
		return this;
	}

	public Screen addSeats(Seat dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("seats")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("seats"));
		return this;
	}

	public java.util.stream.Stream<Seat> getSeats() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("seats")).spliterator(), false).map((relationship) -> new Seat(relationship.getOtherNode(node)));
	}

	public Screen removeSeats(Seat dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("seats")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public java.util.stream.Stream<Seat> getIncomingSeats() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("seats")).spliterator(), false).map((relationship) -> new Seat(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<Cinema> getIncomingScreens() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("screens")).spliterator(), false).map((relationship) -> new Cinema(relationship.getOtherNode(node)));
	}

	@Override
	public String toString() {
		return "";
	}
}