package nextgen.templates.java;

public class MethodCallExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _scope;
	private Object _name;
	private java.util.List<Object> _arguments = new java.util.ArrayList<>();
	private java.util.List<Object> _typeArguments = new java.util.ArrayList<>();

	MethodCallExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MethodCallExpression");
		st.add("scope", _scope);
		st.add("name", _name);
		for (Object o : _arguments) st.add("arguments", o);
		for (Object o : _typeArguments) st.add("typeArguments", o);
		return st.render().trim();
	}

	public MethodCallExpression setScope(Object value) {
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

	public MethodCallExpression removeScope() {
		this._scope = null;
		return this;
	} 

	public MethodCallExpression setName(Object value) {
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

	public MethodCallExpression removeName() {
		this._name = null;
		return this;
	} 

	public MethodCallExpression addArguments(Object value) {
		this._arguments.add(value);
		return this;
	}

	public MethodCallExpression setArguments(Object[] value) {
		this._arguments.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MethodCallExpression setArguments(java.util.Collection<Object> values) {
		this._arguments.addAll(values);
		return this;
	}

	public MethodCallExpression removeArguments(Object value) {
		this._arguments.remove(value);
		return this;
	}

	public MethodCallExpression removeArguments(int index) {
		this._arguments.remove(index);
		return this;
	}

	public java.util.List<Object> getArguments() {
		return this._arguments;
	} 

	public MethodCallExpression addTypeArguments(Object value) {
		this._typeArguments.add(value);
		return this;
	}

	public MethodCallExpression setTypeArguments(Object[] value) {
		this._typeArguments.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MethodCallExpression setTypeArguments(java.util.Collection<Object> values) {
		this._typeArguments.addAll(values);
		return this;
	}

	public MethodCallExpression removeTypeArguments(Object value) {
		this._typeArguments.remove(value);
		return this;
	}

	public MethodCallExpression removeTypeArguments(int index) {
		this._typeArguments.remove(index);
		return this;
	}

	public java.util.List<Object> getTypeArguments() {
		return this._typeArguments;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MethodCallExpression that = (MethodCallExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MethodCallExpression(scope,arguments,typeArguments,name) ::= <<~if(scope)~~scope~.~endif~~if(typeArguments)~<~typeArguments:{it|~it~};separator=\",\"~>~endif~~name~(~arguments:{it|~it~};separator=\", \"~) >>";
}  