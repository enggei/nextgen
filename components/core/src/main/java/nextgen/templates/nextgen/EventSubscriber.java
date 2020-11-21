package nextgen.templates.nextgen;

public class EventSubscriber {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _eventType;
	private Object _eventName;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	EventSubscriber(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EventSubscriber");
		st.add("eventType", _eventType);
		st.add("eventName", _eventName);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public EventSubscriber setEventType(Object value) {
		this._eventType = value;
		return this;
	}

	public Object getEventType() {
		return this._eventType;
	}

	public Object getEventType(Object defaultValue) {
		return this._eventType == null ? defaultValue : this._eventType;
	}

	public boolean hasEventType() {
		return this._eventType != null;
	}

	public EventSubscriber removeEventType() {
		this._eventType = null;
		return this;
	} 

	public EventSubscriber setEventName(Object value) {
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

	public EventSubscriber removeEventName() {
		this._eventName = null;
		return this;
	} 

	public EventSubscriber addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public EventSubscriber setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EventSubscriber setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public EventSubscriber removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public EventSubscriber removeStatements(int index) {
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
		EventSubscriber that = (EventSubscriber) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "EventSubscriber(eventType,statements,eventName) ::= <<@org.greenrobot.eventbus.Subscribe()\n" + 
				"public void on~eventName~(~eventType~ event) {\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  