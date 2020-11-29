package nextgen.templates.maven;

public class Project {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _packageName;
	private String _name;
	private String _root;
	private java.util.List<Object> _templates = new java.util.ArrayList<>();
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<ProjectPackage> _packageDeclarations = new java.util.ArrayList<>();
	private java.util.List<Object> _entities = new java.util.ArrayList<>();
	private java.util.List<Object> _generators = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _files = new java.util.ArrayList<>();

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
		for (Object o : _entities) st.add("entities", o);
		for (Object o : _generators) st.add("generators", o);
		for (Object o : _methods) st.add("methods", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name,init}", map.get("type"), map.get("name"), map.get("init"));
		for (java.util.Map<String, Object> map : _files) st.addAggr("files.{name,parent,path}", map.get("name"), map.get("parent"), map.get("path"));
		return st.render().trim();
	}

	public Project setPackageName(String value) {
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

	public Project removePackageName() {
		this._packageName = null;
		return this;
	} 

	public Project setName(String value) {
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

	public Project removeName() {
		this._name = null;
		return this;
	} 

	public Project setRoot(String value) {
		this._root = value;
		return this;
	}

	public String getRoot() {
		return this._root;
	}

	public String getRoot(String defaultValue) {
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

	public Project addPackageDeclarations(ProjectPackage value) {
		this._packageDeclarations.add(value);
		return this;
	}

	public Project setPackageDeclarations(ProjectPackage[] value) {
		this._packageDeclarations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Project setPackageDeclarations(java.util.Collection<ProjectPackage> values) {
		this._packageDeclarations.addAll(values);
		return this;
	}

	public Project removePackageDeclarations(ProjectPackage value) {
		this._packageDeclarations.remove(value);
		return this;
	}

	public Project removePackageDeclarations(int index) {
		this._packageDeclarations.remove(index);
		return this;
	}

	public java.util.List<ProjectPackage> getPackageDeclarations() {
		return this._packageDeclarations;
	} 

	public Project addEntities(Object value) {
		this._entities.add(value);
		return this;
	}

	public Project setEntities(Object[] value) {
		this._entities.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Project setEntities(java.util.Collection<Object> values) {
		this._entities.addAll(values);
		return this;
	}

	public Project removeEntities(Object value) {
		this._entities.remove(value);
		return this;
	}

	public Project removeEntities(int index) {
		this._entities.remove(index);
		return this;
	}

	public java.util.List<Object> getEntities() {
		return this._entities;
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

	public Project addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public Project setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Project setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public Project removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public Project removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public Project addFields(Object _type, Object _name, Object _init) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		map.put("init", _init);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public Project addFields(Project_Fields value) {
		return addFields(value._type, value._name, value._init);
	}

	public java.util.stream.Stream<Project_Fields> streamFields() {
		return this._fields.stream().map(Project_Fields::new);
	}

	public java.util.List<Object> getFields_Type() {
		return streamFields().map(Project_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Name() {
		return streamFields().map(Project_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Init() {
		return streamFields().map(Project_Fields::getInit).collect(java.util.stream.Collectors.toList());
	}


	public static final class Project_Fields {

		Object _type;
		Object _name;
		Object _init;

		public Project_Fields(Object _type, Object _name, Object _init) {
			this._type = _type;
			this._name = _name;
			this._init = _init;
		}

		private Project_Fields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
			this._init = (Object) map.get("init");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

		public Object getInit() {
			return this._init;
		}

	}  

	public Project addFiles(Object _name, Object _parent, Object _path) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("parent", _parent);
		map.put("path", _path);
		this._files.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFiles() {
		return this._files;
	}

	public Project addFiles(Project_Files value) {
		return addFiles(value._name, value._parent, value._path);
	}

	public java.util.stream.Stream<Project_Files> streamFiles() {
		return this._files.stream().map(Project_Files::new);
	}

	public java.util.List<Object> getFiles_Name() {
		return streamFiles().map(Project_Files::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFiles_Parent() {
		return streamFiles().map(Project_Files::getParent).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFiles_Path() {
		return streamFiles().map(Project_Files::getPath).collect(java.util.stream.Collectors.toList());
	}


	public static final class Project_Files {

		Object _name;
		Object _parent;
		Object _path;

		public Project_Files(Object _name, Object _parent, Object _path) {
			this._name = _name;
			this._parent = _parent;
			this._path = _path;
		}

		private Project_Files(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._parent = (Object) map.get("parent");
			this._path = (Object) map.get("path");
		}

		public Object getName() {
			return this._name;
		}

		public Object getParent() {
			return this._parent;
		}

		public Object getPath() {
			return this._path;
		}

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

	static final String st = "Project(packageName,templates,imports,name,root,fields,files,packageDeclarations,entities,generators,methods) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import nextgen.st.STGenerator;\n" + 
				"import static nextgen.utils.StringUtil.*;\n" + 
				"\n" + 
				"~templates:{it|import nextgen.templates.~it;format=\"toLower\"~.*;\n" + 
				"import nextgen.templates.~it~Patterns;\n" + 
				"};separator=\"\\n\"~\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"import java.util.*;\n" + 
				"import java.io.*;\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"	final File root = new File(\"~root~\");\n" + 
				"	\n" + 
				"	final File mainJava = new File(root, \"src/main/java\");\n" + 
				"	final File mainResources = new File(root, \"src/main/resources\");\n" + 
				"	final File testJava = new File(root, \"src/test/java\");\n" + 
				"	final File testResources = new File(root, \"src/test/resources\");\n" + 
				"	\n" + 
				"	~fields:{it|~if(it.init)~final ~endif~~it.type~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	~files:{it|final File ~it.name~ = new File(~if(it.parent)~~it.parent~, ~endif~\"~it.path~\");};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	~packageDeclarations:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"	~entities:{it|~it~};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	~generators:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  