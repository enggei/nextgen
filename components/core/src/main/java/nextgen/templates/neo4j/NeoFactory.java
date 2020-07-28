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

	public java.util.UUID uuid() {
		return uuid;
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

	public NeoFactory setAccessors(Object[] value) {
		this._accessors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NeoFactory setAccessors(java.util.Collection<Object> values) {
		this._accessors.addAll(values);
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
				"	public <T> T get(java.util.function.Supplier<T> supplier) {\n" + 
				"		try (org.neo4j.graphdb.Transaction tx = db.beginTx()) {\n" + 
				"			final T t = supplier.get();\n" + 
				"			tx.success();\n" + 
				"			return t;\n" + 
				"		} catch (java.lang.Throwable t) {\n" + 
				"			t.printStackTrace();\n" + 
				"			return null;\n" + 
				"		}\n" + 
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
				"	public <T> T getInTransaction(java.util.function.Function<org.neo4j.graphdb.Transaction, T> action) {\n" + 
				"		return getInTransaction(action, throwable -> {\n" + 
				"			throwable.printStackTrace();\n" + 
				"			return null;\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	public <T> T getInTransaction(java.util.function.Function<org.neo4j.graphdb.Transaction, T> action, java.util.function.Function<java.lang.Throwable, T> onException) {\n" + 
				"		T returnValue;\n" + 
				"		try (org.neo4j.graphdb.Transaction tx = db.beginTx()) {\n" + 
				"			returnValue = action.apply(tx);\n" + 
				"			tx.success();\n" + 
				"		} catch (java.lang.Throwable t) {\n" + 
				"			return onException.apply(t);\n" + 
				"		}\n" + 
				"		return returnValue;\n" + 
				"	}\n" + 
				"\n" + 
				"	~accessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	// ONLY delete this node and its relations\n" + 
				"	public void delete(org.neo4j.graphdb.Node node) {\n" + 
				"\n" + 
				"		for (org.neo4j.graphdb.Relationship incoming : node.getRelationships(org.neo4j.graphdb.Direction.INCOMING))\n" + 
				"			incoming.delete();\n" + 
				"\n" + 
				"		for (org.neo4j.graphdb.Relationship outgoing : node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING))\n" + 
				"			outgoing.delete();\n" + 
				"\n" + 
				"		node.delete();\n" + 
				"	}\n" + 
				"\n" + 
				"	// deletes node and its outgoing relations (NOT if any node has other incoming dependencies)\n" + 
				"	public void deleteTree(org.neo4j.graphdb.Node node) {\n" + 
				"\n" + 
				"		final java.util.Iterator<org.neo4j.graphdb.Relationship> incoming = node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).iterator();\n" + 
				"		if (incoming.hasNext()) return;\n" + 
				"\n" + 
				"		for (org.neo4j.graphdb.Relationship outgoing : node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING)) {\n" + 
				"			final org.neo4j.graphdb.Node otherNode = outgoing.getOtherNode(node);\n" + 
				"			outgoing.delete();\n" + 
				"			deleteTree(otherNode);\n" + 
				"		}\n" + 
				"\n" + 
				"		node.delete();\n" + 
				"	}\n" + 
				"} >>";
}  