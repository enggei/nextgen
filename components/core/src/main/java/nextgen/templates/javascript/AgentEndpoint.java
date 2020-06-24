package nextgen.templates.javascript;

public class AgentEndpoint {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _urlParam;
	private Object _action;
	private Object _url;
	private java.util.List<Object> _parameters = new java.util.ArrayList<>();

	AgentEndpoint(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("agentEndpoint");
		st.add("name", _name);
		st.add("urlParam", _urlParam);
		st.add("action", _action);
		st.add("url", _url);
		for (Object o : _parameters) st.add("parameters", o);
		return st.render().trim();
	}

	public AgentEndpoint setName(Object value) {
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

	public AgentEndpoint removeName() {
		this._name = null;
		return this;
	} 

	public AgentEndpoint setUrlParam(Object value) {
		this._urlParam = value;
		return this;
	}

	public Object getUrlParam() {
		return this._urlParam;
	}

	public Object getUrlParam(Object defaultValue) {
		return this._urlParam == null ? defaultValue : this._urlParam;
	}

	public boolean hasUrlParam() {
		return this._urlParam != null;
	}

	public AgentEndpoint removeUrlParam() {
		this._urlParam = null;
		return this;
	} 

	public AgentEndpoint setAction(Object value) {
		this._action = value;
		return this;
	}

	public Object getAction() {
		return this._action;
	}

	public Object getAction(Object defaultValue) {
		return this._action == null ? defaultValue : this._action;
	}

	public boolean hasAction() {
		return this._action != null;
	}

	public AgentEndpoint removeAction() {
		this._action = null;
		return this;
	} 

	public AgentEndpoint setUrl(Object value) {
		this._url = value;
		return this;
	}

	public Object getUrl() {
		return this._url;
	}

	public Object getUrl(Object defaultValue) {
		return this._url == null ? defaultValue : this._url;
	}

	public boolean hasUrl() {
		return this._url != null;
	}

	public AgentEndpoint removeUrl() {
		this._url = null;
		return this;
	} 

	public AgentEndpoint addParameters(Object value) {
		this._parameters.add(value);
		return this;
	}

	public AgentEndpoint setParameters(Object[] value) {
		this._parameters.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public AgentEndpoint setParameters(java.util.Collection<Object> values) {
		this._parameters.addAll(values);
		return this;
	}

	public AgentEndpoint removeParameters(Object value) {
		this._parameters.remove(value);
		return this;
	}

	public AgentEndpoint removeParameters(int index) {
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
		AgentEndpoint that = (AgentEndpoint) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "agentEndpoint(name,urlParam,parameters,action,url) ::= <<~name~: (~if(urlParam)~~urlParam~~if(parameters)~, ~endif~~endif~~parameters:{it|~it~};separator=\",\"~) => requests.~action~('/~url~'~if(urlParam)~ + ~urlParam~~endif~~if(parameters)~, { ~parameters:{it|~it~};separator=\",\"~ }~endif~) >>";
} 