package nextgen.templates.javascript;

public class SendEventBusAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _actionName;
	private Object _address;
	private java.util.List<String> _successStatements = new java.util.ArrayList<>();
	private java.util.List<String> _failStatements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _params = new java.util.ArrayList<>();

	SendEventBusAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SendEventBusAction");
		st.add("actionName", _actionName);
		st.add("address", _address);
		for (Object o : _successStatements) st.add("successStatements", o);
		for (Object o : _failStatements) st.add("failStatements", o);
		for (java.util.Map<String, Object> map : _params) st.addAggr("params.{name,argument}", map.get("name"), map.get("argument"));
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

	public SendEventBusAction setAddress(Object value) {
		this._address = value;
		return this;
	}

	public Object getAddress() {
		return this._address;
	}

	public Object getAddress(Object defaultValue) {
		return this._address == null ? defaultValue : this._address;
	}

	public boolean hasAddress() {
		return this._address != null;
	}

	public SendEventBusAction removeAddress() {
		this._address = null;
		return this;
	} 

	public SendEventBusAction addSuccessStatements(String value) {
		this._successStatements.add(value);
		return this;
	}

	public SendEventBusAction setSuccessStatements(String[] value) {
		this._successStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public SendEventBusAction setSuccessStatements(java.util.Collection<String> values) {
		this._successStatements.addAll(values);
		return this;
	}

	public SendEventBusAction removeSuccessStatements(String value) {
		this._successStatements.remove(value);
		return this;
	}

	public SendEventBusAction removeSuccessStatements(int index) {
		this._successStatements.remove(index);
		return this;
	}

	public java.util.List<String> getSuccessStatements() {
		return this._successStatements;
	} 

	public SendEventBusAction addFailStatements(String value) {
		this._failStatements.add(value);
		return this;
	}

	public SendEventBusAction setFailStatements(String[] value) {
		this._failStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public SendEventBusAction setFailStatements(java.util.Collection<String> values) {
		this._failStatements.addAll(values);
		return this;
	}

	public SendEventBusAction removeFailStatements(String value) {
		this._failStatements.remove(value);
		return this;
	}

	public SendEventBusAction removeFailStatements(int index) {
		this._failStatements.remove(index);
		return this;
	}

	public java.util.List<String> getFailStatements() {
		return this._failStatements;
	} 

	public SendEventBusAction addParams(Object _name, Object _argument) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("argument", _argument);
		this._params.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getParams() {
		return this._params;
	}

	public SendEventBusAction addParams(SendEventBusAction_Params value) {
		return addParams(value._name, value._argument);
	}

	public java.util.stream.Stream<SendEventBusAction_Params> streamParams() {
		return this._params.stream().map(SendEventBusAction_Params::new);
	}

	public static final class SendEventBusAction_Params {

		Object _name;
		Object _argument;

		public SendEventBusAction_Params(Object _name, Object _argument) {
			this._name = _name;
			this._argument = _argument;
		}

		private SendEventBusAction_Params(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._argument = (Object) map.get("argument");
		}

		public Object getName() {
			return this._name;
		}

		public Object getArgument() {
			return this._argument;
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

	static final String st = "SendEventBusAction(actionName,address,params,successStatements,failStatements) ::= <<final DeliveryOptions options = new DeliveryOptions().addHeader(\"action\", \"~actionName~\");\n" + 
				"vertx.eventBus().request(\"~address~\", new JsonObject()~params:{it|.put(\"~it.name~\", ~it.argument~)}~, options, reply -> {\n" + 
				"	if (reply.succeeded()) {\n" + 
				"		~successStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	} else {\n" + 
				"		~failStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"}); >>";
} 