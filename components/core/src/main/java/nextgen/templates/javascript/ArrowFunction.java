package nextgen.templates.javascript;

public class ArrowFunction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _expression;
	private java.util.List<Object> _params = new java.util.ArrayList<>();
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	ArrowFunction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ArrowFunction");
		st.add("expression", _expression);
		for (Object o : _params) st.add("params", o);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public ArrowFunction setExpression(Object value) {
		this._expression = value;
		return this;
	}

	public Object getExpression() {
		return this._expression;
	}

	public Object getExpression(Object defaultValue) {
		return this._expression == null ? defaultValue : this._expression;
	}

	public boolean hasExpression() {
		return this._expression != null;
	}

	public ArrowFunction removeExpression() {
		this._expression = null;
		return this;
	} 

	public ArrowFunction addParams(Object value) {
		this._params.add(value);
		return this;
	}

	public ArrowFunction setParams(Object[] value) {
		this._params.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ArrowFunction setParams(java.util.Collection<Object> values) {
		this._params.addAll(values);
		return this;
	}

	public ArrowFunction removeParams(Object value) {
		this._params.remove(value);
		return this;
	}

	public ArrowFunction removeParams(int index) {
		this._params.remove(index);
		return this;
	}

	public java.util.List<Object> getParams() {
		return this._params;
	} 

	public ArrowFunction addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public ArrowFunction setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ArrowFunction setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public ArrowFunction removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public ArrowFunction removeStatements(int index) {
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
		ArrowFunction that = (ArrowFunction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ArrowFunction(params,expression,statements) ::= <<(~params:{it|~it~};separator=\",\"~) => ~if(expression)~~expression~~else~{\n" + 
				"		~statements:{it|~it~};separator=\"\\n\"~ \n" + 
				"	}~endif~ >>";
}  