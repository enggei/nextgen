package tmp.ucs.domain.neo4j;

// todo node wrapper
public class Address {

	private final org.neo4j.graphdb.Node node;

	public Address(org.neo4j.graphdb.Node node) { 
		this.node= node;
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

	public Address setStreet(java.lang.String value) { 
		if (value == null) node.removeProperty("street"); 
		else node.setProperty("street", value);
		return this;
	}

	public java.lang.String getStreet() { 
		if (node.hasProperty("street")) return (java.lang.String) node.getProperty("street");
		return null;
	}

	public java.lang.String getStreet(java.lang.String defaultValue) { 
		if (node.hasProperty("street")) return (java.lang.String) node.getProperty("street");
		return defaultValue;
	}

	public boolean hasStreet() { 
		return node.hasProperty("street");
	}

	public Address removeStreet() { 
		node.removeProperty("street");
		return this;
	}

	public Address setNo(java.lang.Integer value) { 
		if (value == null) node.removeProperty("no"); 
		else node.setProperty("no", value);
		return this;
	}

	public java.lang.Integer getNo() { 
		if (node.hasProperty("no")) return (java.lang.Integer) node.getProperty("no");
		return null;
	}

	public java.lang.Integer getNo(java.lang.Integer defaultValue) { 
		if (node.hasProperty("no")) return (java.lang.Integer) node.getProperty("no");
		return defaultValue;
	}

	public boolean hasNo() { 
		return node.hasProperty("no");
	}

	public Address removeNo() { 
		node.removeProperty("no");
		return this;
	}

	public Address setLetter(java.lang.String value) { 
		if (value == null) node.removeProperty("letter"); 
		else node.setProperty("letter", value);
		return this;
	}

	public java.lang.String getLetter() { 
		if (node.hasProperty("letter")) return (java.lang.String) node.getProperty("letter");
		return null;
	}

	public java.lang.String getLetter(java.lang.String defaultValue) { 
		if (node.hasProperty("letter")) return (java.lang.String) node.getProperty("letter");
		return defaultValue;
	}

	public boolean hasLetter() { 
		return node.hasProperty("letter");
	}

	public Address removeLetter() { 
		node.removeProperty("letter");
		return this;
	}

	@Override
	public String toString() {
		return "";
	}
}