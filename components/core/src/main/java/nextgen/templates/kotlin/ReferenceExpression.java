package nextgen.templates.kotlin;

public class ReferenceExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _scope;
	private String _name;
	private Expression _property;

	ReferenceExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ReferenceExpression");
		st.add("scope", _scope);
		st.add("name", _name);
		st.add("property", _property);
		return st.render().trim();
	}

	public ReferenceExpression setScope(String value) {
		this._scope = value;
		return this;
	}

	public String getScope() {
		return this._scope;
	}

	public String getScope(String defaultValue) {
		return this._scope == null ? defaultValue : this._scope;
	}

	public boolean hasScope() {
		return this._scope != null;
	}

	public ReferenceExpression removeScope() {
		this._scope = null;
		return this;
	} 

	public ReferenceExpression setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public ReferenceExpression removeName() {
		this._name = null;
		return this;
	} 

	public ReferenceExpression setProperty(Expression value) {
		this._property = value;
		return this;
	}

	public Expression getProperty() {
		return this._property;
	}

	public Expression getProperty(Expression defaultValue) {
		return this._property == null ? defaultValue : this._property;
	}

	public boolean hasProperty() {
		return this._property != null;
	}

	public ReferenceExpression removeProperty() {
		this._property = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ReferenceExpression that = (ReferenceExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ReferenceExpression(scope,name,property) ::= <<~if(scope)~~scope~.~endif~~name~::~property~ >>";
}  