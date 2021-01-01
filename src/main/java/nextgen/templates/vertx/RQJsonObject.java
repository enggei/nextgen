package nextgen.templates.vertx;

public class RQJsonObject {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Object _defaultValue;

	RQJsonObject(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("RQJsonObject");
		st.add("name", _name);
		st.add("defaultValue", _defaultValue);
		return st.render().trim();
	}

	public RQJsonObject setName(String value) {
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

	public RQJsonObject removeName() {
		this._name = null;
		return this;
	} 

	public RQJsonObject setDefaultValue(Object value) {
		this._defaultValue = value;
		return this;
	}

	public Object getDefaultValue() {
		return this._defaultValue;
	}

	public Object getDefaultValue(Object defaultValue) {
		return this._defaultValue == null ? defaultValue : this._defaultValue;
	}

	public boolean hasDefaultValue() {
		return this._defaultValue != null;
	}

	public RQJsonObject removeDefaultValue() {
		this._defaultValue = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RQJsonObject that = (RQJsonObject) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "RQJsonObject(name,defaultValue) ::= <<static JsonObject get~name;format=\"capitalize\"~(JsonObject item) {\n" + 
				"	return item.getJsonObject(\"~name~\", ~defaultValue~);\n" + 
				"} >>";
}  