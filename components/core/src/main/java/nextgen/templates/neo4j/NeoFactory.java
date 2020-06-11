package nextgen.templates.neo4j;

public class NeoFactory {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _package;
	private Object _name;
	private java.util.List<Object> _accessors = new java.util.ArrayList<>();

	NeoFactory(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NeoFactory");
		st.add("package", _package);
		st.add("name", _name);
		for (Object o : _accessors) st.add("accessors", o);
		return st.render().trim();
	}

	public NeoFactory setPackage(Object value) {
		this._package = value;
		return this;
	}

	public Object getPackage() {
		return this._package;
	}

	public Object getPackage(Object defaultValue) {
		return this._package == null ? defaultValue : this._package;
	}

	public boolean hasPackage() {
		return this._package != null;
	}

	public NeoFactory removePackage() {
		this._package = null;
		return this;
	} 

	public NeoFactory setName(Object value) {
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

	public NeoFactory removeName() {
		this._name = null;
		return this;
	} 

	public NeoFactory addAccessors(Object value) {
		this._accessors.add(value);
		return this;
	}

	public NeoFactory removeAccessors(Object value) {
		this._accessors.remove(value);
		return this;
	}

	public NeoFactory removeAccessors(int index) {
		this._accessors.remove(index);
		return this;
	}

	public java.util.List<Object> getAccessors() {
		return this._accessors;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NeoFactory that = (NeoFactory) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NeoFactory(package,name,accessors) ::= <<package ~package~;\n" + 
				"\n" + 
				"public class ~name;format=\"capitalize\"~ {\n" + 
				"\n" + 
				"	private final org.neo4j.graphdb.GraphDatabaseService db;\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~(java.lang.String dir) { \n" + 
				"		this(new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabaseBuilder(new java.io.File(dir)).setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_upgrade, \"true\").newGraphDatabase());\n" + 
				"		Runtime.getRuntime().addShutdownHook(new java.lang.Thread(db::shutdown));\n" + 
				"	}\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~(org.neo4j.graphdb.GraphDatabaseService db) { \n" + 
				"		this.db = db;\n" + 
				"	}\n" + 
				"\n" + 
				"	public org.neo4j.graphdb.GraphDatabaseService getDatabaseService() { \n" + 
				"		return this.db;\n" + 
				"	}\n" + 
				"\n" + 
				"	public void doInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> action) { \n" + 
				"		doInTransaction(action, java.lang.Throwable::printStackTrace);\n" + 
				"	}\n" + 
				"\n" + 
				"	public void doInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> action, java.util.function.Consumer<java.lang.Throwable> onException) { \n" + 
				"		try (org.neo4j.graphdb.Transaction tx = db.beginTx())  { \n" + 
				"			action.accept(tx);\n" + 
				"			tx.success();\n" + 
				"		} catch (java.lang.Throwable t)  { \n" + 
				"			onException.accept(t);\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	~accessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"}>> ";
}  