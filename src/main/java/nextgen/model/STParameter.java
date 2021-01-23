package nextgen.model;

// stParameter STParameter
// labelParameter STParameter
public class STParameter {

	private final org.neo4j.graphdb.Node node;
	private final String uuid;

	public STParameter(org.neo4j.graphdb.Node node) { 
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
		final STParameter other = (STParameter) o;
		return uuid.equals(other.uuid);
	}

	@Override
	public int hashCode() { 
		return uuid.hashCode();
	}

	private static final String _uuid = "uuid";

	public STParameter setUuid(String value) { 
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

	public STParameter removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}
	public java.util.stream.Stream<STTemplate> getIncomingParametersSTTemplate() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("parameters")).spliterator(), false).map((relationship) -> new STTemplate(relationship.getOtherNode(node)));
	}  

	public static final String _name = "name";

	public STParameter setName(String value) { 
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

	public STParameter removeName() { 
		node.removeProperty(_name);
		return this;
	}  

	public STParameter setType(STParameterType value) {
		if (value == null) 
			removeType(); 
		else {
		 	node.setProperty("type", value.name());
		} 
		return this;
	}

	public STParameterType getType() { 
		if (node.hasProperty("type")) return STParameterType.valueOf((java.lang.String) node.getProperty("type"));
		return null;
	}

	public STParameterType getType(STParameterType defaultValue) { 
		if (node.hasProperty("type")) return STParameterType.valueOf((java.lang.String) node.getProperty("type"));
		return defaultValue;
	}

	public boolean hasType() { 
		return node.hasProperty("type");
	}

	public STParameter removeType() { 
		node.removeProperty("type");
		return this;
	}  

	public static final org.neo4j.graphdb.RelationshipType _keys = org.neo4j.graphdb.RelationshipType.withName("keys");

	public STParameter addKeys(STParameterKey dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _keys).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		if (existing.isPresent()) return this;
		final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _keys);
		relationship.setProperty("_t", System.nanoTime());
		return this;
	}

	public java.util.stream.Stream<STParameterKey> getKeys() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _keys).spliterator(), false).map((relationship) -> new STParameterKey(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<STParameterKey> getKeysSorted() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _keys).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t"))).map((relationship) -> new STParameterKey(relationship.getOtherNode(node)));
	}

	public STParameter removeKeys(STParameterKey dst) { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _keys).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public STParameter removeAllKeys() { 
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _keys).forEach(org.neo4j.graphdb.Relationship::delete);
		return this;
	}  

	public static final String _argumentType = "argumentType";

	public STParameter setArgumentType(String value) { 
		if (value == null) {
			removeArgumentType(); 
		} else {
		 	node.setProperty(_argumentType, value);
		}
		return this;
	}

	public String getArgumentType() { 
		if (node.hasProperty(_argumentType)) return (String) node.getProperty(_argumentType);
		return null;
	}

	public String getArgumentType(String defaultValue) { 
		if (node.hasProperty(_argumentType)) return (String) node.getProperty(_argumentType);
		return defaultValue;
	}

	public boolean hasArgumentType() { 
		return node.hasProperty(_argumentType);
	}

	public STParameter removeArgumentType() { 
		node.removeProperty(_argumentType);
		return this;
	}  

	public java.util.stream.Stream<STArgument> getIncomingStParameterSTArgument() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("stParameter")).spliterator(), false).map((relationship) -> new STArgument(relationship.getOtherNode(node)));
	}  

	public java.util.stream.Stream<STTemplate> getIncomingLabelParameterSTTemplate() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("labelParameter")).spliterator(), false).map((relationship) -> new STTemplate(relationship.getOtherNode(node)));
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