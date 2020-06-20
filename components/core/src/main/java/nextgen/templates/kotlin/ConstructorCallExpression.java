package nextgen.templates.kotlin;

public class ConstructorCallExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _className;
	private java.util.List<java.util.Collection<FunctionCallParamExpression>> _params = new java.util.ArrayList<>();

	ConstructorCallExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ConstructorCallExpression");
		st.add("className", _className);
		for (Object o : _params) st.add("params", o);
		return st.render().trim();
	}

	public ConstructorCallExpression setClassName(String value) {
		this._className = value;
		return this;
	}

	public String getClassName() {
		return this._className;
	}

	public String getClassName(String defaultValue) {
		return this._className == null ? defaultValue : this._className;
	}

	public boolean hasClassName() {
		return this._className != null;
	}

	public ConstructorCallExpression removeClassName() {
		this._className = null;
		return this;
	} 

	public ConstructorCallExpression addParams(java.util.Collection<FunctionCallParamExpression> value) {
		this._params.add(value);
		return this;
	}

	public ConstructorCallExpression setParams(java.util.Collection<FunctionCallParamExpression>[] value) {
		this._params.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ConstructorCallExpression setParams(java.util.Collection<java.util.Collection<FunctionCallParamExpression>> values) {
		this._params.addAll(values);
		return this;
	}

	public ConstructorCallExpression removeParams(java.util.Collection<FunctionCallParamExpression> value) {
		this._params.remove(value);
		return this;
	}

	public ConstructorCallExpression removeParams(int index) {
		this._params.remove(index);
		return this;
	}

	public java.util.List<java.util.Collection<FunctionCallParamExpression>> getParams() {
		return this._params;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ConstructorCallExpression that = (ConstructorCallExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ConstructorCallExpression(className,params) ::= <<~className~(~params:{it|~it~};separator=\", \"~) >>";
} 