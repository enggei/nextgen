package nextgen.templates.kotlin;

public class PairExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Expression _first;
	private Expression _second;

	PairExpression(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PairExpression");
		st.add("first", _first);
		st.add("second", _second);
		return st.render().trim();
	}

	public PairExpression setFirst(Expression value) {
		this._first = value;
		return this;
	}

	public Expression getFirst() {
		return this._first;
	}

	public Expression getFirst(Expression defaultValue) {
		return this._first == null ? defaultValue : this._first;
	}

	public boolean hasFirst() {
		return this._first != null;
	}

	public PairExpression removeFirst() {
		this._first = null;
		return this;
	} 

	public PairExpression setSecond(Expression value) {
		this._second = value;
		return this;
	}

	public Expression getSecond() {
		return this._second;
	}

	public Expression getSecond(Expression defaultValue) {
		return this._second == null ? defaultValue : this._second;
	}

	public boolean hasSecond() {
		return this._second != null;
	}

	public PairExpression removeSecond() {
		this._second = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PairExpression that = (PairExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PairExpression(first,second) ::= <<~first~ to ~second~ >>";
}  