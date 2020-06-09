package tmp.ucs.domain.neo4j;

// todo node wrapper
public class Cinema {

	private final org.neo4j.graphdb.Node node;

	public Cinema(org.neo4j.graphdb.Node node) { 
		this.node= node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Cinema other = (Cinema) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	public Cinema setName(java.lang.String value) { 
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

	public Cinema removeName() { 
		node.removeProperty("name");
		return this;
	}

	public Cinema addAliases(java.lang.String dst) { 
		final java.util.Optional<org.neo4j.graphdb.Node> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("aliases")).spliterator(), false).map((r) -> r.getOtherNode(node)).filter((n) -> dst.equals(n.getProperty("value"))).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Node newNode = node.getGraphDatabase().createNode(org.neo4j.graphdb.Label.label("java.lang.String"));
		newNode.setProperty("value", dst);
		node.createRelationshipTo(newNode, org.neo4j.graphdb.RelationshipType.withName("aliases"));
		return this;
	}

	public java.util.stream.Stream<java.lang.String> getAliases() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("aliases")).spliterator(), false).map((relationship) -> (java.lang.String) relationship.getOtherNode(node).getProperty("value"));
	}

	public Cinema setAddress(Address dst) { 
		final org.neo4j.graphdb.Relationship relationship = node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("address"), org.neo4j.graphdb.Direction.OUTGOING);
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("address"));
		return this;
	}

	public Address getAddress() { 
		final org.neo4j.graphdb.Relationship relationship = node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("address"), org.neo4j.graphdb.Direction.OUTGOING);
		return relationship == null ? null : new Address(relationship.getOtherNode(node));
	}

	public Cinema removeAddress(Address dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("address")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public Cinema addScreens(Screen dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("addresses")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("screens"));
		return this;
	}

	public java.util.stream.Stream<Screen> getScreens() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("screens")).spliterator(), false).map((relationship) -> new Screen(relationship.getOtherNode(node)));
	}

	public Cinema removeScreens(Screen dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("screens")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public java.util.stream.Stream<Screen> getIncomingScreens() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("screens")).spliterator(), false).map((relationship) -> new Screen(relationship.getOtherNode(node)));
	}

	@Override
	public String toString() {
		return "";
	}
}