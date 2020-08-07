package nextgen.templates.greenrobot;

public class EventManager {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _package;
	private String _name;
	private java.util.List<java.util.Map<String, Object>> _events = new java.util.ArrayList<>();

	EventManager(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EventManager");
		st.add("package", _package);
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _events) st.addAggr("events.{declaration,postMethod}", map.get("declaration"), map.get("postMethod"));
		return st.render().trim();
	}

	public EventManager setPackage(String value) {
		this._package = value;
		return this;
	}

	public String getPackage() {
		return this._package;
	}

	public String getPackage(String defaultValue) {
		return this._package == null ? defaultValue : this._package;
	}

	public boolean hasPackage() {
		return this._package != null;
	}

	public EventManager removePackage() {
		this._package = null;
		return this;
	} 

	public EventManager setName(String value) {
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

	public EventManager removeName() {
		this._name = null;
		return this;
	} 


	public EventManager addEvents(Event _declaration, PostEventMethod _postMethod) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("declaration", _declaration);
		map.put("postMethod", _postMethod);
		this._events.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getEvents() {
		return this._events;
	}

	public EventManager addEvents(EventManager_Events value) {
		return addEvents(value._declaration, value._postMethod);
	}

	public java.util.stream.Stream<EventManager_Events> streamEvents() {
		return this._events.stream().map(EventManager_Events::new);
	}

	public static final class EventManager_Events {

		Event _declaration;
		PostEventMethod _postMethod;

		public EventManager_Events(Event _declaration, PostEventMethod _postMethod) {
			this._declaration = _declaration;
			this._postMethod = _postMethod;
		}

		private EventManager_Events(java.util.Map<String, Object> map) {
			this._declaration = (Event) map.get("declaration");
			this._postMethod = (PostEventMethod) map.get("postMethod");
		}

		public Event getDeclaration() {
			return this._declaration;
		}

		public PostEventMethod getPostMethod() {
			return this._postMethod;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EventManager that = (EventManager) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "EventManager(package,name,events) ::= <<package ~package~;\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
				"\n" + 
				"	~events:{it|~it.postMethod~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~events:{it|~it.declaration~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  