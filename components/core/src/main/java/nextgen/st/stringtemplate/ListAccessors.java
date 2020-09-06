package nextgen.st.stringtemplate;

public class ListAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _entity;
	private Object _name;

	ListAccessors(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ListAccessors");
		st.add("entity", _entity);
		st.add("name", _name);
		return st.render().trim();
	}

	public ListAccessors setEntity(Object value) {
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

	public ListAccessors removeEntity() {
		this._entity = null;
		return this;
	} 

	public ListAccessors setName(Object value) {
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

	public ListAccessors removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ListAccessors that = (ListAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ListAccessors(entity,name) ::= <<public ~entity;format=\"capitalize\"~ add~name;format=\"capitalize\"~(String value) {\n" + 
				"	return add~name;format=\"capitalize\"~(db.newSTValue(value));\n" + 
				"}\n" + 
				"\n" + 
				"public ~entity;format=\"capitalize\"~ add~name;format=\"capitalize\"~(STValue value) {\n" + 
				"	return add(value, \"~name~\");\n" + 
				"}\n" + 
				"\n" + 
				"public Stream<STValue> get~name;format=\"capitalize\"~() {\n" + 
				"	return stream(\"~name~\");\n" + 
				"} >>";
}  