package nextgen.templates.test;

public class AllTypes {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private TestInterface _single;
	private Object _cond1;
	private Object _cond2;
	private java.util.List<TestInterface> _list = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _kvList = new java.util.ArrayList<>();

	AllTypes(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("allTypes");
		st.add("single", _single);
		st.add("cond1", _cond1);
		st.add("cond2", _cond2);
		for (Object o : _list) st.add("list", o);
		for (java.util.Map<String, Object> map : _kvList) st.addAggr("kvList.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public AllTypes setSingle(TestInterface value) {
		this._single = value;
		return this;
	}

	public TestInterface getSingle() {
		return this._single;
	}

	public TestInterface getSingle(TestInterface defaultValue) {
		return this._single == null ? defaultValue : this._single;
	}

	public boolean hasSingle() {
		return this._single != null;
	}

	public AllTypes removeSingle() {
		this._single = null;
		return this;
	} 

	public AllTypes setCond1(Object value) {
		this._cond1 = value;
		return this;
	}

	public Object getCond1() {
		return this._cond1;
	}

	public Object getCond1(Object defaultValue) {
		return this._cond1 == null ? defaultValue : this._cond1;
	}

	public boolean hasCond1() {
		return this._cond1 != null;
	}

	public AllTypes removeCond1() {
		this._cond1 = null;
		return this;
	} 

	public AllTypes setCond2(Object value) {
		this._cond2 = value;
		return this;
	}

	public Object getCond2() {
		return this._cond2;
	}

	public Object getCond2(Object defaultValue) {
		return this._cond2 == null ? defaultValue : this._cond2;
	}

	public boolean hasCond2() {
		return this._cond2 != null;
	}

	public AllTypes removeCond2() {
		this._cond2 = null;
		return this;
	} 

	public AllTypes addList(TestInterface value) {
		this._list.add(value);
		return this;
	}

	public AllTypes setList(TestInterface[] value) {
		this._list.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public AllTypes setList(java.util.Collection<TestInterface> values) {
		this._list.addAll(values);
		return this;
	}

	public AllTypes removeList(TestInterface value) {
		this._list.remove(value);
		return this;
	}

	public AllTypes removeList(int index) {
		this._list.remove(index);
		return this;
	}

	public java.util.List<TestInterface> getList() {
		return this._list;
	} 

	public AllTypes addKvList(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._kvList.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getKvList() {
		return this._kvList;
	}

	public AllTypes addKvList(AllTypes_KvList value) {
		return addKvList(value._name, value._value);
	}

	public java.util.stream.Stream<AllTypes_KvList> streamKvList() {
		return this._kvList.stream().map(AllTypes_KvList::new);
	}

	public java.util.List<Object> getKvList_Name() {
		return streamKvList().map(AllTypes_KvList::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getKvList_Value() {
		return streamKvList().map(AllTypes_KvList::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class AllTypes_KvList {

		Object _name;
		Object _value;

		public AllTypes_KvList(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private AllTypes_KvList(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._value = (Object) map.get("value");
		}

		public Object getName() {
			return this._name;
		}

		public Object getValue() {
			return this._value;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AllTypes that = (AllTypes) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "allTypes(single,list,kvList,cond1,cond2) ::= <<A single value, ~single~, \n" + 
				"then a list ~list:{it|~it~};separator=\",\"~, \n" + 
				"and a kv-list : ~kvList:{it|~it.name~:~it.value~};separator=\",\"~\n" + 
				"\n" + 
				"If expression ~conditional(cond1,cond2)~ >>";
}  