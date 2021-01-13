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