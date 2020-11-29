package nextgen.templates.javaneo4jembedded;

public class EnumAccessors implements Accessor {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _className;
	private Object _type;
	private java.util.List<Object> _removeStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _setStatements = new java.util.ArrayList<>();

	EnumAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("enumAccessors");
		st.add("name", _name);
		st.add("className", _className);
		st.add("type", _type);
		for (Object o : _removeStatements) st.add("removeStatements", o);
		for (Object o : _setStatements) st.add("setStatements", o);
		return st.render().trim();
	}

	public EnumAccessors setName(Object value) {
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

	public EnumAccessors removeName() {
		this._name = null;
		return this;
	} 

	public EnumAccessors setClassName(Object value) {
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

	public EnumAccessors removeClassName() {
		this._className = null;
		return this;
	} 

	public EnumAccessors setType(Object value) {
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

	public EnumAccessors removeType() {
		this._type = null;
		return this;
	} 

	public EnumAccessors addRemoveStatements(Object value) {
		this._removeStatements.add(value);
		return this;
	}

	public EnumAccessors setRemoveStatements(Object[] value) {
		this._removeStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EnumAccessors setRemoveStatements(java.util.Collection<Object> values) {
		this._removeStatements.addAll(values);
		return this;
	}

	public EnumAccessors removeRemoveStatements(Object value) {
		this._removeStatements.remove(value);
		return this;
	}

	public EnumAccessors removeRemoveStatements(int index) {
		this._removeStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getRemoveStatements() {
		return this._removeStatements;
	} 

	public EnumAccessors addSetStatements(Object value) {
		this._setStatements.add(value);
		return this;
	}

	public EnumAccessors setSetStatements(Object[] value) {
		this._setStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EnumAccessors setSetStatements(java.util.Collection<Object> values) {
		this._setStatements.addAll(values);
		return this;
	}

	public EnumAccessors removeSetStatements(Object value) {
		this._setStatements.remove(value);
		return this;
	}

	public EnumAccessors removeSetStatements(int index) {
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
		EnumAccessors that = (EnumAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "enumAccessors(removeStatements,name,className,setStatements,type) ::= <<public ~className;format=\"capitalize\"~ set~name;format=\"capitalize\"~(~type~ value) {\n" + 
				"	if (value == null) \n" + 
				"		remove~name;format=\"capitalize\"~(); \n" + 
				"	else {\n" + 
				"	 	node.setProperty(\"~name~\", value.name());\n" + 
				"	 	~setStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	} \n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public ~type~ get~name;format=\"capitalize\"~() { \n" + 
				"	if (node.hasProperty(\"~name~\")) return ~type~.valueOf((java.lang.String) node.getProperty(\"~name~\"));\n" + 
				"	return null;\n" + 
				"}\n" + 
				"\n" + 
				"public ~type~ get~name;format=\"capitalize\"~(~type~ defaultValue) { \n" + 
				"	if (node.hasProperty(\"~name~\")) return ~type~.valueOf((java.lang.String) node.getProperty(\"~name~\"));\n" + 
				"	return defaultValue;\n" + 
				"}\n" + 
				"\n" + 
				"public boolean has~name;format=\"capitalize\"~() { \n" + 
				"	return node.hasProperty(\"~name~\");\n" + 
				"}\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ remove~name;format=\"capitalize\"~() { \n" + 
				"	node.removeProperty(\"~name~\");\n" + 
				"	~removeStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	return this;\n" + 
				"} >>";
}  