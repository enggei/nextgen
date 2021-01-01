package nextgen.templates.vertx;

public class ManyAccessor {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _type;
	private Object _model;
	private String _name;

	ManyAccessor(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("manyAccessor");
		st.add("type", _type);
		st.add("model", _model);
		st.add("name", _name);
		return st.render().trim();
	}

	public ManyAccessor setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public ManyAccessor removeType() {
		this._type = null;
		return this;
	} 

	public ManyAccessor setModel(Object value) {
		this._model = value;
		return this;
	}

	public Object getModel() {
		return this._model;
	}

	public Object getModel(Object defaultValue) {
		return this._model == null ? defaultValue : this._model;
	}

	public boolean hasModel() {
		return this._model != null;
	}

	public ManyAccessor removeModel() {
		this._model = null;
		return this;
	} 

	public ManyAccessor setName(String value) {
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

	public ManyAccessor removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ManyAccessor that = (ManyAccessor) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "manyAccessor(type,model,name) ::= <<public ~model~ add~name;format=\"capitalize\"~(JsonObject value) {\n" + 
				"	getOrCreateJsonArray(this, \"~name~\").add(value);\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public JsonArray get~name;format=\"capitalize\"~() {\n" + 
				"	return getJsonArray(this, \"~name~\");\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.stream.Stream<JsonObject> ~name~Stream() {\n" + 
				"	return stream(this, \"~name~\");\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.stream.Stream<~type~> ~name~ModelStream() {\n" + 
				"	return stream(this, \"~name~\").map(~type~::new);\n" + 
				"} >>";
}  