package nextgen.templates.java;

public class ArrayCreationLevel {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _dimension;

	ArrayCreationLevel(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ArrayCreationLevel");
		st.add("dimension", _dimension);
		return st.render().trim();
	}

	public ArrayCreationLevel setDimension(Object value) {
		this._dimension = value;
		return this;
	}

	public Object getDimension() {
		return this._dimension;
	}

	public Object getDimension(Object defaultValue) {
		return this._dimension == null ? defaultValue : this._dimension;
	}

	public boolean hasDimension() {
		return this._dimension != null;
	}

	public ArrayCreationLevel removeDimension() {
		this._dimension = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ArrayCreationLevel that = (ArrayCreationLevel) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ArrayCreationLevel(dimension) ::= <<[~dimension~] >>";
}  