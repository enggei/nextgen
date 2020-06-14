package nextgen.templates.javascript;

public class ForwardRef {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _forward;

	ForwardRef(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ForwardRef");
		st.add("name", _name);
		st.add("forward", _forward);
		return st.render().trim();
	}

	public ForwardRef setName(Object value) {
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

	public ForwardRef removeName() {
		this._name = null;
		return this;
	}

	public ForwardRef setForward(Object value) {
		this._forward = value;
		return this;
	}

	public Object getForward() {
		return this._forward;
	}

	public Object getForward(Object defaultValue) {
		return this._forward == null ? defaultValue : this._forward;
	}

	public boolean hasForward() {
		return this._forward != null;
	}

	public ForwardRef removeForward() {
		this._forward = null;
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

	static final String st = "ForwardRef(name,forward) ::= <<const ~name~ = React.forwardRef( (props, ref) => (\n" + 
				"	~forward~\n" + 
				"));>>";
}