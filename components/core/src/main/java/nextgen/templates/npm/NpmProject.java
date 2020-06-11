package nextgen.templates.npm;

public class NpmProject {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _root;
	private PackageJson _packageJson;
	private WebpackConfig _webpackConfig;
	private Babelrc _babelrc;

	NpmProject(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NpmProject");
		st.add("root", _root);
		st.add("packageJson", _packageJson);
		st.add("webpackConfig", _webpackConfig);
		st.add("babelrc", _babelrc);
		return st.render().trim();
	}

	public NpmProject setRoot(String value) {
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

	public NpmProject removeRoot() {
		this._root = null;
		return this;
	} 

	public NpmProject setPackageJson(PackageJson value) {
		this._packageJson = value;
		return this;
	}

	public PackageJson getPackageJson() {
		return this._packageJson;
	}

	public PackageJson getPackageJson(PackageJson defaultValue) {
		return this._packageJson == null ? defaultValue : this._packageJson;
	}

	public boolean hasPackageJson() {
		return this._packageJson != null;
	}

	public NpmProject removePackageJson() {
		this._packageJson = null;
		return this;
	} 

	public NpmProject setWebpackConfig(WebpackConfig value) {
		this._webpackConfig = value;
		return this;
	}

	public WebpackConfig getWebpackConfig() {
		return this._webpackConfig;
	}

	public WebpackConfig getWebpackConfig(WebpackConfig defaultValue) {
		return this._webpackConfig == null ? defaultValue : this._webpackConfig;
	}

	public boolean hasWebpackConfig() {
		return this._webpackConfig != null;
	}

	public NpmProject removeWebpackConfig() {
		this._webpackConfig = null;
		return this;
	} 

	public NpmProject setBabelrc(Babelrc value) {
		this._babelrc = value;
		return this;
	}

	public Babelrc getBabelrc() {
		return this._babelrc;
	}

	public Babelrc getBabelrc(Babelrc defaultValue) {
		return this._babelrc == null ? defaultValue : this._babelrc;
	}

	public boolean hasBabelrc() {
		return this._babelrc != null;
	}

	public NpmProject removeBabelrc() {
		this._babelrc = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NpmProject that = (NpmProject) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NpmProject(root,packageJson,webpackConfig,babelrc) ::= <<~root~\n" + 
				"~packageJson~\n" + 
				"~webpackConfig~\n" + 
				"~babelrc~>> ";
}  