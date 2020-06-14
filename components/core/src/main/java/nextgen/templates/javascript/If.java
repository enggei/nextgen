package nextgen.templates.javascript;

public class If {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _condition;
	private Object _blockStmt;

	If(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("If");
		st.add("condition", _condition);
		st.add("blockStmt", _blockStmt);
		return st.render().trim();
	}

	public If setCondition(Object value) {
		this._condition = value;
		return this;
	}

	public Object getCondition() {
		return this._condition;
	}

	public Object getCondition(Object defaultValue) {
		return this._condition == null ? defaultValue : this._condition;
	}

	public boolean hasCondition() {
		return this._condition != null;
	}

	public If removeCondition() {
		this._condition = null;
		return this;
	}

	public If setBlockStmt(Object value) {
		this._blockStmt = value;
		return this;
	}

	public Object getBlockStmt() {
		return this._blockStmt;
	}

	public Object getBlockStmt(Object defaultValue) {
		return this._blockStmt == null ? defaultValue : this._blockStmt;
	}

	public boolean hasBlockStmt() {
		return this._blockStmt != null;
	}

	public If removeBlockStmt() {
		this._blockStmt = null;
		return this;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		If that = (If) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "If(condition,blockStmt) ::= <<if (~condition~) ~blockStmt~>>";
}