package nextgen.templates.vertx;

public class RQJsonArray {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;

	RQJsonArray(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("RQJsonArray");
		st.add("name", _name);
		return st.render().trim();
	}

	public RQJsonArray setName(String value) {
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

	public RQJsonArray removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RQJsonArray that = (RQJsonArray) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "RQJsonArray(name) ::= <<static JsonArray get~name;format=\"capitalize\"~(JsonObject item) {\n" + 
				"	return item.getJsonArray(\"~name~\", new JsonArray());\n" + 
				"}\n" + 
				"\n" + 
				"private static Stream<JsonObject> stream~name;format=\"capitalize\"~(JsonObject js) {\n" + 
				"	return get~name;format=\"capitalize\"~(js).stream().map(o -> (JsonObject) o);\n" + 
				"} >>";
}  