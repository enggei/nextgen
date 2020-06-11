package nextgen.templates.java;

public class MethodReferenceExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _identifier;
	private Object _scope;

	MethodReferenceExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MethodReferenceExpression");
		st.add("identifier", _identifier);
		st.add("scope", _scope);
		return st.render().trim();
	}

	public MethodReferenceExpression setIdentifier(Object value) {
		this._identifier = value;
		return this;
	}

	public Object getIdentifier() {
		return this._identifier;
	}

	public Object getIdentifier(Object defaultValue) {
		return this._identifier == null ? defaultValue : this._identifier;
	}

	public boolean hasIdentifier() {
		return this._identifier != null;
	}

	public MethodReferenceExpression removeIdentifier() {
		this._identifier = null;
		return this;
	} 

	public MethodReferenceExpression setScope(Object value) {
		this._scope = value;
		return this;
	}

	public Object getScope() {
		return this._scope;
	}

	public Object getScope(Object defaultValue) {
		return this._scope == null ? defaultValue : this._scope;
	}

	public boolean hasScope() {
		return this._scope != null;
	}

	public MethodReferenceExpression removeScope() {
		this._scope = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MethodReferenceExpression that = (MethodReferenceExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MethodReferenceExpression(identifier,scope) ::= <<~scope~::~identifier~>> ";
}  