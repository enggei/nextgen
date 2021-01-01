package nextgen.templates.vertx;

public class SingleAccessor {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _model;
	private String _name;
	private Object _type;

	SingleAccessor(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("singleAccessor");
		st.add("model", _model);
		st.add("name", _name);
		st.add("type", _type);
		return st.render().trim();
	}

	public SingleAccessor setModel(Object value) {
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

	public SingleAccessor removeModel() {
		this._model = null;
		return this;
	} 

	public SingleAccessor setName(String value) {
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

	public SingleAccessor removeName() {
		this._name = null;
		return this;
	} 

	public SingleAccessor setType(Object value) {
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

	public SingleAccessor removeType() {
		this._type = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SingleAccessor that = (SingleAccessor) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "singleAccessor(model,name,type) ::= <<public ~type~ get~name;format=\"capitalize\"~() {\n" + 
				"	return get~type~(\"~name~\");\n" + 
				"}\n" + 
				"\n" + 
				"public ~model~ set~name;format=\"capitalize\"~(~type~ value) {\n" + 
				"	put(\"~name~\", value);\n" + 
				"	return this;\n" + 
				"} >>";
}  