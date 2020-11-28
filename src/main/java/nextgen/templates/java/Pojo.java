package nextgen.templates.java;

public class Pojo {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _package;
	private String _name;
	private java.util.List<Object> _fieldDeclarations = new java.util.ArrayList<>();
	private java.util.List<Object> _accessors = new java.util.ArrayList<>();
	private java.util.List<String> _lexical = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	Pojo(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Pojo");
		st.add("package", _package);
		st.add("name", _name);
		for (Object o : _fieldDeclarations) st.add("fieldDeclarations", o);
		for (Object o : _accessors) st.add("accessors", o);
		for (Object o : _lexical) st.add("lexical", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name,initializer}", map.get("type"), map.get("name"), map.get("initializer"));
		return st.render().trim();
	}

	public Pojo setPackage(String value) {
		this._package = value;
		return this;
	}

	public String getPackage() {
		return this._package;
	}

	public String getPackage(String defaultValue) {
		return this._package == null ? defaultValue : this._package;
	}

	public boolean hasPackage() {
		return this._package != null;
	}

	public Pojo removePackage() {
		this._package = null;
		return this;
	} 

	public Pojo setName(String value) {
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

	public Pojo removeName() {
		this._name = null;
		return this;
	} 

	public Pojo addFieldDeclarations(Object value) {
		this._fieldDeclarations.add(value);
		return this;
	}

	public Pojo setFieldDeclarations(Object[] value) {
		this._fieldDeclarations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Pojo setFieldDeclarations(java.util.Collection<Object> values) {
		this._fieldDeclarations.addAll(values);
		return this;
	}

	public Pojo removeFieldDeclarations(Object value) {
		this._fieldDeclarations.remove(value);
		return this;
	}

	public Pojo removeFieldDeclarations(int index) {
		this._fieldDeclarations.remove(index);
		return this;
	}

	public java.util.List<Object> getFieldDeclarations() {
		return this._fieldDeclarations;
	} 

	public Pojo addAccessors(Object value) {
		this._accessors.add(value);
		return this;
	}

	public Pojo setAccessors(Object[] value) {
		this._accessors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Pojo setAccessors(java.util.Collection<Object> values) {
		this._accessors.addAll(values);
		return this;
	}

	public Pojo removeAccessors(Object value) {
		this._accessors.remove(value);
		return this;
	}

	public Pojo removeAccessors(int index) {
		this._accessors.remove(index);
		return this;
	}

	public java.util.List<Object> getAccessors() {
		return this._accessors;
	} 

	public Pojo addLexical(String value) {
		this._lexical.add(value);
		return this;
	}

	public Pojo setLexical(String[] value) {
		this._lexical.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Pojo setLexical(java.util.Collection<String> values) {
		this._lexical.addAll(values);
		return this;
	}

	public Pojo removeLexical(String value) {
		this._lexical.remove(value);
		return this;
	}

	public Pojo removeLexical(int index) {
		this._lexical.remove(index);
		return this;
	}

	public java.util.List<String> getLexical() {
		return this._lexical;
	} 

	public Pojo addFields(Object _type, String _name, Object _initializer) {
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

	public Pojo addFields(Pojo_Fields value) {
		return addFields(value._type, value._name, value._initializer);
	}

	public java.util.stream.Stream<Pojo_Fields> streamFields() {
		return this._fields.stream().map(Pojo_Fields::new);
	}

	public java.util.List<Object> getFields_Type() {
		return streamFields().map(Pojo_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<String> getFields_Name() {
		return streamFields().map(Pojo_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Initializer() {
		return streamFields().map(Pojo_Fields::getInitializer).collect(java.util.stream.Collectors.toList());
	}


	public static final class Pojo_Fields {

		Object _type;
		String _name;
		Object _initializer;

		public Pojo_Fields(Object _type, String _name, Object _initializer) {
			this._type = _type;
			this._name = _name;
			this._initializer = _initializer;
		}

		private Pojo_Fields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (String) map.get("name");
			this._initializer = (Object) map.get("initializer");
		}

		public Object getType() {
			return this._type;
		}

		public String getName() {
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
		Pojo that = (Pojo) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Pojo(package,name,fields,fieldDeclarations,accessors,lexical) ::= <<package ~package~;\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"	private final java.util.UUID uuid;\n" + 
				"	~fields:{it|private ~it.type~ _~it.name~~if(it.initializer)~ = ~it.initializer~~endif~;};separator=\"\\n\"~\n" + 
				"	~fieldDeclarations:{it|~it~};separator=\"\\n\"~\n" + 
				"	\n" + 
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
				"	~accessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"~if(lexical)~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public String toString() {\n" + 
				"		return ~lexical:{it|_~it~};separator=\" + \\\" \\\" + \"~;\n" + 
				"	}\n" + 
				"~endif~\n" + 
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