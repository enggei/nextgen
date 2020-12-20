package nextgen.templates.jgoodies;

public class RowSpan {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _n;

	RowSpan(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("rowSpan");
		st.add("n", _n);
		return st.render().trim();
	}

	public RowSpan setN(Object value) {
		this._n = value;
		return this;
	}

	public Object getN() {
		return this._n;
	}

	public Object getN(Object defaultValue) {
		return this._n == null ? defaultValue : this._n;
	}

	public boolean hasN() {
		return this._n != null;
	}

	public RowSpan removeN() {
		this._n = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RowSpan that = (RowSpan) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "rowSpan(n) ::= <<~n~ >>";
}  