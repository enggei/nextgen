package nextgen.templates.java;

public class TryStmt {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _tryBlock;
	private Object _finalClause;
	private java.util.List<Object> _catchClauses = new java.util.ArrayList<>();
	private java.util.List<Object> _resources = new java.util.ArrayList<>();

	TryStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TryStmt");
		st.add("tryBlock", _tryBlock);
		st.add("finalClause", _finalClause);
		for (Object o : _catchClauses) st.add("catchClauses", o);
		for (Object o : _resources) st.add("resources", o);
		return st.render().trim();
	}

	public TryStmt setTryBlock(Object value) {
		this._tryBlock = value;
		return this;
	}

	public Object getTryBlock() {
		return this._tryBlock;
	}

	public Object getTryBlock(Object defaultValue) {
		return this._tryBlock == null ? defaultValue : this._tryBlock;
	}

	public boolean hasTryBlock() {
		return this._tryBlock != null;
	}

	public TryStmt removeTryBlock() {
		this._tryBlock = null;
		return this;
	} 

	public TryStmt setFinalClause(Object value) {
		this._finalClause = value;
		return this;
	}

	public Object getFinalClause() {
		return this._finalClause;
	}

	public Object getFinalClause(Object defaultValue) {
		return this._finalClause == null ? defaultValue : this._finalClause;
	}

	public boolean hasFinalClause() {
		return this._finalClause != null;
	}

	public TryStmt removeFinalClause() {
		this._finalClause = null;
		return this;
	} 
	public TryStmt addCatchClauses(Object value) {
		this._catchClauses.add(value);
		return this;
	}

	public TryStmt removeCatchClauses(Object value) {
		this._catchClauses.remove(value);
		return this;
	}

	public TryStmt removeCatchClauses(int index) {
		this._catchClauses.remove(index);
		return this;
	}

	public java.util.List<Object> getCatchClauses() {
		return this._catchClauses;
	} 

	public TryStmt addResources(Object value) {
		this._resources.add(value);
		return this;
	}

	public TryStmt removeResources(Object value) {
		this._resources.remove(value);
		return this;
	}

	public TryStmt removeResources(int index) {
		this._resources.remove(index);
		return this;
	}

	public java.util.List<Object> getResources() {
		return this._resources;
	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TryStmt that = (TryStmt) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TryStmt(tryBlock,finalClause,catchClauses,resources) ::= <<try~if(resources)~ (~resources:{it|~it~};separator=\";\"~)~endif~ ~tryBlock~ ~catchClauses:{it|~it~}~~if(finalClause)~ finally ~finalClause~~endif~>> ";
}  