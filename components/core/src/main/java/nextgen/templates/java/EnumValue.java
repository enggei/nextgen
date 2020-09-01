package nextgen.templates.java;

public class EnumValue {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private String _lexical;

	EnumValue(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EnumValue");
		st.add("name", _name);
		st.add("lexical", _lexical);
		return st.render().trim();
	}

	public EnumValue setName(String value) {
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

	public EnumValue removeName() {
		this._name = null;
		return this;
	} 

	public EnumValue setLexical(String value) {
		this._lexical = value;
		return this;
	}

	public String getLexical() {
		return this._lexical;
	}

	public String getLexical(String defaultValue) {
		return this._lexical == null ? defaultValue : this._lexical;
	}

	public boolean hasLexical() {
		return this._lexical != null;
	}

	public EnumValue removeLexical() {
		this._lexical = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EnumValue that = (EnumValue) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "EnumValue(name,lexical) ::= <<~name~~if(lexical)~() {\n" + 
				"	@Override\n" + 
				"	public String toString() { return \"~lexical~\"; }\n" + 
				"}~endif~ >>";
}  