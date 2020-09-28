package nextgen.templates.stringtemplate;

public class SingleAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _entity;
	private Object _name;

	SingleAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SingleAccessors");
		st.add("entity", _entity);
		st.add("name", _name);
		return st.render().trim();
	}

	public SingleAccessors setEntity(Object value) {
		this._entity = value;
		return this;
	}

	public Object getEntity() {
		return this._entity;
	}

	public Object getEntity(Object defaultValue) {
		return this._entity == null ? defaultValue : this._entity;
	}

	public boolean hasEntity() {
		return this._entity != null;
	}

	public SingleAccessors removeEntity() {
		this._entity = null;
		return this;
	} 

	public SingleAccessors setName(Object value) {
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

	public SingleAccessors removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SingleAccessors that = (SingleAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SingleAccessors(entity,name) ::= <<public ~entity;format=\"capitalize\"~ set~name;format=\"capitalize\"~(String value) {\n" + 
				"	return set~name;format=\"capitalize\"~(db.newSTValue(value));\n" + 
				"}\n" + 
				"\n" + 
				"public ~entity;format=\"capitalize\"~ set~name;format=\"capitalize\"~(STValue value) {\n" + 
				"	return set(value, \"~name~\");\n" + 
				"}\n" + 
				"\n" + 
				"public STValue get~name;format=\"capitalize\"~() {\n" + 
				"	return get(\"~name~\");\n" + 
				"}\n" + 
				"\n" + 
				"public STArgument get~name;format=\"capitalize\"~Argument() {\n" + 
				"	return getArgument(\"~name~\");\n" + 
				"}\n" + 
				"\n" + 
				"public ~entity;format=\"capitalize\"~ remove~name;format=\"capitalize\"~() {\n" + 
				"	return removeArgument(\"~name~\");\n" + 
				"} >>";
}  