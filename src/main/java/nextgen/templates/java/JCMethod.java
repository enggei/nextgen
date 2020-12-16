package nextgen.templates.java;

public class JCMethod {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _O;
	private Object _apply;
	private Object _T;
	private String _name;
	private java.util.List<java.util.Map<String, Object>> _IN = new java.util.ArrayList<>();

	JCMethod(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JCMethod");
		st.add("O", _O);
		st.add("apply", _apply);
		st.add("T", _T);
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _IN) st.addAggr("IN.{type,value}", map.get("type"), map.get("value"));
		return st.render().trim();
	}

	public JCMethod setO(Object value) {
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

	public JCMethod removeO() {
		this._O = null;
		return this;
	} 

	public JCMethod setApply(Object value) {
		this._apply = value;
		return this;
	}

	public Object getApply() {
		return this._apply;
	}

	public Object getApply(Object defaultValue) {
		return this._apply == null ? defaultValue : this._apply;
	}

	public boolean hasApply() {
		return this._apply != null;
	}

	public JCMethod removeApply() {
		this._apply = null;
		return this;
	} 

	public JCMethod setT(Object value) {
		this._T = value;
		return this;
	}

	public Object getT() {
		return this._T;
	}

	public Object getT(Object defaultValue) {
		return this._T == null ? defaultValue : this._T;
	}

	public boolean hasT() {
		return this._T != null;
	}

	public JCMethod removeT() {
		this._T = null;
		return this;
	} 

	public JCMethod setName(String value) {
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

	public JCMethod removeName() {
		this._name = null;
		return this;
	} 


	public JCMethod addIN(Object _type, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("value", _value);
		this._IN.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getIN() {
		return this._IN;
	}

	public JCMethod addIN(JCMethod_IN value) {
		return addIN(value._type, value._value);
	}

	public java.util.stream.Stream<JCMethod_IN> streamIN() {
		return this._IN.stream().map(JCMethod_IN::new);
	}

	public java.util.List<Object> getIN_Type() {
		return streamIN().map(JCMethod_IN::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getIN_Value() {
		return streamIN().map(JCMethod_IN::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class JCMethod_IN {

		Object _type;
		Object _value;

		public JCMethod_IN(Object _type, Object _value) {
			this._type = _type;
			this._value = _value;
		}

		private JCMethod_IN(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._value = (Object) map.get("value");
		}

		public Object getType() {
			return this._type;
		}

		public Object getValue() {
			return this._value;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JCMethod that = (JCMethod) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JCMethod(O,apply,IN,T,name) ::= <<private static~if(T)~ ~T~~endif~ ~name~(~IN:{it|~it.type~ ~it.value~};separator=\", \"~) {\n" + 
				"	log.println(java.util.Arrays.toString(new String[]{\"~name~\", ~IN:{it|~it.value~};separator=\", \"~}));\n" + 
				"	try {\n" + 
				"		~apply~\n" + 
				"		~if(O)~return ~O~~endif~\n" + 
				"	} catch (Throwable e) {\n" + 
				"		error(e);\n" + 
				"		return null;\n" + 
				"	}\n" + 
				"} >>";
}  