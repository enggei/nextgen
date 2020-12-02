package nextgen.model.workflow;

public class RepeatFlow {

	private final org.neo4j.graphdb.Node node;

	public RepeatFlow(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final RepeatFlow other = (RepeatFlow) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	private static final String _uuid = "uuid";

	public RepeatFlow setUuid(String value) { 
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

	public RepeatFlow removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}

	private static final String _name = "name";

	public RepeatFlow setName(String value) { 
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

	public RepeatFlow removeName() { 
		node.removeProperty(_name);
		return this;
	}

	public RepeatFlow setRepeat(WorkInstance dst) { 
		final org.neo4j.graphdb.Relationship relationship = getRepeatRelation();
		if (relationship != null)  { 
			if (dst != null && relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("repeat"));
		return this;
	}

	public WorkInstance getRepeat() { 
		final org.neo4j.graphdb.Relationship relationship = getRepeatRelation();
		return relationship == null ? null : new WorkInstance(relationship.getOtherNode(node));
	}

	public RepeatFlow removeRepeat() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getRepeatRelation());
		existing.ifPresent(relationship -> {
			relationship.delete();
		});
		return this;
	}

	public org.neo4j.graphdb.Relationship getRepeatRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("repeat"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	private static final String _times = "times";

	public RepeatFlow setTimes(Integer value) { 
		if (value == null) {
			removeTimes(); 
		} else {
		 	node.setProperty(_times, value);
		}
		return this;
	}

	public Integer getTimes() { 
		if (node.hasProperty(_times)) return (Integer) node.getProperty(_times);
		return null;
	}

	public Integer getTimes(Integer defaultValue) { 
		if (node.hasProperty(_times)) return (Integer) node.getProperty(_times);
		return defaultValue;
	}

	public boolean hasTimes() { 
		return node.hasProperty(_times);
	}

	public RepeatFlow removeTimes() { 
		node.removeProperty(_times);
		return this;
	}

	public RepeatFlow setUntil(UntilPredicate value) {
		if (value == null) 
			removeUntil(); 
		else {
		 	node.setProperty("until", value.name());
		} 
		return this;
	}

	public UntilPredicate getUntil() { 
		if (node.hasProperty("until")) return UntilPredicate.valueOf((java.lang.String) node.getProperty("until"));
		return null;
	}

	public UntilPredicate getUntil(UntilPredicate defaultValue) { 
		if (node.hasProperty("until")) return UntilPredicate.valueOf((java.lang.String) node.getProperty("until"));
		return defaultValue;
	}

	public boolean hasUntil() { 
		return node.hasProperty("until");
	}

	public RepeatFlow removeUntil() { 
		node.removeProperty("until");
		return this;
	}

	public java.util.stream.Stream<WorkInstance> getIncomingRepeatWorkInstance() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("repeat")).spliterator(), false).map((relationship) -> new WorkInstance(relationship.getOtherNode(node)));
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
		if (node.hasProperty("times")) jsonObject.put("times", node.getProperty("times"));
		if (node.hasProperty("until")) jsonObject.put("until", node.getProperty("until"));
		final WorkInstance _repeat = getRepeat();
		if (_repeat != null) jsonObject.put("repeat", _repeat.toJsonObject());

		return jsonObject;
	}

	public void delete() {
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();

	}

}