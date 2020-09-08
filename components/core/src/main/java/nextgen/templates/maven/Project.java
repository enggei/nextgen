package nextgen.templates.maven;

public class Project {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private Object _root;
	private java.util.List<Object> _templates = new java.util.ArrayList<>();
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<Object> _packageDeclarations = new java.util.ArrayList<>();
	private java.util.List<Object> _generators = new java.util.ArrayList<>();

	Project(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Project");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("root", _root);
		for (Object o : _templates) st.add("templates", o);
		for (Object o : _imports) st.add("imports", o);
		for (Object o : _packageDeclarations) st.add("packageDeclarations", o);
		for (Object o : _generators) st.add("generators", o);
		return st.render().trim();
	}

	public Project setPackageName(Object value) {
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

	public Project removePackageName() {
		this._packageName = null;
		return this;
	} 

	public Project setName(Object value) {
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

	public Project removeName() {
		this._name = null;
		return this;
	} 

	public Project setRoot(Object value) {
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

	public Project removeRoot() {
		this._root = null;
		return this;
	} 

	public Project addTemplates(Object value) {
		this._templates.add(value);
		return this;
	}

	public Project setTemplates(Object[] value) {
		this._templates.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Project setTemplates(java.util.Collection<Object> values) {
		this._templates.addAll(values);
		return this;
	}

	public Project removeTemplates(Object value) {
		this._templates.remove(value);
		return this;
	}

	public Project removeTemplates(int index) {
		this._templates.remove(index);
		return this;
	}

	public java.util.List<Object> getTemplates() {
		return this._templates;
	} 

	public Project addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public Project setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Project setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public Project removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public Project removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<Object> getImports() {
		return this._imports;
	} 

	public Project addPackageDeclarations(Object value) {
		this._packageDeclarations.add(value);
		return this;
	}

	public Project setPackageDeclarations(Object[] value) {
		this._packageDeclarations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Project setPackageDeclarations(java.util.Collection<Object> values) {
		this._packageDeclarations.addAll(values);
		return this;
	}

	public Project removePackageDeclarations(Object value) {
		this._packageDeclarations.remove(value);
		return this;
	}

	public Project removePackageDeclarations(int index) {
		this._packageDeclarations.remove(index);
		return this;
	}

	public java.util.List<Object> getPackageDeclarations() {
		return this._packageDeclarations;
	} 

	public Project addGenerators(Object value) {
		this._generators.add(value);
		return this;
	}

	public Project setGenerators(Object[] value) {
		this._generators.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Project setGenerators(java.util.Collection<Object> values) {
		this._generators.addAll(values);
		return this;
	}

	public Project removeGenerators(Object value) {
		this._generators.remove(value);
		return this;
	}

	public Project removeGenerators(int index) {
		this._generators.remove(index);
		return this;
	}

	public java.util.List<Object> getGenerators() {
		return this._generators;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Project that = (Project) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Project(packageName,templates,imports,name,root,packageDeclarations,generators) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"~templates:{it|import static ~it~.*;};separator=\"\\n\"~\n" + 
				"\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"	final java.io.File root = new java.io.File(\"~root~\");\n" + 
				"	final java.io.File mainJava = new java.io.File(root, \"src/main/java\");\n" + 
				"	final java.io.File mainResources = new java.io.File(root, \"src/main/resources\");\n" + 
				"	final java.io.File testJava = new java.io.File(root, \"src/test/java\");\n" + 
				"	final java.io.File testResources = new java.io.File(root, \"src/test/resources\");\n" + 
				"\n" + 
				"	~packageDeclarations:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~generators:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	protected static void log(Object log) {\n" + 
				"		System.out.println(log);\n" + 
				"	}\n" + 
				"\n" + 
				"	private class JavaType {\n" + 
				"\n" + 
				"		final ClassOrInterfaceType type;\n" + 
				"\n" + 
				"		public JavaType(String packageDeclaration, String name) {\n" + 
				"			this.type = newClassOrInterfaceType(packageDeclaration, name);\n" + 
				"		}\n" + 
				"\n" + 
				"		public JavaType(PackageDeclaration packageDeclaration, String name) {\n" + 
				"			this(packageDeclaration.getName(), name);\n" + 
				"		}\n" + 
				"	}\n" + 
				"} >>";
}  