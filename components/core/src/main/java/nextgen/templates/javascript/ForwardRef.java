package nextgen.templates.javascript;

public class ForwardRef {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _to;
	private Object _argument;
	private Object _target;

	ForwardRef(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ForwardRef");
		st.add("to", _to);
		st.add("argument", _argument);
		st.add("target", _target);
		return st.render().trim();
	}

	public ForwardRef setTo(Object value) {
		this._to = value;
		return this;
	}

	public Object getTo() {
		return this._to;
	}

	public Object getTo(Object defaultValue) {
		return this._to == null ? defaultValue : this._to;
	}

	public boolean hasTo() {
		return this._to != null;
	}

	public ForwardRef removeTo() {
		this._to = null;
		return this;
	} 

	public ForwardRef setArgument(Object value) {
		this._argument = value;
		return this;
	}

	public Object getArgument() {
		return this._argument;
	}

	public Object getArgument(Object defaultValue) {
		return this._argument == null ? defaultValue : this._argument;
	}

	public boolean hasArgument() {
		return this._argument != null;
	}

	public ForwardRef removeArgument() {
		this._argument = null;
		return this;
	} 

	public ForwardRef setTarget(Object value) {
		this._target = value;
		return this;
	}

	public Object getTarget() {
		return this._target;
	}

	public Object getTarget(Object defaultValue) {
		return this._target == null ? defaultValue : this._target;
	}

	public boolean hasTarget() {
		return this._target != null;
	}

	public ForwardRef removeTarget() {
		this._target = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ForwardRef that = (ForwardRef) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ForwardRef(to,argument,target) ::= <<React.forwardRef((props, ref) => (\n" + 
				"	<RouterLink ref={ref} to={'~to~~if(argument)~/~endif~'~if(argument)~ + ~argument~~endif~}~if(target)~ target=\"~target~\"~endif~ {...props} />\n" + 
				")); >>";
}  