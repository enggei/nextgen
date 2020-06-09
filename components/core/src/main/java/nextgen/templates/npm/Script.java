package nextgen.templates.npm;

public class Script {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _command;
	private Object _name;

	Script(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Script that = (Script) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("script");
		st.add("command", _command);
		st.add("name", _name);
		return st.render().trim();
	}

	public Script setCommand(Object value) {
		this._command = value;
		return this;
	}

	public Object getCommand() {
		return this._command;
	}

	public Object getCommand(Object defaultValue) {
		return this._command == null ? defaultValue : this._command;
	}

	public boolean hasCommand() {
		return this._command != null;
	}

	public Script removeCommand() {
		this._command = null;
		return this;
	} 

	public Script setName(Object value) {
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

	public Script removeName() {
		this._name = null;
		return this;
	} 

	static final String st = "script(command,name) ::= <<\"~name~\": \"~command~\">> ";
} 