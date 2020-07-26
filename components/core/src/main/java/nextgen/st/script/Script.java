package nextgen.st.script;

public class Script {

	private final org.neo4j.graphdb.Node node;

	public Script(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Script other = (Script) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	public Script setName(String value) { 
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

	public Script removeName() { 
		node.removeProperty("name");
		return this;
	}

	public Script setUuid(String value) { 
		if (value == null) node.removeProperty("uuid"); 
		else node.setProperty("uuid", value);
		return this;
	}

	public String getUuid() { 
		if (node.hasProperty("uuid")) return (String) node.getProperty("uuid");
		return null;
	}

	public String getUuid(String defaultValue) { 
		if (node.hasProperty("uuid")) return (String) node.getProperty("uuid");
		return defaultValue;
	}

	public boolean hasUuid() { 
		return node.hasProperty("uuid");
	}

	public Script removeUuid() { 
		node.removeProperty("uuid");
		return this;
	}

	public Script setScript(nextgen.st.model.STValue dst) { 
		final org.neo4j.graphdb.Relationship relationship = getScriptRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("script"));
		return this;
	}

	public nextgen.st.model.STValue getScript() { 
		final org.neo4j.graphdb.Relationship relationship = getScriptRelation();
		return relationship == null ? null : new nextgen.st.model.STValue(relationship.getOtherNode(node));
	}

	public Script removeScript() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getScriptRelation());
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public org.neo4j.graphdb.Relationship getScriptRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("script"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	@Override
	public String toString() {
		return "";
	}

}