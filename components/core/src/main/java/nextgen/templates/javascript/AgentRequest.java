package nextgen.templates.javascript;

public class AgentRequest {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _endpoint;
	private Object _method;
	private Object _finally;
	private java.util.List<Object> _params = new java.util.ArrayList<>();
	private java.util.List<Object> _then = new java.util.ArrayList<>();

	AgentRequest(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("agentRequest");
		st.add("endpoint", _endpoint);
		st.add("method", _method);
		st.add("finally", _finally);
		for (Object o : _params) st.add("params", o);
		for (Object o : _then) st.add("then", o);
		return st.render().trim();
	}

	public AgentRequest setEndpoint(Object value) {
		this._endpoint = value;
		return this;
	}

	public Object getEndpoint() {
		return this._endpoint;
	}

	public Object getEndpoint(Object defaultValue) {
		return this._endpoint == null ? defaultValue : this._endpoint;
	}

	public boolean hasEndpoint() {
		return this._endpoint != null;
	}

	public AgentRequest removeEndpoint() {
		this._endpoint = null;
		return this;
	} 

	public AgentRequest setMethod(Object value) {
		this._method = value;
		return this;
	}

	public Object getMethod() {
		return this._method;
	}

	public Object getMethod(Object defaultValue) {
		return this._method == null ? defaultValue : this._method;
	}

	public boolean hasMethod() {
		return this._method != null;
	}

	public AgentRequest removeMethod() {
		this._method = null;
		return this;
	} 

	public AgentRequest setFinally(Object value) {
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

	public AgentRequest removeFinally() {
		this._finally = null;
		return this;
	} 

	public AgentRequest addParams(Object value) {
		this._params.add(value);
		return this;
	}

	public AgentRequest setParams(Object[] value) {
		this._params.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public AgentRequest setParams(java.util.Collection<Object> values) {
		this._params.addAll(values);
		return this;
	}

	public AgentRequest removeParams(Object value) {
		this._params.remove(value);
		return this;
	}

	public AgentRequest removeParams(int index) {
		this._params.remove(index);
		return this;
	}

	public java.util.List<Object> getParams() {
		return this._params;
	} 

	public AgentRequest addThen(Object value) {
		this._then.add(value);
		return this;
	}

	public AgentRequest setThen(Object[] value) {
		this._then.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public AgentRequest setThen(java.util.Collection<Object> values) {
		this._then.addAll(values);
		return this;
	}

	public AgentRequest removeThen(Object value) {
		this._then.remove(value);
		return this;
	}

	public AgentRequest removeThen(int index) {
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
		AgentRequest that = (AgentRequest) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "agentRequest(endpoint,method,params,then,finally) ::= <<agent.~endpoint~.~method~(~params:{it|~it~};separator=\",\"~)\n" + 
				"	~then:{it|.then(~it~)};separator=\"\\n\"~\n" + 
				"	.catch(action((err) => {\n" + 
				"		console.info(\"error ~endpoint~.~method~ : \" + err.rawResponse);\n" + 
				"		this.setErrors(err.response && err.response.body && err.response.body.errors);\n" + 
				"		throw err;\n" + 
				"	}))\n" + 
				"	.finally(~finally~) >>";
}  