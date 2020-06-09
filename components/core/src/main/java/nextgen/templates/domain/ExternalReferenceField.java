package nextgen.templates.domain;

public class ExternalReferenceField {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Class<?> _type;
	private Boolean _lexical;

	ExternalReferenceField(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ExternalReferenceField that = (ExternalReferenceField) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ExternalReferenceField");
		st.add("name", _name);
		st.add("type", _type);
		st.add("lexical", _lexical);
		return st.render().trim();
	}

	public ExternalReferenceField setName(String value) {
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

	public ExternalReferenceField removeName() {
		this._name = null;
		return this;
	} 

	public ExternalReferenceField setType(Class<?> value) {
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

	public ExternalReferenceField removeType() {
		this._type = null;
		return this;
	} 

	public ExternalReferenceField setLexical(Boolean value) {
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

	public ExternalReferenceField removeLexical() {
		this._lexical = null;
		return this;
	} 

	static final String st = "ExternalReferenceField(name,type,lexical) ::= <<External field ~name~ (~type~)~if(lexical)~ lexical~endif~>> ";
} 