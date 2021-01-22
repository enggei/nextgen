package nextgen.templates.javaneo4jembedded;

public class ListReferenceAccessors implements Accessor {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _name;
	private Object _type;
	private java.util.List<Object> _setStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _removeStatements = new java.util.ArrayList<>();

	ListReferenceAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("listReferenceAccessors");
		st.add("className", _className);
		st.add("name", _name);
		st.add("type", _type);
		for (Object o : _setStatements) st.add("setStatements", o);
		for (Object o : _removeStatements) st.add("removeStatements", o);
		return st.render().trim();
	}

	public ListReferenceAccessors setClassName(Object value) {
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

	public ListReferenceAccessors removeClassName() {
		this._className = null;
		return this;
	} 

	public ListReferenceAccessors setName(Object value) {
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

	public ListReferenceAccessors removeName() {
		this._name = null;
		return this;
	} 

	public ListReferenceAccessors setType(Object value) {
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

	public ListReferenceAccessors removeType() {
		this._type = null;
		return this;
	} 

	public ListReferenceAccessors addSetStatements(Object value) {
		this._setStatements.add(value);
		return this;
	}

	public ListReferenceAccessors setSetStatements(Object[] value) {
		this._setStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ListReferenceAccessors setSetStatements(java.util.Collection<Object> values) {
		this._setStatements.addAll(values);
		return this;
	}

	public ListReferenceAccessors removeSetStatements(Object value) {
		this._setStatements.remove(value);
		return this;
	}

	public ListReferenceAccessors removeSetStatements(int index) {
		this._setStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getSetStatements() {
		return this._setStatements;
	} 

	public ListReferenceAccessors addRemoveStatements(Object value) {
		this._removeStatements.add(value);
		return this;
	}

	public ListReferenceAccessors setRemoveStatements(Object[] value) {
		this._removeStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ListReferenceAccessors setRemoveStatements(java.util.Collection<Object> values) {
		this._removeStatements.addAll(values);
		return this;
	}

	public ListReferenceAccessors removeRemoveStatements(Object value) {
		this._removeStatements.remove(value);
		return this;
	}

	public ListReferenceAccessors removeRemoveStatements(int index) {
		this._removeStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getRemoveStatements() {
		return this._removeStatements;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ListReferenceAccessors that = (ListReferenceAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "listReferenceAccessors(className,name,setStatements,removeStatements,type) ::= <<public static final org.neo4j.graphdb.RelationshipType _~name~ = org.neo4j.graphdb.RelationshipType.withName(\"~name~\");\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ add~name;format=\"capitalize\"~(~type~ dst) { \n" + 
				"	final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _~name~).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();\n" + 
				"	if (existing.isPresent()) return this;\n" + 
				"	final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), _~name~);\n" + 
				"	relationship.setProperty(\"_t\", System.nanoTime());\n" + 
				"	~setStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.stream.Stream<~type~> get~name;format=\"capitalize\"~() { \n" + 
				"	return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _~name~).spliterator(), false).map((relationship) -> new ~type~(relationship.getOtherNode(node)));\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.stream.Stream<~type~> get~name;format=\"capitalize\"~Sorted() { \n" + 
				"	return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _~name~).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty(\"_t\"))).map((relationship) -> new ~type~(relationship.getOtherNode(node)));\n" + 
				"}\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ remove~name;format=\"capitalize\"~(~type~ dst) { \n" + 
				"	final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _~name~).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();\n" + 
				"	existing.ifPresent(org.neo4j.graphdb.Relationship::delete);\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ removeAll~name;format=\"capitalize\"~() { \n" + 
				"	node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, _~name~).forEach(org.neo4j.graphdb.Relationship::delete);\n" + 
				"	~removeStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	return this;\n" + 
				"} >>";
}  