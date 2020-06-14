package nextgen.templates.java;

public class BlockStmt implements Statement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _isStatic;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	BlockStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BlockStmt");
		st.add("isStatic", _isStatic);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public BlockStmt setIsStatic(Object value) {
		this._isStatic = value;
		return this;
	}

	public Object getIsStatic() {
		return this._isStatic;
	}

	public Object getIsStatic(Object defaultValue) {
		return this._isStatic == null ? defaultValue : this._isStatic;
	}

	public boolean hasIsStatic() {
		return this._isStatic != null;
	}

	public BlockStmt removeIsStatic() {
		this._isStatic = null;
		return this;
	} 

	public BlockStmt addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public BlockStmt setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public BlockStmt setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public BlockStmt removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public BlockStmt removeStatements(int index) {
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
		BlockStmt that = (BlockStmt) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BlockStmt(isStatic,statements) ::= <<~if(isStatic)~ static~endif~ { ~if(statements)~\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"~endif~\n" + 
				"} >>";
} 