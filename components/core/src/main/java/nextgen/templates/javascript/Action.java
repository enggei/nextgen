package nextgen.templates.javascript;

public class Action {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _params = new java.util.ArrayList<>();
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	Action(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Action");
		st.add("name", _name);
		for (Object o : _params) st.add("params", o);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public Action setName(Object value) {
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

	public Action removeName() {
		this._name = null;
		return this;
	}

	public Action addParams(Object value) {
		this._params.add(value);
		return this;
	}

	public Action setParams(Object[] value) {
		this._params.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Action setParams(java.util.Collection<Object> values) {
		this._params.addAll(values);
		return this;
	}

	public Action removeParams(Object value) {
		this._params.remove(value);
		return this;
	}

	public Action removeParams(int index) {
		this._params.remove(index);
		return this;
	}

	public java.util.List<Object> getParams() {
		return this._params;
	}

	public Action addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public Action setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Action setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public Action removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public Action removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Action that = (Action) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Action(name,params,statements) ::= <<@action ~name~(~params:{it|~it~};separator=\",\"~) {\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"}>>";
}