package nextgen.templates.java;

public class ArrayList {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _type;

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
		st.add("type", _type);
		return st.render().trim();
	}

	public ArrayList setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public ArrayList removeType() {
		this._type = null;
		return this;
	} 

	static final String st = "ArrayList(type) ::= <<java.util.ArrayList<~type~> >> ";
} 