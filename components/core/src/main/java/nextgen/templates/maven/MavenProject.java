package nextgen.templates.maven;

public class MavenProject {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _projectName;
	private Object _root;
	private Object _mainJava;
	private Object _testJava;

	MavenProject(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MavenProject");
		st.add("projectName", _projectName);
		st.add("root", _root);
		st.add("mainJava", _mainJava);
		st.add("testJava", _testJava);
		return st.render().trim();
	}

	public MavenProject setProjectName(Object value) {
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

	public MavenProject removeProjectName() {
		this._projectName = null;
		return this;
	} 

	public MavenProject setRoot(Object value) {
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

	public MavenProject removeRoot() {
		this._root = null;
		return this;
	} 

	public MavenProject setMainJava(Object value) {
		this._mainJava = value;
		return this;
	}

	public Object getMainJava() {
		return this._mainJava;
	}

	public Object getMainJava(Object defaultValue) {
		return this._mainJava == null ? defaultValue : this._mainJava;
	}

	public boolean hasMainJava() {
		return this._mainJava != null;
	}

	public MavenProject removeMainJava() {
		this._mainJava = null;
		return this;
	} 

	public MavenProject setTestJava(Object value) {
		this._testJava = value;
		return this;
	}

	public Object getTestJava() {
		return this._testJava;
	}

	public Object getTestJava(Object defaultValue) {
		return this._testJava == null ? defaultValue : this._testJava;
	}

	public boolean hasTestJava() {
		return this._testJava != null;
	}

	public MavenProject removeTestJava() {
		this._testJava = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MavenProject that = (MavenProject) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MavenProject(projectName,root,mainJava,testJava) ::= <<~projectName~\n" + 
				"\n" + 
				"root : ~root~\n" + 
				"mainJava : ~mainJava~\n" + 
				"testJava : ~testJava~ >>";
}  