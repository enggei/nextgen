package nextgen.templates.domain;

public class Domain {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _entities = new java.util.ArrayList<>();

	Domain(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Domain that = (Domain) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Domain");
		st.add("name", _name);
		for (Object o : _entities) st.add("entities", o);
		return st.render().trim();
	}

	public Domain setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public Domain removeName() {
		this._name = null;
		return this;
	} 
	public Domain addEntities(Object value) {
		this._entities.add(value);
		return this;
	}

	public Domain removeEntities(Object value) {
		this._entities.remove(value);
		return this;
	}

	public Domain removeEntities(int index) {
		this._entities.remove(index);
		return this;
	}

	public java.util.List<Object> getEntities() {
		return this._entities;
	} 

	static final String st = "Domain(name,entities) ::= <<~name~\n" + 
				"\n" + 
				"~entities:{it|~it~};separator=\"\\n\"~>> ";
} 