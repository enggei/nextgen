package nextgen.templates.java;

public class FieldAccessExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _scope;
	private Object _name;

	FieldAccessExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FieldAccessExpression that = (FieldAccessExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FieldAccessExpression");
		st.add("scope", _scope);
		st.add("name", _name);
		return st.render().trim();
	}

	public FieldAccessExpression setScope(Object value) {
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

	public FieldAccessExpression removeScope() {
		this._scope = null;
		return this;
	} 

	public FieldAccessExpression setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public FieldAccessExpression removeName() {
		this._name = null;
		return this;
	} 

	static final String st = "FieldAccessExpression(scope,name) ::= <<~if(scope)~~scope~.~endif~~name~>> ";
} 