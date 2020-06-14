package nextgen.templates.neo4j;

public class EnumAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _name;
	private Object _type;

	EnumAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("enumAccessors");
		st.add("className", _className);
		st.add("name", _name);
		st.add("type", _type);
		return st.render().trim();
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

	static final String st = "enumAccessors(className,name,type) ::= <<public ~className;format=\"capitalize\"~ set~name;format=\"capitalize\"~(~type~ value) { \n" + 
				"	if (value == null) node.removeProperty(\"~name~\"); \n" + 
				"	else node.setProperty(\"~name~\", value.name());\n" + 
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
				"	return this;\n" + 
				"} >>";
} 