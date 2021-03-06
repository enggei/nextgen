package nextgen.model;

// stTemplate STTemplate
public class STTemplate {

	private final org.neo4j.graphdb.Node node;
	private final String uuid;

	public STTemplate(org.neo4j.graphdb.Node node) { 
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
		final STTemplate other = (STTemplate) o;
		return uuid.equals(other.uuid);
	}

	@Override
	public int hashCode() { 
		return uuid.hashCode();
	}

	private static final String _uuid = "uuid";

	public STTemplate setUuid(String value) { 
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

	public STTemplate removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}
	public static final org.neo4j.graphdb.RelationshipType _parameters = org.neo4j.graphdb.RelationshipType.withName("parameters");

	public STTemplate addParameters(STParameter dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _parameters).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _parameters);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STParameter> getParameters() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _parameters).spliterator(), false).map((relationship) -> new STParameter(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STParameter> getParametersSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _parameters).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> new STParameter(relationship.getOtherNode(node)));
	}

	public STTemplate removeParameters(STParameter dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _parameters).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public STTemplate removeAllParameters() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _parameters).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}  

	public java.util.stream.Stream<STGroupModel> getIncomingTemplatesSTGroupModel() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("templates")).spliterator(), false).map((relationship) -> new STGroupModel(relationship.getOtherNode(node)));
	}  

	public static final String _name = "name";

	public STTemplate setName(String value) { 
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

	public STTemplate removeName() { 
		node.removeProperty(_name);
		return this;
	}  

	public static final String _text = "text";

	public STTemplate setText(String value) { 
		if (value == null) {
			removeText(); 
		} else {
		 	node.setProperty(_text, value);
		}
		return this;
	}

	public String getText() { 
		if (node.hasProperty(_text)) return (String) node.getProperty(_text);
		return null;
	}

	public String getText(String defaultValue) { 
		if (node.hasProperty(_text)) return (String) node.getProperty(_text);
		return defaultValue;
	}

	public boolean hasText() { 
		return node.hasProperty(_text);
	}

	public STTemplate removeText() { 
		node.removeProperty(_text);
		return this;
	}  

	public static final org.neo4j.graphdb.RelationshipType _implements = org.neo4j.graphdb.RelationshipType.withName("implements");

	public STTemplate addImplements(String dst) { 
		final java.util.Optional<org.neo4j.graphdb.Node> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _implements).spliterator(), false).map((r) -> r.getOtherNode(node)).filter((n) -> dst.equals(n.getProperty("value"))).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Node newNode = node.getGraphDatabase().createNode(org.neo4j.graphdb.Label.label("String"));
		newNode.setProperty("value", dst);
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(newNode, _implements);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<String> getImplements() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _implements).spliterator(), false).map((relationship) -> (String) relationship.getOtherNode(node).getProperty("value"));
	}

	public java.util.stream.Stream<String> getImplementsSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _implements).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> (String) relationship.getOtherNode(node).getProperty("value"));
	}

	public STTemplate removeAllImplements() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _implements).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public STTemplate removeImplements(String value) { 
		if (value == null) return this;
		java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _implements).spliterator(), false)
			.filter((relationship) -> value.equals(relationship.getOtherNode(node).getProperty("value")))
			.forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}  

	public static final org.neo4j.graphdb.RelationshipType _children = org.neo4j.graphdb.RelationshipType.withName("children");

	public STTemplate addChildren(STTemplate dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _children).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _children);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STTemplate> getChildren() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _children).spliterator(), false).map((relationship) -> new STTemplate(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STTemplate> getChildrenSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _children).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> new STTemplate(relationship.getOtherNode(node)));
	}

	public STTemplate removeChildren(STTemplate dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _children).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public STTemplate removeAllChildren() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _children).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}  

	public java.util.stream.Stream<STTemplate> getIncomingChildrenSTTemplate() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("children")).spliterator(), false).map((relationship) -> new STTemplate(relationship.getOtherNode(node)));
	}  

	public java.util.stream.Stream<STModel> getIncomingStTemplateSTModel() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("stTemplate")).spliterator(), false).map((relationship) -> new STModel(relationship.getOtherNode(node)));
	}  

	public STTemplate setLabelParameter(STParameter dst) { 
		final org.neo4j.graphdb.Relationship relationship = getLabelParameterRelation();
		if (relationship != null)  { 
			if (dst != null && relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("labelParameter"));
		return this;
	}

	public STParameter getLabelParameter() { 
		final org.neo4j.graphdb.Relationship relationship = getLabelParameterRelation();
		return relationship == null ? null : new STParameter(relationship.getOtherNode(node));
	}

	public STTemplate removeLabelParameter() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getLabelParameterRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getLabelParameterRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("labelParameter"), org.neo4j.graphdb.Direction.OUTGOING);
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