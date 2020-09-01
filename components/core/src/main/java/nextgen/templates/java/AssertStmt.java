package nextgen.templates.java;

public class AssertStmt implements Statement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _message;
	private Object _expression;

	AssertStmt(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AssertStmt");
		st.add("message", _message);
		st.add("expression", _expression);
		return st.render().trim();
	}

	public AssertStmt setMessage(Object value) {
		this._message = value;
		return this;
	}

	public Object getMessage() {
		return this._message;
	}

	public Object getMessage(Object defaultValue) {
		return this._message == null ? defaultValue : this._message;
	}

	public boolean hasMessage() {
		return this._message != null;
	}

	public AssertStmt removeMessage() {
		this._message = null;
		return this;
	} 

	public AssertStmt setExpression(Object value) {
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

	public AssertStmt removeExpression() {
		this._expression = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AssertStmt that = (AssertStmt) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AssertStmt(message,expression) ::= <<assert ~expression~~if(message)~ : ~message~~endif~; >>";
}  