package nextgen.templates.greenrobot;

public class Event {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private String _name;
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	Event(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("event");
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public Event setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public Event removePackageName() {
		this._packageName = null;
		return this;
	} 

	public Event setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public Event removeName() {
		this._name = null;
		return this;
	} 


	public Event addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public Event addFields(Event_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<Event_Fields> streamFields() {
		return this._fields.stream().map(Event_Fields::new);
	}

	public java.util.List<Object> getFields_Type() {
		return streamFields().map(Event_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Name() {
		return streamFields().map(Event_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class Event_Fields {

		Object _type;
		Object _name;

		public Event_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private Event_Fields(java.util.Map<String, Object> map) {
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
		Event that = (Event) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "event(packageName,name,fields) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public final class ~name~ {\n" + 
				"\n" + 
				"	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
				"\n" + 
				"	public static void post(~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"		log.info(\"post ~name~\");\n" + 
				"		org.greenrobot.eventbus.EventBus.getDefault().post(new ~name~(~fields:{it|~it.name~};separator=\", \"~));\n" + 
				"	}\n" + 
				"\n" + 
				"	~fields:{it|public final ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	public ~name~(~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"} >>";
}  