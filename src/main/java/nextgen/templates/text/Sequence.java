package nextgen.templates.text;

public class Sequence {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _items = new java.util.ArrayList<>();

	Sequence(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Sequence");
		for (Object o : _items) st.add("items", o);
		return st.render().trim();
	}


	public Sequence addItems(Object value) {
		this._items.add(value);
		return this;
	}

	public Sequence setItems(Object[] value) {
		this._items.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Sequence setItems(java.util.Collection<Object> values) {
		this._items.addAll(values);
		return this;
	}

	public Sequence removeItems(Object value) {
		this._items.remove(value);
		return this;
	}

	public Sequence removeItems(int index) {
		this._items.remove(index);
		return this;
	}

	public java.util.List<Object> getItems() {
		return this._items;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Sequence that = (Sequence) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Sequence(items) ::= <<~items:{it|~it~};separator=\" \"~ >>";
}  