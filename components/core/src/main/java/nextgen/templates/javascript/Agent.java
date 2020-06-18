package nextgen.templates.javascript;

public class Agent {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<java.util.Map<String, Object>> _agentDeclarations = new java.util.ArrayList<>();

	Agent(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Agent");
		for (java.util.Map<String, Object> map : _agentDeclarations) st.addAggr("agentDeclarations.{declaration,name}", map.get("declaration"), map.get("name"));
		return st.render().trim();
	}



	public Agent addAgentDeclarations(Object _declaration, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("declaration", _declaration);
		map.put("name", _name);
		this._agentDeclarations.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAgentDeclarations() {
		return this._agentDeclarations;
	}

	public Agent addAgentDeclarations(Agent_AgentDeclarations value) {
		return addAgentDeclarations(value._declaration, value._name);
	}

	public java.util.stream.Stream<Agent_AgentDeclarations> streamAgentDeclarations() {
		return this._agentDeclarations.stream().map(Agent_AgentDeclarations::new);
	}

	public static final class Agent_AgentDeclarations {

		Object _declaration;
		Object _name;

		public Agent_AgentDeclarations(Object _declaration, Object _name) {
			this._declaration = _declaration;
			this._name = _name;
		}

		private Agent_AgentDeclarations(java.util.Map<String, Object> map) {
			this._declaration = (Object) map.get("declaration");
			this._name = (Object) map.get("name");
		}

		public Object getDeclaration() {
			return this._declaration;
		}

		public Object getName() {
			return this._name;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Agent that = (Agent) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Agent(agentDeclarations) ::= <<import superagentPromise from 'superagent-promise';\n" + 
				"import _superagent from 'superagent';\n" + 
				"import appStore from './stores/AppStore';\n" + 
				"import authStore from './stores/AuthStore';\n" + 
				"\n" + 
				"const superagent = superagentPromise(_superagent, global.Promise);\n" + 
				"\n" + 
				"const handleErrors = err => {\n" + 
				"	if (err && err.response && err.response.status === 401) {\n" + 
				"		authStore.logout();\n" + 
				"	}\n" + 
				"	return err;\n" + 
				"};\n" + 
				"\n" + 
				"const responseBody = res => res.body;\n" + 
				"\n" + 
				"const tokenPlugin = req => {\n" + 
				"	if (appStore.token) {\n" + 
				"		req.set('Authorization', `Bearer ${appStore.token}`);\n" + 
				"	}\n" + 
				"};\n" + 
				"\n" + 
				"const requests = {\n" + 
				"	del: url =>\n" + 
				"		superagent\n" + 
				"			.del(`${url}`)\n" + 
				"			.use(tokenPlugin)\n" + 
				"			.end(handleErrors)\n" + 
				"			.then(responseBody),\n" + 
				"	get: url =>\n" + 
				"		superagent\n" + 
				"			.get(`${url}`)\n" + 
				"			.use(tokenPlugin)\n" + 
				"			.end(handleErrors)\n" + 
				"			.then(responseBody),\n" + 
				"	put: (url, body) =>\n" + 
				"		superagent\n" + 
				"			.put(`${url}`, body)\n" + 
				"			.use(tokenPlugin)\n" + 
				"			.end(handleErrors)\n" + 
				"			.then(responseBody),\n" + 
				"	post: (url, body) =>\n" + 
				"		superagent\n" + 
				"			.post(`${url}`, body)\n" + 
				"			.use(tokenPlugin)\n" + 
				"			.end(handleErrors)\n" + 
				"			.then(responseBody)\n" + 
				"};\n" + 
				"\n" + 
				"~agentDeclarations:{it|~it.declaration~};separator=\"\\n\"~\n" + 
				"\n" + 
				"const Auth = { \n" + 
				"	current: () => requests.get('/user'),\n" + 
				"	login: (username, password) => requests.post('/login', { username, password }),\n" + 
				"	save: (user) => requests.put('/user', { user })\n" + 
				"}\n" + 
				"\n" + 
				"export default {\n" + 
				"	Auth~if(agentDeclarations)~,\n" + 
				"	\n" + 
				"	~agentDeclarations:{it|~it.name~};separator=\",\\n\"~~endif~\n" + 
				"	\n" + 
				"}; >>";
} 