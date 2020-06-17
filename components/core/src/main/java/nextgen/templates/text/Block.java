package nextgen.templates.text;

public class Block {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _start;
	private Object _end;
	private java.util.List<Object> _scope = new java.util.ArrayList<>();

	Block(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Block");
		st.add("start", _start);
		st.add("end", _end);
		for (Object o : _scope) st.add("scope", o);
		return st.render().trim();
	}

	public Block setStart(Object value) {
		this._start = value;
		return this;
	}

	public Object getStart() {
		return this._start;
	}

	public Object getStart(Object defaultValue) {
		return this._start == null ? defaultValue : this._start;
	}

	public boolean hasStart() {
		return this._start != null;
	}

	public Block removeStart() {
		this._start = null;
		return this;
	} 

	public Block setEnd(Object value) {
		this._end = value;
		return this;
	}

	public Object getEnd() {
		return this._end;
	}

	public Object getEnd(Object defaultValue) {
		return this._end == null ? defaultValue : this._end;
	}

	public boolean hasEnd() {
		return this._end != null;
	}

	public Block removeEnd() {
		this._end = null;
		return this;
	} 

	public Block addScope(Object value) {
		this._scope.add(value);
		return this;
	}

	public Block setScope(Object[] value) {
		this._scope.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Block setScope(java.util.Collection<Object> values) {
		this._scope.addAll(values);
		return this;
	}

	public Block removeScope(Object value) {
		this._scope.remove(value);
		return this;
	}

	public Block removeScope(int index) {
		this._scope.remove(index);
		return this;
	}

	public java.util.List<Object> getScope() {
		return this._scope;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Block that = (Block) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Block(start,scope,end) ::= <<~start~\n" + 
				"	~scope:{it|~it~};separator=\"\\n\"~\n" + 
				"~end~ >>";
} 