package nextgen.templates.java;

public class BoundedListReferenceAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _name;
	private Object _type;

	BoundedListReferenceAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("boundedListReferenceAccessors");
		st.add("className", _className);
		st.add("name", _name);
		st.add("type", _type);
		return st.render().trim();
	}

	public BoundedListReferenceAccessors setClassName(Object value) {
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

	public BoundedListReferenceAccessors removeClassName() {
		this._className = null;
		return this;
	} 

	public BoundedListReferenceAccessors setName(Object value) {
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

	public BoundedListReferenceAccessors removeName() {
		this._name = null;
		return this;
	} 

	public BoundedListReferenceAccessors setType(Object value) {
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

	public BoundedListReferenceAccessors removeType() {
		this._type = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BoundedListReferenceAccessors that = (BoundedListReferenceAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "boundedListReferenceAccessors(className,name,type) ::= <<public java.util.List<~type~> get~name;format=\"capitalize\"~() {\n" + 
				"	return this._~name~;\n" + 
				"}\n" + 
				"\n" + 
				"public ~className~ add~name;format=\"capitalize\"~(~type~ value) {\n" + 
				"	this._~name~.add(value);\n" + 
				"	if (value != null) value.addPropertyChangeListener(this);\n" + 
				"	this.pcs.firePropertyChange(\"add.~name~\", null, value);\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public ~className~ remove~name;format=\"capitalize\"~(~type~ value) {\n" + 
				"	this._~name~.remove(value);\n" + 
				"	if (value != null) value.removePropertyChangeListener(this);\n" + 
				"	this.pcs.firePropertyChange(\"remove.~name~\", value, null);\n" + 
				"	return this;\n" + 
				"} >>";
}  