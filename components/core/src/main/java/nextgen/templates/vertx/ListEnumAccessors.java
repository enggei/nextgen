package nextgen.templates.vertx;

public class ListEnumAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _name;
	private Object _type;

	ListEnumAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("listEnumAccessors");
		st.add("className", _className);
		st.add("name", _name);
		st.add("type", _type);
		return st.render().trim();
	}

	public ListEnumAccessors setClassName(Object value) {
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

	public ListEnumAccessors removeClassName() {
		this._className = null;
		return this;
	} 

	public ListEnumAccessors setName(Object value) {
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

	public ListEnumAccessors removeName() {
		this._name = null;
		return this;
	} 

	public ListEnumAccessors setType(Object value) {
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

	public ListEnumAccessors removeType() {
		this._type = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ListEnumAccessors that = (ListEnumAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "listEnumAccessors(className,name,type) ::= <<public ~className;format=\"capitalize\"~ add~name;format=\"capitalize\"~(~type~ value) { \n" + 
				"	io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray(\"~name~\");\n" + 
				"	if (jsonArray == null) jsonObject.put(\"~name~\", jsonArray = new io.vertx.core.json.JsonArray());\n" + 
				"	jsonArray.add(value.name());\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.stream.Stream<~type~> get~name;format=\"capitalize\"~() { \n" + 
				"	return jsonObject.getJsonArray(\"~name~\", new io.vertx.core.json.JsonArray()).stream().map((o) -> ~type~.valueOf(o.toString()));\n" + 
				"}\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ remove~name;format=\"capitalize\"~(~type~ value) { \n" + 
				"	final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray(\"~name~\", new io.vertx.core.json.JsonArray());\n" + 
				"	jsonArray.remove(value.name());\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public ~className;format=\"capitalize\"~ clear~name;format=\"capitalize\"~() { \n" + 
				"	jsonObject.put(\"~name~\", new io.vertx.core.json.JsonArray());\n" + 
				"	return this;\n" + 
				"} >>";
}  