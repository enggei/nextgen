package nextgen.templates.maven;

public class ProjectPackage {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _packageName;
	private java.util.List<java.util.Map<String, Object>> _types = new java.util.ArrayList<>();

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
		st.add("packageName", _packageName);
		for (java.util.Map<String, Object> map : _types) st.addAggr("types.{name}", map.get("name"));
		return st.render().trim();
	}

	public ProjectPackage setName(Object value) {
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

	public ProjectPackage removeName() {
		this._name = null;
		return this;
	} 

	public ProjectPackage setPackageName(Object value) {
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

	public ProjectPackage removePackageName() {
		this._packageName = null;
		return this;
	} 


	public ProjectPackage addTypes(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._types.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getTypes() {
		return this._types;
	}

	public ProjectPackage addTypes(ProjectPackage_Types value) {
		return addTypes(value._name);
	}

	public java.util.stream.Stream<ProjectPackage_Types> streamTypes() {
		return this._types.stream().map(ProjectPackage_Types::new);
	}

	public static final class ProjectPackage_Types {

		Object _name;

		public ProjectPackage_Types(Object _name) {
			this._name = _name;
		}

		private ProjectPackage_Types(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}

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

	static final String st = "ProjectPackage(name,packageName,types) ::= <<private final PackageDeclaration ~name~ = newPackageDeclaration(\"~packageName~\");\n" + 
				"~types:{it|private final JavaType ~it.name~Type = new JavaType(~name~, \"~it.name~\");};separator=\"\\n\\n\"~ >>";
}  