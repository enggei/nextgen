package nextgen.templates.kotlin;

public class FunctionCallParamExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _fieldName;
	private Expression _expression;

	FunctionCallParamExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FunctionCallParamExpression");
		st.add("fieldName", _fieldName);
		st.add("expression", _expression);
		return st.render().trim();
	}

	public FunctionCallParamExpression setFieldName(String value) {
		this._fieldName = value;
		return this;
	}

	public String getFieldName() {
		return this._fieldName;
	}

	public String getFieldName(String defaultValue) {
		return this._fieldName == null ? defaultValue : this._fieldName;
	}

	public boolean hasFieldName() {
		return this._fieldName != null;
	}

	public FunctionCallParamExpression removeFieldName() {
		this._fieldName = null;
		return this;
	} 

	public FunctionCallParamExpression setExpression(Expression value) {
		this._expression = value;
		return this;
	}

	public Expression getExpression() {
		return this._expression;
	}

	public Expression getExpression(Expression defaultValue) {
		return this._expression == null ? defaultValue : this._expression;
	}

	public boolean hasExpression() {
		return this._expression != null;
	}

	public FunctionCallParamExpression removeExpression() {
		this._expression = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FunctionCallParamExpression that = (FunctionCallParamExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FunctionCallParamExpression(fieldName,expression) ::= <<~fieldName~ = ~expression~ >>";
} 