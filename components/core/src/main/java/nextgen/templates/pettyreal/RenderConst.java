package nextgen.templates.pettyreal;

public class RenderConst {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _source;
	private java.util.List<Object> _elements = new java.util.ArrayList<>();

	RenderConst(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("RenderConst");
		st.add("source", _source);
		for (Object o : _elements) st.add("elements", o);
		return st.render().trim();
	}

	public RenderConst setSource(Object value) {
		this._source = value;
		return this;
	}

	public Object getSource() {
		return this._source;
	}

	public Object getSource(Object defaultValue) {
		return this._source == null ? defaultValue : this._source;
	}

	public boolean hasSource() {
		return this._source != null;
	}

	public RenderConst removeSource() {
		this._source = null;
		return this;
	} 

	public RenderConst addElements(Object value) {
		this._elements.add(value);
		return this;
	}

	public RenderConst setElements(Object[] value) {
		this._elements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public RenderConst setElements(java.util.Collection<Object> values) {
		this._elements.addAll(values);
		return this;
	}

	public RenderConst removeElements(Object value) {
		this._elements.remove(value);
		return this;
	}

	public RenderConst removeElements(int index) {
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
		RenderConst that = (RenderConst) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "RenderConst(elements,source) ::= <<const { ~elements:{it|~it~};separator=\",\"~ } = this.props.~source~; >>";
}  