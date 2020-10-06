package nextgen.templates.greenrobot;

public class CallPostEventMethod {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _eventManager;
	private String _event;
	private java.util.List<Object> _arguments = new java.util.ArrayList<>();

	CallPostEventMethod(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CallPostEventMethod");
		st.add("eventManager", _eventManager);
		st.add("event", _event);
		for (Object o : _arguments) st.add("arguments", o);
		return st.render().trim();
	}

	public CallPostEventMethod setEventManager(String value) {
		this._eventManager = value;
		return this;
	}

	public String getEventManager() {
		return this._eventManager;
	}

	public String getEventManager(String defaultValue) {
		return this._eventManager == null ? defaultValue : this._eventManager;
	}

	public boolean hasEventManager() {
		return this._eventManager != null;
	}

	public CallPostEventMethod removeEventManager() {
		this._eventManager = null;
		return this;
	} 

	public CallPostEventMethod setEvent(String value) {
		this._event = value;
		return this;
	}

	public String getEvent() {
		return this._event;
	}

	public String getEvent(String defaultValue) {
		return this._event == null ? defaultValue : this._event;
	}

	public boolean hasEvent() {
		return this._event != null;
	}

	public CallPostEventMethod removeEvent() {
		this._event = null;
		return this;
	} 

	public CallPostEventMethod addArguments(Object value) {
		this._arguments.add(value);
		return this;
	}

	public CallPostEventMethod setArguments(Object[] value) {
		this._arguments.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CallPostEventMethod setArguments(java.util.Collection<Object> values) {
		this._arguments.addAll(values);
		return this;
	}

	public CallPostEventMethod removeArguments(Object value) {
		this._arguments.remove(value);
		return this;
	}

	public CallPostEventMethod removeArguments(int index) {
		this._arguments.remove(index);
		return this;
	}

	public java.util.List<Object> getArguments() {
		return this._arguments;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CallPostEventMethod that = (CallPostEventMethod) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CallPostEventMethod(eventManager,event,arguments) ::= <<~eventManager~.post~event~(~arguments:{it|~it~};separator=\", \"~); >>";
}  