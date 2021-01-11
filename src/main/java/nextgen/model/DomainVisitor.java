package nextgen.model;

public class DomainVisitor {

	private final org.neo4j.graphdb.Node node;
	private final String uuid;

	public DomainVisitor(org.neo4j.graphdb.Node node) { 
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
		final DomainVisitor other = (DomainVisitor) o;
		return uuid.equals(other.uuid);
	}

	@Override
	public int hashCode() { 
		return uuid.hashCode();
	}

	private static final String _uuid = "uuid";

	public DomainVisitor setUuid(String value) { 
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

	public DomainVisitor removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}
	private static final String _name = "name";

	public DomainVisitor setName(String value) { 
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

	public DomainVisitor removeName() { 
		node.removeProperty(_name);
		return this;
	}

	public Domain getIncomingDomain() { 
		org.neo4j.graphdb.Relationship relationship = node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("visitors"), org.neo4j.graphdb.Direction.INCOMING);
		return relationship == null ? null : new Domain(relationship.getOtherNode(node));
	}

	private static final org.neo4j.graphdb.RelationshipType _imports = org.neo4j.graphdb.RelationshipType.withName("imports");

	public DomainVisitor addImports(String dst) { 
		final java.util.Optional<org.neo4j.graphdb.Node> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _imports).spliterator(), false).map((r) -> r.getOtherNode(node)).filter((n) -> dst.equals(n.getProperty("value"))).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Node newNode = node.getGraphDatabase().createNode(org.neo4j.graphdb.Label.label("String"));
		newNode.setProperty("value", dst);
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(newNode, _imports);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<String> getImports() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _imports).spliterator(), false).map((relationship) -> (String) relationship.getOtherNode(node).getProperty("value"));
	}

	public java.util.stream.Stream<String> getImportsSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _imports).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> (String) relationship.getOtherNode(node).getProperty("value"));
	}

	public DomainVisitor removeAllImports() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _imports).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public DomainVisitor removeImports(String value) { 
		if (value == null) return this;
		java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _imports).spliterator(), false)
			.filter((relationship) -> value.equals(relationship.getOtherNode(node).getProperty("value")))
			.forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	private static final org.neo4j.graphdb.RelationshipType _onDomain = org.neo4j.graphdb.RelationshipType.withName("onDomain");

	public DomainVisitor addOnDomain(String dst) { 
		final java.util.Optional<org.neo4j.graphdb.Node> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onDomain).spliterator(), false).map((r) -> r.getOtherNode(node)).filter((n) -> dst.equals(n.getProperty("value"))).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Node newNode = node.getGraphDatabase().createNode(org.neo4j.graphdb.Label.label("String"));
		newNode.setProperty("value", dst);
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(newNode, _onDomain);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<String> getOnDomain() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onDomain).spliterator(), false).map((relationship) -> (String) relationship.getOtherNode(node).getProperty("value"));
	}

	public java.util.stream.Stream<String> getOnDomainSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onDomain).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> (String) relationship.getOtherNode(node).getProperty("value"));
	}

	public DomainVisitor removeAllOnDomain() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onDomain).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public DomainVisitor removeOnDomain(String value) { 
		if (value == null) return this;
		java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onDomain).spliterator(), false)
			.filter((relationship) -> value.equals(relationship.getOtherNode(node).getProperty("value")))
			.forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	private static final org.neo4j.graphdb.RelationshipType _onEntity = org.neo4j.graphdb.RelationshipType.withName("onEntity");

	public DomainVisitor addOnEntity(String dst) { 
		final java.util.Optional<org.neo4j.graphdb.Node> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onEntity).spliterator(), false).map((r) -> r.getOtherNode(node)).filter((n) -> dst.equals(n.getProperty("value"))).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Node newNode = node.getGraphDatabase().createNode(org.neo4j.graphdb.Label.label("String"));
		newNode.setProperty("value", dst);
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(newNode, _onEntity);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<String> getOnEntity() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onEntity).spliterator(), false).map((relationship) -> (String) relationship.getOtherNode(node).getProperty("value"));
	}

	public java.util.stream.Stream<String> getOnEntitySorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onEntity).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> (String) relationship.getOtherNode(node).getProperty("value"));
	}

	public DomainVisitor removeAllOnEntity() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onEntity).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public DomainVisitor removeOnEntity(String value) { 
		if (value == null) return this;
		java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onEntity).spliterator(), false)
			.filter((relationship) -> value.equals(relationship.getOtherNode(node).getProperty("value")))
			.forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	private static final org.neo4j.graphdb.RelationshipType _onRelation = org.neo4j.graphdb.RelationshipType.withName("onRelation");

	public DomainVisitor addOnRelation(String dst) { 
		final java.util.Optional<org.neo4j.graphdb.Node> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onRelation).spliterator(), false).map((r) -> r.getOtherNode(node)).filter((n) -> dst.equals(n.getProperty("value"))).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Node newNode = node.getGraphDatabase().createNode(org.neo4j.graphdb.Label.label("String"));
		newNode.setProperty("value", dst);
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(newNode, _onRelation);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<String> getOnRelation() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onRelation).spliterator(), false).map((relationship) -> (String) relationship.getOtherNode(node).getProperty("value"));
	}

	public java.util.stream.Stream<String> getOnRelationSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onRelation).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> (String) relationship.getOtherNode(node).getProperty("value"));
	}

	public DomainVisitor removeAllOnRelation() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onRelation).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public DomainVisitor removeOnRelation(String value) { 
		if (value == null) return this;
		java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onRelation).spliterator(), false)
			.filter((relationship) -> value.equals(relationship.getOtherNode(node).getProperty("value")))
			.forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	private static final org.neo4j.graphdb.RelationshipType _onComplete = org.neo4j.graphdb.RelationshipType.withName("onComplete");

	public DomainVisitor addOnComplete(String dst) { 
		final java.util.Optional<org.neo4j.graphdb.Node> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onComplete).spliterator(), false).map((r) -> r.getOtherNode(node)).filter((n) -> dst.equals(n.getProperty("value"))).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Node newNode = node.getGraphDatabase().createNode(org.neo4j.graphdb.Label.label("String"));
		newNode.setProperty("value", dst);
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(newNode, _onComplete);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<String> getOnComplete() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onComplete).spliterator(), false).map((relationship) -> (String) relationship.getOtherNode(node).getProperty("value"));
	}

	public java.util.stream.Stream<String> getOnCompleteSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onComplete).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> (String) relationship.getOtherNode(node).getProperty("value"));
	}

	public DomainVisitor removeAllOnComplete() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onComplete).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public DomainVisitor removeOnComplete(String value) { 
		if (value == null) return this;
		java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _onComplete).spliterator(), false)
			.filter((relationship) -> value.equals(relationship.getOtherNode(node).getProperty("value")))
			.forEach(org.neo4j.graphdb.Relationship::delete);
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