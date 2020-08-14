package nextgen.templates.javascript;

public class NamedImport {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _names = new java.util.ArrayList<>();

	NamedImport(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("namedImport");
		for (Object o : _names) st.add("names", o);
		return st.render().trim();
	}


	public NamedImport addNames(Object value) {
		this._names.add(value);
		return this;
	}

	public NamedImport setNames(Object[] value) {
		this._names.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NamedImport setNames(java.util.Collection<Object> values) {
		this._names.addAll(values);
		return this;
	}

	public NamedImport removeNames(Object value) {
		this._names.remove(value);
		return this;
	}

	public NamedImport removeNames(int index) {
		this._names.remove(index);
		return this;
	}

	public java.util.List<Object> getNames() {
		return this._names;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NamedImport that = (NamedImport) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "namedImport(names) ::= <<{ ~names:{it|~it~};separator=\", \"~ } >>";
}  