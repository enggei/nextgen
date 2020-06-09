package nextgen.templates.neo4j;

public class IncomingReferenceStream {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _type;
	private Object _name;

	IncomingReferenceStream(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IncomingReferenceStream that = (IncomingReferenceStream) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("incomingReferenceStream");
		st.add("type", _type);
		st.add("name", _name);
		return st.render().trim();
	}

	public IncomingReferenceStream setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public IncomingReferenceStream removeType() {
		this._type = null;
		return this;
	} 

	public IncomingReferenceStream setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public IncomingReferenceStream removeName() {
		this._name = null;
		return this;
	} 

	static final String st = "incomingReferenceStream(type,name) ::= <<public java.util.stream.Stream<~type~> getIncoming~name;format=\"capitalize\"~() { \n" + 
				"	return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName(\"~name~\")).spliterator(), false).map((relationship) -> new ~type~(relationship.getOtherNode(node)));\n" + 
				"}>> ";
} 