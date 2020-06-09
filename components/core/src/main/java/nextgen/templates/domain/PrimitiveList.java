package nextgen.templates.domain;

public class PrimitiveList {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Class<?> _type;

	PrimitiveList(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PrimitiveList that = (PrimitiveList) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PrimitiveList");
		st.add("name", _name);
		st.add("type", _type);
		return st.render().trim();
	}

	public PrimitiveList setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public PrimitiveList removeName() {
		this._name = null;
		return this;
	} 

	public PrimitiveList setType(Class<?> value) {
		this._type = value;
		return this;
	}

	public Class<?> getType() {
		return this._type;
	}

	public Class<?> getType(Class<?> defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public PrimitiveList removeType() {
		this._type = null;
		return this;
	} 

	static final String st = "PrimitiveList(name,type) ::= <<List of ~name~ (~type~)>> ";
} 