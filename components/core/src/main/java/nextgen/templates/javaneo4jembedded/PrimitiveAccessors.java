package nextgen.templates.javaneo4jembedded;

public class PrimitiveAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _className;
	private Object _type;
	private java.util.List<Object> _setStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _removeStatements = new java.util.ArrayList<>();

	PrimitiveAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("primitiveAccessors");
		st.add("name", _name);
		st.add("className", _className);
		st.add("type", _type);
		for (Object o : _setStatements) st.add("setStatements", o);
		for (Object o : _removeStatements) st.add("removeStatements", o);
		return st.render().trim();
	}

	public PrimitiveAccessors setName(Object value) {
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

	public PrimitiveAccessors removeName() {
		this._name = null;
		return this;
	} 

	public PrimitiveAccessors setClassName(Object value) {
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

	public PrimitiveAccessors removeClassName() {
		this._className = null;
		return this;
	} 

	public PrimitiveAccessors setType(Object value) {
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

	public PrimitiveAccessors removeType() {
		this._type = null;
		return this;
	} 

	public PrimitiveAccessors addSetStatements(Object value) {
		this._setStatements.add(value);
		return this;
	}

	public PrimitiveAccessors setSetStatements(Object[] value) {
		this._setStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PrimitiveAccessors setSetStatements(java.util.Collection<Object> values) {
		this._setStatements.addAll(values);
		return this;
	}

	public PrimitiveAccessors removeSetStatements(Object value) {
		this._setStatements.remove(value);
		return this;
	}

	public PrimitiveAccessors removeSetStatements(int index) {
		this._setStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getSetStatements() {
		return this._setStatements;
	} 

	public PrimitiveAccessors addRemoveStatements(Object value) {
		this._removeStatements.add(value);
		return this;
	}

	public PrimitiveAccessors setRemoveStatements(Object[] value) {
		this._removeStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PrimitiveAccessors setRemoveStatements(java.util.Collection<Object> values) {
		this._removeStatements.addAll(values);
		return this;
	}

	public PrimitiveAccessors removeRemoveStatements(Object value) {
		this._removeStatements.remove(value);
		return this;
	}

	public PrimitiveAccessors removeRemoveStatements(int index) {
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
		PrimitiveAccessors that = (PrimitiveAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "primitiveAccessors(name,className,type,setStatements,removeStatements) ::= <<private static final String _~name~ = \"~name~\";\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ set~name;format=\"capitalize\"~(~type~ value) { \n" + 
				"	if (value == null) \n" + 
				"		remove~name;format=\"capitalize\"~(); \n" + 
				"	else {\n" + 
				"	 	node.setProperty(_~name~, value);\n" + 
				"	 	~setStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public ~type~ get~name;format=\"capitalize\"~() { \n" + 
				"	if (node.hasProperty(_~name~)) return (~type~) node.getProperty(_~name~);\n" + 
				"	return null;\n" + 
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