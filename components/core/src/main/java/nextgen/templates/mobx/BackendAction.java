package nextgen.templates.mobx;

public class BackendAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _endpoint;
	private Object _method;
	private Object _observable;
	private java.util.List<Object> _params = new java.util.ArrayList<>();

	BackendAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BackendAction");
		st.add("name", _name);
		st.add("endpoint", _endpoint);
		st.add("method", _method);
		st.add("observable", _observable);
		for (Object o : _params) st.add("params", o);
		return st.render().trim();
	}

	public BackendAction setName(Object value) {
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

	public BackendAction removeName() {
		this._name = null;
		return this;
	} 

	public BackendAction setEndpoint(Object value) {
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

	public BackendAction removeEndpoint() {
		this._endpoint = null;
		return this;
	} 

	public BackendAction setMethod(Object value) {
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

	public BackendAction removeMethod() {
		this._method = null;
		return this;
	} 

	public BackendAction setObservable(Object value) {
		this._observable = value;
		return this;
	}

	public Object getObservable() {
		return this._observable;
	}

	public Object getObservable(Object defaultValue) {
		return this._observable == null ? defaultValue : this._observable;
	}

	public boolean hasObservable() {
		return this._observable != null;
	}

	public BackendAction removeObservable() {
		this._observable = null;
		return this;
	} 

	public BackendAction addParams(Object value) {
		this._params.add(value);
		return this;
	}

	public BackendAction setParams(Object[] value) {
		this._params.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public BackendAction setParams(java.util.Collection<Object> values) {
		this._params.addAll(values);
		return this;
	}

	public BackendAction removeParams(Object value) {
		this._params.remove(value);
		return this;
	}

	public BackendAction removeParams(int index) {
		this._params.remove(index);
		return this;
	}

	public java.util.List<Object> getParams() {
		return this._params;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BackendAction that = (BackendAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BackendAction(name,params,endpoint,method,observable) ::= <<@action ~name~(~params:{it|~it~};separator=\",\"~) {\n" + 
				"	console.info(\"action ~name~\");\n" + 
				"	this.inProgress = true;\n" + 
				"	agent.~endpoint~.~method~(~params:{it|~it~};separator=\",\"~)\n" + 
				"		.then(({ data }) => this.set~name;format=\"capitalize\"~(data))\n" + 
				"		.catch(action((err) => {\n" + 
				"			console.info(\"error ~endpoint~.~method~ : \" + err.rawResponse);\n" + 
				"			this.setErrors(\"~name~\", err.response && err.response.body && err.response.body.errors);\n" + 
				"			throw err;\n" + 
				"		}))\n" + 
				"		.finally(action(() => this.inProgress = false))\n" + 
				"}\n" + 
				"\n" + 
				"@action set~name;format=\"capitalize\"~(data) {\n" + 
				"	console.info(\"set~name;format=\"capitalize\"~ \" + data);\n" + 
				"	this.~observable~ = data;\n" + 
				"} >>";
}  