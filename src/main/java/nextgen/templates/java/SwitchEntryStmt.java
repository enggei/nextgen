package nextgen.templates.java;

public class SwitchEntryStmt implements Statement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<Object> _labels = new java.util.ArrayList<>();

	SwitchEntryStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SwitchEntryStmt");
		for (Object o : _statements) st.add("statements", o);
		for (Object o : _labels) st.add("labels", o);
		return st.render().trim();
	}


	public SwitchEntryStmt addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public SwitchEntryStmt setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public SwitchEntryStmt setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
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

	public SwitchEntryStmt addLabels(Object value) {
		this._labels.add(value);
		return this;
	}

	public SwitchEntryStmt setLabels(Object[] value) {
		this._labels.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public SwitchEntryStmt setLabels(java.util.Collection<Object> values) {
		this._labels.addAll(values);
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

	static final String st = "SwitchEntryStmt(statements,labels) ::= <<~if(labels)~~labels:{it|case ~it~ :};separator=\"\\n\"~~else~default :~endif~\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~ >>";
}  