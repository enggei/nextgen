package nextgen.templates.java;

public class Enum {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _package;
	private java.util.List<Object> _enumValues = new java.util.ArrayList<>();

	Enum(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Enum");
		st.add("name", _name);
		st.add("package", _package);
		for (Object o : _enumValues) st.add("enumValues", o);
		return st.render().trim();
	}

	public Enum setName(Object value) {
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

	public Enum removeName() {
		this._name = null;
		return this;
	} 

	public Enum setPackage(Object value) {
		this._package = value;
		return this;
	}

	public Object getPackage() {
		return this._package;
	}

	public Object getPackage(Object defaultValue) {
		return this._package == null ? defaultValue : this._package;
	}

	public boolean hasPackage() {
		return this._package != null;
	}

	public Enum removePackage() {
		this._package = null;
		return this;
	} 

	public Enum addEnumValues(Object value) {
		this._enumValues.add(value);
		return this;
	}

	public Enum setEnumValues(Object[] value) {
		this._enumValues.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Enum setEnumValues(java.util.Collection<Object> values) {
		this._enumValues.addAll(values);
		return this;
	}

	public Enum removeEnumValues(Object value) {
		this._enumValues.remove(value);
		return this;
	}

	public Enum removeEnumValues(int index) {
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
		Enum that = (Enum) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Enum(name,enumValues,package) ::= <<package ~package~;\n" + 
				"\n" + 
				"public enum ~name~ {\n" + 
				"\n" + 
				"	~enumValues:{it|~it~};separator=\",\\n\"~\n" + 
				"} >>";
}  