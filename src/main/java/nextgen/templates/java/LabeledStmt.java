package nextgen.templates.java;

public class LabeledStmt implements Statement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _label;
	private Object _statement;

	LabeledStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LabeledStmt");
		st.add("label", _label);
		st.add("statement", _statement);
		return st.render().trim();
	}

	public LabeledStmt setLabel(Object value) {
		this._label = value;
		return this;
	}

	public Object getLabel() {
		return this._label;
	}

	public Object getLabel(Object defaultValue) {
		return this._label == null ? defaultValue : this._label;
	}

	public boolean hasLabel() {
		return this._label != null;
	}

	public LabeledStmt removeLabel() {
		this._label = null;
		return this;
	} 

	public LabeledStmt setStatement(Object value) {
		this._statement = value;
		return this;
	}

	public Object getStatement() {
		return this._statement;
	}

	public Object getStatement(Object defaultValue) {
		return this._statement == null ? defaultValue : this._statement;
	}

	public boolean hasStatement() {
		return this._statement != null;
	}

	public LabeledStmt removeStatement() {
		this._statement = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LabeledStmt that = (LabeledStmt) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "LabeledStmt(label,statement) ::= <<~label~ : \n" + 
				"	~statement~ >>";
}  