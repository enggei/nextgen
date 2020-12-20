package nextgen.templates.brain;

public class Combinator {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private String _name;
	private java.util.List<Object> _combinations = new java.util.ArrayList<>();

	Combinator(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Combinator");
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (Object o : _combinations) st.add("combinations", o);
		return st.render().trim();
	}

	public Combinator setPackageName(Object value) {
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

	public Combinator removePackageName() {
		this._packageName = null;
		return this;
	} 

	public Combinator setName(String value) {
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

	public Combinator removeName() {
		this._name = null;
		return this;
	} 

	public Combinator addCombinations(Object value) {
		this._combinations.add(value);
		return this;
	}

	public Combinator setCombinations(Object[] value) {
		this._combinations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Combinator setCombinations(java.util.Collection<Object> values) {
		this._combinations.addAll(values);
		return this;
	}

	public Combinator removeCombinations(Object value) {
		this._combinations.remove(value);
		return this;
	}

	public Combinator removeCombinations(int index) {
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
		Combinator that = (Combinator) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Combinator(packageName,name,combinations) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public interface ~name~ {\n" + 
				"\n" + 
				"	~combinations:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  