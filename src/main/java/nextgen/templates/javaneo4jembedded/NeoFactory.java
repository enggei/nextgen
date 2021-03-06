package nextgen.templates.javaneo4jembedded;

public class NeoFactory {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _package;
	private java.util.List<Object> _accessors = new java.util.ArrayList<>();

	NeoFactory(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NeoFactory");
		st.add("name", _name);
		st.add("package", _package);
		for (Object o : _accessors) st.add("accessors", o);
		return st.render().trim();
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

	static final String st = "NeoFactory(accessors,name,package) ::= <<package ~package~;\n" + 
				"\n" + 
				"public class ~name;format=\"capitalize\"~ {\n" + 
				"\n" + 
				"	private final org.neo4j.graphdb.GraphDatabaseService db;\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~(java.lang.String dir) { \n" + 
				"		this(new org.neo4j.graphdb.factory.GraphDatabaseFactory()\n" + 
				"				.newEmbeddedDatabaseBuilder(new java.io.File(dir))\n" + 
				"				.setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_upgrade, \"true\")\n" + 
				"				.newGraphDatabase());\n" + 
				"		Runtime.getRuntime().addShutdownHook(new java.lang.Thread(db::shutdown));\n" + 
				"	}\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~(org.neo4j.graphdb.GraphDatabaseService db) { \n" + 
				"		this.db = db;\n" + 
				"		cleanup();\n" + 
				"	}\n" + 
				"\n" + 
				"	public org.neo4j.graphdb.GraphDatabaseService getDatabaseService() { \n" + 
				"		return this.db;\n" + 
				"	}\n" + 
				"\n" + 
				"	private void cleanup() {\n" + 
				"      doInTransaction(transaction -> {\n" + 
				"         //findAllDomainProperty().forEach(DomainProperty::delete);\n" + 
				"         //findAllDomainRelation().forEach(DomainRelation::delete);\n" + 
				"         //findAllDomainEntity().forEach(DomainEntity::delete);\n" + 
				"         //findAllDomain().forEach(Domain::delete);\n" + 
				"      });\n" + 
				"   }\n" + 
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
				"\n" + 
				"	public static String toString(org.neo4j.graphdb.Node node) {\n" + 
				"		final StringBuilder out = new StringBuilder();\n" + 
				"		out.append(\"Node : \").append(node.getId()).append(\" \");\n" + 
				"		node.getLabels().forEach(label -> out.append(label.name()).append(\" \"));\n" + 
				"		out.append(\"(\");\n" + 
				"		node.getPropertyKeys().forEach(s -> out.append(\" \").append(s).append(\":\").append(node.getProperty(s)));\n" + 
				"		out.append(\")\");\n" + 
				"		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(relationship -> relationship.getPropertyKeys().forEach(s -> out.append(\"\\n\\t\\t -> \").append(s).append(\":\").append(relationship.getProperty(s))));\n" + 
				"		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(relationship -> relationship.getPropertyKeys().forEach(s -> out.append(\"\\n\\t\\t <- \").append(s).append(\":\").append(relationship.getProperty(s))));\n" + 
				"		return out.toString().trim();\n" + 
				"	}\n" + 
				"		\n" + 
				"	public static String toString(org.neo4j.graphdb.Relationship relationship) {\n" + 
				"		final StringBuilder out = new StringBuilder();\n" + 
				"		out.append(\"Relationship : \").append(relationship.getType()).append(\" \");\n" + 
				"		out.append(\"(\");\n" + 
				"		relationship.getPropertyKeys().forEach(s -> out.append(\" \").append(s).append(\":\").append(relationship.getProperty(s)));\n" + 
				"		out.append(\")\");\n" + 
				"		out.append(\" \").append(toString(relationship.getStartNode())).append(\" -> \").append(toString(relationship.getEndNode()));\n" + 
				"		return out.toString().trim();\n" + 
				"	}\n" + 
				"} >>";
}  