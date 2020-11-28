package nextgen.templates.typescript;

public class ArrayType {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _elementType;

	ArrayType(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("arrayType");
		st.add("elementType", _elementType);
		return st.render().trim();
	}

	public ArrayType setElementType(Object value) {
		this._elementType = value;
		return this;
	}

	public Object getElementType() {
		return this._elementType;
	}

	public Object getElementType(Object defaultValue) {
		return this._elementType == null ? defaultValue : this._elementType;
	}

	public boolean hasElementType() {
		return this._elementType != null;
	}

	public ArrayType removeElementType() {
		this._elementType = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ArrayType that = (ArrayType) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "arrayType(elementType) ::= <<Array<~elementType~> >>";
} 