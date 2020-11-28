package nextgen.templates.java;

public class IfStmt implements Statement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _condition;
	private Object _then;
	private Object _elseStmt;

	IfStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("IfStmt");
		st.add("condition", _condition);
		st.add("then", _then);
		st.add("elseStmt", _elseStmt);
		return st.render().trim();
	}

	public IfStmt setCondition(Object value) {
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

	public IfStmt removeCondition() {
		this._condition = null;
		return this;
	} 

	public IfStmt setThen(Object value) {
		this._then = value;
		return this;
	}

	public Object getThen() {
		return this._then;
	}

	public Object getThen(Object defaultValue) {
		return this._then == null ? defaultValue : this._then;
	}

	public boolean hasThen() {
		return this._then != null;
	}

	public IfStmt removeThen() {
		this._then = null;
		return this;
	} 

	public IfStmt setElseStmt(Object value) {
		this._elseStmt = value;
		return this;
	}

	public Object getElseStmt() {
		return this._elseStmt;
	}

	public Object getElseStmt(Object defaultValue) {
		return this._elseStmt == null ? defaultValue : this._elseStmt;
	}

	public boolean hasElseStmt() {
		return this._elseStmt != null;
	}

	public IfStmt removeElseStmt() {
		this._elseStmt = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IfStmt that = (IfStmt) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "IfStmt(condition,then,elseStmt) ::= <<if (~condition~) ~then~~if(elseStmt)~ \n" + 
				"else ~elseStmt~~endif~ >>";
}  