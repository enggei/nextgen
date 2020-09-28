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
		for (java.util.Map<String, Object> map : _params) st.addAggr("params.{type,name}", map.get("type"), map.get("name"));
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

	public DomainAction addParams(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._params.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getParams() {
		return this._params;
	}

	public DomainAction addParams(DomainAction_Params value) {
		return addParams(value._type, value._name);
	}

	public java.util.stream.Stream<DomainAction_Params> streamParams() {
		return this._params.stream().map(DomainAction_Params::new);
	}

	public java.util.List<Object> getParams_Type() {
		return streamParams().map(DomainAction_Params::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getParams_Name() {
		return streamParams().map(DomainAction_Params::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class DomainAction_Params {

		Object _type;
		Object _name;

		public DomainAction_Params(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private DomainAction_Params(java.util.Map<String, Object> map) {
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
		DomainAction that = (DomainAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DomainAction(name,params,statements) ::= <<private void ~name~(Message<JsonObject> message) {\n" + 
				"	log.info(\"~name~ \" + message.body().encodePrettily());\n" + 
				"~if(params)~\n" + 
				"	final JsonObject body = message.body();\n" + 
				"	~params:{it|final ~it.type~ ~it.name~ = body.get~it.type~(\"~it.name~\");};separator=\"\\n\"~\n" + 
				"~endif~\n" + 
				"	\n" + 
				"	db.doInTransaction(transaction -> {\n" + 
				"		~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}, throwable -> {\n" + 
				"		message.fail(ErrorCodes.DB_ERROR.ordinal(), throwable.getMessage());\n" + 
				"	});\n" + 
				"} >>";
}  