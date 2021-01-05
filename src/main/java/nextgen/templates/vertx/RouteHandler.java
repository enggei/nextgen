package nextgen.templates.vertx;

public class RouteHandler {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _arguments;
	private Object _name;
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
		st.add("arguments", _arguments);
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _params) st.addAggr("params.{name,type}", map.get("name"), map.get("type"));
		return st.render().trim();
	}

	public RouteHandler setArguments(Object value) {
		this._arguments = value;
		return this;
	}

	public Object getArguments() {
		return this._arguments;
	}

	public Object getArguments(Object defaultValue) {
		return this._arguments == null ? defaultValue : this._arguments;
	}

	public boolean hasArguments() {
		return this._arguments != null;
	}

	public RouteHandler removeArguments() {
		this._arguments = null;
		return this;
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


	public RouteHandler setParams(java.util.Collection<RouteHandler_Params> values) {
			this._params.clear();
			values.stream().map(RouteHandler_Params::asMap).forEach(map -> _params.add(map));
			return this;
		}

	public RouteHandler addParams(Object _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("type", _type);
		this._params.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getParams() {
		return this._params;
	}

	public RouteHandler addParams(RouteHandler_Params value) {
		return addParams(value._name, value._type);
	}

	public java.util.stream.Stream<RouteHandler_Params> streamParams() {
		return this._params.stream().map(RouteHandler_Params::new);
	}

	public java.util.List<Object> getParams_Name() {
		return streamParams().map(RouteHandler_Params::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getParams_Type() {
		return streamParams().map(RouteHandler_Params::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class RouteHandler_Params {

		Object _name;
		Object _type;

		public RouteHandler_Params(Object _name, Object _type) {
			this._name = _name;
			this._type = _type;
		}

		private RouteHandler_Params(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("name", _name);
			map.put("type", _type);
			return map;
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

	static final String st = "RouteHandler(arguments,name,params) ::= <<private void ~name~(RoutingContext routingContext~if(params)~, ~params:{it|~it.type~ ~it.name~};separator=\",\"~~endif~) {\n" + 
				"	debug(\"~name~\", routingContext);\n" + 
				"\n" + 
				"	vertx.eventBus().request(\"~name~\", ~if(arguments)~~arguments~~else~routingContext.getBody()~endif~, (Handler<AsyncResult<Message<Buffer~gt()~~gt()~>) reply -> {\n" + 
				"		if (reply.succeeded()) {\n" + 
				"			sendHtmlResponse(routingContext, OK, new ~name;format=\"capitalize\"~Page(reply.result().body()).toString());	\n" + 
				"		} else {\n" + 
				"			sendErrors(routingContext, INTERNAL_SERVER_ERROR,	reply.cause().getMessage());\n" + 
				"		}\n" + 
				"	});\n" + 
				"} >>";
}  