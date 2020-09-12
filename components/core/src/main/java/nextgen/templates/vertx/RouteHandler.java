package nextgen.templates.vertx;

public class RouteHandler {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _params = new java.util.ArrayList<>();

	RouteHandler(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("RouteHandler");
		st.add("name", _name);
		for (Object o : _statements) st.add("statements", o);
		for (java.util.Map<String, Object> map : _params) st.addAggr("params.{type,name}", map.get("type"), map.get("name"));
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

	public RouteHandler addParams(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._params.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getParams() {
		return this._params;
	}

	public RouteHandler addParams(RouteHandler_Params value) {
		return addParams(value._type, value._name);
	}

	public java.util.stream.Stream<RouteHandler_Params> streamParams() {
		return this._params.stream().map(RouteHandler_Params::new);
	}

	public static final class RouteHandler_Params {

		Object _type;
		Object _name;

		public RouteHandler_Params(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private RouteHandler_Params(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

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

	static final String st = "RouteHandler(name,params,statements) ::= <<private void ~name~(RoutingContext routingContext~if(params)~, ~params:{it|~it.type~ ~it.name~};separator=\",\"~~endif~) {\n" + 
				"	WebUtils.debug(\"~name~\", routingContext);\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  