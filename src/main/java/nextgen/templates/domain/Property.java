package nextgen.templates.domain;

public class Property {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Object _type;
	private Object _quantifier;

	Property(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Property");
		st.add("name", _name);
		st.add("type", _type);
		st.add("quantifier", _quantifier);
		return st.render().trim();
	}

	public Property setName(String value) {
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

	public Property removeName() {
		this._name = null;
		return this;
	} 

	public Property setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public Property removeType() {
		this._type = null;
		return this;
	} 

	public Property setQuantifier(Object value) {
		this._quantifier = value;
		return this;
	}

	public Object getQuantifier() {
		return this._quantifier;
	}

	public Object getQuantifier(Object defaultValue) {
		return this._quantifier == null ? defaultValue : this._quantifier;
	}

	public boolean hasQuantifier() {
		return this._quantifier != null;
	}

	public Property removeQuantifier() {
		this._quantifier = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Property that = (Property) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Property(name,type,quantifier) ::= <<~name~	~quantifier~	~type~ >>";
}  