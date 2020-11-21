package nextgen.templates.nextgen;

public class EntityConstraints {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _entity;
	private java.util.List<Object> _deleteStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _constraints = new java.util.ArrayList<>();

	EntityConstraints(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EntityConstraints");
		st.add("entity", _entity);
		for (Object o : _deleteStatements) st.add("deleteStatements", o);
		for (Object o : _constraints) st.add("constraints", o);
		return st.render().trim();
	}

	public EntityConstraints setEntity(Object value) {
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

	public EntityConstraints removeEntity() {
		this._entity = null;
		return this;
	} 

	public EntityConstraints addDeleteStatements(Object value) {
		this._deleteStatements.add(value);
		return this;
	}

	public EntityConstraints setDeleteStatements(Object[] value) {
		this._deleteStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EntityConstraints setDeleteStatements(java.util.Collection<Object> values) {
		this._deleteStatements.addAll(values);
		return this;
	}

	public EntityConstraints removeDeleteStatements(Object value) {
		this._deleteStatements.remove(value);
		return this;
	}

	public EntityConstraints removeDeleteStatements(int index) {
		this._deleteStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getDeleteStatements() {
		return this._deleteStatements;
	} 

	public EntityConstraints addConstraints(Object value) {
		this._constraints.add(value);
		return this;
	}

	public EntityConstraints setConstraints(Object[] value) {
		this._constraints.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EntityConstraints setConstraints(java.util.Collection<Object> values) {
		this._constraints.addAll(values);
		return this;
	}

	public EntityConstraints removeConstraints(Object value) {
		this._constraints.remove(value);
		return this;
	}

	public EntityConstraints removeConstraints(int index) {
		this._constraints.remove(index);
		return this;
	}

	public java.util.List<Object> getConstraints() {
		return this._constraints;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EntityConstraints that = (EntityConstraints) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "EntityConstraints(deleteStatements,constraints,entity) ::= <<public static String canDelete(~entity~ entity) {\n" + 
				"	final StringBuilder constraints = new StringBuilder(\"\");\n" + 
				"	~constraints:{it|~it~};separator=\"\\n\"~\n" + 
				"	return constraints.toString().trim();\n" + 
				"}\n" + 
				"\n" + 
				"public static String delete(~entity~ entity) {\n" + 
				"	~deleteStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	return entity.getUuid();\n" + 
				"} >>";
}  