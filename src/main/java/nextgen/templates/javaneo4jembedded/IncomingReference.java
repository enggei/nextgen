package nextgen.templates.javaneo4jembedded;

public class IncomingReference {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _type;
	private String _name;

	IncomingReference(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("incomingReference");
		st.add("type", _type);
		st.add("name", _name);
		return st.render().trim();
	}

	public IncomingReference setType(Object value) {
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

	public IncomingReference removeType() {
		this._type = null;
		return this;
	} 

	public IncomingReference setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public IncomingReference removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IncomingReference that = (IncomingReference) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "incomingReference(type,name) ::= <<public ~type~ getIncoming~name;format=\"capitalize\"~~type;format=\"capitalize\"~() {\n" + 
				"	org.neo4j.graphdb.Relationship relationship = node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName(\"~name~\"), org.neo4j.graphdb.Direction.INCOMING); \n" + 
				"	return relationship == null ? null : new ~type~(relationship.getOtherNode(node));\n" + 
				"} >>";
}  