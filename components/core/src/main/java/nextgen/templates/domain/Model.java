package nextgen.templates.domain;

public class Model {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	Model(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Model");
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public Model setName(Object value) {
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

	public Model removeName() {
		this._name = null;
		return this;
	} 


	public Model addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public Model addFields(Model_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<Model_Fields> streamFields() {
		return this._fields.stream().map(Model_Fields::new);
	}

	public static final class Model_Fields {

		Object _type;
		Object _name;

		public Model_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private Model_Fields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
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
		Model that = (Model) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Model(name,fields) ::= <<protected ~name~ new~name;format=\"capitalize\"~() { return new ~name~(); }\n" + 
				"\n" + 
				"protected class ~name~ {\n" + 
				"\n" + 
				"	private final java.util.UUID uuid = java.util.UUID.randomUUID();\n" + 
				"	~fields:{it|protected ~it.type~ _~it.name~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	protected ~name~() {\n" + 
				"\n" + 
				"	}\n" + 
				"~fields:{it|\n" + 
				"\n" + 
				"	protected ~name~ set~it.name;format=\"capitalize\"~(~it.type~ _~it.name~) {\n" + 
				"		this._~it.name~ = _~it.name~;\n" + 
				"		return this;\n" + 
				"	\\}\n" + 
				"\n" + 
				"	protected ~it.type~ get~it.name;format=\"capitalize\"~() {\n" + 
				"		return this._~it.name~;\n" + 
				"	\\}\n" + 
				"};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public boolean equals(Object o) {\n" + 
				"		if (this == o) return true;\n" + 
				"		if (o == null || getClass() != o.getClass()) return false;\n" + 
				"		UseCase useCase = (UseCase) o;\n" + 
				"		return uuid.equals(useCase.uuid);\n" + 
				"	}\n" + 
				"	\n" + 
				"	@Override\n" + 
				"	public int hashCode() {\n" + 
				"		return java.util.Objects.hash(uuid);\n" + 
				"	}\n" + 
				"} >>";
}  