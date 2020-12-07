package nextgen.templates.java;

public class SynchronizedStmt implements Statement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _body;
	private Object _expression;

	SynchronizedStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SynchronizedStmt");
		st.add("body", _body);
		st.add("expression", _expression);
		return st.render().trim();
	}

	public SynchronizedStmt setBody(Object value) {
		this._body = value;
		return this;
	}

	public Object getBody() {
		return this._body;
	}

	public Object getBody(Object defaultValue) {
		return this._body == null ? defaultValue : this._body;
	}

	public boolean hasBody() {
		return this._body != null;
	}

	public SynchronizedStmt removeBody() {
		this._body = null;
		return this;
	} 

	public SynchronizedStmt setExpression(Object value) {
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

	public SynchronizedStmt removeExpression() {
		this._expression = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SynchronizedStmt that = (SynchronizedStmt) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SynchronizedStmt(body,expression) ::= <<synchronized ( ~expression~ ) ~body~ >>";
}  