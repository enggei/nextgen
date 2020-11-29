package nextgen.templates.java;

public class JavaLibrary {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private java.util.List<JavaPackage> _packages = new java.util.ArrayList<>();

	JavaLibrary(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JavaLibrary");
		st.add("name", _name);
		for (Object o : _packages) st.add("packages", o);
		return st.render().trim();
	}

	public JavaLibrary setName(String value) {
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

	public JavaLibrary removeName() {
		this._name = null;
		return this;
	} 

	public JavaLibrary addPackages(JavaPackage value) {
		this._packages.add(value);
		return this;
	}

	public JavaLibrary setPackages(JavaPackage[] value) {
		this._packages.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JavaLibrary setPackages(java.util.Collection<JavaPackage> values) {
		this._packages.addAll(values);
		return this;
	}

	public JavaLibrary removePackages(JavaPackage value) {
		this._packages.remove(value);
		return this;
	}

	public JavaLibrary removePackages(int index) {
		this._packages.remove(index);
		return this;
	}

	public java.util.List<JavaPackage> getPackages() {
		return this._packages;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JavaLibrary that = (JavaLibrary) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JavaLibrary(name,packages) ::= <<~name~\n" + 
				"\n" + 
				"~packages:{it|~it~};separator=\"\\n\\n\"~ >>";
}  