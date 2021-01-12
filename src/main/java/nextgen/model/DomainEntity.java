package nextgen.model;

public class DomainEntity {

	private final org.neo4j.graphdb.Node node;
	private final String uuid;

	public DomainEntity(org.neo4j.graphdb.Node node) { 
		this.node = node;
		if (!node.hasProperty("uuid")) this.node.setProperty("uuid", this.uuid = java.util.UUID.randomUUID().toString());
		else this.uuid = node.getProperty("uuid").toString();}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}


	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final DomainEntity other = (DomainEntity) o;
		return uuid.equals(other.uuid);
	}

	@Override
	public int hashCode() { 
		return uuid.hashCode();
	}

	private static final String _uuid = "uuid";

	public DomainEntity setUuid(String value) { 
		if (value == null) {
			removeUuid(); 
		} else {
			node.setProperty(_uuid, value);
		}
		return this;
	}

	public String getUuid() { 
		if (node.hasProperty(_uuid)) return (String) node.getProperty(_uuid);
		return null;
	}

	public String getUuid(String defaultValue) { 
		if (node.hasProperty(_uuid)) return (String) node.getProperty(_uuid);
		return defaultValue;
	}

	public boolean hasUuid() { 
		return node.hasProperty(_uuid);
	}

	public DomainEntity removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}
	private static final String _name = "name";

	public DomainEntity setName(String value) { 
		if (value == null) {
			removeName(); 
		} else {
		 	node.setProperty(_name, value);
		}
		return this;
	}

	public String getName() { 
		if (node.hasProperty(_name)) return (String) node.getProperty(_name);
		return null;
	}

	public String getName(String defaultValue) { 
		if (node.hasProperty(_name)) return (String) node.getProperty(_name);
		return defaultValue;
	}

	public boolean hasName() { 
		return node.hasProperty(_name);
	}

	public DomainEntity removeName() { 
		node.removeProperty(_name);
		return this;
	}

	public Domain getIncomingDomain() { 
		org.neo4j.graphdb.Relationship relationship = node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("entities"), org.neo4j.graphdb.Direction.INCOMING);
		return relationship == null ? null : new Domain(relationship.getOtherNode(node));
	}

	public DomainEntity setType(DomainEntityType value) {
		if (value == null) 
			removeType(); 
		else {
		 	node.setProperty("type", value.name());
		} 
		return this;
	}

	public DomainEntityType getType() { 
		if (node.hasProperty("type")) return DomainEntityType.valueOf((java.lang.String) node.getProperty("type"));
		return null;
	}

	public DomainEntityType getType(DomainEntityType defaultValue) { 
		if (node.hasProperty("type")) return DomainEntityType.valueOf((java.lang.String) node.getProperty("type"));
		return defaultValue;
	}

	public boolean hasType() { 
		return node.hasProperty("type");
	}

	public DomainEntity removeType() { 
		node.removeProperty("type");
		return this;
	}

	private static final String _enums = "enums";

	public DomainEntity setEnums(String value) { 
		if (value == null) {
			removeEnums(); 
		} else {
		 	node.setProperty(_enums, value);
		}
		return this;
	}

	public String getEnums() { 
		if (node.hasProperty(_enums)) return (String) node.getProperty(_enums);
		return null;
	}

	public String getEnums(String defaultValue) { 
		if (node.hasProperty(_enums)) return (String) node.getProperty(_enums);
		return defaultValue;
	}

	public boolean hasEnums() { 
		return node.hasProperty(_enums);
	}

	public DomainEntity removeEnums() { 
		node.removeProperty(_enums);
		return this;
	}

	@Override
	public String toString() {
		final StringBuilder out = new StringBuilder();
		out.append("Node : ").append(node.getId()).append(" ");
		node.getLabels().forEach(label -> out.append(label.name()).append(" "));
		out.append("(");
		node.getPropertyKeys().forEach(s -> out.append(" ").append(s).append(":").append(node.getProperty(s)));
		out.append(")");
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(relationship -> {
			out.append("\n\t -> ").append(relationship.getType()).append(" (");
			relationship.getPropertyKeys().forEach(s -> out.append(" ").append(s).append(":").append(relationship.getProperty(s)));
			out.append(")");
		});
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(relationship -> {
			out.append("\n\t <- ").append(relationship.getType()).append(" (");
			relationship.getPropertyKeys().forEach(s -> out.append(" ").append(s).append(":").append(relationship.getProperty(s)));
			out.append(")");
		});
		return out.toString().trim();
	}

	public void delete() {
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();	
	}


}