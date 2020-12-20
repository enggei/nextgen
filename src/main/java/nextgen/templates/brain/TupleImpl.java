package nextgen.templates.brain;

public class TupleImpl {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _tuple;
	private String _name;
	private Object _I;
	private Object _second;
	private Object _packageName;
	private Object _O;
	private Object _first;

	TupleImpl(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TupleImpl");
		st.add("tuple", _tuple);
		st.add("name", _name);
		st.add("I", _I);
		st.add("second", _second);
		st.add("packageName", _packageName);
		st.add("O", _O);
		st.add("first", _first);
		return st.render().trim();
	}

	public TupleImpl setTuple(Object value) {
		this._tuple = value;
		return this;
	}

	public Object getTuple() {
		return this._tuple;
	}

	public Object getTuple(Object defaultValue) {
		return this._tuple == null ? defaultValue : this._tuple;
	}

	public boolean hasTuple() {
		return this._tuple != null;
	}

	public TupleImpl removeTuple() {
		this._tuple = null;
		return this;
	} 

	public TupleImpl setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public TupleImpl removeName() {
		this._name = null;
		return this;
	} 

	public TupleImpl setI(Object value) {
		this._I = value;
		return this;
	}

	public Object getI() {
		return this._I;
	}

	public Object getI(Object defaultValue) {
		return this._I == null ? defaultValue : this._I;
	}

	public boolean hasI() {
		return this._I != null;
	}

	public TupleImpl removeI() {
		this._I = null;
		return this;
	} 

	public TupleImpl setSecond(Object value) {
		this._second = value;
		return this;
	}

	public Object getSecond() {
		return this._second;
	}

	public Object getSecond(Object defaultValue) {
		return this._second == null ? defaultValue : this._second;
	}

	public boolean hasSecond() {
		return this._second != null;
	}

	public TupleImpl removeSecond() {
		this._second = null;
		return this;
	} 

	public TupleImpl setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public TupleImpl removePackageName() {
		this._packageName = null;
		return this;
	} 

	public TupleImpl setO(Object value) {
		this._O = value;
		return this;
	}

	public Object getO() {
		return this._O;
	}

	public Object getO(Object defaultValue) {
		return this._O == null ? defaultValue : this._O;
	}

	public boolean hasO() {
		return this._O != null;
	}

	public TupleImpl removeO() {
		this._O = null;
		return this;
	} 

	public TupleImpl setFirst(Object value) {
		this._first = value;
		return this;
	}

	public Object getFirst() {
		return this._first;
	}

	public Object getFirst(Object defaultValue) {
		return this._first == null ? defaultValue : this._first;
	}

	public boolean hasFirst() {
		return this._first != null;
	}

	public TupleImpl removeFirst() {
		this._first = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TupleImpl that = (TupleImpl) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TupleImpl(tuple,name,I,second,packageName,O,first) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public class ~name~ implements ~tuple~ {\n" + 
				"\n" + 
				"	@Override\n" + 
				"   public ~I~ first() {\n" + 
				"      ~first~\n" + 
				"   }\n" + 
				"\n" + 
				"   @Override\n" + 
				"   public ~O~ second() {\n" + 
				"      ~second~\n" + 
				"   }\n" + 
				"} >>";
}  