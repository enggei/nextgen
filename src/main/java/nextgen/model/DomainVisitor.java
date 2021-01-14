package nextgen.model;

public class DomainVisitor {

	private final org.neo4j.graphdb.Node node;
	private final String uuid;

	public DomainVisitor(org.neo4j.graphdb.Node node) { 
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
	public java.util.stream.Stream<Domain> getIncomingVisitorsDomain() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("visitors")).spliterator(), false).map((relationship) -> new Domain(relationship.getOtherNode(node)));
	}  

	public static final String _name = "name";

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

	public static final String _onDomain = "onDomain";

	public DomainVisitor setOnDomain(String value) { 
		if (value == null) {
			removeOnDomain(); 
		} else {
		 	node.setProperty(_onDomain, value);
		}
		return this;
	}

	public String getOnDomain() { 
		if (node.hasProperty(_onDomain)) return (String) node.getProperty(_onDomain);
		return null;
	}

	public String getOnDomain(String defaultValue) { 
		if (node.hasProperty(_onDomain)) return (String) node.getProperty(_onDomain);
		return defaultValue;
	}

	public boolean hasOnDomain() { 
		return node.hasProperty(_onDomain);
	}

	public DomainVisitor removeOnDomain() { 
		node.removeProperty(_onDomain);
		return this;
	}  

	public static final String _onEntity = "onEntity";

	public DomainVisitor setOnEntity(String value) { 
		if (value == null) {
			removeOnEntity(); 
		} else {
		 	node.setProperty(_onEntity, value);
		}
		return this;
	}

	public String getOnEntity() { 
		if (node.hasProperty(_onEntity)) return (String) node.getProperty(_onEntity);
		return null;
	}

	public String getOnEntity(String defaultValue) { 
		if (node.hasProperty(_onEntity)) return (String) node.getProperty(_onEntity);
		return defaultValue;
	}

	public boolean hasOnEntity() { 
		return node.hasProperty(_onEntity);
	}

	public DomainVisitor removeOnEntity() { 
		node.removeProperty(_onEntity);
		return this;
	}  

	public static final String _onRelation = "onRelation";

	public DomainVisitor setOnRelation(String value) { 
		if (value == null) {
			removeOnRelation(); 
		} else {
		 	node.setProperty(_onRelation, value);
		}
		return this;
	}

	public String getOnRelation() { 
		if (node.hasProperty(_onRelation)) return (String) node.getProperty(_onRelation);
		return null;
	}

	public String getOnRelation(String defaultValue) { 
		if (node.hasProperty(_onRelation)) return (String) node.getProperty(_onRelation);
		return defaultValue;
	}

	public boolean hasOnRelation() { 
		return node.hasProperty(_onRelation);
	}

	public DomainVisitor removeOnRelation() { 
		node.removeProperty(_onRelation);
		return this;
	}  

	public static final String _onComplete = "onComplete";

	public DomainVisitor setOnComplete(String value) { 
		if (value == null) {
			removeOnComplete(); 
		} else {
		 	node.setProperty(_onComplete, value);
		}
		return this;
	}

	public String getOnComplete() { 
		if (node.hasProperty(_onComplete)) return (String) node.getProperty(_onComplete);
		return null;
	}

	public String getOnComplete(String defaultValue) { 
		if (node.hasProperty(_onComplete)) return (String) node.getProperty(_onComplete);
		return defaultValue;
	}

	public boolean hasOnComplete() { 
		return node.hasProperty(_onComplete);
	}

	public DomainVisitor removeOnComplete() { 
		node.removeProperty(_onComplete);
		return this;
	}  

	public static final org.neo4j.graphdb.RelationshipType _templates = org.neo4j.graphdb.RelationshipType.withName("templates");

	public DomainVisitor addTemplates(STTemplate dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _templates).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _templates);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STTemplate> getTemplates() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _templates).spliterator(), false).map((relationship) -> new STTemplate(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STTemplate> getTemplatesSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _templates).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> new STTemplate(relationship.getOtherNode(node)));
	}

	public DomainVisitor removeTemplates(STTemplate dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _templates).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public DomainVisitor removeAllTemplates() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _templates).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}  

	public static final String _onEntityEntity = "onEntityEntity";

	public DomainVisitor setOnEntityEntity(String value) { 
		if (value == null) {
			removeOnEntityEntity(); 
		} else {
		 	node.setProperty(_onEntityEntity, value);
		}
		return this;
	}

	public String getOnEntityEntity() { 
		if (node.hasProperty(_onEntityEntity)) return (String) node.getProperty(_onEntityEntity);
		return null;
	}

	public String getOnEntityEntity(String defaultValue) { 
		if (node.hasProperty(_onEntityEntity)) return (String) node.getProperty(_onEntityEntity);
		return defaultValue;
	}

	public boolean hasOnEntityEntity() { 
		return node.hasProperty(_onEntityEntity);
	}

	public DomainVisitor removeOnEntityEntity() { 
		node.removeProperty(_onEntityEntity);
		return this;
	}  

	public static final String _onEnumEntity = "onEnumEntity";

	public DomainVisitor setOnEnumEntity(String value) { 
		if (value == null) {
			removeOnEnumEntity(); 
		} else {
		 	node.setProperty(_onEnumEntity, value);
		}
		return this;
	}

	public String getOnEnumEntity() { 
		if (node.hasProperty(_onEnumEntity)) return (String) node.getProperty(_onEnumEntity);
		return null;
	}

	public String getOnEnumEntity(String defaultValue) { 
		if (node.hasProperty(_onEnumEntity)) return (String) node.getProperty(_onEnumEntity);
		return defaultValue;
	}

	public boolean hasOnEnumEntity() { 
		return node.hasProperty(_onEnumEntity);
	}

	public DomainVisitor removeOnEnumEntity() { 
		node.removeProperty(_onEnumEntity);
		return this;
	}  

	public static final String _onPrimitiveEntity = "onPrimitiveEntity";

	public DomainVisitor setOnPrimitiveEntity(String value) { 
		if (value == null) {
			removeOnPrimitiveEntity(); 
		} else {
		 	node.setProperty(_onPrimitiveEntity, value);
		}
		return this;
	}

	public String getOnPrimitiveEntity() { 
		if (node.hasProperty(_onPrimitiveEntity)) return (String) node.getProperty(_onPrimitiveEntity);
		return null;
	}

	public String getOnPrimitiveEntity(String defaultValue) { 
		if (node.hasProperty(_onPrimitiveEntity)) return (String) node.getProperty(_onPrimitiveEntity);
		return defaultValue;
	}

	public boolean hasOnPrimitiveEntity() { 
		return node.hasProperty(_onPrimitiveEntity);
	}

	public DomainVisitor removeOnPrimitiveEntity() { 
		node.removeProperty(_onPrimitiveEntity);
		return this;
	}  

	public static final String _onOneEntityRelation = "onOneEntityRelation";

	public DomainVisitor setOnOneEntityRelation(String value) { 
		if (value == null) {
			removeOnOneEntityRelation(); 
		} else {
		 	node.setProperty(_onOneEntityRelation, value);
		}
		return this;
	}

	public String getOnOneEntityRelation() { 
		if (node.hasProperty(_onOneEntityRelation)) return (String) node.getProperty(_onOneEntityRelation);
		return null;
	}

	public String getOnOneEntityRelation(String defaultValue) { 
		if (node.hasProperty(_onOneEntityRelation)) return (String) node.getProperty(_onOneEntityRelation);
		return defaultValue;
	}

	public boolean hasOnOneEntityRelation() { 
		return node.hasProperty(_onOneEntityRelation);
	}

	public DomainVisitor removeOnOneEntityRelation() { 
		node.removeProperty(_onOneEntityRelation);
		return this;
	}  

	public static final String _onOneEnumRelation = "onOneEnumRelation";

	public DomainVisitor setOnOneEnumRelation(String value) { 
		if (value == null) {
			removeOnOneEnumRelation(); 
		} else {
		 	node.setProperty(_onOneEnumRelation, value);
		}
		return this;
	}

	public String getOnOneEnumRelation() { 
		if (node.hasProperty(_onOneEnumRelation)) return (String) node.getProperty(_onOneEnumRelation);
		return null;
	}

	public String getOnOneEnumRelation(String defaultValue) { 
		if (node.hasProperty(_onOneEnumRelation)) return (String) node.getProperty(_onOneEnumRelation);
		return defaultValue;
	}

	public boolean hasOnOneEnumRelation() { 
		return node.hasProperty(_onOneEnumRelation);
	}

	public DomainVisitor removeOnOneEnumRelation() { 
		node.removeProperty(_onOneEnumRelation);
		return this;
	}  

	public static final String _onOnePrimitiveRelation = "onOnePrimitiveRelation";

	public DomainVisitor setOnOnePrimitiveRelation(String value) { 
		if (value == null) {
			removeOnOnePrimitiveRelation(); 
		} else {
		 	node.setProperty(_onOnePrimitiveRelation, value);
		}
		return this;
	}

	public String getOnOnePrimitiveRelation() { 
		if (node.hasProperty(_onOnePrimitiveRelation)) return (String) node.getProperty(_onOnePrimitiveRelation);
		return null;
	}

	public String getOnOnePrimitiveRelation(String defaultValue) { 
		if (node.hasProperty(_onOnePrimitiveRelation)) return (String) node.getProperty(_onOnePrimitiveRelation);
		return defaultValue;
	}

	public boolean hasOnOnePrimitiveRelation() { 
		return node.hasProperty(_onOnePrimitiveRelation);
	}

	public DomainVisitor removeOnOnePrimitiveRelation() { 
		node.removeProperty(_onOnePrimitiveRelation);
		return this;
	}  

	public static final String _onManyEntityRelation = "onManyEntityRelation";

	public DomainVisitor setOnManyEntityRelation(String value) { 
		if (value == null) {
			removeOnManyEntityRelation(); 
		} else {
		 	node.setProperty(_onManyEntityRelation, value);
		}
		return this;
	}

	public String getOnManyEntityRelation() { 
		if (node.hasProperty(_onManyEntityRelation)) return (String) node.getProperty(_onManyEntityRelation);
		return null;
	}

	public String getOnManyEntityRelation(String defaultValue) { 
		if (node.hasProperty(_onManyEntityRelation)) return (String) node.getProperty(_onManyEntityRelation);
		return defaultValue;
	}

	public boolean hasOnManyEntityRelation() { 
		return node.hasProperty(_onManyEntityRelation);
	}

	public DomainVisitor removeOnManyEntityRelation() { 
		node.removeProperty(_onManyEntityRelation);
		return this;
	}  

	public static final String _onManyEnumRelation = "onManyEnumRelation";

	public DomainVisitor setOnManyEnumRelation(String value) { 
		if (value == null) {
			removeOnManyEnumRelation(); 
		} else {
		 	node.setProperty(_onManyEnumRelation, value);
		}
		return this;
	}

	public String getOnManyEnumRelation() { 
		if (node.hasProperty(_onManyEnumRelation)) return (String) node.getProperty(_onManyEnumRelation);
		return null;
	}

	public String getOnManyEnumRelation(String defaultValue) { 
		if (node.hasProperty(_onManyEnumRelation)) return (String) node.getProperty(_onManyEnumRelation);
		return defaultValue;
	}

	public boolean hasOnManyEnumRelation() { 
		return node.hasProperty(_onManyEnumRelation);
	}

	public DomainVisitor removeOnManyEnumRelation() { 
		node.removeProperty(_onManyEnumRelation);
		return this;
	}  

	public static final String _onManyPrimitiveRelation = "onManyPrimitiveRelation";

	public DomainVisitor setOnManyPrimitiveRelation(String value) { 
		if (value == null) {
			removeOnManyPrimitiveRelation(); 
		} else {
		 	node.setProperty(_onManyPrimitiveRelation, value);
		}
		return this;
	}

	public String getOnManyPrimitiveRelation() { 
		if (node.hasProperty(_onManyPrimitiveRelation)) return (String) node.getProperty(_onManyPrimitiveRelation);
		return null;
	}

	public String getOnManyPrimitiveRelation(String defaultValue) { 
		if (node.hasProperty(_onManyPrimitiveRelation)) return (String) node.getProperty(_onManyPrimitiveRelation);
		return defaultValue;
	}

	public boolean hasOnManyPrimitiveRelation() { 
		return node.hasProperty(_onManyPrimitiveRelation);
	}

	public DomainVisitor removeOnManyPrimitiveRelation() { 
		node.removeProperty(_onManyPrimitiveRelation);
		return this;
	}  

	public static final String _onOptionalEntityRelation = "onOptionalEntityRelation";

	public DomainVisitor setOnOptionalEntityRelation(String value) { 
		if (value == null) {
			removeOnOptionalEntityRelation(); 
		} else {
		 	node.setProperty(_onOptionalEntityRelation, value);
		}
		return this;
	}

	public String getOnOptionalEntityRelation() { 
		if (node.hasProperty(_onOptionalEntityRelation)) return (String) node.getProperty(_onOptionalEntityRelation);
		return null;
	}

	public String getOnOptionalEntityRelation(String defaultValue) { 
		if (node.hasProperty(_onOptionalEntityRelation)) return (String) node.getProperty(_onOptionalEntityRelation);
		return defaultValue;
	}

	public boolean hasOnOptionalEntityRelation() { 
		return node.hasProperty(_onOptionalEntityRelation);
	}

	public DomainVisitor removeOnOptionalEntityRelation() { 
		node.removeProperty(_onOptionalEntityRelation);
		return this;
	}  

	public static final String _onOptionalEnumRelation = "onOptionalEnumRelation";

	public DomainVisitor setOnOptionalEnumRelation(String value) { 
		if (value == null) {
			removeOnOptionalEnumRelation(); 
		} else {
		 	node.setProperty(_onOptionalEnumRelation, value);
		}
		return this;
	}

	public String getOnOptionalEnumRelation() { 
		if (node.hasProperty(_onOptionalEnumRelation)) return (String) node.getProperty(_onOptionalEnumRelation);
		return null;
	}

	public String getOnOptionalEnumRelation(String defaultValue) { 
		if (node.hasProperty(_onOptionalEnumRelation)) return (String) node.getProperty(_onOptionalEnumRelation);
		return defaultValue;
	}

	public boolean hasOnOptionalEnumRelation() { 
		return node.hasProperty(_onOptionalEnumRelation);
	}

	public DomainVisitor removeOnOptionalEnumRelation() { 
		node.removeProperty(_onOptionalEnumRelation);
		return this;
	}  

	public static final String _onOptionalPrimitiveRelation = "onOptionalPrimitiveRelation";

	public DomainVisitor setOnOptionalPrimitiveRelation(String value) { 
		if (value == null) {
			removeOnOptionalPrimitiveRelation(); 
		} else {
		 	node.setProperty(_onOptionalPrimitiveRelation, value);
		}
		return this;
	}

	public String getOnOptionalPrimitiveRelation() { 
		if (node.hasProperty(_onOptionalPrimitiveRelation)) return (String) node.getProperty(_onOptionalPrimitiveRelation);
		return null;
	}

	public String getOnOptionalPrimitiveRelation(String defaultValue) { 
		if (node.hasProperty(_onOptionalPrimitiveRelation)) return (String) node.getProperty(_onOptionalPrimitiveRelation);
		return defaultValue;
	}

	public boolean hasOnOptionalPrimitiveRelation() { 
		return node.hasProperty(_onOptionalPrimitiveRelation);
	}

	public DomainVisitor removeOnOptionalPrimitiveRelation() { 
		node.removeProperty(_onOptionalPrimitiveRelation);
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