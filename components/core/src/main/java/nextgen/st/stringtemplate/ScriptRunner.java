package nextgen.st.stringtemplate;

public class ScriptRunner {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private Object _script;
	private Object _templatesDir;
	private Object _dbDir;
	private java.util.List<Object> _imports = new java.util.ArrayList<>();

	ScriptRunner(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ScriptRunner");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("script", _script);
		st.add("templatesDir", _templatesDir);
		st.add("dbDir", _dbDir);
		for (Object o : _imports) st.add("imports", o);
		return st.render().trim();
	}

	public ScriptRunner setPackageName(Object value) {
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

	public ScriptRunner removePackageName() {
		this._packageName = null;
		return this;
	} 

	public ScriptRunner setName(Object value) {
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

	public ScriptRunner removeName() {
		this._name = null;
		return this;
	} 

	public ScriptRunner setScript(Object value) {
		this._script = value;
		return this;
	}

	public Object getScript() {
		return this._script;
	}

	public Object getScript(Object defaultValue) {
		return this._script == null ? defaultValue : this._script;
	}

	public boolean hasScript() {
		return this._script != null;
	}

	public ScriptRunner removeScript() {
		this._script = null;
		return this;
	} 

	public ScriptRunner setTemplatesDir(Object value) {
		this._templatesDir = value;
		return this;
	}

	public Object getTemplatesDir() {
		return this._templatesDir;
	}

	public Object getTemplatesDir(Object defaultValue) {
		return this._templatesDir == null ? defaultValue : this._templatesDir;
	}

	public boolean hasTemplatesDir() {
		return this._templatesDir != null;
	}

	public ScriptRunner removeTemplatesDir() {
		this._templatesDir = null;
		return this;
	} 

	public ScriptRunner setDbDir(Object value) {
		this._dbDir = value;
		return this;
	}

	public Object getDbDir() {
		return this._dbDir;
	}

	public Object getDbDir(Object defaultValue) {
		return this._dbDir == null ? defaultValue : this._dbDir;
	}

	public boolean hasDbDir() {
		return this._dbDir != null;
	}

	public ScriptRunner removeDbDir() {
		this._dbDir = null;
		return this;
	} 

	public ScriptRunner addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public ScriptRunner setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ScriptRunner setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public ScriptRunner removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public ScriptRunner removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<Object> getImports() {
		return this._imports;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ScriptRunner that = (ScriptRunner) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ScriptRunner(packageName,imports,name,script,templatesDir,dbDir) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name~ implements Runnable {\n" + 
				"\n" + 
				"	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
				"	private final nextgen.st.model.STModelDB db;\n" + 
				"	private final nextgen.st.STRenderer renderer;\n" + 
				"\n" + 
				"	public ~name~(nextgen.st.model.STModelDB db, nextgen.st.STRenderer renderer) {\n" + 
				"		this.db = db;\n" + 
				"		this.renderer = renderer;\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void run() {\n" + 
				"		db.doInTransaction(transaction -> {\n" + 
				"			~script~\n" + 
				"		});\n" + 
				"	}\n" + 
				"	\n" + 
				"	public static void main(String[] args) {\n" + 
				"		final java.util.Collection<nextgen.st.domain.STGroupModel> stGroups = new java.util.ArrayList<>();\n" + 
				"		final java.io.File templatesDir = new java.io.File(\"~templatesDir~\");\n" + 
				"		java.util.Optional.ofNullable(templatesDir.listFiles(pathname -> pathname.isFile() && pathname.getName().toLowerCase().endsWith(\".json\")))\n" + 
				"			.ifPresent(files -> {\n" + 
				"				for (java.io.File file : files)\n" + 
				"						stGroups.add(new nextgen.st.domain.STGroupModel(nextgen.st.STParser.readJsonObject(file)));\n" + 
				"			});\n" + 
				"		new Thread(new ~name~(new nextgen.st.model.STModelDB(\"~dbDir~\", stGroups), new nextgen.st.STRenderer(stGroups))).start();\n" + 
				"	}\n" + 
				"} >>";
}  