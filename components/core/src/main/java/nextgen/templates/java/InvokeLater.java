package nextgen.templates.java;

public class InvokeLater {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _methodReference;
	private Object _statement;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	InvokeLater(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("InvokeLater");
		st.add("methodReference", _methodReference);
		st.add("statement", _statement);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public InvokeLater setMethodReference(Object value) {
		this._methodReference = value;
		return this;
	}

	public Object getMethodReference() {
		return this._methodReference;
	}

	public Object getMethodReference(Object defaultValue) {
		return this._methodReference == null ? defaultValue : this._methodReference;
	}

	public boolean hasMethodReference() {
		return this._methodReference != null;
	}

	public InvokeLater removeMethodReference() {
		this._methodReference = null;
		return this;
	} 

	public InvokeLater setStatement(Object value) {
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

	public InvokeLater removeStatement() {
		this._statement = null;
		return this;
	} 

	public InvokeLater addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public InvokeLater setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public InvokeLater setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public InvokeLater removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public InvokeLater removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InvokeLater that = (InvokeLater) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "InvokeLater(methodReference,statement,statements) ::= <<javax.swing.SwingUtilities.invokeLater(~if(methodReference)~~methodReference~~else~() -> ~if(statement)~~statement~~else~ {\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~	\n" + 
				"}~endif~~endif~); >>";
}  