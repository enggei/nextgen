package nextgen.templates.projects;

public class JavaMavenProject {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _root;
	private Object _mainSrc;
	private Object _testSrc;
	private Object _pom;

	JavaMavenProject(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JavaMavenProject");
		st.add("name", _name);
		st.add("root", _root);
		st.add("mainSrc", _mainSrc);
		st.add("testSrc", _testSrc);
		st.add("pom", _pom);
		return st.render().trim();
	}

	public JavaMavenProject setName(Object value) {
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

	public JavaMavenProject removeName() {
		this._name = null;
		return this;
	} 

	public JavaMavenProject setRoot(Object value) {
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

	public JavaMavenProject removeRoot() {
		this._root = null;
		return this;
	} 

	public JavaMavenProject setMainSrc(Object value) {
		this._mainSrc = value;
		return this;
	}

	public Object getMainSrc() {
		return this._mainSrc;
	}

	public Object getMainSrc(Object defaultValue) {
		return this._mainSrc == null ? defaultValue : this._mainSrc;
	}

	public boolean hasMainSrc() {
		return this._mainSrc != null;
	}

	public JavaMavenProject removeMainSrc() {
		this._mainSrc = null;
		return this;
	} 

	public JavaMavenProject setTestSrc(Object value) {
		this._testSrc = value;
		return this;
	}

	public Object getTestSrc() {
		return this._testSrc;
	}

	public Object getTestSrc(Object defaultValue) {
		return this._testSrc == null ? defaultValue : this._testSrc;
	}

	public boolean hasTestSrc() {
		return this._testSrc != null;
	}

	public JavaMavenProject removeTestSrc() {
		this._testSrc = null;
		return this;
	} 

	public JavaMavenProject setPom(Object value) {
		this._pom = value;
		return this;
	}

	public Object getPom() {
		return this._pom;
	}

	public Object getPom(Object defaultValue) {
		return this._pom == null ? defaultValue : this._pom;
	}

	public boolean hasPom() {
		return this._pom != null;
	}

	public JavaMavenProject removePom() {
		this._pom = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JavaMavenProject that = (JavaMavenProject) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JavaMavenProject(name,root,mainSrc,testSrc,pom) ::= <<~name~\n" + 
				"~root~\n" + 
				"~mainSrc~\n" + 
				"~testSrc~\n" + 
				"\n" + 
				"~pom~ >>";
}  