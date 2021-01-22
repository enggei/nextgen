package nextgen.templates.javaneo4jembedded;

public class NeoFactoryAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Boolean _useUUID;
	private Object _name;
	private java.util.List<Object> _properties = new java.util.ArrayList<>();
	private java.util.List<Object> _newInstanceStatements = new java.util.ArrayList<>();

	NeoFactoryAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NeoFactoryAccessors");
		st.add("useUUID", _useUUID);
		st.add("name", _name);
		for (Object o : _properties) st.add("properties", o);
		for (Object o : _newInstanceStatements) st.add("newInstanceStatements", o);
		return st.render().trim();
	}

	public NeoFactoryAccessors setUseUUID(Boolean value) {
		this._useUUID = value;
		return this;
	}

	public Boolean getUseUUID() {
		return this._useUUID;
	}

	public Boolean getUseUUID(Boolean defaultValue) {
		return this._useUUID == null ? defaultValue : this._useUUID;
	}

	public boolean hasUseUUID() {
		return this._useUUID != null;
	}

	public NeoFactoryAccessors removeUseUUID() {
		this._useUUID = null;
		return this;
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

	public NeoFactoryAccessors setProperties(Object[] value) {
		this._properties.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NeoFactoryAccessors setProperties(java.util.Collection<Object> values) {
		this._properties.addAll(values);
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

	public NeoFactoryAccessors addNewInstanceStatements(Object value) {
		this._newInstanceStatements.add(value);
		return this;
	}

	public NeoFactoryAccessors setNewInstanceStatements(Object[] value) {
		this._newInstanceStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NeoFactoryAccessors setNewInstanceStatements(java.util.Collection<Object> values) {
		this._newInstanceStatements.addAll(values);
		return this;
	}

	public NeoFactoryAccessors removeNewInstanceStatements(Object value) {
		this._newInstanceStatements.remove(value);
		return this;
	}

	public NeoFactoryAccessors removeNewInstanceStatements(int index) {
		this._newInstanceStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getNewInstanceStatements() {
		return this._newInstanceStatements;
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

	static final String st = "NeoFactoryAccessors(properties,newInstanceStatements,useUUID,name) ::= <<public static final org.neo4j.graphdb.Label ~name~Label = org.neo4j.graphdb.Label.label(\"~name~\");\n" + 
				"\n" + 
				"public static boolean is~name;format=\"capitalize\"~(org.neo4j.graphdb.Node node) {\n" + 
				"	return node != null && node.hasLabel(~name~Label);\n" + 
				"}\n" + 
				"\n" + 
				"public ~name;format=\"capitalize\"~ new~name;format=\"capitalize\"~() { \n" + 
				"	~name;format=\"capitalize\"~ newInstance = new~name;format=\"capitalize\"~(db.createNode(~name~Label));\n" + 
				"	~if(useUUID)~newInstance.setUuid(java.util.UUID.randomUUID().toString());~endif~\n" + 
				"	~newInstanceStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	return newInstance;\n" + 
				"}\n" + 
				"\n" + 
				"public ~name;format=\"capitalize\"~ new~name;format=\"capitalize\"~(org.neo4j.graphdb.Node node) { \n" + 
				"	return new ~name;format=\"capitalize\"~(node);\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.stream.Stream<~name;format=\"capitalize\"~> findAll~name;format=\"capitalize\"~() { \n" + 
				"	return db.findNodes(~name~Label).stream().map(this::new~name;format=\"capitalize\"~);\n" + 
				"}\n" + 
				"\n" + 
				"~properties:{it|~it~};separator=\"\\n\\n\"~ >>";
}  