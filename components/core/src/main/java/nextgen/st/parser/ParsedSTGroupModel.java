package nextgen.st.parser;

public class ParsedSTGroupModel {

	private final java.util.UUID uuid;
	private String _name;
	private String _delimiter;
	private java.util.List<ParsedSTTemplate> _templates = new java.util.ArrayList<>();

	public ParsedSTGroupModel() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public ParsedSTGroupModel(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public String getName() {
		return this._name;
	}

	public ParsedSTGroupModel setName(String value) {
		this._name = value;
		return this;
	}

	public String getDelimiter() {
		return this._delimiter;
	}

	public ParsedSTGroupModel setDelimiter(String value) {
		this._delimiter = value;
		return this;
	}

	public java.util.List<ParsedSTTemplate> getTemplates() {
		return this._templates;
	}

	public ParsedSTGroupModel addTemplates(ParsedSTTemplate value) {
		this._templates.add(value);
		return this;
	}

	public ParsedSTGroupModel removeTemplates(ParsedSTTemplate value) {
		this._templates.remove(value);
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
		ParsedSTGroupModel that = (ParsedSTGroupModel) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}