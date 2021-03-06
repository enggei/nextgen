package nextgen.templates.java;

public class ExpressionStmt implements Statement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Expression _expression;
	private Object _comment;

	ExpressionStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ExpressionStmt");
		st.add("expression", _expression);
		st.add("comment", _comment);
		return st.render().trim();
	}

	public ExpressionStmt setExpression(Expression value) {
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

	public ExpressionStmt removeExpression() {
		this._expression = null;
		return this;
	} 

	public ExpressionStmt setComment(Object value) {
		this._comment = value;
		return this;
	}

	public Object getComment() {
		return this._comment;
	}

	public Object getComment(Object defaultValue) {
		return this._comment == null ? defaultValue : this._comment;
	}

	public boolean hasComment() {
		return this._comment != null;
	}

	public ExpressionStmt removeComment() {
		this._comment = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ExpressionStmt that = (ExpressionStmt) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ExpressionStmt(expression,comment) ::= <<~if(comment)~//~comment~\n" + 
				"~endif~~expression~; >>";
}  