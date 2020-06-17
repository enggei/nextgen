package nextgen.templates.vertx;

public class JsonObjectAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _params = new java.util.ArrayList<>();

	JsonObjectAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("jsonObjectAction");
		st.add("name", _name);
		for (Object o : _statements) st.add("statements", o);
		for (java.util.Map<String, Object> map : _params) st.addAggr("params.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public JsonObjectAction setName(Object value) {
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

	public JsonObjectAction removeName() {
		this._name = null;
		return this;
	} 

	public JsonObjectAction addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public JsonObjectAction setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JsonObjectAction setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public JsonObjectAction removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public JsonObjectAction removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public JsonObjectAction addParams(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._params.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getParams() {
		return this._params;
	}

	public JsonObjectAction addParams(JsonObjectAction_Params value) {
		return addParams(value._type, value._name);
	}

	public java.util.stream.Stream<JsonObjectAction_Params> streamParams() {
		return this._params.stream().map(JsonObjectAction_Params::new);
	}

	public static final class JsonObjectAction_Params {

		Object _type;
		Object _name;

		public JsonObjectAction_Params(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private JsonObjectAction_Params(java.util.Map<String, Object> map) {
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
		JsonObjectAction that = (JsonObjectAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "jsonObjectAction(name,params,statements) ::= <<private void ~name~(Message<JsonObject> message) {\n" + 
				"\n" + 
				"	final JsonObject body = message.body();\n" + 
				"	~params:{it|final ~it.type~ ~it.name~ = body.get~it.type~(\"~it.name~\");};separator=\"\\n\"~\n" + 
				"\n" + 
				"	final JsonObject response = new JsonObject();\n" + 
				"	\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"	message.reply(response);\n" + 
				"} >>";
} 