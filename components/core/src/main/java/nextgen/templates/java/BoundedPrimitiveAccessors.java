package nextgen.templates.java;

public class BoundedPrimitiveAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _type;
	private Object _name;
	private Object _className;

	BoundedPrimitiveAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("boundedPrimitiveAccessors");
		st.add("type", _type);
		st.add("name", _name);
		st.add("className", _className);
		return st.render().trim();
	}

	public BoundedPrimitiveAccessors setType(Object value) {
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

	public BoundedPrimitiveAccessors removeType() {
		this._type = null;
		return this;
	} 

	public BoundedPrimitiveAccessors setName(Object value) {
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

	public BoundedPrimitiveAccessors removeName() {
		this._name = null;
		return this;
	} 

	public BoundedPrimitiveAccessors setClassName(Object value) {
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

	public BoundedPrimitiveAccessors removeClassName() {
		this._className = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BoundedPrimitiveAccessors that = (BoundedPrimitiveAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "boundedPrimitiveAccessors(type,name,className) ::= <<public ~type~ get~name;format=\"capitalize\"~() {\n" + 
				"	return this._~name~;\n" + 
				"}\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ set~name;format=\"capitalize\"~(~type~ value) {\n" + 
				"	~type~ oldValue = this._~name~;\n" + 
				"	this._~name~ = value;\n" + 
				"	this.pcs.firePropertyChange(\"~name~\", oldValue, value);\n" + 
				"	return this;\n" + 
				"} >>";
}  