package nextgen.templates.nextgen;

public class AppEvents {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _packageName;
	private String _name;
	private java.util.List<AppEvent> _events = new java.util.ArrayList<>();
	private java.util.List<NewOpenRemovedEvents> _newOpenRemovedEvents = new java.util.ArrayList<>();

	AppEvents(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AppEvents");
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (Object o : _events) st.add("events", o);
		for (Object o : _newOpenRemovedEvents) st.add("newOpenRemovedEvents", o);
		return st.render().trim();
	}

	public AppEvents setPackageName(String value) {
		this._packageName = value;
		return this;
	}

	public String getPackageName() {
		return this._packageName;
	}

	public String getPackageName(String defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public AppEvents removePackageName() {
		this._packageName = null;
		return this;
	} 

	public AppEvents setName(String value) {
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

	public AppEvents removeName() {
		this._name = null;
		return this;
	} 

	public AppEvents addEvents(AppEvent value) {
		this._events.add(value);
		return this;
	}

	public AppEvents setEvents(AppEvent[] value) {
		this._events.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public AppEvents setEvents(java.util.Collection<AppEvent> values) {
		this._events.addAll(values);
		return this;
	}

	public AppEvents removeEvents(AppEvent value) {
		this._events.remove(value);
		return this;
	}

	public AppEvents removeEvents(int index) {
		this._events.remove(index);
		return this;
	}

	public java.util.List<AppEvent> getEvents() {
		return this._events;
	} 

	public AppEvents addNewOpenRemovedEvents(NewOpenRemovedEvents value) {
		this._newOpenRemovedEvents.add(value);
		return this;
	}

	public AppEvents setNewOpenRemovedEvents(NewOpenRemovedEvents[] value) {
		this._newOpenRemovedEvents.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public AppEvents setNewOpenRemovedEvents(java.util.Collection<NewOpenRemovedEvents> values) {
		this._newOpenRemovedEvents.addAll(values);
		return this;
	}

	public AppEvents removeNewOpenRemovedEvents(NewOpenRemovedEvents value) {
		this._newOpenRemovedEvents.remove(value);
		return this;
	}

	public AppEvents removeNewOpenRemovedEvents(int index) {
		this._newOpenRemovedEvents.remove(index);
		return this;
	}

	public java.util.List<NewOpenRemovedEvents> getNewOpenRemovedEvents() {
		return this._newOpenRemovedEvents;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AppEvents that = (AppEvents) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AppEvents(packageName,name,events,newOpenRemovedEvents) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
				"\n" + 
				"	~events:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~newOpenRemovedEvents:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  