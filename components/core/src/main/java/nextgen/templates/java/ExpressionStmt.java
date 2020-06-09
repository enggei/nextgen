package nextgen.templates.java;

public class ExpressionStmt {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _comment;
	private Object _expression;

	ExpressionStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
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

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ExpressionStmt");
		st.add("comment", _comment);
		st.add("expression", _expression);
		return st.render().trim();
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

	public ExpressionStmt setExpression(Object value) {
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

	public ExpressionStmt removeExpression() {
		this._expression = null;
		return this;
	} 

	static final String st = "ExpressionStmt(comment,expression) ::= <<~if(comment)~~comment~\n" + 
				"~endif~~expression~;>> ";
} 