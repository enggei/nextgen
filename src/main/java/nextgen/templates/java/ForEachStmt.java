package nextgen.templates.java;

public class ForEachStmt implements Statement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _variable;
	private Object _iterable;
	private Object _body;

	ForEachStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ForEachStmt");
		st.add("variable", _variable);
		st.add("iterable", _iterable);
		st.add("body", _body);
		return st.render().trim();
	}

	public ForEachStmt setVariable(Object value) {
		this._variable = value;
		return this;
	}

	public Object getVariable() {
		return this._variable;
	}

	public Object getVariable(Object defaultValue) {
		return this._variable == null ? defaultValue : this._variable;
	}

	public boolean hasVariable() {
		return this._variable != null;
	}

	public ForEachStmt removeVariable() {
		this._variable = null;
		return this;
	} 

	public ForEachStmt setIterable(Object value) {
		this._iterable = value;
		return this;
	}

	public Object getIterable() {
		return this._iterable;
	}

	public Object getIterable(Object defaultValue) {
		return this._iterable == null ? defaultValue : this._iterable;
	}

	public boolean hasIterable() {
		return this._iterable != null;
	}

	public ForEachStmt removeIterable() {
		this._iterable = null;
		return this;
	} 

	public ForEachStmt setBody(Object value) {
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

	public ForEachStmt removeBody() {
		this._body = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ForEachStmt that = (ForEachStmt) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ForEachStmt(variable,iterable,body) ::= <<for (~variable~ : ~iterable~) ~body~ >>";
}  