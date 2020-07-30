package grammars;

public class AntlrParserRule {

	private final java.util.UUID uuid;
	public String _name;
	public java.util.List<String> _alternatives = new java.util.ArrayList<>();

	public AntlrParserRule() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public AntlrParserRule(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AntlrParserRule that = (AntlrParserRule) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}