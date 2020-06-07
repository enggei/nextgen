package nextgen.templates.npm;

public class WebpackConfig {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _outputFilename;
	private Object _mainEntry;

	WebpackConfig(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
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

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("WebpackConfig");
		st.add("outputFilename", _outputFilename);
		st.add("mainEntry", _mainEntry);
		return st.render().trim();
	}

	public WebpackConfig setOutputFilename(Object value) {
		this._outputFilename = value;
		return this;
	}

	public Object getOutputFilename() {
		return this._outputFilename;
	}

	public boolean hasOutputFilename() {
		return this._outputFilename != null;
	}

	public WebpackConfig removeOutputFilename() {
		this._outputFilename = null;
		return this;
	} 

	public WebpackConfig setMainEntry(Object value) {
		this._mainEntry = value;
		return this;
	}

	public Object getMainEntry() {
		return this._mainEntry;
	}

	public boolean hasMainEntry() {
		return this._mainEntry != null;
	}

	public WebpackConfig removeMainEntry() {
		this._mainEntry = null;
		return this;
	} 

	static final String st = "WebpackConfig(outputFilename,mainEntry) ::= <<const path = require('path');\n" + 
				"\n" + 
				"module.exports = {\n" + 
				"	entry: { \n" + 
				"		main: '~mainEntry~' \n" + 
				"	},\n" + 
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
				"};>> ";
} 