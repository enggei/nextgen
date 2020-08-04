package nextgen.templates.javaneo4jembedded;

public class ReferenceAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _name;
	private Object _type;
	private Object _observable;

	ReferenceAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("referenceAccessors");
		st.add("className", _className);
		st.add("name", _name);
		st.add("type", _type);
		st.add("observable", _observable);
		return st.render().trim();
	}

	public ReferenceAccessors setClassName(Object value) {
		this._className = value;
		return this;
	}

	public Object getClassName() {
		return this._className;
	}

	public Object getClassName(Object defaultValue) {
		return this._className == null ? defaultValue : this._className;
	}

	public boolean hasClassName() {
		return this._className != null;
	}

	public ReferenceAccessors removeClassName() {
		this._className = null;
		return this;
	} 

	public ReferenceAccessors setName(Object value) {
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

	public ReferenceAccessors removeName() {
		this._name = null;
		return this;
	} 

	public ReferenceAccessors setType(Object value) {
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

	public ReferenceAccessors removeType() {
		this._type = null;
		return this;
	} 

	public ReferenceAccessors setObservable(Object value) {
		this._observable = value;
		return this;
	}

	public Object getObservable() {
		return this._observable;
	}

	public Object getObservable(Object defaultValue) {
		return this._observable == null ? defaultValue : this._observable;
	}

	public boolean hasObservable() {
		return this._observable != null;
	}

	public ReferenceAccessors removeObservable() {
		this._observable = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ReferenceAccessors that = (ReferenceAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "referenceAccessors(className,name,type,observable) ::= <<public ~className;format=\"capitalize\"~ set~name;format=\"capitalize\"~(~type~ dst) { \n" + 
				"	final org.neo4j.graphdb.Relationship relationship = get~name;format=\"capitalize\"~Relation();\n" + 
				"	if (relationship != null)  { \n" + 
				"		if (relationship.getOtherNode(node).equals(dst.getNode())) return this;\n" + 
				"		relationship.delete();\n" + 
				"	}\n" + 
				"	if (dst == null) return this;\n" + 
				"	node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName(\"~name~\"));\n" + 
				"	~if(observable)~this.pcs.firePropertyChange(\"set.~name~\", null, dst);~endif~\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public ~type~ get~name;format=\"capitalize\"~() { \n" + 
				"	final org.neo4j.graphdb.Relationship relationship = get~name;format=\"capitalize\"~Relation();\n" + 
				"	return relationship == null ? null : new ~type~(relationship.getOtherNode(node));\n" + 
				"}\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ remove~name;format=\"capitalize\"~() { \n" + 
				"	final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.Optional.ofNullable(get~name;format=\"capitalize\"~Relation());\n" + 
				"	existing.ifPresent(org.neo4j.graphdb.Relationship::delete);\n" + 
				"	~if(observable)~this.pcs.firePropertyChange(\"remove.~name~\", true, false);~endif~\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public org.neo4j.graphdb.Relationship get~name;format=\"capitalize\"~Relation() { \n" + 
				"	return node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName(\"~name~\"), org.neo4j.graphdb.Direction.OUTGOING);\n" + 
				"} >>";
}  