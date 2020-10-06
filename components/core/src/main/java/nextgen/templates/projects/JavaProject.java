package nextgen.templates.projects;

public class JavaProject {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _packageName;
	private String _name;
	private String _outputRoot;
	private java.util.List<JavaProjectPackage> _packages = new java.util.ArrayList<>();

	JavaProject(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JavaProject");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("outputRoot", _outputRoot);
		for (Object o : _packages) st.add("packages", o);
		return st.render().trim();
	}

	public JavaProject setPackageName(String value) {
		this._packageName = value;
		return this;
	}

	public String getPackageName() {
		return this._packageName;
	}

	public String getPackageName(String defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public JavaProject removePackageName() {
		this._packageName = null;
		return this;
	} 

	public JavaProject setName(String value) {
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

	public JavaProject removeName() {
		this._name = null;
		return this;
	} 

	public JavaProject setOutputRoot(String value) {
		this._outputRoot = value;
		return this;
	}

	public String getOutputRoot() {
		return this._outputRoot;
	}

	public String getOutputRoot(String defaultValue) {
		return this._outputRoot == null ? defaultValue : this._outputRoot;
	}

	public boolean hasOutputRoot() {
		return this._outputRoot != null;
	}

	public JavaProject removeOutputRoot() {
		this._outputRoot = null;
		return this;
	} 

	public JavaProject addPackages(JavaProjectPackage value) {
		this._packages.add(value);
		return this;
	}

	public JavaProject setPackages(JavaProjectPackage[] value) {
		this._packages.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JavaProject setPackages(java.util.Collection<JavaProjectPackage> values) {
		this._packages.addAll(values);
		return this;
	}

	public JavaProject removePackages(JavaProjectPackage value) {
		this._packages.remove(value);
		return this;
	}

	public JavaProject removePackages(int index) {
		this._packages.remove(index);
		return this;
	}

	public java.util.List<JavaProjectPackage> getPackages() {
		return this._packages;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JavaProject that = (JavaProject) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JavaProject(packageName,name,outputRoot,packages) ::= <<~packageName~\n" + 
				"\n" + 
				"~name~\n" + 
				"~outputRoot~\n" + 
				"\n" + 
				"~packages:{it|~it~};separator=\"\\n\"~ >>";
}  