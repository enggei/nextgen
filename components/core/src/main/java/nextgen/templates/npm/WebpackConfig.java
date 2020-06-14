package nextgen.templates.npm;

public class WebpackConfig {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _mainEntry;
	private Object _mode;
	private Object _outputFilename;

	WebpackConfig(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("WebpackConfig");
		st.add("mainEntry", _mainEntry);
		st.add("mode", _mode);
		st.add("outputFilename", _outputFilename);
		return st.render().trim();
	}

	public WebpackConfig setMainEntry(Object value) {
		this._mainEntry = value;
		return this;
	}

	public Object getMainEntry() {
		return this._mainEntry;
	}

	public Object getMainEntry(Object defaultValue) {
		return this._mainEntry == null ? defaultValue : this._mainEntry;
	}

	public boolean hasMainEntry() {
		return this._mainEntry != null;
	}

	public WebpackConfig removeMainEntry() {
		this._mainEntry = null;
		return this;
	}

	public WebpackConfig setMode(Object value) {
		this._mode = value;
		return this;
	}

	public Object getMode() {
		return this._mode;
	}

	public Object getMode(Object defaultValue) {
		return this._mode == null ? defaultValue : this._mode;
	}

	public boolean hasMode() {
		return this._mode != null;
	}

	public WebpackConfig removeMode() {
		this._mode = null;
		return this;
	}

	public WebpackConfig setOutputFilename(Object value) {
		this._outputFilename = value;
		return this;
	}

	public Object getOutputFilename() {
		return this._outputFilename;
	}

	public Object getOutputFilename(Object defaultValue) {
		return this._outputFilename == null ? defaultValue : this._outputFilename;
	}

	public boolean hasOutputFilename() {
		return this._outputFilename != null;
	}

	public WebpackConfig removeOutputFilename() {
		this._outputFilename = null;
		return this;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WebpackConfig that = (WebpackConfig) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "WebpackConfig(mainEntry,mode,outputFilename) ::= <<const path = require('path');\n" + 
				"\n" + 
				"module.exports = {\n" + 
				"	entry: { \n" + 
				"		main: '.~mainEntry~' \n" + 
				"	},\n" + 
				"	mode: '~if(mode)~~mode~~else~production~endif~'\n" + 
				"	output: {\n" + 
				"		path: __dirname,\n" + 
				"		filename: '~outputFilename~'\n" + 
				"	},\n" + 
				"	module: {\n" + 
				"		rules: [\n" + 
				"			{\n" + 
				"				test: path.join(__dirname, '.'),\n" + 
				"				exclude: /(node_modules)/,\n" + 
				"				use: [\n" + 
				"					{\n" + 
				"						loader: 'babel-loader',\n" + 
				"						options: {\n" + 
				"			    			presets: [\"@babel/preset-env\", \"@babel/preset-react\"]\n" + 
				"						}\n" + 
				"					}\n" + 
				"				]\n" + 
				"			}\n" + 
				"		]\n" + 
				"	}\n" + 
				"};>>";
}