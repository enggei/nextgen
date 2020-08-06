package nextgen.templates.vertx;

public class SendEventBusAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _actionName;
	private java.util.List<java.util.Map<String, Object>> _params = new java.util.ArrayList<>();

	SendEventBusAction(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SendEventBusAction");
		st.add("actionName", _actionName);
		for (java.util.Map<String, Object> map : _params) st.addAggr("params.{name}", map.get("name"));
		return st.render().trim();
	}

	public SendEventBusAction setActionName(Object value) {
		this._actionName = value;
		return this;
	}

	public Object getActionName() {
		return this._actionName;
	}

	public Object getActionName(Object defaultValue) {
		return this._actionName == null ? defaultValue : this._actionName;
	}

	public boolean hasActionName() {
		return this._actionName != null;
	}

	public SendEventBusAction removeActionName() {
		this._actionName = null;
		return this;
	} 


	public SendEventBusAction addParams(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._params.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getParams() {
		return this._params;
	}

	public SendEventBusAction addParams(SendEventBusAction_Params value) {
		return addParams(value._name);
	}

	public java.util.stream.Stream<SendEventBusAction_Params> streamParams() {
		return this._params.stream().map(SendEventBusAction_Params::new);
	}

	public static final class SendEventBusAction_Params {

		Object _name;

		public SendEventBusAction_Params(Object _name) {
			this._name = _name;
		}

		private SendEventBusAction_Params(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SendEventBusAction that = (SendEventBusAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SendEventBusAction(actionName,params) ::= <<getFromDomainDB(vertx, routingContext, \"~actionName~\", new JsonObject()~if(params)~.~params:{it|put(\"~it.name~\", routingContext.request().getParam(\"~it.name~\"))}~~endif~); >>";
}  