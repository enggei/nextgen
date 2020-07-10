package nextgen.templates.java;

public class ProjectTypes {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _projectName;
	private Object _root;
	private Object _javaMain;
	private Object _javaTest;
	private java.util.List<Object> _packages = new java.util.ArrayList<>();
	private java.util.List<Object> _names = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _types = new java.util.ArrayList<>();

	ProjectTypes(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ProjectTypes");
		st.add("projectName", _projectName);
		st.add("root", _root);
		st.add("javaMain", _javaMain);
		st.add("javaTest", _javaTest);
		for (Object o : _packages) st.add("packages", o);
		for (Object o : _names) st.add("names", o);
		for (java.util.Map<String, Object> map : _types) st.addAggr("types.{name,variableName}", map.get("name"), map.get("variableName"));
		return st.render().trim();
	}

	public ProjectTypes setProjectName(Object value) {
		this._projectName = value;
		return this;
	}

	public Object getProjectName() {
		return this._projectName;
	}

	public Object getProjectName(Object defaultValue) {
		return this._projectName == null ? defaultValue : this._projectName;
	}

	public boolean hasProjectName() {
		return this._projectName != null;
	}

	public ProjectTypes removeProjectName() {
		this._projectName = null;
		return this;
	} 

	public ProjectTypes setRoot(Object value) {
		this._root = value;
		return this;
	}

	public Object getRoot() {
		return this._root;
	}

	public Object getRoot(Object defaultValue) {
		return this._root == null ? defaultValue : this._root;
	}

	public boolean hasRoot() {
		return this._root != null;
	}

	public ProjectTypes removeRoot() {
		this._root = null;
		return this;
	} 

	public ProjectTypes setJavaMain(Object value) {
		this._javaMain = value;
		return this;
	}

	public Object getJavaMain() {
		return this._javaMain;
	}

	public Object getJavaMain(Object defaultValue) {
		return this._javaMain == null ? defaultValue : this._javaMain;
	}

	public boolean hasJavaMain() {
		return this._javaMain != null;
	}

	public ProjectTypes removeJavaMain() {
		this._javaMain = null;
		return this;
	} 

	public ProjectTypes setJavaTest(Object value) {
		this._javaTest = value;
		return this;
	}

	public Object getJavaTest() {
		return this._javaTest;
	}

	public Object getJavaTest(Object defaultValue) {
		return this._javaTest == null ? defaultValue : this._javaTest;
	}

	public boolean hasJavaTest() {
		return this._javaTest != null;
	}

	public ProjectTypes removeJavaTest() {
		this._javaTest = null;
		return this;
	} 

	public ProjectTypes addPackages(Object value) {
		this._packages.add(value);
		return this;
	}

	public ProjectTypes setPackages(Object[] value) {
		this._packages.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ProjectTypes setPackages(java.util.Collection<Object> values) {
		this._packages.addAll(values);
		return this;
	}

	public ProjectTypes removePackages(Object value) {
		this._packages.remove(value);
		return this;
	}

	public ProjectTypes removePackages(int index) {
		this._packages.remove(index);
		return this;
	}

	public java.util.List<Object> getPackages() {
		return this._packages;
	} 

	public ProjectTypes addNames(Object value) {
		this._names.add(value);
		return this;
	}

	public ProjectTypes setNames(Object[] value) {
		this._names.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ProjectTypes setNames(java.util.Collection<Object> values) {
		this._names.addAll(values);
		return this;
	}

	public ProjectTypes removeNames(Object value) {
		this._names.remove(value);
		return this;
	}

	public ProjectTypes removeNames(int index) {
		this._names.remove(index);
		return this;
	}

	public java.util.List<Object> getNames() {
		return this._names;
	} 

	public ProjectTypes addTypes(Object _name, Object _variableName) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("variableName", _variableName);
		this._types.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getTypes() {
		return this._types;
	}

	public ProjectTypes addTypes(ProjectTypes_Types value) {
		return addTypes(value._name, value._variableName);
	}

	public java.util.stream.Stream<ProjectTypes_Types> streamTypes() {
		return this._types.stream().map(ProjectTypes_Types::new);
	}

	public static final class ProjectTypes_Types {

		Object _name;
		Object _variableName;

		public ProjectTypes_Types(Object _name, Object _variableName) {
			this._name = _name;
			this._variableName = _variableName;
		}

		private ProjectTypes_Types(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._variableName = (Object) map.get("variableName");
		}

		public Object getName() {
			return this._name;
		}

		public Object getVariableName() {
			return this._variableName;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProjectTypes that = (ProjectTypes) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ProjectTypes(projectName,root,javaMain,javaTest,packages,types,names) ::= <<Project ~projectName~\n" + 
				"~root~\n" + 
				"~javaMain~\n" + 
				"~javaTest~\n" + 
				"~packages:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"~types:{it|~it.name~ ~it.variableName~};separator=\"\\n\"~\n" + 
				"~names:{it|~it~};separator=\"\\n\"~ >>";
}  