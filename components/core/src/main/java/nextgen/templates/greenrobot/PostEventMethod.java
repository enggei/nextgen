package nextgen.templates.greenrobot;

public class PostEventMethod {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _eventName;
	private java.util.List<java.util.Map<String, Object>> _parameters = new java.util.ArrayList<>();

	PostEventMethod(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PostEventMethod");
		st.add("eventName", _eventName);
		for (java.util.Map<String, Object> map : _parameters) st.addAggr("parameters.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public PostEventMethod setEventName(Object value) {
		this._eventName = value;
		return this;
	}

	public Object getEventName() {
		return this._eventName;
	}

	public Object getEventName(Object defaultValue) {
		return this._eventName == null ? defaultValue : this._eventName;
	}

	public boolean hasEventName() {
		return this._eventName != null;
	}

	public PostEventMethod removeEventName() {
		this._eventName = null;
		return this;
	} 


	public PostEventMethod addParameters(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._parameters.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getParameters() {
		return this._parameters;
	}

	public PostEventMethod addParameters(PostEventMethod_Parameters value) {
		return addParameters(value._type, value._name);
	}

	public java.util.stream.Stream<PostEventMethod_Parameters> streamParameters() {
		return this._parameters.stream().map(PostEventMethod_Parameters::new);
	}

	public static final class PostEventMethod_Parameters {

		Object _type;
		Object _name;

		public PostEventMethod_Parameters(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private PostEventMethod_Parameters(java.util.Map<String, Object> map) {
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
		PostEventMethod that = (PostEventMethod) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PostEventMethod(eventName,parameters) ::= <<public static void post~eventName~(~parameters:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"	log.info(\"post ~eventName~\");\n" + 
				"	org.greenrobot.eventbus.EventBus.getDefault().post(new ~eventName~(~parameters:{it|~it.name~};separator=\", \"~));\n" + 
				"} >>";
}  