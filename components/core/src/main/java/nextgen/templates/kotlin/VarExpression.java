package nextgen.templates.kotlin;

public class VarExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _varname;

	VarExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("VarExpression");
		st.add("varname", _varname);
		return st.render().trim();
	}

	public VarExpression setVarname(String value) {
		this._varname = value;
		return this;
	}

	public String getVarname() {
		return this._varname;
	}

	public String getVarname(String defaultValue) {
		return this._varname == null ? defaultValue : this._varname;
	}

	public boolean hasVarname() {
		return this._varname != null;
	}

	public VarExpression removeVarname() {
		this._varname = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VarExpression that = (VarExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "VarExpression(varname) ::= <<~varname~ >>";
} 