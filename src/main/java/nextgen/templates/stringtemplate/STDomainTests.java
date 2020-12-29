package nextgen.templates.stringtemplate;

public class STDomainTests {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private Object _domainName;
	private java.util.List<java.util.Map<String, Object>> _testcases = new java.util.ArrayList<>();

	STDomainTests(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("STDomainTests");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("domainName", _domainName);
		for (java.util.Map<String, Object> map : _testcases) st.addAggr("testcases.{impl,name}", map.get("impl"), map.get("name"));
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


	public STDomainTests setTestcases(java.util.Collection<STDomainTests_Testcases> values) {
			this._testcases.clear();
			values.stream().map(STDomainTests_Testcases::asMap).forEach(map -> _testcases.add(map));
			return this;
		}

	public STDomainTests addTestcases(Object _impl, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("impl", _impl);
		map.put("name", _name);
		this._testcases.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getTestcases() {
		return this._testcases;
	}

	public STDomainTests addTestcases(STDomainTests_Testcases value) {
		return addTestcases(value._impl, value._name);
	}

	public java.util.stream.Stream<STDomainTests_Testcases> streamTestcases() {
		return this._testcases.stream().map(STDomainTests_Testcases::new);
	}

	public java.util.List<Object> getTestcases_Impl() {
		return streamTestcases().map(STDomainTests_Testcases::getImpl).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getTestcases_Name() {
		return streamTestcases().map(STDomainTests_Testcases::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class STDomainTests_Testcases {

		Object _impl;
		Object _name;

		public STDomainTests_Testcases(Object _impl, Object _name) {
			this._impl = _impl;
			this._name = _name;
		}

		private STDomainTests_Testcases(java.util.Map<String, Object> map) {
			this._impl = (Object) map.get("impl");
			this._name = (Object) map.get("name");
		}

		public Object getImpl() {
			return this._impl;
		}

		public Object getName() {
			return this._name;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("impl", _impl);
			map.put("name", _name);
			return map;
		}

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

	static final String st = "STDomainTests(packageName,testcases,name,domainName) ::= <<package ~packageName~;\n" + 
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
				"} >>";
}  