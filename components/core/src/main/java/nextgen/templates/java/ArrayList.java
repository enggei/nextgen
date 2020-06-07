package nextgen.templates.java;

public class ArrayList {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _types = new java.util.ArrayList<>();

	ArrayList(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ArrayList that = (ArrayList) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ArrayList");
		for (Object o : _types) st.add("types", o);
		return st.render().trim();
	}

	public ArrayList addTypes(Object value) {
		this._types.add(value);
		return this;
	}

	public ArrayList removeTypes(Object value) {
		this._types.remove(value);
		return this;
	}

	public ArrayList removeTypes(int index) {
		this._types.remove(index);
		return this;
	}

	public java.util.List<Object> getTypes() {
		return this._types;
	} 

	static final String st = "ArrayList(types) ::= <<java.util.ArrayList<~types:{it|~it~};separator=\",\"~> >> ";
} 