package nextgen.templates.kotlin;

public class OverrideHashCode {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private ReturnStatement _returnStatement;

	OverrideHashCode(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("OverrideHashCode");
		st.add("returnStatement", _returnStatement);
		return st.render().trim();
	}

	public OverrideHashCode setReturnStatement(ReturnStatement value) {
		this._returnStatement = value;
		return this;
	}

	public ReturnStatement getReturnStatement() {
		return this._returnStatement;
	}

	public ReturnStatement getReturnStatement(ReturnStatement defaultValue) {
		return this._returnStatement == null ? defaultValue : this._returnStatement;
	}

	public boolean hasReturnStatement() {
		return this._returnStatement != null;
	}

	public OverrideHashCode removeReturnStatement() {
		this._returnStatement = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OverrideHashCode that = (OverrideHashCode) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "OverrideHashCode(returnStatement) ::= <<override fun hashCode(): Int {\n" + 
				"	~returnStatement~\n" + 
				"} >>";
}  