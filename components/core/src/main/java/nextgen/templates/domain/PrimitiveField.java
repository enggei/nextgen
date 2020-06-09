package nextgen.templates.domain;

public class PrimitiveField {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Class<?> _type;
	private Boolean _lexical;

	PrimitiveField(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PrimitiveField that = (PrimitiveField) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PrimitiveField");
		st.add("name", _name);
		st.add("type", _type);
		st.add("lexical", _lexical);
		return st.render().trim();
	}

	public PrimitiveField setName(String value) {
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

	public PrimitiveField removeName() {
		this._name = null;
		return this;
	} 

	public PrimitiveField setType(Class<?> value) {
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

	public PrimitiveField removeType() {
		this._type = null;
		return this;
	} 

	public PrimitiveField setLexical(Boolean value) {
		this._lexical = value;
		return this;
	}

	public Boolean getLexical() {
		return this._lexical;
	}

	public Boolean getLexical(Boolean defaultValue) {
		return this._lexical == null ? defaultValue : this._lexical;
	}

	public boolean hasLexical() {
		return this._lexical != null;
	}

	public PrimitiveField removeLexical() {
		this._lexical = null;
		return this;
	} 

	static final String st = "PrimitiveField(name,type,lexical) ::= <<One-to-one ~name~ ~type~ ~if(lexical)~lexical~endif~>> ";
} 