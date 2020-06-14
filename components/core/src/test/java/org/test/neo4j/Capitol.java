package org.test.neo4j;

public class Capitol {

	private final org.neo4j.graphdb.Node node;

	public Capitol(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Capitol other = (Capitol) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	public Capitol setName(String value) { 
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

	public Capitol removeName() { 
		node.removeProperty("name");
		return this;
	}

	public java.util.stream.Stream<Country> getIncomingCapitol() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("capitol")).spliterator(), false).map((relationship) -> new Country(relationship.getOtherNode(node)));
	}

	@Override
	public String toString() {
		return "";
	}
}