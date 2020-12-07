package nextgen.templates.java;

public class CatchClause implements Statement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _body;
	private Object _parameter;

	CatchClause(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CatchClause");
		st.add("body", _body);
		st.add("parameter", _parameter);
		return st.render().trim();
	}

	public CatchClause setBody(Object value) {
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

	public CatchClause removeBody() {
		this._body = null;
		return this;
	} 

	public CatchClause setParameter(Object value) {
		this._parameter = value;
		return this;
	}

	public Object getParameter() {
		return this._parameter;
	}

	public Object getParameter(Object defaultValue) {
		return this._parameter == null ? defaultValue : this._parameter;
	}

	public boolean hasParameter() {
		return this._parameter != null;
	}

	public CatchClause removeParameter() {
		this._parameter = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CatchClause that = (CatchClause) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CatchClause(body,parameter) ::= <<catch (~parameter~) ~body~ >>";
}  