package nextgen.model;

// name STValue
// packageName STValue
// path STValue
// statements STValue
// imports STValue
// methods STValue
// type STValue
// packageName STValue
// path STValue
// value STValue
// value STValue
public class STValue {

	private final org.neo4j.graphdb.Node node;
	private final String uuid;

	public STValue(org.neo4j.graphdb.Node node) { 
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
		final STValue other = (STValue) o;
		return uuid.equals(other.uuid);
	}

	@Override
	public int hashCode() { 
		return uuid.hashCode();
	}

	private static final String _uuid = "uuid";

	public STValue setUuid(String value) { 
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

	public STValue removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}
	public java.util.stream.Stream<STFile> getIncomingNameSTFile() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("name")).spliterator(), false).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}  

	public java.util.stream.Stream<STProject> getIncomingValuesSTProject() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("values")).spliterator(), false).map((relationship) -> new STProject(relationship.getOtherNode(node)));
	}  

	public java.util.stream.Stream<STGroupFile> getIncomingPackageNameSTGroupFile() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("packageName")).spliterator(), false).map((relationship) -> new STGroupFile(relationship.getOtherNode(node)));
	}  

	public java.util.stream.Stream<STGroupFile> getIncomingPathSTGroupFile() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("path")).spliterator(), false).map((relationship) -> new STGroupFile(relationship.getOtherNode(node)));
	}  

	public java.util.stream.Stream<STGroupAction> getIncomingStatementsSTGroupAction() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("statements")).spliterator(), false).map((relationship) -> new STGroupAction(relationship.getOtherNode(node)));
	}  

	public java.util.stream.Stream<STGroupAction> getIncomingImportsSTGroupAction() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("imports")).spliterator(), false).map((relationship) -> new STGroupAction(relationship.getOtherNode(node)));
	}  

	public java.util.stream.Stream<STGroupAction> getIncomingMethodsSTGroupAction() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("methods")).spliterator(), false).map((relationship) -> new STGroupAction(relationship.getOtherNode(node)));
	}  

	public STValue setType(STValueType value) {
		if (value == null) 
			removeType(); 
		else {
		 	node.setProperty("type", value.name());
		} 
		return this;
	}

	public STValueType getType() { 
		if (node.hasProperty("type")) return STValueType.valueOf((java.lang.String) node.getProperty("type"));
		return null;
	}

	public STValueType getType(STValueType defaultValue) { 
		if (node.hasProperty("type")) return STValueType.valueOf((java.lang.String) node.getProperty("type"));
		return defaultValue;
	}

	public boolean hasType() { 
		return node.hasProperty("type");
	}

	public STValue removeType() { 
		node.removeProperty("type");
		return this;
	}  

	public static final String _value = "value";

	public STValue setValue(String value) { 
		if (value == null) {
			removeValue(); 
		} else {
		 	node.setProperty(_value, value);
		}
		return this;
	}

	public String getValue() { 
		if (node.hasProperty(_value)) return (String) node.getProperty(_value);
		return null;
	}

	public String getValue(String defaultValue) { 
		if (node.hasProperty(_value)) return (String) node.getProperty(_value);
		return defaultValue;
	}

	public boolean hasValue() { 
		return node.hasProperty(_value);
	}

	public STValue removeValue() { 
		node.removeProperty(_value);
		return this;
	}  

	public STValue setStModel(STModel dst) { 
		final org.neo4j.graphdb.Relationship relationship = getStModelRelation();
		if (relationship != null)  { 
			if (dst != null && relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("stModel"));
		return this;
	}

	public STModel getStModel() { 
		final org.neo4j.graphdb.Relationship relationship = getStModelRelation();
		return relationship == null ? null : new STModel(relationship.getOtherNode(node));
	}

	public STValue removeStModel() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getStModelRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getStModelRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("stModel"), org.neo4j.graphdb.Direction.OUTGOING);
	}  

	public STValue setStEnumValue(STEnumValue dst) { 
		final org.neo4j.graphdb.Relationship relationship = getStEnumValueRelation();
		if (relationship != null)  { 
			if (dst != null && relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("stEnumValue"));
		return this;
	}

	public STEnumValue getStEnumValue() { 
		final org.neo4j.graphdb.Relationship relationship = getStEnumValueRelation();
		return relationship == null ? null : new STEnumValue(relationship.getOtherNode(node));
	}

	public STValue removeStEnumValue() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getStEnumValueRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getStEnumValueRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("stEnumValue"), org.neo4j.graphdb.Direction.OUTGOING);
	}  

	public java.util.stream.Stream<STFile> getIncomingTypeSTFile() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("type")).spliterator(), false).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}  

	public java.util.stream.Stream<STFile> getIncomingPackageNameSTFile() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("packageName")).spliterator(), false).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}  

	public java.util.stream.Stream<STFile> getIncomingPathSTFile() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("path")).spliterator(), false).map((relationship) -> new STFile(relationship.getOtherNode(node)));
	}  

	public java.util.stream.Stream<STArgument> getIncomingValueSTArgument() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("value")).spliterator(), false).map((relationship) -> new STArgument(relationship.getOtherNode(node)));
	}  

	public java.util.stream.Stream<STArgumentKV> getIncomingValueSTArgumentKV() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("value")).spliterator(), false).map((relationship) -> new STArgumentKV(relationship.getOtherNode(node)));
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