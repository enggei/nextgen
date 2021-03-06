package nextgen.templates.javaneo4jembedded;

public class EnumListAccessors implements Accessor {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _type;
	private Object _name;
	private java.util.List<Object> _removeStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _setStatements = new java.util.ArrayList<>();

	EnumListAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("enumListAccessors");
		st.add("className", _className);
		st.add("type", _type);
		st.add("name", _name);
		for (Object o : _removeStatements) st.add("removeStatements", o);
		for (Object o : _setStatements) st.add("setStatements", o);
		return st.render().trim();
	}

	public EnumListAccessors setClassName(Object value) {
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

	public EnumListAccessors removeClassName() {
		this._className = null;
		return this;
	} 

	public EnumListAccessors setType(Object value) {
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

	public EnumListAccessors removeType() {
		this._type = null;
		return this;
	} 

	public EnumListAccessors setName(Object value) {
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

	public EnumListAccessors removeName() {
		this._name = null;
		return this;
	} 

	public EnumListAccessors addRemoveStatements(Object value) {
		this._removeStatements.add(value);
		return this;
	}

	public EnumListAccessors setRemoveStatements(Object[] value) {
		this._removeStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EnumListAccessors setRemoveStatements(java.util.Collection<Object> values) {
		this._removeStatements.addAll(values);
		return this;
	}

	public EnumListAccessors removeRemoveStatements(Object value) {
		this._removeStatements.remove(value);
		return this;
	}

	public EnumListAccessors removeRemoveStatements(int index) {
		this._removeStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getRemoveStatements() {
		return this._removeStatements;
	} 

	public EnumListAccessors addSetStatements(Object value) {
		this._setStatements.add(value);
		return this;
	}

	public EnumListAccessors setSetStatements(Object[] value) {
		this._setStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EnumListAccessors setSetStatements(java.util.Collection<Object> values) {
		this._setStatements.addAll(values);
		return this;
	}

	public EnumListAccessors removeSetStatements(Object value) {
		this._setStatements.remove(value);
		return this;
	}

	public EnumListAccessors removeSetStatements(int index) {
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
		EnumListAccessors that = (EnumListAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "enumListAccessors(className,removeStatements,setStatements,type,name) ::= <<public ~className;format=\"capitalize\"~ add~name;format=\"capitalize\"~(~type~ dst) { \n" + 
				"	final java.util.Optional<org.neo4j.graphdb.Node> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName(\"~name~\")).spliterator(), false).map((r) -> r.getOtherNode(node)).filter((n) -> dst.equals(n.getProperty(\"value\"))).findAny();\n" + 
				"	if (existing.isPresent()) return this;\n" + 
				"	final org.neo4j.graphdb.Node newNode = node.getGraphDatabase().createNode(org.neo4j.graphdb.Label.label(\"~type~\"));\n" + 
				"	newNode.setProperty(\"value\", dst.name());\n" + 
				"	node.createRelationshipTo(newNode, org.neo4j.graphdb.RelationshipType.withName(\"~name~\"));\n" + 
				"	~setStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.stream.Stream<~type~> get~name;format=\"capitalize\"~() { \n" + 
				"	return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName(\"~name~\")).spliterator(), false).map((relationship) -> ~type~.valueOf(relationship.getOtherNode(node).getProperty(\"value\").toString()));\n" + 
				"}\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ removeAll~name;format=\"capitalize\"~() { \n" + 
				"	node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName(\"~name~\")).forEach(org.neo4j.graphdb.Relationship::delete);\n" + 
				"	~removeStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	return this;\n" + 
				"} >>";
}  