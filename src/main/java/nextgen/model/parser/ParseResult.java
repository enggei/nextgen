package nextgen.model.parser;

public class ParseResult {

	private final java.util.UUID uuid;
	private ParsedSTGroupModel _parsed;
	private java.util.List<ParserError> _errors = new java.util.ArrayList<>();

	public ParseResult() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public ParseResult(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public ParsedSTGroupModel getParsed() {
		return this._parsed;
	}

	public ParseResult setParsed(ParsedSTGroupModel value) {
		this._parsed = value;
		return this;
	}

	public ParseResult removeParsed() {
		this._parsed = null;
		return this;
	}

	public java.util.List<ParserError> getErrors() {
		return this._errors;
	}

	public ParseResult addErrors(ParserError value) {
		this._errors.add(value);
		return this;
	}

	public ParseResult removeErrors(ParserError value) {
		this._errors.remove(value);
		return this;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ParseResult that = (ParseResult) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}