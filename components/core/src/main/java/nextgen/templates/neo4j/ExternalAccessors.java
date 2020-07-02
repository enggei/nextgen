package nextgen.templates.neo4j;

public class ExternalAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _name;
	private Object _type;

	ExternalAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("externalAccessors");
		st.add("className", _className);
		st.add("name", _name);
		st.add("type", _type);
		return st.render().trim();
	}

	public ExternalAccessors setClassName(Object value) {
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

	public ExternalAccessors removeClassName() {
		this._className = null;
		return this;
	} 

	public ExternalAccessors setName(Object value) {
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

	public ExternalAccessors removeName() {
		this._name = null;
		return this;
	} 

	public ExternalAccessors setType(Object value) {
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

	public ExternalAccessors removeType() {
		this._type = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ExternalAccessors that = (ExternalAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "externalAccessors(className,name,type) ::= <<public ~className;format=\"capitalize\"~ set~name;format=\"capitalize\"~(~type~ value) { \n" + 
				"	this._~name~ = value;\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public ~type~ get~name;format=\"capitalize\"~() { \n" + 
				"	return this._~name~;\n" + 
				"}\n" + 
				"\n" + 
				"public ~type~ get~name;format=\"capitalize\"~(~type~ defaultValue) { \n" + 
				"	return this._~name~ == null ? defaultValue : this._~name~;\n" + 
				"} >>";
}  