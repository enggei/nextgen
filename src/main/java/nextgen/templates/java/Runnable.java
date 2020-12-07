package nextgen.templates.java;

public class Runnable {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private String _packageName;
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	Runnable(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Runnable");
		st.add("name", _name);
		st.add("packageName", _packageName);
		for (Object o : _methods) st.add("methods", o);
		for (Object o : _statements) st.add("statements", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public Runnable setName(String value) {
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

	public Runnable removeName() {
		this._name = null;
		return this;
	} 

	public Runnable setPackageName(String value) {
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

	public Runnable removePackageName() {
		this._packageName = null;
		return this;
	} 

	public Runnable addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public Runnable setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Runnable setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public Runnable removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public Runnable removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public Runnable addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public Runnable setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Runnable setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public Runnable removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public Runnable removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public Runnable addFields(Object _type, String _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public Runnable addFields(Runnable_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<Runnable_Fields> streamFields() {
		return this._fields.stream().map(Runnable_Fields::new);
	}

	public java.util.List<Object> getFields_Type() {
		return streamFields().map(Runnable_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<String> getFields_Name() {
		return streamFields().map(Runnable_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class Runnable_Fields {

		Object _type;
		String _name;

		public Runnable_Fields(Object _type, String _name) {
			this._type = _type;
			this._name = _name;
		}

		private Runnable_Fields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (String) map.get("name");
		}

		public Object getType() {
			return this._type;
		}

		public String getName() {
			return this._name;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Runnable that = (Runnable) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Runnable(methods,statements,fields,name,packageName) ::= <<package ~if(packageName)~~packageName~~else~tmp~endif~;\n" + 
				"\n" + 
				"public class ~name~ implements Runnable {\n" + 
				"\n" + 
				"	~fields:{it|private final ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	public ~name~(~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {	\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"	\n" + 
				"	@Override\n" + 
				"	public void run() {\n" + 
				"		~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  