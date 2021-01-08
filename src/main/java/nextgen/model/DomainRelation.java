package nextgen.model;

public class DomainRelation {

	private final org.neo4j.graphdb.Node node;
	private final String uuid;

	public DomainRelation(org.neo4j.graphdb.Node node) { 
		this.node = node;
		if (!node.hasProperty("uuid")) this.node.setProperty("uuid", this.uuid = java.util.UUID.randomUUID().toString());
		else this.uuid = node.getProperty("uuid").toString();
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}


	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final DomainRelation other = (DomainRelation) o;
		return uuid.equals(other.uuid);
	}

	@Override
	public int hashCode() { 
		return uuid.hashCode();
	}

	private static final String _uuid = "uuid";

	public DomainRelation setUuid(String value) { 
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

	public DomainRelation removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}
	private static final org.neo4j.graphdb.RelationshipType _properties = org.neo4j.graphdb.RelationshipType.withName("properties");

	public DomainRelation addProperties(DomainProperty dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _properties).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _properties);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<DomainProperty> getProperties() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _properties).spliterator(), false).map((relationship) -> new DomainProperty(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<DomainProperty> getPropertiesSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _properties).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> new DomainProperty(relationship.getOtherNode(node)));
	}

	public DomainRelation removeProperties(DomainProperty dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _properties).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public DomainRelation removeAllProperties() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _properties).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public DomainRelation setEntity(DomainEntity dst) { 
		final org.neo4j.graphdb.Relationship relationship = getEntityRelation();
		if (relationship != null)  { 
			if (dst != null && relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("entity"));
		return this;
	}

	public DomainEntity getEntity() { 
		final org.neo4j.graphdb.Relationship relationship = getEntityRelation();
		return relationship == null ? null : new DomainEntity(relationship.getOtherNode(node));
	}

	public DomainRelation removeEntity() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getEntityRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getEntityRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("entity"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public DomainRelation setName(STValue dst) { 
		final org.neo4j.graphdb.Relationship relationship = getNameRelation();
		if (relationship != null)  { 
			if (dst != null && relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("name"));
		return this;
	}

	public STValue getName() { 
		final org.neo4j.graphdb.Relationship relationship = getNameRelation();
		return relationship == null ? null : new STValue(relationship.getOtherNode(node));
	}

	public DomainRelation removeName() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getNameRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getNameRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("name"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public DomainEntity getIncomingEntity() { 
		org.neo4j.graphdb.Relationship relationship = node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("relations"), org.neo4j.graphdb.Direction.INCOMING);
		return relationship == null ? null : new DomainEntity(relationship.getOtherNode(node));
	}

	public DomainRelation setType(nextgen.model.DomainRelationType value) {
		if (value == null) 
			removeType(); 
		else {
		 	node.setProperty("type", value.name());
		} 
		return this;
	}

	public nextgen.model.DomainRelationType getType() { 
		if (node.hasProperty("type")) return nextgen.model.DomainRelationType.valueOf((java.lang.String) node.getProperty("type"));
		return null;
	}

	public nextgen.model.DomainRelationType getType(nextgen.model.DomainRelationType defaultValue) { 
		if (node.hasProperty("type")) return nextgen.model.DomainRelationType.valueOf((java.lang.String) node.getProperty("type"));
		return defaultValue;
	}

	public boolean hasType() { 
		return node.hasProperty("type");
	}

	public DomainRelation removeType() { 
		node.removeProperty("type");
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