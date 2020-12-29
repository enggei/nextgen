package nextgen.templates.stringtemplate;

public class STEnum {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private java.util.List<Object> _enumValues = new java.util.ArrayList<>();

	STEnum(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("STEnum");
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (Object o : _enumValues) st.add("enumValues", o);
		return st.render().trim();
	}

	public STEnum setPackageName(Object value) {
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

	public STEnum removePackageName() {
		this._packageName = null;
		return this;
	} 

	public STEnum setName(Object value) {
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

	public STEnum removeName() {
		this._name = null;
		return this;
	} 

	public STEnum addEnumValues(Object value) {
		this._enumValues.add(value);
		return this;
	}

	public STEnum setEnumValues(Object[] value) {
		this._enumValues.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public STEnum setEnumValues(java.util.Collection<Object> values) {
		this._enumValues.addAll(values);
		return this;
	}

	public STEnum removeEnumValues(Object value) {
		this._enumValues.remove(value);
		return this;
	}

	public STEnum removeEnumValues(int index) {
		this._enumValues.remove(index);
		return this;
	}

	public java.util.List<Object> getEnumValues() {
		return this._enumValues;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STEnum that = (STEnum) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "STEnum(packageName,enumValues,name) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public enum ~name~ {\n" + 
				"\n" + 
				"	~enumValues:{it|~it~};separator=\",\\n\"~\n" + 
				"} >>";
}  