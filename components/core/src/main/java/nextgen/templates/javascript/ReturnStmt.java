package nextgen.templates.javascript;

public class ReturnStmt {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _returnValue;

	ReturnStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("returnStmt");
		st.add("returnValue", _returnValue);
		return st.render().trim();
	}

	public ReturnStmt setReturnValue(Object value) {
		this._returnValue = value;
		return this;
	}

	public Object getReturnValue() {
		return this._returnValue;
	}

	public Object getReturnValue(Object defaultValue) {
		return this._returnValue == null ? defaultValue : this._returnValue;
	}

	public boolean hasReturnValue() {
		return this._returnValue != null;
	}

	public ReturnStmt removeReturnValue() {
		this._returnValue = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ReturnStmt that = (ReturnStmt) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "returnStmt(returnValue) ::= <<return ~returnValue~; >>";
}  