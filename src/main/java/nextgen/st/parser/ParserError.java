package nextgen.st.parser;

public class ParserError {

	private final java.util.UUID uuid;
	private ParserErrorType _type;
	private String _message;
	private Integer _line;
	private Integer _charPosition;

	public ParserError() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public ParserError(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public ParserErrorType getType() {
		return this._type;
	}

	public ParserError setType(ParserErrorType value) {
		this._type = value;
		return this;
	}

	public String getMessage() {
		return this._message;
	}

	public ParserError setMessage(String value) {
		this._message = value;
		return this;
	}

	public Integer getLine() {
		return this._line;
	}

	public ParserError setLine(Integer value) {
		this._line = value;
		return this;
	}

	public Integer getCharPosition() {
		return this._charPosition;
	}

	public ParserError setCharPosition(Integer value) {
		this._charPosition = value;
		return this;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ParserError that = (ParserError) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}