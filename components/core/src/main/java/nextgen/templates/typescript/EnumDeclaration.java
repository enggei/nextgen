package nextgen.templates.typescript;

public class EnumDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _enumValues = new java.util.ArrayList<>();

	EnumDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("enumDeclaration");
		st.add("name", _name);
		for (Object o : _enumValues) st.add("enumValues", o);
		return st.render().trim();
	}

	public EnumDeclaration setName(Object value) {
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

	public EnumDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public EnumDeclaration addEnumValues(Object value) {
		this._enumValues.add(value);
		return this;
	}

	public EnumDeclaration setEnumValues(Object[] value) {
		this._enumValues.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EnumDeclaration setEnumValues(java.util.Collection<Object> values) {
		this._enumValues.addAll(values);
		return this;
	}

	public EnumDeclaration removeEnumValues(Object value) {
		this._enumValues.remove(value);
		return this;
	}

	public EnumDeclaration removeEnumValues(int index) {
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
		EnumDeclaration that = (EnumDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "enumDeclaration(name,enumValues) ::= <<enum ~name~ {~enumValues:{it|~it~};separator=\",\"~} >>";
} 