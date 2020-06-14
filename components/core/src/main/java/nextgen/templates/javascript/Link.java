package nextgen.templates.javascript;

public class Link {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _to;

	Link(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Link");
		st.add("to", _to);
		return st.render().trim();
	}

	public Link setTo(Object value) {
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

	public Link removeTo() {
		this._to = null;
		return this;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Link that = (Link) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Link(to) ::= <<<Link innerRef={ ref } to=\"~to~\" { ...props } /> >>";
}