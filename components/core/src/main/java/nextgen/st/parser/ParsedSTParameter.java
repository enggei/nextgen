package nextgen.st.parser;

public class ParsedSTParameter {

	private final java.util.UUID uuid;
	private String _name;
	private nextgen.st.domain.STParameterType _type;
	private java.util.List<ParsedSTParameterKey> _keys = new java.util.ArrayList<>();
	private String _argumentType;

	public ParsedSTParameter() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public ParsedSTParameter(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public String getName() {
		return this._name;
	}

	public ParsedSTParameter setName(String value) {
		this._name = value;
		return this;
	}

	public nextgen.st.domain.STParameterType getType() {
		return this._type;
	}

	public ParsedSTParameter setType(nextgen.st.domain.STParameterType value) {
		this._type = value;
		return this;
	}

	public ParsedSTParameter removeType() {
		this._type = null;
		return this;
	}

	public java.util.List<ParsedSTParameterKey> getKeys() {
		return this._keys;
	}

	public ParsedSTParameter addKeys(ParsedSTParameterKey value) {
		this._keys.add(value);
		return this;
	}

	public ParsedSTParameter removeKeys(ParsedSTParameterKey value) {
		this._keys.remove(value);
		return this;
	}

	public String getArgumentType() {
		return this._argumentType;
	}

	public ParsedSTParameter setArgumentType(String value) {
		this._argumentType = value;
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
		ParsedSTParameter that = (ParsedSTParameter) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}