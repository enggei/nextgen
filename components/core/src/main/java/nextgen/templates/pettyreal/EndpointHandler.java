package nextgen.templates.pettyreal;

public class EndpointHandler {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	EndpointHandler(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EndpointHandler");
		st.add("name", _name);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public EndpointHandler setName(Object value) {
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

	public EndpointHandler removeName() {
		this._name = null;
		return this;
	} 

	public EndpointHandler addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public EndpointHandler setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EndpointHandler setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public EndpointHandler removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public EndpointHandler removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EndpointHandler that = (EndpointHandler) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "EndpointHandler(name,statements) ::= <<private void ~name~(RoutingContext routingContext) {\n" + 
				"	log.info(\"handle ~name~\");\n" + 
				"	~statements:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  