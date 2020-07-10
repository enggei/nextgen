package nextgen.templates.greenrobot;

public class Subscribe {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _threadMode;
	private Object _message;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	Subscribe(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("subscribe");
		st.add("threadMode", _threadMode);
		st.add("message", _message);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public Subscribe setThreadMode(Object value) {
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

	public Subscribe removeThreadMode() {
		this._threadMode = null;
		return this;
	} 

	public Subscribe setMessage(Object value) {
		this._message = value;
		return this;
	}

	public Object getMessage() {
		return this._message;
	}

	public Object getMessage(Object defaultValue) {
		return this._message == null ? defaultValue : this._message;
	}

	public boolean hasMessage() {
		return this._message != null;
	}

	public Subscribe removeMessage() {
		this._message = null;
		return this;
	} 

	public Subscribe addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public Subscribe setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Subscribe setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public Subscribe removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public Subscribe removeStatements(int index) {
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
		Subscribe that = (Subscribe) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "subscribe(threadMode,message,statements) ::= <<@org.greenrobot.eventbus.Subscribe(~if(threadMode)~threadMode = org.greenrobot.eventbus.ThreadMode.~threadMode~~endif~)\n" + 
				"public void on~message;format=\"capitalize\"~(~message~ event) {\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  