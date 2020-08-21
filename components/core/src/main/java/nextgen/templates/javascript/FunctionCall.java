package nextgen.templates.javascript;

public class FunctionCall {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _scope;
	private Object _name;
	private java.util.List<Object> _parameters = new java.util.ArrayList<>();

	FunctionCall(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("functionCall");
		st.add("scope", _scope);
		st.add("name", _name);
		for (Object o : _parameters) st.add("parameters", o);
		return st.render().trim();
	}

	public FunctionCall setScope(Object value) {
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

	public FunctionCall removeScope() {
		this._scope = null;
		return this;
	} 

	public FunctionCall setName(Object value) {
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

	public FunctionCall removeName() {
		this._name = null;
		return this;
	} 

	public FunctionCall addParameters(Object value) {
		this._parameters.add(value);
		return this;
	}

	public FunctionCall setParameters(Object[] value) {
		this._parameters.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FunctionCall setParameters(java.util.Collection<Object> values) {
		this._parameters.addAll(values);
		return this;
	}

	public FunctionCall removeParameters(Object value) {
		this._parameters.remove(value);
		return this;
	}

	public FunctionCall removeParameters(int index) {
		this._parameters.remove(index);
		return this;
	}

	public java.util.List<Object> getParameters() {
		return this._parameters;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FunctionCall that = (FunctionCall) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "functionCall(scope,name,parameters) ::= <<~if(scope)~~scope~.~endif~~name~(~parameters:{it|~it~};separator=\",\"~) >>";
}  