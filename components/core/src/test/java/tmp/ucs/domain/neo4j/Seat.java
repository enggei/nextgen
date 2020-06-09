package tmp.ucs.domain.neo4j;

// todo node wrapper
public class Seat {

	private final org.neo4j.graphdb.Node node;

	public Seat(org.neo4j.graphdb.Node node) { 
		this.node= node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Seat other = (Seat) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	public Seat setNo(java.lang.Integer value) { 
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

	public Seat removeNo() { 
		node.removeProperty("no");
		return this;
	}

	public Seat setStatus(SeatStatus value) { 
		if (value == null) node.removeProperty("status"); 
		else node.setProperty("status", value.name());
		return this;
	}

	public SeatStatus getStatus() { 
		if (node.hasProperty("status")) return SeatStatus.valueOf((java.lang.String) node.getProperty("status"));
		return null;
	}

	public SeatStatus getStatus(SeatStatus defaultValue) { 
		if (node.hasProperty("status")) return SeatStatus.valueOf((java.lang.String) node.getProperty("status"));
		return defaultValue;
	}

	public boolean hasStatus() { 
		return node.hasProperty("status");
	}

	public Seat removeStatus() { 
		node.removeProperty("status");
		return this;
	}

	@Override
	public String toString() {
		return "";
	}
}