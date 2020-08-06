package nextgen.templates.vertx;

public class ListPrimitiveAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _name;
	private Object _type;

	ListPrimitiveAccessors(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("listPrimitiveAccessors");
		st.add("className", _className);
		st.add("name", _name);
		st.add("type", _type);
		return st.render().trim();
	}

	public ListPrimitiveAccessors setClassName(Object value) {
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

	public ListPrimitiveAccessors removeClassName() {
		this._className = null;
		return this;
	} 

	public ListPrimitiveAccessors setName(Object value) {
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

	public ListPrimitiveAccessors removeName() {
		this._name = null;
		return this;
	} 

	public ListPrimitiveAccessors setType(Object value) {
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

	public ListPrimitiveAccessors removeType() {
		this._type = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ListPrimitiveAccessors that = (ListPrimitiveAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "listPrimitiveAccessors(className,name,type) ::= <<public ~className;format=\"capitalize\"~ add~name;format=\"capitalize\"~(~type~ value) { \n" + 
				"	io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray(\"~name~\");\n" + 
				"	if (jsonArray == null) jsonObject.put(\"~name~\", jsonArray = new io.vertx.core.json.JsonArray());\n" + 
				"	jsonArray.add(value);\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.stream.Stream<~type~> get~name;format=\"capitalize\"~() { \n" + 
				"	return jsonObject.getJsonArray(\"~name~\", new io.vertx.core.json.JsonArray()).stream().map((o) -> (~type~)o);\n" + 
				"}\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ remove~name;format=\"capitalize\"~(~type~ value) { \n" + 
				"	final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray(\"~name~\", new io.vertx.core.json.JsonArray());\n" + 
				"	for (int i = 0; i < jsonArray.size(); i++)  { \n" + 
				"		final ~type~ o = jsonArray.get~type~(i);\n" + 
				"		if (value.equals(o))  { \n" + 
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
				"} >>";
}  