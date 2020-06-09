package tmp.ucs.domain.neo4j;

// todo node wrapper
public class Region {

	private final org.neo4j.graphdb.Node node;

	public Region(org.neo4j.graphdb.Node node) { 
		this.node= node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Region other = (Region) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	public Region setName(java.lang.String value) { 
		if (value == null) node.removeProperty("name"); 
		else node.setProperty("name", value);
		return this;
	}

	public java.lang.String getName() { 
		if (node.hasProperty("name")) return (java.lang.String) node.getProperty("name");
		return null;
	}

	public java.lang.String getName(java.lang.String defaultValue) { 
		if (node.hasProperty("name")) return (java.lang.String) node.getProperty("name");
		return defaultValue;
	}

	public boolean hasName() { 
		return node.hasProperty("name");
	}

	public Region removeName() { 
		node.removeProperty("name");
		return this;
	}

	public Region addCountries(Country dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("addresses")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("countries"));
		return this;
	}

	public java.util.stream.Stream<Country> getCountries() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("countries")).spliterator(), false).map((relationship) -> new Country(relationship.getOtherNode(node)));
	}

	public Region removeCountries(Country dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("countries")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public java.util.stream.Stream<Country> getIncomingCountries() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("countries")).spliterator(), false).map((relationship) -> new Country(relationship.getOtherNode(node)));
	}

	@Override
	public String toString() {
		return "";
	}
}