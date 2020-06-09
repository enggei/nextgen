package nextgen.templates.vertx;

public class ListReferenceAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _name;
	private Object _type;

	ListReferenceAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ListReferenceAccessors that = (ListReferenceAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("listReferenceAccessors");
		st.add("className", _className);
		st.add("name", _name);
		st.add("type", _type);
		return st.render().trim();
	}

	public ListReferenceAccessors setClassName(Object value) {
		this._className = value;
		return this;
	}

	public Object getClassName() {
		return this._className;
	}

	public Object getClassName(Object defaultValue) {
		return this._className == null ? defaultValue : this._className;
	}

	public boolean hasClassName() {
		return this._className != null;
	}

	public ListReferenceAccessors removeClassName() {
		this._className = null;
		return this;
	} 

	public ListReferenceAccessors setName(Object value) {
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

	public ListReferenceAccessors removeName() {
		this._name = null;
		return this;
	} 

	public ListReferenceAccessors setType(Object value) {
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

	public ListReferenceAccessors removeType() {
		this._type = null;
		return this;
	} 

	static final String st = "listReferenceAccessors(className,name,type) ::= <<public ~className;format=\"capitalize\"~ add~name;format=\"capitalize\"~(~type~ value) { \n" + 
				"	io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray(\"~name~\");\n" + 
				"	if (jsonArray == null) jsonObject.put(\"~name~\", jsonArray = new io.vertx.core.json.JsonArray());\n" + 
				"	jsonArray.add(value.getJsonObject());\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.stream.Stream<~type~> get~name;format=\"capitalize\"~() { \n" + 
				"	return jsonObject.getJsonArray(\"~name~\", new io.vertx.core.json.JsonArray()).stream().map((o) -> new ~type~((io.vertx.core.json.JsonObject) o));\n" + 
				"}\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ remove~name;format=\"capitalize\"~(~type~ value) { \n" + 
				"	final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray(\"~name~\", new io.vertx.core.json.JsonArray());\n" + 
				"	for (int i = 0; i < jsonArray.size(); i++)  { \n" + 
				"		final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);\n" + 
				"		if (value.getJsonObject().getString(\"uuid\").equals(o.getString(\"uuid\")))  { \n" + 
				"			jsonArray.remove(i);\n" + 
				"			return this;\n" + 
				"		}\n" + 
				"	}\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ clear~name;format=\"capitalize\"~() { \n" + 
				"	jsonObject.put(\"~name~\", new io.vertx.core.json.JsonArray());\n" + 
				"	return this;\n" + 
				"}>> ";
} 