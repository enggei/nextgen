package nextgen.workflow;

public class WorkInstance {

	private final org.neo4j.graphdb.Node node;

	public WorkInstance(org.neo4j.graphdb.Node node) { 
		this.node = node;
	}

	public org.neo4j.graphdb.Node getNode() { 
		return this.node;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final WorkInstance other = (WorkInstance) o;
		return node.equals(other.node);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(node);
	}

	private static final String _uuid = "uuid";

	public WorkInstance setUuid(String value) { 
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

	public WorkInstance removeUuid() { 
		node.removeProperty(_uuid);
		return this;
	}

	public WorkInstance setType(WorkType value) { 
		if (value == null) node.removeProperty("type"); 
		else node.setProperty("type", value.name());
		return this;
	}

	public WorkType getType() { 
		if (node.hasProperty("type")) return WorkType.valueOf((java.lang.String) node.getProperty("type"));
		return null;
	}

	public WorkType getType(WorkType defaultValue) { 
		if (node.hasProperty("type")) return WorkType.valueOf((java.lang.String) node.getProperty("type"));
		return defaultValue;
	}

	public boolean hasType() { 
		return node.hasProperty("type");
	}

	public WorkInstance removeType() { 
		node.removeProperty("type");
		return this;
	}

	public WorkInstance setWork(Work dst) { 
		final org.neo4j.graphdb.Relationship relationship = getWorkRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("work"));
		return this;
	}

	public Work getWork() { 
		final org.neo4j.graphdb.Relationship relationship = getWorkRelation();
		return relationship == null ? null : new Work(relationship.getOtherNode(node));
	}

	public WorkInstance removeWork() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getWorkRelation());
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public org.neo4j.graphdb.Relationship getWorkRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("work"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public WorkInstance setConditional(ConditionalFlow dst) { 
		final org.neo4j.graphdb.Relationship relationship = getConditionalRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("conditional"));
		return this;
	}

	public ConditionalFlow getConditional() { 
		final org.neo4j.graphdb.Relationship relationship = getConditionalRelation();
		return relationship == null ? null : new ConditionalFlow(relationship.getOtherNode(node));
	}

	public WorkInstance removeConditional() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getConditionalRelation());
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public org.neo4j.graphdb.Relationship getConditionalRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("conditional"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public java.util.stream.Stream<ConditionalFlow> getIncomingExecuteConditionalFlow() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("execute")).spliterator(), false).map((relationship) -> new ConditionalFlow(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<ConditionalFlow> getIncomingThenConditionalFlow() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("then")).spliterator(), false).map((relationship) -> new ConditionalFlow(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<ConditionalFlow> getIncomingOtherwiseConditionalFlow() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("otherwise")).spliterator(), false).map((relationship) -> new ConditionalFlow(relationship.getOtherNode(node)));
	}

	public WorkInstance setSequential(SequentialFlow dst) { 
		final org.neo4j.graphdb.Relationship relationship = getSequentialRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("sequential"));
		return this;
	}

	public SequentialFlow getSequential() { 
		final org.neo4j.graphdb.Relationship relationship = getSequentialRelation();
		return relationship == null ? null : new SequentialFlow(relationship.getOtherNode(node));
	}

	public WorkInstance removeSequential() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getSequentialRelation());
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public org.neo4j.graphdb.Relationship getSequentialRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("sequential"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public java.util.stream.Stream<SequentialFlow> getIncomingExecuteSequentialFlow() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("execute")).spliterator(), false).map((relationship) -> new SequentialFlow(relationship.getOtherNode(node)));
	}

	public java.util.stream.Stream<SequentialFlow> getIncomingThenSequentialFlow() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("then")).spliterator(), false).map((relationship) -> new SequentialFlow(relationship.getOtherNode(node)));
	}

	public WorkInstance setParallel(ParallelFlow dst) { 
		final org.neo4j.graphdb.Relationship relationship = getParallelRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("parallel"));
		return this;
	}

	public ParallelFlow getParallel() { 
		final org.neo4j.graphdb.Relationship relationship = getParallelRelation();
		return relationship == null ? null : new ParallelFlow(relationship.getOtherNode(node));
	}

	public WorkInstance removeParallel() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getParallelRelation());
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public org.neo4j.graphdb.Relationship getParallelRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("parallel"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public java.util.stream.Stream<ParallelFlow> getIncomingExecuteParallelFlow() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("execute")).spliterator(), false).map((relationship) -> new ParallelFlow(relationship.getOtherNode(node)));
	}

	public WorkInstance setRepeat(RepeatFlow dst) { 
		final org.neo4j.graphdb.Relationship relationship = getRepeatRelation();
		if (relationship != null)  { 
			if (relationship.getOtherNode(node).equals(dst.getNode())) return this;
			relationship.delete();
		}
		if (dst == null) return this;
		node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName("repeat"));
		return this;
	}

	public RepeatFlow getRepeat() { 
		final org.neo4j.graphdb.Relationship relationship = getRepeatRelation();
		return relationship == null ? null : new RepeatFlow(relationship.getOtherNode(node));
	}

	public WorkInstance removeRepeat() { 
		final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(getRepeatRelation());
		existing.ifPresent(org.neo4j.graphdb.Relationship::delete);
		return this;
	}

	public org.neo4j.graphdb.Relationship getRepeatRelation() { 
		return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName("repeat"), org.neo4j.graphdb.Direction.OUTGOING);
	}

	public java.util.stream.Stream<RepeatFlow> getIncomingRepeatRepeatFlow() { 
		return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("repeat")).spliterator(), false).map((relationship) -> new RepeatFlow(relationship.getOtherNode(node)));
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
		if (node.hasProperty("type")) jsonObject.put("type", node.getProperty("type"));
		final Work _work = getWork();
		if (_work != null) jsonObject.put("work", _work.toJsonObject());

		final ConditionalFlow _conditional = getConditional();
		if (_conditional != null) jsonObject.put("conditional", _conditional.toJsonObject());

		final SequentialFlow _sequential = getSequential();
		if (_sequential != null) jsonObject.put("sequential", _sequential.toJsonObject());

		final ParallelFlow _parallel = getParallel();
		if (_parallel != null) jsonObject.put("parallel", _parallel.toJsonObject());

		final RepeatFlow _repeat = getRepeat();
		if (_repeat != null) jsonObject.put("repeat", _repeat.toJsonObject());

		return jsonObject;
	}

	public void delete() {
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
		node.delete();
	}

}