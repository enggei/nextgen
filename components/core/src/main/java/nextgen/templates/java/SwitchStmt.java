package nextgen.templates.java;

public class SwitchStmt implements Statement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _selector;
	private java.util.List<Object> _entries = new java.util.ArrayList<>();

	SwitchStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SwitchStmt");
		st.add("selector", _selector);
		for (Object o : _entries) st.add("entries", o);
		return st.render().trim();
	}

	public SwitchStmt setSelector(Object value) {
		this._selector = value;
		return this;
	}

	public Object getSelector() {
		return this._selector;
	}

	public Object getSelector(Object defaultValue) {
		return this._selector == null ? defaultValue : this._selector;
	}

	public boolean hasSelector() {
		return this._selector != null;
	}

	public SwitchStmt removeSelector() {
		this._selector = null;
		return this;
	} 

	public SwitchStmt addEntries(Object value) {
		this._entries.add(value);
		return this;
	}

	public SwitchStmt setEntries(Object[] value) {
		this._entries.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public SwitchStmt setEntries(java.util.Collection<Object> values) {
		this._entries.addAll(values);
		return this;
	}

	public SwitchStmt removeEntries(Object value) {
		this._entries.remove(value);
		return this;
	}

	public SwitchStmt removeEntries(int index) {
		this._entries.remove(index);
		return this;
	}

	public java.util.List<Object> getEntries() {
		return this._entries;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SwitchStmt that = (SwitchStmt) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SwitchStmt(selector,entries) ::= <<switch(~selector~) {\n" + 
				"	~entries:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  