package nextgen.templates.npm;

public class PackageJson {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _main;
	private Object _license;
	private Object _bugsUrl;
	private Object _homepage;
	private Object _repositoryUrl;
	private Object _author;
	private Object _version;
	private Object _repositoryType;
	private Object _description;
	private Object _name;
	private java.util.List<Object> _devDependencies = new java.util.ArrayList<>();
	private java.util.List<Object> _scripts = new java.util.ArrayList<>();
	private java.util.List<Object> _dependencies = new java.util.ArrayList<>();

	PackageJson(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("packageJson");
		st.add("main", _main);
		st.add("license", _license);
		st.add("bugsUrl", _bugsUrl);
		st.add("homepage", _homepage);
		st.add("repositoryUrl", _repositoryUrl);
		st.add("author", _author);
		st.add("version", _version);
		st.add("repositoryType", _repositoryType);
		st.add("description", _description);
		st.add("name", _name);
		for (Object o : _devDependencies) st.add("devDependencies", o);
		for (Object o : _scripts) st.add("scripts", o);
		for (Object o : _dependencies) st.add("dependencies", o);
		return st.render().trim();
	}

	public PackageJson setMain(Object value) {
		this._main = value;
		return this;
	}

	public Object getMain() {
		return this._main;
	}

	public Object getMain(Object defaultValue) {
		return this._main == null ? defaultValue : this._main;
	}

	public boolean hasMain() {
		return this._main != null;
	}

	public PackageJson removeMain() {
		this._main = null;
		return this;
	}

	public PackageJson setLicense(Object value) {
		this._license = value;
		return this;
	}

	public Object getLicense() {
		return this._license;
	}

	public Object getLicense(Object defaultValue) {
		return this._license == null ? defaultValue : this._license;
	}

	public boolean hasLicense() {
		return this._license != null;
	}

	public PackageJson removeLicense() {
		this._license = null;
		return this;
	}

	public PackageJson setBugsUrl(Object value) {
		this._bugsUrl = value;
		return this;
	}

	public Object getBugsUrl() {
		return this._bugsUrl;
	}

	public Object getBugsUrl(Object defaultValue) {
		return this._bugsUrl == null ? defaultValue : this._bugsUrl;
	}

	public boolean hasBugsUrl() {
		return this._bugsUrl != null;
	}

	public PackageJson removeBugsUrl() {
		this._bugsUrl = null;
		return this;
	}

	public PackageJson setHomepage(Object value) {
		this._homepage = value;
		return this;
	}

	public Object getHomepage() {
		return this._homepage;
	}

	public Object getHomepage(Object defaultValue) {
		return this._homepage == null ? defaultValue : this._homepage;
	}

	public boolean hasHomepage() {
		return this._homepage != null;
	}

	public PackageJson removeHomepage() {
		this._homepage = null;
		return this;
	}

	public PackageJson setRepositoryUrl(Object value) {
		this._repositoryUrl = value;
		return this;
	}

	public Object getRepositoryUrl() {
		return this._repositoryUrl;
	}

	public Object getRepositoryUrl(Object defaultValue) {
		return this._repositoryUrl == null ? defaultValue : this._repositoryUrl;
	}

	public boolean hasRepositoryUrl() {
		return this._repositoryUrl != null;
	}

	public PackageJson removeRepositoryUrl() {
		this._repositoryUrl = null;
		return this;
	}

	public PackageJson setAuthor(Object value) {
		this._author = value;
		return this;
	}

	public Object getAuthor() {
		return this._author;
	}

	public Object getAuthor(Object defaultValue) {
		return this._author == null ? defaultValue : this._author;
	}

	public boolean hasAuthor() {
		return this._author != null;
	}

	public PackageJson removeAuthor() {
		this._author = null;
		return this;
	}

	public PackageJson setVersion(Object value) {
		this._version = value;
		return this;
	}

	public Object getVersion() {
		return this._version;
	}

	public Object getVersion(Object defaultValue) {
		return this._version == null ? defaultValue : this._version;
	}

	public boolean hasVersion() {
		return this._version != null;
	}

	public PackageJson removeVersion() {
		this._version = null;
		return this;
	}

	public PackageJson setRepositoryType(Object value) {
		this._repositoryType = value;
		return this;
	}

	public Object getRepositoryType() {
		return this._repositoryType;
	}

	public Object getRepositoryType(Object defaultValue) {
		return this._repositoryType == null ? defaultValue : this._repositoryType;
	}

	public boolean hasRepositoryType() {
		return this._repositoryType != null;
	}

	public PackageJson removeRepositoryType() {
		this._repositoryType = null;
		return this;
	}

	public PackageJson setDescription(Object value) {
		this._description = value;
		return this;
	}

	public Object getDescription() {
		return this._description;
	}

	public Object getDescription(Object defaultValue) {
		return this._description == null ? defaultValue : this._description;
	}

	public boolean hasDescription() {
		return this._description != null;
	}

	public PackageJson removeDescription() {
		this._description = null;
		return this;
	}

	public PackageJson setName(Object value) {
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

	public PackageJson removeName() {
		this._name = null;
		return this;
	}

	public PackageJson addDevDependencies(Object value) {
		this._devDependencies.add(value);
		return this;
	}

	public PackageJson removeDevDependencies(Object value) {
		this._devDependencies.remove(value);
		return this;
	}

	public PackageJson removeDevDependencies(int index) {
		this._devDependencies.remove(index);
		return this;
	}

	public java.util.List<Object> getDevDependencies() {
		return this._devDependencies;
	}

	public PackageJson addScripts(Object value) {
		this._scripts.add(value);
		return this;
	}

	public PackageJson removeScripts(Object value) {
		this._scripts.remove(value);
		return this;
	}

	public PackageJson removeScripts(int index) {
		this._scripts.remove(index);
		return this;
	}

	public java.util.List<Object> getScripts() {
		return this._scripts;
	}

	public PackageJson addDependencies(Object value) {
		this._dependencies.add(value);
		return this;
	}

	public PackageJson removeDependencies(Object value) {
		this._dependencies.remove(value);
		return this;
	}

	public PackageJson removeDependencies(int index) {
		this._dependencies.remove(index);
		return this;
	}

	public java.util.List<Object> getDependencies() {
		return this._dependencies;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PackageJson that = (PackageJson) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "packageJson(main,license,bugsUrl,devDependencies,scripts,dependencies,homepage,repositoryUrl,author,version,repositoryType,description,name) ::= <<{\n" + 
				"  \"name\": \"~name~\",\n" + 
				"  \"version\": \"~version~\",\n" + 
				"  \"description\": \"~description~\",\n" + 
				"  \"main\": \"~main~\",\n" + 
				"  \"scripts\": {\n" + 
				"    ~scripts:{it|~it~};separator=\",\\n\"~\n" + 
				"  },\n" + 
				"  \"repository\": {\n" + 
				"    \"type\": \"~repositoryType~\",\n" + 
				"    \"url\": \"~repositoryUrl~\"\n" + 
				"  },\n" + 
				"  \"author\": \"~author~\",\n" + 
				"  \"license\": \"~license~\",\n" + 
				"  \"bugs\": {\n" + 
				"    \"url\": \"~bugsUrl~\"\n" + 
				"  },\n" + 
				"  \"homepage\": \"~homepage~\",\n" + 
				"  \"dependencies\": {\n" + 
				"    ~dependencies:{it|~it~};separator=\",\\n\"~\n" + 
				"  },\n" + 
				"  \"devDependencies\": {\n" + 
				"    ~devDependencies:{it|~it~};separator=\",\\n\"~\n" + 
				"  }\n" + 
				"}>>";
} 