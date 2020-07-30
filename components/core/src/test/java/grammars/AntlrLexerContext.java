package grammars;

public class AntlrLexerContext {

	private final java.util.UUID uuid;
	public boolean _prelim = true;
	public boolean _inOptions = false;
	public java.util.List<String> _options = new java.util.ArrayList<>();
	public java.util.Queue<String> _queue = new java.util.LinkedList<>();
	public java.util.List<AntlrParserRule> _rules = new java.util.ArrayList<>();

	public AntlrLexerContext() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public AntlrLexerContext(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AntlrLexerContext that = (AntlrLexerContext) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}