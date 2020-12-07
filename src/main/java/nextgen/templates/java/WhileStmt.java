package nextgen.templates.java;

public class WhileStmt implements Statement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _body;
	private Expression _condition;

	WhileStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("WhileStmt");
		st.add("body", _body);
		st.add("condition", _condition);
		return st.render().trim();
	}

	public WhileStmt setBody(Object value) {
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

	public WhileStmt removeBody() {
		this._body = null;
		return this;
	} 

	public WhileStmt setCondition(Expression value) {
		this._condition = value;
		return this;
	}

	public Expression getCondition() {
		return this._condition;
	}

	public Expression getCondition(Expression defaultValue) {
		return this._condition == null ? defaultValue : this._condition;
	}

	public boolean hasCondition() {
		return this._condition != null;
	}

	public WhileStmt removeCondition() {
		this._condition = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WhileStmt that = (WhileStmt) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "WhileStmt(body,condition) ::= <<while (~condition~) ~body~ >>";
}  