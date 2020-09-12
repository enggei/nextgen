package nextgen.templates.domain;

public class JavaProject {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _packageName;
	private Object _javaPatterns;
	private String _name;
	private String _root;
	private java.util.List<Object> _libraries = new java.util.ArrayList<>();
	private java.util.List<JavaPackage> _packageDeclarations = new java.util.ArrayList<>();
	private java.util.List<Object> _models = new java.util.ArrayList<>();

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
		st.add("javaPatterns", _javaPatterns);
		st.add("name", _name);
		st.add("root", _root);
		for (Object o : _libraries) st.add("libraries", o);
		for (Object o : _packageDeclarations) st.add("packageDeclarations", o);
		for (Object o : _models) st.add("models", o);
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

	public JavaProject setJavaPatterns(Object value) {
		this._javaPatterns = value;
		return this;
	}

	public Object getJavaPatterns() {
		return this._javaPatterns;
	}

	public Object getJavaPatterns(Object defaultValue) {
		return this._javaPatterns == null ? defaultValue : this._javaPatterns;
	}

	public boolean hasJavaPatterns() {
		return this._javaPatterns != null;
	}

	public JavaProject removeJavaPatterns() {
		this._javaPatterns = null;
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

	public JavaProject setRoot(String value) {
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

	public JavaProject removeRoot() {
		this._root = null;
		return this;
	} 

	public JavaProject addLibraries(Object value) {
		this._libraries.add(value);
		return this;
	}

	public JavaProject setLibraries(Object[] value) {
		this._libraries.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JavaProject setLibraries(java.util.Collection<Object> values) {
		this._libraries.addAll(values);
		return this;
	}

	public JavaProject removeLibraries(Object value) {
		this._libraries.remove(value);
		return this;
	}

	public JavaProject removeLibraries(int index) {
		this._libraries.remove(index);
		return this;
	}

	public java.util.List<Object> getLibraries() {
		return this._libraries;
	} 

	public JavaProject addPackageDeclarations(JavaPackage value) {
		this._packageDeclarations.add(value);
		return this;
	}

	public JavaProject setPackageDeclarations(JavaPackage[] value) {
		this._packageDeclarations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JavaProject setPackageDeclarations(java.util.Collection<JavaPackage> values) {
		this._packageDeclarations.addAll(values);
		return this;
	}

	public JavaProject removePackageDeclarations(JavaPackage value) {
		this._packageDeclarations.remove(value);
		return this;
	}

	public JavaProject removePackageDeclarations(int index) {
		this._packageDeclarations.remove(index);
		return this;
	}

	public java.util.List<JavaPackage> getPackageDeclarations() {
		return this._packageDeclarations;
	} 

	public JavaProject addModels(Object value) {
		this._models.add(value);
		return this;
	}

	public JavaProject setModels(Object[] value) {
		this._models.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JavaProject setModels(java.util.Collection<Object> values) {
		this._models.addAll(values);
		return this;
	}

	public JavaProject removeModels(Object value) {
		this._models.remove(value);
		return this;
	}

	public JavaProject removeModels(int index) {
		this._models.remove(index);
		return this;
	}

	public java.util.List<Object> getModels() {
		return this._models;
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

	static final String st = "JavaProject(packageName,javaPatterns,name,root,libraries,packageDeclarations,models) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import nextgen.templates.java.*;\n" + 
				"\n" + 
				"~if(javaPatterns)~import static ~packageName~.~name~.JavaPatterns.*;~endif~\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"	final java.io.File root = new java.io.File(\"~root~\");\n" + 
				"	final java.io.File mainJava = new java.io.File(root, \"src/main/java\");\n" + 
				"	final java.io.File mainResources = new java.io.File(root, \"src/main/resources\");\n" + 
				"	final java.io.File testJava = new java.io.File(root, \"src/test/java\");\n" + 
				"	final java.io.File testResources = new java.io.File(root, \"src/test/resources\");\n" + 
				"\n" + 
				"	~libraries:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~packageDeclarations:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~javaPatterns~\n" + 
				"\n" + 
				"	~models:{it|~it~}~\n" + 
				"\n" + 
				"	protected static void log(Object log) {\n" + 
				"		System.out.println(log);\n" + 
				"	}\n" + 
				"} >>";
}  