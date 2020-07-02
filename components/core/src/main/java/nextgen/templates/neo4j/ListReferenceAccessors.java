package nextgen.templates.neo4j;

public class ListReferenceAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _name;
	private Object _type;

	ListReferenceAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("listReferenceAccessors");
		st.add("className", _className);
		st.add("name", _name);
		st.add("type", _type);
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

	static final String st = "listReferenceAccessors(className,name,type) ::= <<public ~className;format=\"capitalize\"~ add~name;format=\"capitalize\"~(~type~ dst) { \n" + 
				"	final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName(\"~name~\")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();\n" + 
				"	if (existing.isPresent()) return this;\n" + 
				"	final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(dst.getNode(), org.neo4j.graphdb.RelationshipType.withName(\"~name~\"));\n" + 
				"	relationship.setProperty(\"_t\", System.nanoTime());\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.stream.Stream<~type~> get~name;format=\"capitalize\"~() { \n" + 
				"	return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName(\"~name~\")).spliterator(), false).map((relationship) -> new ~type~(relationship.getOtherNode(node)));\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.stream.Stream<~type~> get~name;format=\"capitalize\"~Sorted() { \n" + 
				"	return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName(\"~name~\")).spliterator(), false).sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty(\"_t\", o.getId()))).map((relationship) -> new ~type~(relationship.getOtherNode(node)));\n" + 
				"}\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ remove~name;format=\"capitalize\"~(~type~ dst) { \n" + 
				"	final java.util.Optional<org.neo4j.graphdb.Relationship> existing = java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName(\"~name~\")).spliterator(), false).filter((r) -> r.getOtherNode(node).equals(dst.getNode())).findAny();\n" + 
				"	existing.ifPresent(org.neo4j.graphdb.Relationship::delete);\n" + 
				"	return this;\n" + 
				"} >>";
}  