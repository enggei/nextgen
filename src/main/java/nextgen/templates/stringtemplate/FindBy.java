package nextgen.templates.stringtemplate;

public class FindBy {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _entity;

	FindBy(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FindBy");
		st.add("name", _name);
		st.add("entity", _entity);
		return st.render().trim();
	}

	public FindBy setName(Object value) {
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

	public FindBy removeName() {
		this._name = null;
		return this;
	} 

	public FindBy setEntity(Object value) {
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

	public FindBy removeEntity() {
		this._entity = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FindBy that = (FindBy) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FindBy(name,entity) ::= <<public Optional<~entity;format=\"capitalize\"~> find~entity;format=\"capitalize\"~By~name;format=\"capitalize\"~(STValue value) {\n" + 
				"	return value == null ? Optional.empty() : Optional.ofNullable(db.find(\"~name~\", value, ~entity;format=\"capitalize\"~.stTemplateUuid, ~entity;format=\"capitalize\"~::new));\n" + 
				"}\n" + 
				"\n" + 
				"public ~entity;format=\"capitalize\"~ findOrCreate~entity;format=\"capitalize\"~By~name;format=\"capitalize\"~(STValue value) {\n" + 
				"	return find~entity;format=\"capitalize\"~By~name;format=\"capitalize\"~(value).orElseGet(() -> new ~entity;format=\"capitalize\"~(db).set~name;format=\"capitalize\"~(value));\n" + 
				"} >>";
}  