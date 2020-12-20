package nextgen.templates.jgoodies;

public class Grow {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _double;

	Grow(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("grow");
		st.add("double", _double);
		return st.render().trim();
	}

	public Grow setDouble(Object value) {
		this._double = value;
		return this;
	}

	public Object getDouble() {
		return this._double;
	}

	public Object getDouble(Object defaultValue) {
		return this._double == null ? defaultValue : this._double;
	}

	public boolean hasDouble() {
		return this._double != null;
	}

	public Grow removeDouble() {
		this._double = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Grow that = (Grow) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "grow(double) ::= <<grow~if(double)~(~double~)~endif~ >>";
}  