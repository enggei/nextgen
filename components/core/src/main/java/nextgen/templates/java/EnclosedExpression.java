package nextgen.templates.java;

public class EnclosedExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _expression;

	EnclosedExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EnclosedExpression that = (EnclosedExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EnclosedExpression");
		st.add("expression", _expression);
		return st.render().trim();
	}

	public EnclosedExpression setExpression(Object value) {
		this._expression = value;
		return this;
	}

	public Object getExpression() {
		return this._expression;
	}

	public boolean hasExpression() {
		return this._expression != null;
	}

	public EnclosedExpression removeExpression() {
		this._expression = null;
		return this;
	} 

	static final String st = "EnclosedExpression(expression) ::= <<(~expression~)>> ";
} 