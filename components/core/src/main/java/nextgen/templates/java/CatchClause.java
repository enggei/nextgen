package nextgen.templates.java;

public class CatchClause {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _parameter;
	private Object _body;

	CatchClause(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CatchClause");
		st.add("parameter", _parameter);
		st.add("body", _body);
		return st.render().trim();
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

	static final String st = "CatchClause(parameter,body) ::= <<catch (~parameter~) ~body~>> ";
}  