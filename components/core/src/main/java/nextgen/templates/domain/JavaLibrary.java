package nextgen.templates.domain;

public class JavaLibrary {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _packages = new java.util.ArrayList<>();

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

	public JavaLibrary setName(Object value) {
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

	public JavaLibrary removeName() {
		this._name = null;
		return this;
	} 

	public JavaLibrary addPackages(Object value) {
		this._packages.add(value);
		return this;
	}

	public JavaLibrary setPackages(Object[] value) {
		this._packages.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JavaLibrary setPackages(java.util.Collection<Object> values) {
		this._packages.addAll(values);
		return this;
	}

	public JavaLibrary removePackages(Object value) {
		this._packages.remove(value);
		return this;
	}

	public JavaLibrary removePackages(int index) {
		this._packages.remove(index);
		return this;
	}

	public java.util.List<Object> getPackages() {
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

	static final String st = "JavaLibrary(name,packages) ::= <<// ~name~\n" + 
				"~packages:{it|~it~};separator=\"\\n\\n\"~ >>";
}  