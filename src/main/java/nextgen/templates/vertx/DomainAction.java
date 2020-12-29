package nextgen.templates.vertx;

public class DomainAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _params = new java.util.ArrayList<>();

	DomainAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DomainAction");
		st.add("name", _name);
		for (Object o : _statements) st.add("statements", o);
		for (java.util.Map<String, Object> map : _params) st.addAggr("params.{name,type}", map.get("name"), map.get("type"));
		return st.render().trim();
	}

	public DomainAction setName(Object value) {
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

	public DomainAction removeName() {
		this._name = null;
		return this;
	} 

	public DomainAction addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public DomainAction setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainAction setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public DomainAction removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public DomainAction removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public DomainAction setParams(java.util.Collection<DomainAction_Params> values) {
			this._params.clear();
			values.stream().map(DomainAction_Params::asMap).forEach(map -> _params.add(map));
			return this;
		}

	public DomainAction addParams(Object _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("type", _type);
		this._params.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getParams() {
		return this._params;
	}

	public DomainAction addParams(DomainAction_Params value) {
		return addParams(value._name, value._type);
	}

	public java.util.stream.Stream<DomainAction_Params> streamParams() {
		return this._params.stream().map(DomainAction_Params::new);
	}

	public java.util.List<Object> getParams_Name() {
		return streamParams().map(DomainAction_Params::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getParams_Type() {
		return streamParams().map(DomainAction_Params::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class DomainAction_Params {

		Object _name;
		Object _type;

		public DomainAction_Params(Object _name, Object _type) {
			this._name = _name;
			this._type = _type;
		}

		private DomainAction_Params(java.util.Map<String, Object> map) {
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
		DomainAction that = (DomainAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DomainAction(statements,params,name) ::= <<private void ~name~(Message<io.vertx.core.buffer.Buffer> message) {\n" + 
				"	debug(\"~name~\", message);\n" + 
				"~if(params)~\n" + 
				"	final JsonObject body = message.body();\n" + 
				"	~params:{it|final ~it.type~ ~it.name~ = body.get~it.type~(\"~it.name~\");};separator=\"\\n\"~\n" + 
				"~endif~\n" + 
				"	\n" + 
				"	doInTransaction(transaction -> {\n" + 
				"		final JsonObject reply = new JsonObject();\n" + 
				"		~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"		message.reply(reply);\n" + 
				"	}, throwable -> {\n" + 
				"		message.fail(500, throwable.getMessage());\n" + 
				"	});\n" + 
				"} >>";
}  