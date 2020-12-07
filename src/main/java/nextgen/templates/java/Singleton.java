package nextgen.templates.java;

public class Singleton {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private String _packageName;
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	Singleton(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Singleton");
		st.add("name", _name);
		st.add("packageName", _packageName);
		for (Object o : _methods) st.add("methods", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{initializer,type,name}", map.get("initializer"), map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public Singleton setName(String value) {
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

	public Singleton removeName() {
		this._name = null;
		return this;
	} 

	public Singleton setPackageName(String value) {
		this._packageName = value;
		return this;
	}

	public String getPackageName() {
		return this._packageName;
	}

	public String getPackageName(String defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public Singleton removePackageName() {
		this._packageName = null;
		return this;
	} 

	public Singleton addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public Singleton setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Singleton setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public Singleton removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public Singleton removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public Singleton addFields(Object _initializer, Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("initializer", _initializer);
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public Singleton addFields(Singleton_Fields value) {
		return addFields(value._initializer, value._type, value._name);
	}

	public java.util.stream.Stream<Singleton_Fields> streamFields() {
		return this._fields.stream().map(Singleton_Fields::new);
	}

	public java.util.List<Object> getFields_Initializer() {
		return streamFields().map(Singleton_Fields::getInitializer).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Type() {
		return streamFields().map(Singleton_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Name() {
		return streamFields().map(Singleton_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class Singleton_Fields {

		Object _initializer;
		Object _type;
		Object _name;

		public Singleton_Fields(Object _initializer, Object _type, Object _name) {
			this._initializer = _initializer;
			this._type = _type;
			this._name = _name;
		}

		private Singleton_Fields(java.util.Map<String, Object> map) {
			this._initializer = (Object) map.get("initializer");
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
		}

		public Object getInitializer() {
			return this._initializer;
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Singleton that = (Singleton) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Singleton(methods,name,fields,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public final class ~name~ {\n" + 
				"\n" + 
				"	private static ~name~ INSTANCE;\n" + 
				"	~fields:{it|private ~it.type~ _~it.name~~if(it.initializer)~ = ~it.initializer~~endif~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	private ~name~() {		  \n" + 
				"	}\n" + 
				"\n" + 
				"	public static synchronized ~name~ getInstance() {\n" + 
				"		if (INSTANCE == null) INSTANCE = new ~name~();\n" + 
				"		return INSTANCE;\n" + 
				"	}\n" + 
				"\n" + 
				"~fields:{it|\n" + 
				"	public ~it.type~ get~it.name;format=\"capitalize\"~() {\n" + 
				"		return _~it.name~;\n" + 
				"	~eom()~\n" + 
				"\n" + 
				"	public ~name~ set~it.name;format=\"capitalize\"~(~it.type~ value) {\n" + 
				"		this._~it.name~ = value;\n" + 
				"		return this;\n" + 
				"	~eom()~\n" + 
				"};separator=\"\\n\"~\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  