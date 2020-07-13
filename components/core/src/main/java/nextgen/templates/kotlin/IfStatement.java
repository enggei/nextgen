package nextgen.templates.kotlin;

public class IfStatement implements Statement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private LogicalExpression _logicalExpression;
	private java.util.List<Statement> _statements = new java.util.ArrayList<>();

	IfStatement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("IfStatement");
		st.add("logicalExpression", _logicalExpression);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public IfStatement setLogicalExpression(LogicalExpression value) {
		this._logicalExpression = value;
		return this;
	}

	public LogicalExpression getLogicalExpression() {
		return this._logicalExpression;
	}

	public LogicalExpression getLogicalExpression(LogicalExpression defaultValue) {
		return this._logicalExpression == null ? defaultValue : this._logicalExpression;
	}

	public boolean hasLogicalExpression() {
		return this._logicalExpression != null;
	}

	public IfStatement removeLogicalExpression() {
		this._logicalExpression = null;
		return this;
	} 

	public IfStatement addStatements(Statement value) {
		this._statements.add(value);
		return this;
	}

	public IfStatement setStatements(Statement[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public IfStatement setStatements(java.util.Collection<Statement> values) {
		this._statements.addAll(values);
		return this;
	}

	public IfStatement removeStatements(Statement value) {
		this._statements.remove(value);
		return this;
	}

	public IfStatement removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Statement> getStatements() {
		return this._statements;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IfStatement that = (IfStatement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "IfStatement(logicalExpression,statements) ::= <<if(~logicalExpression~) {\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  