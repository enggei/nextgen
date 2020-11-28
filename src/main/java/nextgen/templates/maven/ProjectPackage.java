package nextgen.templates.maven;

public class ProjectPackage {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private ProjectPackage _parentPackage;
	private String _packageName;
	private java.util.List<Object> _childPackages = new java.util.ArrayList<>();

	ProjectPackage(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ProjectPackage");
		st.add("name", _name);
		st.add("parentPackage", _parentPackage);
		st.add("packageName", _packageName);
		for (Object o : _childPackages) st.add("childPackages", o);
		return st.render().trim();
	}

	public ProjectPackage setName(String value) {
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

	public ProjectPackage removeName() {
		this._name = null;
		return this;
	} 

	public ProjectPackage setParentPackage(ProjectPackage value) {
		this._parentPackage = value;
		return this;
	}

	public ProjectPackage getParentPackage() {
		return this._parentPackage;
	}

	public ProjectPackage getParentPackage(ProjectPackage defaultValue) {
		return this._parentPackage == null ? defaultValue : this._parentPackage;
	}

	public boolean hasParentPackage() {
		return this._parentPackage != null;
	}

	public ProjectPackage removeParentPackage() {
		this._parentPackage = null;
		return this;
	} 

	public ProjectPackage setPackageName(String value) {
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

	public ProjectPackage removePackageName() {
		this._packageName = null;
		return this;
	} 

	public ProjectPackage addChildPackages(Object value) {
		this._childPackages.add(value);
		return this;
	}

	public ProjectPackage setChildPackages(Object[] value) {
		this._childPackages.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ProjectPackage setChildPackages(java.util.Collection<Object> values) {
		this._childPackages.addAll(values);
		return this;
	}

	public ProjectPackage removeChildPackages(Object value) {
		this._childPackages.remove(value);
		return this;
	}

	public ProjectPackage removeChildPackages(int index) {
		this._childPackages.remove(index);
		return this;
	}

	public java.util.List<Object> getChildPackages() {
		return this._childPackages;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProjectPackage that = (ProjectPackage) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ProjectPackage(name,parentPackage,packageName,childPackages) ::= <<protected final nextgen.templates.java.PackageDeclaration ~name~ = nextgen.templates.JavaPatterns.newPackageDeclaration(~if(parentPackage)~~parentPackage~, ~endif~\"~packageName~\");\n" + 
				"~childPackages:{it|~it~};separator=\"\\n\"~ >>";
}  