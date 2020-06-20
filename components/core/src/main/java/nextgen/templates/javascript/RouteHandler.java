package nextgen.templates.javascript;

public class RouteHandler {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	RouteHandler(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("routeHandler");
		st.add("name", _name);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public RouteHandler setName(Object value) {
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

	public RouteHandler removeName() {
		this._name = null;
		return this;
	} 

	public RouteHandler addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public RouteHandler setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public RouteHandler setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public RouteHandler removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public RouteHandler removeStatements(int index) {
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
		RouteHandler that = (RouteHandler) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "routeHandler(name,statements) ::= <<private void ~name~(RoutingContext routingContext) {\n" + 
				"	WebUtils.debug(\"~name~\", routingContext);\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
} 