package nextgen.templates.maven;

public class Project {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _root;
	private Object _pom;
	private java.util.List<Object> _modules = new java.util.ArrayList<>();

	Project(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
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

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Project");
		st.add("name", _name);
		st.add("root", _root);
		st.add("pom", _pom);
		for (Object o : _modules) st.add("modules", o);
		return st.render().trim();
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

	public Project setPom(Object value) {
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

	public Project removePom() {
		this._pom = null;
		return this;
	} 
	public Project addModules(Object value) {
		this._modules.add(value);
		return this;
	}

	public Project removeModules(Object value) {
		this._modules.remove(value);
		return this;
	}

	public Project removeModules(int index) {
		this._modules.remove(index);
		return this;
	}

	public java.util.List<Object> getModules() {
		return this._modules;
	} 

	static final String st = "Project(name,root,pom,modules) ::= <<Project ~name~\n" + 
				"\n" + 
				"root	:	~root~\n" + 
				"Pom	: ~pom~\n" + 
				"\n" + 
				"Modules :\n" + 
				"~modules:{it|~it~};separator=\"\\n\"~>> ";
} 