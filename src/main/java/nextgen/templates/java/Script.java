package nextgen.templates.java;

public class Script {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _packageName;
	private String _name;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	Script(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Script");
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (Object o : _statements) st.add("statements", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public Script setPackageName(String value) {
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

	public Script removePackageName() {
		this._packageName = null;
		return this;
	} 

	public Script setName(String value) {
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

	public Script removeName() {
		this._name = null;
		return this;
	} 

	public Script addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public Script setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Script setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public Script removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public Script removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public Script addFields(Object _type, String _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public Script addFields(Script_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<Script_Fields> streamFields() {
		return this._fields.stream().map(Script_Fields::new);
	}

	public java.util.List<Object> getFields_Type() {
		return streamFields().map(Script_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<String> getFields_Name() {
		return streamFields().map(Script_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class Script_Fields {

		Object _type;
		String _name;

		public Script_Fields(Object _type, String _name) {
			this._type = _type;
			this._name = _name;
		}

		private Script_Fields(java.util.Map<String, Object> map) {
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
		Script that = (Script) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Script(packageName,name,fields,statements) ::= <<package ~if(packageName)~~packageName~~else~tmp~endif~;\n" + 
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
				"} >>";
}  