package nextgen.model.parser;

public class ParsedSTParameterKey {

	private final java.util.UUID uuid;
	private String _name;
	private String _argumentType;

	public ParsedSTParameterKey() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public ParsedSTParameterKey(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public String getName() {
		return this._name;
	}

	public ParsedSTParameterKey setName(String value) {
		this._name = value;
		return this;
	}

	public String getArgumentType() {
		return this._argumentType;
	}

	public ParsedSTParameterKey setArgumentType(String value) {
		this._argumentType = value;
		return this;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ParsedSTParameterKey that = (ParsedSTParameterKey) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}