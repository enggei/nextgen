package nextgen.st.stringtemplate;

public class STEnumValue {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _lexical;

	STEnumValue(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("STEnumValue");
		st.add("name", _name);
		st.add("lexical", _lexical);
		return st.render().trim();
	}

	public STEnumValue setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public STEnumValue removeName() {
		this._name = null;
		return this;
	} 

	public STEnumValue setLexical(Object value) {
		this._lexical = value;
		return this;
	}

	public Object getLexical() {
		return this._lexical;
	}

	public Object getLexical(Object defaultValue) {
		return this._lexical == null ? defaultValue : this._lexical;
	}

	public boolean hasLexical() {
		return this._lexical != null;
	}

	public STEnumValue removeLexical() {
		this._lexical = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STEnumValue that = (STEnumValue) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "STEnumValue(name,lexical) ::= <<~name~~if(lexical)~() {\n" + 
				"	@Override\n" + 
				"	public String toString() { return \"~lexical~\"; }\n" + 
				"}~endif~ >>";
}  