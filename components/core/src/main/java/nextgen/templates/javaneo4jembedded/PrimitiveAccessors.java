package nextgen.templates.javaneo4jembedded;

public class PrimitiveAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _className;
	private Object _type;

	PrimitiveAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
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

	static final String st = "primitiveAccessors(name,className,type) ::= <<private static final String _~name~ = \"~name~\";\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ set~name;format=\"capitalize\"~(~type~ value) { \n" + 
				"	if (value == null) node.removeProperty(_~name~); \n" + 
				"	else node.setProperty(_~name~, value);\n" + 
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
				"	return this;\n" + 
				"} >>";
}  