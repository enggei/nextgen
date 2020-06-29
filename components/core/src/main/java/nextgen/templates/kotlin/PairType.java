package nextgen.templates.kotlin;

public class PairType implements TypeDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private TypeDeclaration _first;
	private TypeDeclaration _second;

	PairType(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PairType");
		st.add("first", _first);
		st.add("second", _second);
		return st.render().trim();
	}

	public PairType setFirst(TypeDeclaration value) {
		this._first = value;
		return this;
	}

	public TypeDeclaration getFirst() {
		return this._first;
	}

	public TypeDeclaration getFirst(TypeDeclaration defaultValue) {
		return this._first == null ? defaultValue : this._first;
	}

	public boolean hasFirst() {
		return this._first != null;
	}

	public PairType removeFirst() {
		this._first = null;
		return this;
	} 

	public PairType setSecond(TypeDeclaration value) {
		this._second = value;
		return this;
	}

	public TypeDeclaration getSecond() {
		return this._second;
	}

	public TypeDeclaration getSecond(TypeDeclaration defaultValue) {
		return this._second == null ? defaultValue : this._second;
	}

	public boolean hasSecond() {
		return this._second != null;
	}

	public PairType removeSecond() {
		this._second = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PairType that = (PairType) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PairType(first,second) ::= <<Pair<~first~, ~second~> >>";
}  