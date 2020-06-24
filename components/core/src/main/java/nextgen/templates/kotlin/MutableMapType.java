package nextgen.templates.kotlin;

public class MutableMapType implements TypeDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private TypeDeclaration _first;
	private TypeDeclaration _second;

	MutableMapType(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MutableMapType");
		st.add("first", _first);
		st.add("second", _second);
		return st.render().trim();
	}

	public MutableMapType setFirst(TypeDeclaration value) {
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

	public MutableMapType removeFirst() {
		this._first = null;
		return this;
	} 

	public MutableMapType setSecond(TypeDeclaration value) {
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

	public MutableMapType removeSecond() {
		this._second = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MutableMapType that = (MutableMapType) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MutableMapType(first,second) ::= <<MutableMap<~first~, ~second~> >>";
} 