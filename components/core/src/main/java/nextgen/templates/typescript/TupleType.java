package nextgen.templates.typescript;

public class TupleType {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _first;
	private Object _second;

	TupleType(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("tupleType");
		st.add("first", _first);
		st.add("second", _second);
		return st.render().trim();
	}

	public TupleType setFirst(Object value) {
		this._first = value;
		return this;
	}

	public Object getFirst() {
		return this._first;
	}

	public Object getFirst(Object defaultValue) {
		return this._first == null ? defaultValue : this._first;
	}

	public boolean hasFirst() {
		return this._first != null;
	}

	public TupleType removeFirst() {
		this._first = null;
		return this;
	} 

	public TupleType setSecond(Object value) {
		this._second = value;
		return this;
	}

	public Object getSecond() {
		return this._second;
	}

	public Object getSecond(Object defaultValue) {
		return this._second == null ? defaultValue : this._second;
	}

	public boolean hasSecond() {
		return this._second != null;
	}

	public TupleType removeSecond() {
		this._second = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TupleType that = (TupleType) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "tupleType(first,second) ::= <<[~first~,~second~] >>";
} 