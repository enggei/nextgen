package nextgen.templates.kotlin;

public class TodoStatement implements Statement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _reason;

	TodoStatement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TodoStatement");
		st.add("reason", _reason);
		return st.render().trim();
	}

	public TodoStatement setReason(String value) {
		this._reason = value;
		return this;
	}

	public String getReason() {
		return this._reason;
	}

	public String getReason(String defaultValue) {
		return this._reason == null ? defaultValue : this._reason;
	}

	public boolean hasReason() {
		return this._reason != null;
	}

	public TodoStatement removeReason() {
		this._reason = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TodoStatement that = (TodoStatement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TodoStatement(reason) ::= <<TODO(\"~reason~\") >>";
} 