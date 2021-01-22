package nextgen.templates.javaneo4jembedded;

public class ReferenceOptionalAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _type;
	private String _name;
	private java.util.List<Object> _removeStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _setStatements = new java.util.ArrayList<>();

	ReferenceOptionalAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("referenceOptionalAccessors");
		st.add("className", _className);
		st.add("type", _type);
		st.add("name", _name);
		for (Object o : _removeStatements) st.add("removeStatements", o);
		for (Object o : _setStatements) st.add("setStatements", o);
		return st.render().trim();
	}

	public ReferenceOptionalAccessors setClassName(Object value) {
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

	public ReferenceOptionalAccessors removeClassName() {
		this._className = null;
		return this;
	} 

	public ReferenceOptionalAccessors setType(Object value) {
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

	public ReferenceOptionalAccessors removeType() {
		this._type = null;
		return this;
	} 

	public ReferenceOptionalAccessors setName(String value) {
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

	public ReferenceOptionalAccessors removeName() {
		this._name = null;
		return this;
	} 

	public ReferenceOptionalAccessors addRemoveStatements(Object value) {
		this._removeStatements.add(value);
		return this;
	}

	public ReferenceOptionalAccessors setRemoveStatements(Object[] value) {
		this._removeStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ReferenceOptionalAccessors setRemoveStatements(java.util.Collection<Object> values) {
		this._removeStatements.addAll(values);
		return this;
	}

	public ReferenceOptionalAccessors removeRemoveStatements(Object value) {
		this._removeStatements.remove(value);
		return this;
	}

	public ReferenceOptionalAccessors removeRemoveStatements(int index) {
		this._removeStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getRemoveStatements() {
		return this._removeStatements;
	} 

	public ReferenceOptionalAccessors addSetStatements(Object value) {
		this._setStatements.add(value);
		return this;
	}

	public ReferenceOptionalAccessors setSetStatements(Object[] value) {
		this._setStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ReferenceOptionalAccessors setSetStatements(java.util.Collection<Object> values) {
		this._setStatements.addAll(values);
		return this;
	}

	public ReferenceOptionalAccessors removeSetStatements(Object value) {
		this._setStatements.remove(value);
		return this;
	}

	public ReferenceOptionalAccessors removeSetStatements(int index) {
		this._setStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getSetStatements() {
		return this._setStatements;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ReferenceOptionalAccessors that = (ReferenceOptionalAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "referenceOptionalAccessors(className,removeStatements,setStatements,type,name) ::= <<public ~className;format=\"capitalize\"~ set~name;format=\"capitalize\"~(~type~ dst) { \n" + 
				"	final org.neo4j.graphdb.Relationship relationship = get~name;format=\"capitalize\"~Relation().orElse(null);\n" + 
				"	if (relationship != null)  { \n" + 
				"		if (dst != null && relationship.getOtherNode(node).equals(dst.getNode())) return this;\n" + 
				"		relationship.delete();\n" + 
				"	}\n" + 
				"	if (dst == null) return this;\n" + 
				"	node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName(\"~name~\"));\n" + 
				"	~setStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.Optional<~type~> get~name;format=\"capitalize\"~() { \n" + 
				"	final org.neo4j.graphdb.Relationship relationship = get~name;format=\"capitalize\"~Relation().orElse(null);\n" + 
				"	return relationship == null ? java.util.Optional.empty() : java.util.Optional.of(new ~type~(relationship.getOtherNode(node)));\n" + 
				"}\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ remove~name;format=\"capitalize\"~() { \n" + 
				"	final java.util.Optional<org.neo4j.graphdb.Relationship> existing = get~name;format=\"capitalize\"~Relation();\n" + 
				"	existing.ifPresent(relationship -> {\n" + 
				"		relationship.delete();\n" + 
				"		~removeStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	});\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.Optional<org.neo4j.graphdb.Relationship> get~name;format=\"capitalize\"~Relation() { \n" + 
				"	return java.util.Optional.ofNullable(node.getSingleRelationship(org.neo4j.graphdb.RelationshipType.withName(\"~name~\"), org.neo4j.graphdb.Direction.OUTGOING));\n" + 
				"} >>";
}  