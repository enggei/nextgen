package nextgen.templates.javaswing;

public class EntityActions {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _entity;
	private java.util.List<Object> _actions = new java.util.ArrayList<>();

	EntityActions(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EntityActions");
		st.add("entity", _entity);
		for (Object o : _actions) st.add("actions", o);
		return st.render().trim();
	}

	public EntityActions setEntity(Object value) {
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

	public EntityActions removeEntity() {
		this._entity = null;
		return this;
	} 

	public EntityActions addActions(Object value) {
		this._actions.add(value);
		return this;
	}

	public EntityActions setActions(Object[] value) {
		this._actions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EntityActions setActions(java.util.Collection<Object> values) {
		this._actions.addAll(values);
		return this;
	}

	public EntityActions removeActions(Object value) {
		this._actions.remove(value);
		return this;
	}

	public EntityActions removeActions(int index) {
		this._actions.remove(index);
		return this;
	}

	public java.util.List<Object> getActions() {
		return this._actions;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EntityActions that = (EntityActions) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "EntityActions(entity,actions) ::= <<public List<Action> get~entity~Actions(List<Action> actions) {\n" + 
				"	~actions:{it|actions.add(new ~it~());};separator=\"\\n\"~\n" + 
				"	return actions;\n" + 
				"} >>";
}  