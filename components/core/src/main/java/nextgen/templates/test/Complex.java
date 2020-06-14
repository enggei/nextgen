package nextgen.templates.test;

public class Complex {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _condition1;
	private Object _condition2;
	private java.util.List<java.util.Map<String, Object>> _list = new java.util.ArrayList<>();

	Complex(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("complex");
		st.add("condition1", _condition1);
		st.add("condition2", _condition2);
		for (java.util.Map<String, Object> map : _list) st.addAggr("list.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public Complex setCondition1(Object value) {
		this._condition1 = value;
		return this;
	}

	public Object getCondition1() {
		return this._condition1;
	}

	public Object getCondition1(Object defaultValue) {
		return this._condition1 == null ? defaultValue : this._condition1;
	}

	public boolean hasCondition1() {
		return this._condition1 != null;
	}

	public Complex removeCondition1() {
		this._condition1 = null;
		return this;
	} 

	public Complex setCondition2(Object value) {
		this._condition2 = value;
		return this;
	}

	public Object getCondition2() {
		return this._condition2;
	}

	public Object getCondition2(Object defaultValue) {
		return this._condition2 == null ? defaultValue : this._condition2;
	}

	public boolean hasCondition2() {
		return this._condition2 != null;
	}

	public Complex removeCondition2() {
		this._condition2 = null;
		return this;
	} 


	public Complex addList(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._list.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getList() {
		return this._list;
	}

	public Complex addList(Complex_List value) {
		return addList(value._name, value._value);
	}

	public java.util.stream.Stream<Complex_List> streamList() {
		return this._list.stream().map(Complex_List::new);
	}

	public static final class Complex_List {

		Object _name;
		Object _value;

		public Complex_List(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private Complex_List(java.util.Map<String, Object> map) {
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
		Complex that = (Complex) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "complex(list,condition1,condition2) ::= <<~if(list)~~list:{it|~it.name~ ~it.value~(~if(condition1)~1~elseif(condition2)~2~else~NULL~endif~)};separator=\"\\n\"~~endif~ >>";
} 