package nextgen.st.script;

public class ScriptNeoFactory {

	private final org.neo4j.graphdb.GraphDatabaseService db;

	public ScriptNeoFactory(java.lang.String dir) { 
		this(new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabaseBuilder(new java.io.File(dir)).setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_upgrade, "true").newGraphDatabase());
		Runtime.getRuntime().addShutdownHook(new java.lang.Thread(db::shutdown));
	}

	public ScriptNeoFactory(org.neo4j.graphdb.GraphDatabaseService db) { 
		this.db = db;
	}

	public org.neo4j.graphdb.GraphDatabaseService getDatabaseService() { 
		return this.db;
	}

	public void doInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> action) { 
		doInTransaction(action, java.lang.Throwable::printStackTrace);
	}

	public <T> T get(java.util.function.Supplier<T> supplier) {
		try (org.neo4j.graphdb.Transaction tx = db.beginTx()) {
			final T t = supplier.get();
			tx.success();
			return t;
		} catch (java.lang.Throwable t) {
			t.printStackTrace();
			return null;
		}
	}

	public void doInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> action, java.util.function.Consumer<java.lang.Throwable> onException) { 
		try (org.neo4j.graphdb.Transaction tx = db.beginTx())  { 
			action.accept(tx);
			tx.success();
		} catch (java.lang.Throwable t)  { 
			onException.accept(t);
		}
	}

	public <T> T getInTransaction(java.util.function.Function<org.neo4j.graphdb.Transaction, T> action) {
		return getInTransaction(action, throwable -> {
			throwable.printStackTrace();
			return null;
		});
	}

	public <T> T getInTransaction(java.util.function.Function<org.neo4j.graphdb.Transaction, T> action, java.util.function.Function<java.lang.Throwable, T> onException) {
		T returnValue;
		try (org.neo4j.graphdb.Transaction tx = db.beginTx()) {
			returnValue = action.apply(tx);
			tx.success();
		} catch (java.lang.Throwable t) {
			return onException.apply(t);
		}
		return returnValue;
	}

	private static final org.neo4j.graphdb.Label ScriptLabel = org.neo4j.graphdb.Label.label("Script");

	public static boolean isScript(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(ScriptLabel);
	}

	public Script newScript() { 
		return newScript(db.createNode(ScriptLabel));
	}

	public Script newScript(org.neo4j.graphdb.Node node) { 
		return new Script(node);
	}

	public java.util.stream.Stream<Script> findAllScript() { 
		return db.findNodes(ScriptLabel).stream().map(this::newScript);
	}

	public Script findScriptByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(ScriptLabel, "name", value);
		return node == null ? null : newScript(node);
	}

	public Script findOrCreateScriptByName(String value) {
		final Script existing = findScriptByName(value);
		return existing == null ? newScript().setName(value) : existing;
	}

	public java.util.stream.Stream<Script> findAllScriptByName(String value) {
		return db.findNodes(ScriptLabel, "name", value).stream().map(this::newScript);
	}

	// ONLY delete this node and its relations
	public void delete(org.neo4j.graphdb.Node node) {

		for (org.neo4j.graphdb.Relationship incoming : node.getRelationships(org.neo4j.graphdb.Direction.INCOMING))
			incoming.delete();

		for (org.neo4j.graphdb.Relationship outgoing : node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING))
			outgoing.delete();

		node.delete();
	}

	// deletes node and its outgoing relations (NOT if any node has other incoming dependencies)
	public void deleteTree(org.neo4j.graphdb.Node node) {

		final java.util.Iterator<org.neo4j.graphdb.Relationship> incoming = node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).iterator();
		if (incoming.hasNext()) return;

		for (org.neo4j.graphdb.Relationship outgoing : node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING)) {
			final org.neo4j.graphdb.Node otherNode = outgoing.getOtherNode(node);
			outgoing.delete();
			deleteTree(otherNode);
		}

		node.delete();
	}
}