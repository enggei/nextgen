package nextgen.templates.java;

public class ValueObject {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _package;
	private Object _name;
	private java.util.List<Object> _lexical = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	ValueObject(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ValueObject");
		st.add("package", _package);
		st.add("name", _name);
		for (Object o : _lexical) st.add("lexical", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name,initializer}", map.get("type"), map.get("name"), map.get("initializer"));
		return st.render().trim();
	}

	public ValueObject setPackage(Object value) {
		this._package = value;
		return this;
	}

	public Object getPackage() {
		return this._package;
	}

	public Object getPackage(Object defaultValue) {
		return this._package == null ? defaultValue : this._package;
	}

	public boolean hasPackage() {
		return this._package != null;
	}

	public ValueObject removePackage() {
		this._package = null;
		return this;
	} 

	public ValueObject setName(Object value) {
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

	public ValueObject removeName() {
		this._name = null;
		return this;
	} 

	public ValueObject addLexical(Object value) {
		this._lexical.add(value);
		return this;
	}

	public ValueObject setLexical(Object[] value) {
		this._lexical.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ValueObject setLexical(java.util.Collection<Object> values) {
		this._lexical.addAll(values);
		return this;
	}

	public ValueObject removeLexical(Object value) {
		this._lexical.remove(value);
		return this;
	}

	public ValueObject removeLexical(int index) {
		this._lexical.remove(index);
		return this;
	}

	public java.util.List<Object> getLexical() {
		return this._lexical;
	} 

	public ValueObject addFields(Object _type, Object _name, Object _initializer) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		map.put("initializer", _initializer);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public ValueObject addFields(ValueObject_Fields value) {
		return addFields(value._type, value._name, value._initializer);
	}

	public java.util.stream.Stream<ValueObject_Fields> streamFields() {
		return this._fields.stream().map(ValueObject_Fields::new);
	}

	public static final class ValueObject_Fields {

		Object _type;
		Object _name;
		Object _initializer;

		public ValueObject_Fields(Object _type, Object _name, Object _initializer) {
			this._type = _type;
			this._name = _name;
			this._initializer = _initializer;
		}

		private ValueObject_Fields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
			this._initializer = (Object) map.get("initializer");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

		public Object getInitializer() {
			return this._initializer;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ValueObject that = (ValueObject) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ValueObject(package,name,fields,lexical) ::= <<package ~package~;\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"	private final java.util.UUID uuid;\n" + 
				"	~fields:{it|public ~it.type~ _~it.name~~if(it.initializer)~ = ~it.initializer~~endif~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	public ~name~() {\n" + 
				"		this.uuid = java.util.UUID.randomUUID();\n" + 
				"	}\n" + 
				"\n" + 
				"	public ~name~(java.util.UUID uuid) {\n" + 
				"		this.uuid = uuid;\n" + 
				"	}\n" + 
				"\n" + 
				"	public java.util.UUID getUuid() {\n" + 
				"		return this.uuid;\n" + 
				"	}	\n" + 
				"	\n" + 
				"	@Override\n" + 
				"	public String toString() {\n" + 
				"		return ~if(lexical)~~lexical:{it|_~it~};separator=\" + \\\" \\\" + \"~~else~this.uuid.toString()~endif~;\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public boolean equals(Object o) {\n" + 
				"		if (this == o) return true;\n" + 
				"		if (o == null || getClass() != o.getClass()) return false;\n" + 
				"		~name~ that = (~name~) o;\n" + 
				"		return uuid.equals(that.uuid);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public int hashCode() {\n" + 
				"		return java.util.Objects.hash(uuid);\n" + 
				"	}\n" + 
				"} >>";
}  