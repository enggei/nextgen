package nextgen.templates.java;

public class DoStmt implements Statement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _condition;
	private Object _body;

	DoStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DoStmt");
		st.add("condition", _condition);
		st.add("body", _body);
		return st.render().trim();
	}

	public DoStmt setCondition(Object value) {
		this._condition = value;
		return this;
	}

	public Object getCondition() {
		return this._condition;
	}

	public Object getCondition(Object defaultValue) {
		return this._condition == null ? defaultValue : this._condition;
	}

	public boolean hasCondition() {
		return this._condition != null;
	}

	public DoStmt removeCondition() {
		this._condition = null;
		return this;
	} 

	public DoStmt setBody(Object value) {
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

	public DoStmt removeBody() {
		this._body = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DoStmt that = (DoStmt) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DoStmt(condition,body) ::= <<do ~body~ while (~condition~); >>";
} 