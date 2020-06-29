package nextgen.templates.java;

public class TypeParameter {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _typeBounds = new java.util.ArrayList<>();

	TypeParameter(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TypeParameter");
		st.add("name", _name);
		for (Object o : _typeBounds) st.add("typeBounds", o);
		return st.render().trim();
	}

	public TypeParameter setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public TypeParameter removeName() {
		this._name = null;
		return this;
	} 

	public TypeParameter addTypeBounds(Object value) {
		this._typeBounds.add(value);
		return this;
	}

	public TypeParameter setTypeBounds(Object[] value) {
		this._typeBounds.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TypeParameter setTypeBounds(java.util.Collection<Object> values) {
		this._typeBounds.addAll(values);
		return this;
	}

	public TypeParameter removeTypeBounds(Object value) {
		this._typeBounds.remove(value);
		return this;
	}

	public TypeParameter removeTypeBounds(int index) {
		this._typeBounds.remove(index);
		return this;
	}

	public java.util.List<Object> getTypeBounds() {
		return this._typeBounds;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TypeParameter that = (TypeParameter) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TypeParameter(name,typeBounds) ::= <<~name~~if(typeBounds)~ extends ~typeBounds:{it|~it~};separator=\" & \"~~endif~ >>";
}  