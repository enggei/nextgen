package nextgen.templates.domain;

public class ExternalReferenceList {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Class<?> _type;

	ExternalReferenceList(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ExternalReferenceList that = (ExternalReferenceList) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ExternalReferenceList");
		st.add("name", _name);
		st.add("type", _type);
		return st.render().trim();
	}

	public ExternalReferenceList setName(String value) {
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

	public ExternalReferenceList removeName() {
		this._name = null;
		return this;
	} 

	public ExternalReferenceList setType(Class<?> value) {
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

	public ExternalReferenceList removeType() {
		this._type = null;
		return this;
	} 

	static final String st = "ExternalReferenceList(name,type) ::= <<One-to-many ~name~ ~type~>> ";
} 