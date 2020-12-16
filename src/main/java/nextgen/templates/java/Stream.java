package nextgen.templates.java;

public class Stream {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _elements = new java.util.ArrayList<>();

	Stream(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Stream");
		for (Object o : _elements) st.add("elements", o);
		return st.render().trim();
	}


	public Stream addElements(Object value) {
		this._elements.add(value);
		return this;
	}

	public Stream setElements(Object[] value) {
		this._elements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Stream setElements(java.util.Collection<Object> values) {
		this._elements.addAll(values);
		return this;
	}

	public Stream removeElements(Object value) {
		this._elements.remove(value);
		return this;
	}

	public Stream removeElements(int index) {
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
		Stream that = (Stream) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Stream(elements) ::= <<~elements:{it|~it~};separator=\".\"~ >>";
}  