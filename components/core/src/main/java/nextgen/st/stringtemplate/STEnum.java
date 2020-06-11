package nextgen.st.stringtemplate;

public class STEnum {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _package;
	private Object _name;
	private java.util.List<Object> _enumValues = new java.util.ArrayList<>();

	STEnum(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("STEnum");
		st.add("package", _package);
		st.add("name", _name);
		for (Object o : _enumValues) st.add("enumValues", o);
		return st.render().trim();
	}

	public STEnum setPackage(Object value) {
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

	public STEnum removePackage() {
		this._package = null;
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

	static final String st = "STEnum(package,name,enumValues) ::= <<package ~package~;\n" + 
				"\n" + 
				"public enum ~name~ {\n" + 
				"\n" + 
				"	~enumValues:{it|~it~};separator=\",\\n\"~\n" + 
				"}>> ";
}  