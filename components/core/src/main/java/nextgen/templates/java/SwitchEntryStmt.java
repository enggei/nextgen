package nextgen.templates.java;

public class SwitchEntryStmt {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _labels = new java.util.ArrayList<>();
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	SwitchEntryStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SwitchEntryStmt that = (SwitchEntryStmt) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SwitchEntryStmt");
		for (Object o : _labels) st.add("labels", o);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public SwitchEntryStmt addLabels(Object value) {
		this._labels.add(value);
		return this;
	}

	public SwitchEntryStmt removeLabels(Object value) {
		this._labels.remove(value);
		return this;
	}

	public SwitchEntryStmt removeLabels(int index) {
		this._labels.remove(index);
		return this;
	}

	public java.util.List<Object> getLabels() {
		return this._labels;
	} 

	public SwitchEntryStmt addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public SwitchEntryStmt removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public SwitchEntryStmt removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	static final String st = "SwitchEntryStmt(labels,statements) ::= <<~if(labels)~~labels:{it|case ~it~ :};separator=\"\\n\"~~else~default :~endif~\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~>> ";
} 