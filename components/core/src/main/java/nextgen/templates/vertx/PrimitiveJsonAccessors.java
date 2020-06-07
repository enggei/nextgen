package nextgen.templates.vertx;

public class PrimitiveJsonAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _name;
	private Object _type;

	PrimitiveJsonAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PrimitiveJsonAccessors that = (PrimitiveJsonAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("primitiveJsonAccessors");
		st.add("className" ,_className);
		st.add("name" ,_name);
		st.add("type" ,_type);
		return st.render().trim();
	}

	public PrimitiveJsonAccessors setClassName(Object value) {
		this._className = value;
		return this;
	}

	public Object getClassName() {
		return this._className;
	}

	public boolean hasClassName() {
		return this._className != null;
	}

	public PrimitiveJsonAccessors removeClassName() {
		this._className = null;
		return this;
	} 

	public PrimitiveJsonAccessors setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public PrimitiveJsonAccessors removeName() {
		this._name = null;
		return this;
	} 

	public PrimitiveJsonAccessors setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public PrimitiveJsonAccessors removeType() {
		this._type = null;
		return this;
	} 

	static final String st = "primitiveJsonAccessors(className,name,type) ::= <<public ~className;format=\"capitalize\"~ set~name;format=\"capitalize\"~(~type~ value) { \n" + 
				"	jsonObject.put(\"~name~\", value);\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public ~type~ get~name;format=\"capitalize\"~() { \n" + 
				"	return jsonObject.get~type~(\"~name~\");\n" + 
				"}\n" + 
				"\n" + 
				"public ~type~ get~name;format=\"capitalize\"~(~type~ defaultValue) { \n" + 
				"	return jsonObject.get~type~(\"~name~\", defaultValue);\n" + 
				"}>> ";
} 