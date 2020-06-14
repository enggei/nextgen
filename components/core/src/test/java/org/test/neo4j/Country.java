package org.test.neo4j;

public class Country {

	private final org.neo4j.graphdb.Node node;
	private java.io.File _map;
	private java.util.concurrent.atomic.AtomicInteger _population;

	public Country(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Country other = (Country) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	public Country setName(String value) { 
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

	public Country removeName() { 
		node.removeProperty("name");
		return this;
	}

	public Country setId(Long value) { 
		if (value == null) node.removeProperty("id"); 
		else node.setProperty("id", value);
		return this;
	}

	public Long getId() { 
		if (node.hasProperty("id")) return (Long) node.getProperty("id");
		return null;
	}

	public Long getId(Long defaultValue) { 
		if (node.hasProperty("id")) return (Long) node.getProperty("id");
		return defaultValue;
	}

	public boolean hasId() { 
		return node.hasProperty("id");
	}

	public Country removeId() { 
		node.removeProperty("id");
		return this;
	}

	public Country setMap(java.io.File value) { 
		this._map = value;
		return this;
	}

	public java.io.File getMap() { 
		return this._map;
	}

	public java.io.File getMap(java.io.File defaultValue) { 
		return this._map == null ? defaultValue : this._map;
	}

	public Country setPopulation(java.util.concurrent.atomic.AtomicInteger value) { 
		this._population = value;
		return this;
	}

	public java.util.concurrent.atomic.AtomicInteger getPopulation() { 
		return this._population;
	}

	public java.util.concurrent.atomic.AtomicInteger getPopulation(java.util.concurrent.atomic.AtomicInteger defaultValue) { 
		return this._population == null ? defaultValue : this._population;
	}

	public Country setCapitol(Capitol dst) { 
		final org.neo4j.graphdb.Relationship relationship = node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("capitol"), org.neo4j.graphdb.Direction.OUTGOING);
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("capitol"));
		return this;
	}

	public Capitol getCapitol() { 
		final org.neo4j.graphdb.Relationship relationship = node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("capitol"), org.neo4j.graphdb.Direction.OUTGOING);
		return relationship == null ? null : new Capitol(relationship.getOtherNode(node));
	}

	public Country removeCapitol(Capitol dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("capitol")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public Country addCities(City dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("cities")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("cities"));
		return this;
	}

	public java.util.stream.Stream<City> getCities() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("cities")).spliterator(), false).map((relationship) -> new City(relationship.getOtherNode(node)));
	}

	public Country removeCities(City dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("cities")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public java.util.stream.Stream<City> getIncomingCities() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("cities")).spliterator(), false).map((relationship) -> new City(relationship.getOtherNode(node)));
	}

	@Override
	public String toString() {
		return "";
	}
}