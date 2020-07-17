package nextgen.templates.java;

public class JavaPackage {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private java.util.List<ClassOrInterfaceType> _types = new java.util.ArrayList<>();

	JavaPackage(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JavaPackage");
		st.add("name", _name);
		for (Object o : _types) st.add("types", o);
		return st.render().trim();
	}

	public JavaPackage setName(String value) {
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

	public JavaPackage removeName() {
		this._name = null;
		return this;
	} 

	public JavaPackage addTypes(ClassOrInterfaceType value) {
		this._types.add(value);
		return this;
	}

	public JavaPackage setTypes(ClassOrInterfaceType[] value) {
		this._types.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JavaPackage setTypes(java.util.Collection<ClassOrInterfaceType> values) {
		this._types.addAll(values);
		return this;
	}

	public JavaPackage removeTypes(ClassOrInterfaceType value) {
		this._types.remove(value);
		return this;
	}

	public JavaPackage removeTypes(int index) {
		this._types.remove(index);
		return this;
	}

	public java.util.List<ClassOrInterfaceType> getTypes() {
		return this._types;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JavaPackage that = (JavaPackage) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JavaPackage(name,types) ::= <<// java package \n" + 
				"~name~\n" + 
				"\n" + 
				"~types:{it|~it~};separator=\"\\n\"~ >>";
}  