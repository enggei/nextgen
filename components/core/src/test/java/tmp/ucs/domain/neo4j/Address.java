package tmp.ucs.domain.neo4j;

public class Address {

	private final org.neo4j.graphdb.Node node;

	public Address(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Address other = (Address) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	public Address setStreet(String value) { 
		if (value == null) node.removeProperty("street"); 
		else node.setProperty("street", value);
		return this;
	}

	public String getStreet() { 
		if (node.hasProperty("street")) return (String) node.getProperty("street");
		return null;
	}

	public String getStreet(String defaultValue) { 
		if (node.hasProperty("street")) return (String) node.getProperty("street");
		return defaultValue;
	}

	public boolean hasStreet() { 
		return node.hasProperty("street");
	}

	public Address removeStreet() { 
		node.removeProperty("street");
		return this;
	}

	public Address setNo(Integer value) { 
		if (value == null) node.removeProperty("no"); 
		else node.setProperty("no", value);
		return this;
	}

	public Integer getNo() { 
		if (node.hasProperty("no")) return (Integer) node.getProperty("no");
		return null;
	}

	public Integer getNo(Integer defaultValue) { 
		if (node.hasProperty("no")) return (Integer) node.getProperty("no");
		return defaultValue;
	}

	public boolean hasNo() { 
		return node.hasProperty("no");
	}

	public Address removeNo() { 
		node.removeProperty("no");
		return this;
	}

	public Address setLetter(String value) { 
		if (value == null) node.removeProperty("letter"); 
		else node.setProperty("letter", value);
		return this;
	}

	public String getLetter() { 
		if (node.hasProperty("letter")) return (String) node.getProperty("letter");
		return null;
	}

	public String getLetter(String defaultValue) { 
		if (node.hasProperty("letter")) return (String) node.getProperty("letter");
		return defaultValue;
	}

	public boolean hasLetter() { 
		return node.hasProperty("letter");
	}

	public Address removeLetter() { 
		node.removeProperty("letter");
		return this;
	}

	public java.util.stream.Stream<City> getIncomingAddresses() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("addresses")).spliterator(), false).map((relationship) -> new City(relationship.getOtherNode(node)));
	}

	@Override
	public String toString() {
		return "";
	}
}