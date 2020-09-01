package nextgen.templates.nextgen;

public class AppEvent {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	AppEvent(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AppEvent");
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public AppEvent setName(Object value) {
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

	public AppEvent removeName() {
		this._name = null;
		return this;
	} 


	public AppEvent addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public AppEvent addFields(AppEvent_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<AppEvent_Fields> streamFields() {
		return this._fields.stream().map(AppEvent_Fields::new);
	}

	public static final class AppEvent_Fields {

		Object _type;
		Object _name;

		public AppEvent_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private AppEvent_Fields(java.util.Map<String, Object> map) {
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
		AppEvent that = (AppEvent) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AppEvent(name,fields) ::= <<public static void post~name~(~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"	log.info(\"post ~name~\");\n" + 
				"	org.greenrobot.eventbus.EventBus.getDefault().post(new ~name~(~fields:{it|~it.name~};separator=\", \"~));\n" + 
				"}\n" + 
				"\n" + 
				"public static class ~name~ {\n" + 
				"\n" + 
				"	~fields:{it|public final ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	public ~name~(~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"} >>";
}  