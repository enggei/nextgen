package nextgen.st.parser;

public class ParsedSTTemplate {

	private final java.util.UUID uuid;
	private String _name;
	private String _text;
	private java.util.List<ParsedSTParameter> _parameters = new java.util.ArrayList<>();

	public ParsedSTTemplate() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public ParsedSTTemplate(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public String getName() {
		return this._name;
	}

	public ParsedSTTemplate setName(String value) {
		this._name = value;
		return this;
	}

	public String getText() {
		return this._text;
	}

	public ParsedSTTemplate setText(String value) {
		this._text = value;
		return this;
	}

	public java.util.List<ParsedSTParameter> getParameters() {
		return this._parameters;
	}

	public ParsedSTTemplate addParameters(ParsedSTParameter value) {
		this._parameters.add(value);
		return this;
	}

	public ParsedSTTemplate removeParameters(ParsedSTParameter value) {
		this._parameters.remove(value);
		return this;
	}

	@Override
	public String toString() {
		return _name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ParsedSTTemplate that = (ParsedSTTemplate) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}