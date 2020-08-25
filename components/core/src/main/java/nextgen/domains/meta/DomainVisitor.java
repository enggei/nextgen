package nextgen.domains.meta;

public class DomainVisitor {

	private final org.neo4j.graphdb.Node node;

	public DomainVisitor(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final DomainVisitor other = (DomainVisitor) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	private static final String _uuid = "uuid";

	public DomainVisitor setUuid(String value) { 
		if (value == null) node.removeProperty(_uuid); 
		else node.setProperty(_uuid, value);
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
		if (value == null) node.removeProperty(_name); 
		else node.setProperty(_name, value);
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

	private static final String _initStatements = "initStatements";

	public DomainVisitor setInitStatements(String value) { 
		if (value == null) node.removeProperty(_initStatements); 
		else node.setProperty(_initStatements, value);
		return this;
	}

	public String getInitStatements() { 
		if (node.hasProperty(_initStatements)) return (String) node.getProperty(_initStatements);
		return null;
	}

	public String getInitStatements(String defaultValue) { 
		if (node.hasProperty(_initStatements)) return (String) node.getProperty(_initStatements);
		return defaultValue;
	}

	public boolean hasInitStatements() { 
		return node.hasProperty(_initStatements);
	}

	public DomainVisitor removeInitStatements() { 
		node.removeProperty(_initStatements);
		return this;
	}

	private static final String _endStatements = "endStatements";

	public DomainVisitor setEndStatements(String value) { 
		if (value == null) node.removeProperty(_endStatements); 
		else node.setProperty(_endStatements, value);
		return this;
	}

	public String getEndStatements() { 
		if (node.hasProperty(_endStatements)) return (String) node.getProperty(_endStatements);
		return null;
	}

	public String getEndStatements(String defaultValue) { 
		if (node.hasProperty(_endStatements)) return (String) node.getProperty(_endStatements);
		return defaultValue;
	}

	public boolean hasEndStatements() { 
		return node.hasProperty(_endStatements);
	}

	public DomainVisitor removeEndStatements() { 
		node.removeProperty(_endStatements);
		return this;
	}

	private static final org.neo4j.graphdb.RelationshipType _fields = org.neo4j.graphdb.RelationshipType.withName("fields");

	public DomainVisitor addFields(VisitorField dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _fields).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _fields);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<VisitorField> getFields() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _fields).spliterator(), false).map((relationship) -> new VisitorField(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<VisitorField> getFieldsSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _fields).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t", o.getId()))).map((relationship) -> new VisitorField(relationship.getOtherNode(node)));
	}

	public DomainVisitor removeFields(VisitorField dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _fields).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public DomainVisitor removeAllFields() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _fields).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public java.util.stream.Stream<VisitorField> getIncomingFieldsVisitorField() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("fields")).spliterator(), false).map((relationship) -> new VisitorField(relationship.getOtherNode(node)));
	}

	private static final org.neo4j.graphdb.RelationshipType _entityVisitors = org.neo4j.graphdb.RelationshipType.withName("entityVisitors");

	public DomainVisitor addEntityVisitors(EntityVisitorMethod dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _entityVisitors).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _entityVisitors);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<EntityVisitorMethod> getEntityVisitors() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _entityVisitors).spliterator(), false).map((relationship) -> new EntityVisitorMethod(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<EntityVisitorMethod> getEntityVisitorsSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _entityVisitors).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t", o.getId()))).map((relationship) -> new EntityVisitorMethod(relationship.getOtherNode(node)));
	}

	public DomainVisitor removeEntityVisitors(EntityVisitorMethod dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _entityVisitors).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public DomainVisitor removeAllEntityVisitors() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _entityVisitors).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public java.util.stream.Stream<EntityVisitorMethod> getIncomingEntityVisitorsEntityVisitorMethod() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("entityVisitors")).spliterator(), false).map((relationship) -> new EntityVisitorMethod(relationship.getOtherNode(node)));
	}

	private static final org.neo4j.graphdb.RelationshipType _relationVisitors = org.neo4j.graphdb.RelationshipType.withName("relationVisitors");

	public DomainVisitor addRelationVisitors(RelationVisitorMethod dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _relationVisitors).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _relationVisitors);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<RelationVisitorMethod> getRelationVisitors() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _relationVisitors).spliterator(), false).map((relationship) -> new RelationVisitorMethod(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<RelationVisitorMethod> getRelationVisitorsSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _relationVisitors).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t", o.getId()))).map((relationship) -> new RelationVisitorMethod(relationship.getOtherNode(node)));
	}

	public DomainVisitor removeRelationVisitors(RelationVisitorMethod dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _relationVisitors).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public DomainVisitor removeAllRelationVisitors() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _relationVisitors).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public java.util.stream.Stream<RelationVisitorMethod> getIncomingRelationVisitorsRelationVisitorMethod() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("relationVisitors")).spliterator(), false).map((relationship) -> new RelationVisitorMethod(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<MetaDomain> getIncomingVisitorsMetaDomain() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("visitors")).spliterator(), false).map((relationship) -> new MetaDomain(relationship.getOtherNode(node)));
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

	public io.vertx.core.json.JsonObject toJsonObject() {
		io.vertx.core.json.JsonObject jsonObject = new io.vertx.core.json.JsonObject();
		if (node.hasProperty("uuid")) jsonObject.put("uuid", node.getProperty("uuid"));
		if (node.hasProperty("name")) jsonObject.put("name", node.getProperty("name"));
		if (node.hasProperty("initStatements")) jsonObject.put("initStatements", node.getProperty("initStatements"));
		if (node.hasProperty("endStatements")) jsonObject.put("endStatements", node.getProperty("endStatements"));
		final io.vertx.core.json.JsonArray _fields = new io.vertx.core.json.JsonArray();
		getFields().forEach(element -> _fields.add(element.toJsonObject()));
		if (!_fields.isEmpty()) jsonObject.put("fields", _fields);

		final io.vertx.core.json.JsonArray _entityVisitors = new io.vertx.core.json.JsonArray();
		getEntityVisitors().forEach(element -> _entityVisitors.add(element.toJsonObject()));
		if (!_entityVisitors.isEmpty()) jsonObject.put("entityVisitors", _entityVisitors);

		final io.vertx.core.json.JsonArray _relationVisitors = new io.vertx.core.json.JsonArray();
		getRelationVisitors().forEach(element -> _relationVisitors.add(element.toJsonObject()));
		if (!_relationVisitors.isEmpty()) jsonObject.put("relationVisitors", _relationVisitors);

		return jsonObject;
	}

	public void delete() {
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();
	}

}