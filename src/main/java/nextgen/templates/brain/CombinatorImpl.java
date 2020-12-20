package nextgen.templates.brain;

public class CombinatorImpl {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Object _packageName;
	private Object _combinator;
	private java.util.List<Object> _combinations = new java.util.ArrayList<>();

	CombinatorImpl(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CombinatorImpl");
		st.add("name", _name);
		st.add("packageName", _packageName);
		st.add("combinator", _combinator);
		for (Object o : _combinations) st.add("combinations", o);
		return st.render().trim();
	}

	public CombinatorImpl setName(String value) {
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

	public CombinatorImpl removeName() {
		this._name = null;
		return this;
	} 

	public CombinatorImpl setPackageName(Object value) {
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

	public CombinatorImpl removePackageName() {
		this._packageName = null;
		return this;
	} 

	public CombinatorImpl setCombinator(Object value) {
		this._combinator = value;
		return this;
	}

	public Object getCombinator() {
		return this._combinator;
	}

	public Object getCombinator(Object defaultValue) {
		return this._combinator == null ? defaultValue : this._combinator;
	}

	public boolean hasCombinator() {
		return this._combinator != null;
	}

	public CombinatorImpl removeCombinator() {
		this._combinator = null;
		return this;
	} 

	public CombinatorImpl addCombinations(Object value) {
		this._combinations.add(value);
		return this;
	}

	public CombinatorImpl setCombinations(Object[] value) {
		this._combinations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CombinatorImpl setCombinations(java.util.Collection<Object> values) {
		this._combinations.addAll(values);
		return this;
	}

	public CombinatorImpl removeCombinations(Object value) {
		this._combinations.remove(value);
		return this;
	}

	public CombinatorImpl removeCombinations(int index) {
		this._combinations.remove(index);
		return this;
	}

	public java.util.List<Object> getCombinations() {
		return this._combinations;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CombinatorImpl that = (CombinatorImpl) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CombinatorImpl(name,packageName,combinator,combinations) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public class ~name~ implements ~combinator~ {\n" + 
				"\n" + 
				"	~combinations:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  