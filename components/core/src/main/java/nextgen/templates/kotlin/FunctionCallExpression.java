package nextgen.templates.kotlin;

public class FunctionCallExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _scope;
	private String _functionName;
	private java.util.List<Expression> _arguments = new java.util.ArrayList<>();

	FunctionCallExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FunctionCallExpression");
		st.add("scope", _scope);
		st.add("functionName", _functionName);
		for (Object o : _arguments) st.add("arguments", o);
		return st.render().trim();
	}

	public FunctionCallExpression setScope(String value) {
		this._scope = value;
		return this;
	}

	public String getScope() {
		return this._scope;
	}

	public String getScope(String defaultValue) {
		return this._scope == null ? defaultValue : this._scope;
	}

	public boolean hasScope() {
		return this._scope != null;
	}

	public FunctionCallExpression removeScope() {
		this._scope = null;
		return this;
	} 

	public FunctionCallExpression setFunctionName(String value) {
		this._functionName = value;
		return this;
	}

	public String getFunctionName() {
		return this._functionName;
	}

	public String getFunctionName(String defaultValue) {
		return this._functionName == null ? defaultValue : this._functionName;
	}

	public boolean hasFunctionName() {
		return this._functionName != null;
	}

	public FunctionCallExpression removeFunctionName() {
		this._functionName = null;
		return this;
	} 

	public FunctionCallExpression addArguments(Expression value) {
		this._arguments.add(value);
		return this;
	}

	public FunctionCallExpression setArguments(Expression[] value) {
		this._arguments.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FunctionCallExpression setArguments(java.util.Collection<Expression> values) {
		this._arguments.addAll(values);
		return this;
	}

	public FunctionCallExpression removeArguments(Expression value) {
		this._arguments.remove(value);
		return this;
	}

	public FunctionCallExpression removeArguments(int index) {
		this._arguments.remove(index);
		return this;
	}

	public java.util.List<Expression> getArguments() {
		return this._arguments;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FunctionCallExpression that = (FunctionCallExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FunctionCallExpression(scope,functionName,arguments) ::= <<~if(scope)~~scope~.~endif~~functionName~(~arguments:{it|~it~};separator=\", \"~) >>";
}  