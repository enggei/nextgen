package nextgen.templates.nextgen;

public class EventSubscription {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _threadMode;
	private Object _eventName;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	EventSubscription(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EventSubscription");
		st.add("threadMode", _threadMode);
		st.add("eventName", _eventName);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public EventSubscription setThreadMode(Object value) {
		this._threadMode = value;
		return this;
	}

	public Object getThreadMode() {
		return this._threadMode;
	}

	public Object getThreadMode(Object defaultValue) {
		return this._threadMode == null ? defaultValue : this._threadMode;
	}

	public boolean hasThreadMode() {
		return this._threadMode != null;
	}

	public EventSubscription removeThreadMode() {
		this._threadMode = null;
		return this;
	} 

	public EventSubscription setEventName(Object value) {
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

	public EventSubscription removeEventName() {
		this._eventName = null;
		return this;
	} 

	public EventSubscription addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public EventSubscription setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EventSubscription setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public EventSubscription removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public EventSubscription removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EventSubscription that = (EventSubscription) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "EventSubscription(threadMode,eventName,statements) ::= <<@org.greenrobot.eventbus.Subscribe(~if(threadMode)~threadMode = org.greenrobot.eventbus.ThreadMode.~threadMode~~endif~)\n" + 
				"public void on~eventName;format=\"capitalize\"~(nextgen.events.~eventName~ event) {\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  