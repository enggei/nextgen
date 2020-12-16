package nextgen.templates.java;

public class Type {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Object _packageName;
	private java.util.List<Object> _lexical = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	Type(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Type");
		st.add("name", _name);
		st.add("packageName", _packageName);
		for (Object o : _lexical) st.add("lexical", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{name,type}", map.get("name"), map.get("type"));
		return st.render().trim();
	}

	public Type setName(String value) {
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

	public Type removeName() {
		this._name = null;
		return this;
	} 

	public Type setPackageName(Object value) {
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

	public Type removePackageName() {
		this._packageName = null;
		return this;
	} 

	public Type addLexical(Object value) {
		this._lexical.add(value);
		return this;
	}

	public Type setLexical(Object[] value) {
		this._lexical.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Type setLexical(java.util.Collection<Object> values) {
		this._lexical.addAll(values);
		return this;
	}

	public Type removeLexical(Object value) {
		this._lexical.remove(value);
		return this;
	}

	public Type removeLexical(int index) {
		this._lexical.remove(index);
		return this;
	}

	public java.util.List<Object> getLexical() {
		return this._lexical;
	} 

	public Type addFields(Object _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("type", _type);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public Type addFields(Type_Fields value) {
		return addFields(value._name, value._type);
	}

	public java.util.stream.Stream<Type_Fields> streamFields() {
		return this._fields.stream().map(Type_Fields::new);
	}

	public java.util.List<Object> getFields_Name() {
		return streamFields().map(Type_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Type() {
		return streamFields().map(Type_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class Type_Fields {

		Object _name;
		Object _type;

		public Type_Fields(Object _name, Object _type) {
			this._name = _name;
			this._type = _type;
		}

		private Type_Fields(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Type that = (Type) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Type(fields,name,lexical,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"	public static Builder builder() { return new Builder(); }\n" + 
				"\n" + 
				"	public static class Builder implements java.util.function.Supplier<~name~> {\n" + 
				"	\n" + 
				"		~fields:{it|private ~it.type~ _~it.name~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"		private Builder() { }\n" + 
				"		\n" + 
				"~fields:{it|\n" + 
				"		public Builder ~it.name~(~it.type~ _~it.name~) {\n" + 
				"			this._~it.name~ = _~it.name~;\n" + 
				"			return this;\n" + 
				"		~eom()~\n" + 
				"};separator=\"\\n\\n\"~\n" + 
				"		@Override\n" + 
				"		public ~name~ get() {\n" + 
				"			return new ~name~(~fields:{it|_~it.name~};separator=\", \"~);\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	private final java.util.UUID uuid;\n" + 
				"	~fields:{it|private final ~it.type~ _~it.name~;};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	public ~name~(~fields:{it|~it.type~ _~it.name~};separator=\", \"~) {\n" + 
				"		this.uuid = java.util.UUID.randomUUID();\n" + 
				"		~fields:{it|this._~it.name~ = _~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	public final java.util.UUID uuid() {\n" + 
				"		return this.uuid;\n" + 
				"	}	\n" + 
				"	\n" + 
				"	~fields:{it|public final ~it.type~ ~it.name~() {\n" + 
				"		return _~it.name~;\n" + 
				"	~eom()~\n" + 
				"	};separator=\"\\n\"~\n" + 
				"	\n" + 
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