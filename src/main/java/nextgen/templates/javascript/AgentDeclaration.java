package nextgen.templates.javascript;

public class AgentDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private java.util.List<AgentEndpoint> _agentEndpoint = new java.util.ArrayList<>();

	AgentDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("agentDeclaration");
		st.add("name", _name);
		for (Object o : _agentEndpoint) st.add("agentEndpoint", o);
		return st.render().trim();
	}

	public AgentDeclaration setName(String value) {
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

	public AgentDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public AgentDeclaration addAgentEndpoint(AgentEndpoint value) {
		this._agentEndpoint.add(value);
		return this;
	}

	public AgentDeclaration setAgentEndpoint(AgentEndpoint[] value) {
		this._agentEndpoint.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public AgentDeclaration setAgentEndpoint(java.util.Collection<AgentEndpoint> values) {
		this._agentEndpoint.addAll(values);
		return this;
	}

	public AgentDeclaration removeAgentEndpoint(AgentEndpoint value) {
		this._agentEndpoint.remove(value);
		return this;
	}

	public AgentDeclaration removeAgentEndpoint(int index) {
		this._agentEndpoint.remove(index);
		return this;
	}

	public java.util.List<AgentEndpoint> getAgentEndpoint() {
		return this._agentEndpoint;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AgentDeclaration that = (AgentDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "agentDeclaration(name,agentEndpoint) ::= <<const ~name~ = { \n" + 
				"	~agentEndpoint:{it|~it~};separator=\",\\n\"~\n" + 
				"} >>";
}  