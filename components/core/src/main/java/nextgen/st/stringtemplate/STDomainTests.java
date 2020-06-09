package nextgen.st.stringtemplate;

public class STDomainTests {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _domainName;
	private Object _name;
	private java.util.List<java.util.Map<String, Object>> _testcases = new java.util.ArrayList<>();

	STDomainTests(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STDomainTests that = (STDomainTests) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("STDomainTests");
		st.add("packageName", _packageName);
		st.add("domainName", _domainName);
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _testcases) st.addAggr("testcases.{name,impl}", map.get("name"), map.get("impl"));
		return st.render().trim();
	}

	public STDomainTests setPackageName(Object value) {
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

	public STDomainTests removePackageName() {
		this._packageName = null;
		return this;
	} 

	public STDomainTests setDomainName(Object value) {
		this._domainName = value;
		return this;
	}

	public Object getDomainName() {
		return this._domainName;
	}

	public Object getDomainName(Object defaultValue) {
		return this._domainName == null ? defaultValue : this._domainName;
	}

	public boolean hasDomainName() {
		return this._domainName != null;
	}

	public STDomainTests removeDomainName() {
		this._domainName = null;
		return this;
	} 

	public STDomainTests setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public STDomainTests removeName() {
		this._name = null;
		return this;
	} 
	public STDomainTests addTestcases(Object _name, Object _impl) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("impl", _impl);
		this._testcases.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getTestcases() {
		return this._testcases;
	}

	public STDomainTests addTestcases(STDomainTests_Testcases value) {
		return addTestcases(value._name, value._impl);
	}

	public java.util.stream.Stream<STDomainTests_Testcases> streamTestcases() {
		return this._testcases.stream().map(STDomainTests_Testcases::new);
	}

	public static final class STDomainTests_Testcases {

		Object _name;
		Object _impl;

		public STDomainTests_Testcases(Object _name, Object _impl) {
			this._name = _name;
			this._impl = _impl;
		}

		private STDomainTests_Testcases(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._impl = (Object) map.get("impl");
		}

		public Object getName() {
			return this._name;
		}

		public Object getImpl() {
			return this._impl;
		}

	} 

	static final String st = "STDomainTests(packageName,domainName,name,testcases) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import static ~packageName~.~domainName~.*;\n" + 
				"\n" + 
				"/**\n" + 
				" * Tests for ~domainName~\n" + 
				" **/\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"	@org.junit.Test\n" + 
				"	public void testAll() {\n" + 
				"		~testcases:{it|test~it.name;format=\"capitalize\"~();};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	~testcases:{it|~it.impl~};separator=\"\\n\\n\"~\n" + 
				"}>> ";
} 