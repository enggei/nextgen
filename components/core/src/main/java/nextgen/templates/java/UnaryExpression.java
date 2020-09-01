package nextgen.templates.java;

public class UnaryExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _isPrefix;
	private Object _operator;
	private Object _expression;
	private Object _isPostfix;

	UnaryExpression(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("UnaryExpression");
		st.add("isPrefix", _isPrefix);
		st.add("operator", _operator);
		st.add("expression", _expression);
		st.add("isPostfix", _isPostfix);
		return st.render().trim();
	}

	public UnaryExpression setIsPrefix(Object value) {
		this._isPrefix = value;
		return this;
	}

	public Object getIsPrefix() {
		return this._isPrefix;
	}

	public Object getIsPrefix(Object defaultValue) {
		return this._isPrefix == null ? defaultValue : this._isPrefix;
	}

	public boolean hasIsPrefix() {
		return this._isPrefix != null;
	}

	public UnaryExpression removeIsPrefix() {
		this._isPrefix = null;
		return this;
	} 

	public UnaryExpression setOperator(Object value) {
		this._operator = value;
		return this;
	}

	public Object getOperator() {
		return this._operator;
	}

	public Object getOperator(Object defaultValue) {
		return this._operator == null ? defaultValue : this._operator;
	}

	public boolean hasOperator() {
		return this._operator != null;
	}

	public UnaryExpression removeOperator() {
		this._operator = null;
		return this;
	} 

	public UnaryExpression setExpression(Object value) {
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

	public UnaryExpression removeExpression() {
		this._expression = null;
		return this;
	} 

	public UnaryExpression setIsPostfix(Object value) {
		this._isPostfix = value;
		return this;
	}

	public Object getIsPostfix() {
		return this._isPostfix;
	}

	public Object getIsPostfix(Object defaultValue) {
		return this._isPostfix == null ? defaultValue : this._isPostfix;
	}

	public boolean hasIsPostfix() {
		return this._isPostfix != null;
	}

	public UnaryExpression removeIsPostfix() {
		this._isPostfix = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UnaryExpression that = (UnaryExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "UnaryExpression(isPrefix,operator,expression,isPostfix) ::= <<~if(isPrefix)~~operator~~endif~~expression~~if(isPostfix)~~operator~~endif~ >>";
}  