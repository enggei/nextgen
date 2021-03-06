package nextgen.templates.javaneo4jembedded;

public class PrimitiveOptionalAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _type;
	private Object _className;
	private String _name;
	private java.util.List<Object> _removeStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _setStatements = new java.util.ArrayList<>();

	PrimitiveOptionalAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("primitiveOptionalAccessors");
		st.add("type", _type);
		st.add("className", _className);
		st.add("name", _name);
		for (Object o : _removeStatements) st.add("removeStatements", o);
		for (Object o : _setStatements) st.add("setStatements", o);
		return st.render().trim();
	}

	public PrimitiveOptionalAccessors setType(Object value) {
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

	public PrimitiveOptionalAccessors removeType() {
		this._type = null;
		return this;
	} 

	public PrimitiveOptionalAccessors setClassName(Object value) {
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

	public PrimitiveOptionalAccessors removeClassName() {
		this._className = null;
		return this;
	} 

	public PrimitiveOptionalAccessors setName(String value) {
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

	public PrimitiveOptionalAccessors removeName() {
		this._name = null;
		return this;
	} 

	public PrimitiveOptionalAccessors addRemoveStatements(Object value) {
		this._removeStatements.add(value);
		return this;
	}

	public PrimitiveOptionalAccessors setRemoveStatements(Object[] value) {
		this._removeStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PrimitiveOptionalAccessors setRemoveStatements(java.util.Collection<Object> values) {
		this._removeStatements.addAll(values);
		return this;
	}

	public PrimitiveOptionalAccessors removeRemoveStatements(Object value) {
		this._removeStatements.remove(value);
		return this;
	}

	public PrimitiveOptionalAccessors removeRemoveStatements(int index) {
		this._removeStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getRemoveStatements() {
		return this._removeStatements;
	} 

	public PrimitiveOptionalAccessors addSetStatements(Object value) {
		this._setStatements.add(value);
		return this;
	}

	public PrimitiveOptionalAccessors setSetStatements(Object[] value) {
		this._setStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PrimitiveOptionalAccessors setSetStatements(java.util.Collection<Object> values) {
		this._setStatements.addAll(values);
		return this;
	}

	public PrimitiveOptionalAccessors removeSetStatements(Object value) {
		this._setStatements.remove(value);
		return this;
	}

	public PrimitiveOptionalAccessors removeSetStatements(int index) {
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
		PrimitiveOptionalAccessors that = (PrimitiveOptionalAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "primitiveOptionalAccessors(removeStatements,setStatements,type,className,name) ::= <<public static final String _~name~ = \"~name~\";\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ set~name;format=\"capitalize\"~(~type~ value) { \n" + 
				"	if (value == null) {\n" + 
				"		remove~name;format=\"capitalize\"~(); \n" + 
				"	} else {\n" + 
				"	 	node.setProperty(_~name~, value);\n" + 
				"	 	~setStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.Optional<~type~> get~name;format=\"capitalize\"~() { \n" + 
				"	if (node.hasProperty(_~name~)) return java.util.Optional.of((~type~) node.getProperty(_~name~));\n" + 
				"	return java.util.Optional.empty();\n" + 
				"}\n" + 
				"\n" + 
				"public ~type~ get~name;format=\"capitalize\"~(~type~ defaultValue) { \n" + 
				"	if (node.hasProperty(_~name~)) return (~type~) node.getProperty(_~name~);\n" + 
				"	return defaultValue;\n" + 
				"}\n" + 
				"\n" + 
				"public boolean has~name;format=\"capitalize\"~() { \n" + 
				"	return node.hasProperty(_~name~);\n" + 
				"}\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ remove~name;format=\"capitalize\"~() { \n" + 
				"	node.removeProperty(_~name~);\n" + 
				"	~removeStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	return this;\n" + 
				"} >>";
}  