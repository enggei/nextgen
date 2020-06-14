package org.test.neo4j;

public class City {

	private final org.neo4j.graphdb.Node node;

	public City(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final City other = (City) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	public City setName(String value) { 
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

	public City removeName() { 
		node.removeProperty("name");
		return this;
	}

	public City setPopulation(Long value) { 
		if (value == null) node.removeProperty("population"); 
		else node.setProperty("population", value);
		return this;
	}

	public Long getPopulation() { 
		if (node.hasProperty("population")) return (Long) node.getProperty("population");
		return null;
	}

	public Long getPopulation(Long defaultValue) { 
		if (node.hasProperty("population")) return (Long) node.getProperty("population");
		return defaultValue;
	}

	public boolean hasPopulation() { 
		return node.hasProperty("population");
	}

	public City removePopulation() { 
		node.removeProperty("population");
		return this;
	}

	public java.util.stream.Stream<Country> getIncomingCities() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("cities")).spliterator(), false).map((relationship) -> new Country(relationship.getOtherNode(node)));
	}

	@Override
	public String toString() {
		return "";
	}
}