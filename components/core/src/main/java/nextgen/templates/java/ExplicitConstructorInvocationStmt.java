package nextgen.templates.java;

public class ExplicitConstructorInvocationStmt {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _isThis;
	private java.util.List<Object> _arguments = new java.util.ArrayList<>();

	ExplicitConstructorInvocationStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ExplicitConstructorInvocationStmt");
		st.add("isThis", _isThis);
		for (Object o : _arguments) st.add("arguments", o);
		return st.render().trim();
	}

	public ExplicitConstructorInvocationStmt setIsThis(Object value) {
		this._isThis = value;
		return this;
	}

	public Object getIsThis() {
		return this._isThis;
	}

	public Object getIsThis(Object defaultValue) {
		return this._isThis == null ? defaultValue : this._isThis;
	}

	public boolean hasIsThis() {
		return this._isThis != null;
	}

	public ExplicitConstructorInvocationStmt removeIsThis() {
		this._isThis = null;
		return this;
	} 

	public ExplicitConstructorInvocationStmt addArguments(Object value) {
		this._arguments.add(value);
		return this;
	}

	public ExplicitConstructorInvocationStmt removeArguments(Object value) {
		this._arguments.remove(value);
		return this;
	}

	public ExplicitConstructorInvocationStmt removeArguments(int index) {
		this._arguments.remove(index);
		return this;
	}

	public java.util.List<Object> getArguments() {
		return this._arguments;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ExplicitConstructorInvocationStmt that = (ExplicitConstructorInvocationStmt) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ExplicitConstructorInvocationStmt(isThis,arguments) ::= <<~if(isThis)~this~else~super~endif~(~arguments:{it|~it~};separator=\", \"~);>> ";
}  