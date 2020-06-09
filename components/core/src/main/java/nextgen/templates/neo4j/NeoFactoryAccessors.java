package nextgen.templates.neo4j;

public class NeoFactoryAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _properties = new java.util.ArrayList<>();

	NeoFactoryAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NeoFactoryAccessors that = (NeoFactoryAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NeoFactoryAccessors");
		st.add("name", _name);
		for (Object o : _properties) st.add("properties", o);
		return st.render().trim();
	}

	public NeoFactoryAccessors setName(Object value) {
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

	public NeoFactoryAccessors removeName() {
		this._name = null;
		return this;
	} 
	public NeoFactoryAccessors addProperties(Object value) {
		this._properties.add(value);
		return this;
	}

	public NeoFactoryAccessors removeProperties(Object value) {
		this._properties.remove(value);
		return this;
	}

	public NeoFactoryAccessors removeProperties(int index) {
		this._properties.remove(index);
		return this;
	}

	public java.util.List<Object> getProperties() {
		return this._properties;
	} 

	static final String st = "NeoFactoryAccessors(name,properties) ::= <<public ~name;format=\"capitalize\"~ new~name;format=\"capitalize\"~() { \n" + 
				"	return new~name;format=\"capitalize\"~(db.createNode(org.neo4j.graphdb.Label.label(\"~name~\")));\n" + 
				"}\n" + 
				"\n" + 
				"public ~name;format=\"capitalize\"~ new~name;format=\"capitalize\"~(org.neo4j.graphdb.Node node) { \n" + 
				"	return new ~name;format=\"capitalize\"~(node);\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.stream.Stream<~name;format=\"capitalize\"~> findAll~name;format=\"capitalize\"~() { \n" + 
				"	return db.findNodes(org.neo4j.graphdb.Label.label(\"~name~\")).stream().map(this::new~name;format=\"capitalize\"~);\n" + 
				"}\n" + 
				"\n" + 
				"~properties:{it|~it~};separator=\"\\n\\n\"~>> ";
} 