package nextgen.templates.typescript;

public class ArrayInitializer {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _elements = new java.util.ArrayList<>();

	ArrayInitializer(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("arrayInitializer");
		for (Object o : _elements) st.add("elements", o);
		return st.render().trim();
	}


	public ArrayInitializer addElements(Object value) {
		this._elements.add(value);
		return this;
	}

	public ArrayInitializer setElements(Object[] value) {
		this._elements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ArrayInitializer setElements(java.util.Collection<Object> values) {
		this._elements.addAll(values);
		return this;
	}

	public ArrayInitializer removeElements(Object value) {
		this._elements.remove(value);
		return this;
	}

	public ArrayInitializer removeElements(int index) {
		this._elements.remove(index);
		return this;
	}

	public java.util.List<Object> getElements() {
		return this._elements;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ArrayInitializer that = (ArrayInitializer) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "arrayInitializer(elements) ::= <<[~elements:{it|~it~};separator=\",\"~] >>";
} 