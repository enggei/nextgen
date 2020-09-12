package nextgen.templates.java;

public class BoundedReferenceAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _type;
	private Object _name;
	private Object _className;

	BoundedReferenceAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("boundedReferenceAccessors");
		st.add("type", _type);
		st.add("name", _name);
		st.add("className", _className);
		return st.render().trim();
	}

	public BoundedReferenceAccessors setType(Object value) {
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

	public BoundedReferenceAccessors removeType() {
		this._type = null;
		return this;
	} 

	public BoundedReferenceAccessors setName(Object value) {
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

	public BoundedReferenceAccessors removeName() {
		this._name = null;
		return this;
	} 

	public BoundedReferenceAccessors setClassName(Object value) {
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

	public BoundedReferenceAccessors removeClassName() {
		this._className = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BoundedReferenceAccessors that = (BoundedReferenceAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "boundedReferenceAccessors(type,name,className) ::= <<public ~type~ get~name;format=\"capitalize\"~() {\n" + 
				"	return this._~name~;\n" + 
				"}\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ set~name;format=\"capitalize\"~(~type~ value) {\n" + 
				"	~type~ oldValue = this._~name~;\n" + 
				"	if (oldValue != null) oldValue.removePropertyChangeListener(this);\n" + 
				"	this._~name~ = value;\n" + 
				"	if (value != null) value.addPropertyChangeListener(this);\n" + 
				"	this.pcs.firePropertyChange(\"~name~\", oldValue, value);\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ remove~name;format=\"capitalize\"~() {\n" + 
				"	~type~ oldValue = this._~name~;\n" + 
				"	this._~name~ = null;\n" + 
				"	if (oldValue != null) oldValue.removePropertyChangeListener(this);\n" + 
				"	this.pcs.firePropertyChange(\"~name~\", oldValue, null);\n" + 
				"	return this;\n" + 
				"} >>";
}  