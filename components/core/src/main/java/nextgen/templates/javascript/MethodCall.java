package nextgen.templates.javascript;

public class MethodCall {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _scope;
	private Object _name;
	private Object _catch;
	private Object _finally;
	private java.util.List<Object> _arguments = new java.util.ArrayList<>();
	private java.util.List<Object> _then = new java.util.ArrayList<>();

	MethodCall(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("methodCall");
		st.add("scope", _scope);
		st.add("name", _name);
		st.add("catch", _catch);
		st.add("finally", _finally);
		for (Object o : _arguments) st.add("arguments", o);
		for (Object o : _then) st.add("then", o);
		return st.render().trim();
	}

	public MethodCall setScope(Object value) {
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

	public MethodCall removeScope() {
		this._scope = null;
		return this;
	} 

	public MethodCall setName(Object value) {
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

	public MethodCall removeName() {
		this._name = null;
		return this;
	} 

	public MethodCall setCatch(Object value) {
		this._catch = value;
		return this;
	}

	public Object getCatch() {
		return this._catch;
	}

	public Object getCatch(Object defaultValue) {
		return this._catch == null ? defaultValue : this._catch;
	}

	public boolean hasCatch() {
		return this._catch != null;
	}

	public MethodCall removeCatch() {
		this._catch = null;
		return this;
	} 

	public MethodCall setFinally(Object value) {
		this._finally = value;
		return this;
	}

	public Object getFinally() {
		return this._finally;
	}

	public Object getFinally(Object defaultValue) {
		return this._finally == null ? defaultValue : this._finally;
	}

	public boolean hasFinally() {
		return this._finally != null;
	}

	public MethodCall removeFinally() {
		this._finally = null;
		return this;
	} 

	public MethodCall addArguments(Object value) {
		this._arguments.add(value);
		return this;
	}

	public MethodCall setArguments(Object[] value) {
		this._arguments.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MethodCall setArguments(java.util.Collection<Object> values) {
		this._arguments.addAll(values);
		return this;
	}

	public MethodCall removeArguments(Object value) {
		this._arguments.remove(value);
		return this;
	}

	public MethodCall removeArguments(int index) {
		this._arguments.remove(index);
		return this;
	}

	public java.util.List<Object> getArguments() {
		return this._arguments;
	} 

	public MethodCall addThen(Object value) {
		this._then.add(value);
		return this;
	}

	public MethodCall setThen(Object[] value) {
		this._then.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MethodCall setThen(java.util.Collection<Object> values) {
		this._then.addAll(values);
		return this;
	}

	public MethodCall removeThen(Object value) {
		this._then.remove(value);
		return this;
	}

	public MethodCall removeThen(int index) {
		this._then.remove(index);
		return this;
	}

	public java.util.List<Object> getThen() {
		return this._then;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MethodCall that = (MethodCall) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "methodCall(scope,name,arguments,then,catch,finally) ::= <<~if(scope)~~scope~.~endif~~name~(~arguments:{it|~it~};separator=\", \"~)\n" + 
				"	~then:{it|.then(~it~)};separator=\"\\n\"~\n" + 
				"~if(catch)~\n" + 
				"	.catch(~catch~)~endif~\n" + 
				"~if(finally)~\n" + 
				"	.finally(~finally~)\n" + 
				"~endif~ >>";
} 