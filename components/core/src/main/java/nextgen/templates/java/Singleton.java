package nextgen.templates.java;

public class Singleton {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _packageName;
	private String _name;
	private java.util.List<Object> _accessors = new java.util.ArrayList<>();
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
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (Object o : _accessors) st.add("accessors", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name,initializer}", map.get("type"), map.get("name"), map.get("initializer"));
		return st.render().trim();
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

	public Singleton addAccessors(Object value) {
		this._accessors.add(value);
		return this;
	}

	public Singleton setAccessors(Object[] value) {
		this._accessors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Singleton setAccessors(java.util.Collection<Object> values) {
		this._accessors.addAll(values);
		return this;
	}

	public Singleton removeAccessors(Object value) {
		this._accessors.remove(value);
		return this;
	}

	public Singleton removeAccessors(int index) {
		this._accessors.remove(index);
		return this;
	}

	public java.util.List<Object> getAccessors() {
		return this._accessors;
	} 

	public Singleton addFields(Object _type, Object _name, Object _initializer) {
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

	public Singleton addFields(Singleton_Fields value) {
		return addFields(value._type, value._name, value._initializer);
	}

	public java.util.stream.Stream<Singleton_Fields> streamFields() {
		return this._fields.stream().map(Singleton_Fields::new);
	}

	public java.util.List<Object> getFields_Type() {
		return streamFields().map(Singleton_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Name() {
		return streamFields().map(Singleton_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Initializer() {
		return streamFields().map(Singleton_Fields::getInitializer).collect(java.util.stream.Collectors.toList());
	}


	public static final class Singleton_Fields {

		Object _type;
		Object _name;
		Object _initializer;

		public Singleton_Fields(Object _type, Object _name, Object _initializer) {
			this._type = _type;
			this._name = _name;
			this._initializer = _initializer;
		}

		private Singleton_Fields(java.util.Map<String, Object> map) {
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
		Singleton that = (Singleton) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Singleton(packageName,name,fields,accessors) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public final class ~name~ {\n" + 
				" \n" + 
				"    private static ~name~ INSTANCE;\n" + 
				"    ~fields:{it|private ~it.type~ _~it.name~~if(it.initializer)~ = ~it.initializer~~endif~;};separator=\"\\n\"~\n" + 
				"    \n" + 
				"    private ~name~() {        \n" + 
				"    }\n" + 
				"    \n" + 
				"    public static synchronized ~name~ getInstance() {\n" + 
				"        if(INSTANCE == null) INSTANCE = new ~name~();\n" + 
				"        return INSTANCE;\n" + 
				"    }\n" + 
				" \n" + 
				"    ~accessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  