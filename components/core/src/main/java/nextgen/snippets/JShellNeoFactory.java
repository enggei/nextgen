package nextgen.snippets;

public class JShellNeoFactory {

	private final org.neo4j.graphdb.GraphDatabaseService db;

	public JShellNeoFactory(java.lang.String dir) {
		this(new org.neo4j.graphdb.factory.GraphDatabaseFactory()
				.newEmbeddedDatabaseBuilder(new java.io.File(dir))
				.setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_upgrade, "true")
				.newGraphDatabase());
		Runtime.getRuntime().addShutdownHook(new java.lang.Thread(db::shutdown));
	}



	public JShellNeoFactory(org.neo4j.graphdb.GraphDatabaseService db) {
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

	private static final org.neo4j.graphdb.Label ShellScriptLabel = org.neo4j.graphdb.Label.label("ShellScript");

	public static boolean isShellScript(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(ShellScriptLabel);
	}

	public ShellScript newShellScript() {
		return newShellScript(db.createNode(ShellScriptLabel));
	}

	public ShellScript newShellScript(org.neo4j.graphdb.Node node) {
		return new ShellScript(node);
	}

	public java.util.stream.Stream<ShellScript> findAllShellScript() {
		return db.findNodes(ShellScriptLabel).stream().map(this::newShellScript);
	}

	public ShellScript findShellScriptByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(ShellScriptLabel, "uuid", value);
		return node == null ? null : newShellScript(node);
	}

	public ShellScript findOrCreateShellScriptByUuid(String value) {
		final ShellScript existing = findShellScriptByUuid(value);
		return existing == null ? newShellScript().setUuid(value) : existing;
	}

	public java.util.stream.Stream<ShellScript> findAllShellScriptByUuid(String value) {
		return db.findNodes(ShellScriptLabel, "uuid", value).stream().map(this::newShellScript);
	}

	public ShellScript findShellScriptByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(ShellScriptLabel, "name", value);
		return node == null ? null : newShellScript(node);
	}

	public ShellScript findOrCreateShellScriptByName(String value) {
		final ShellScript existing = findShellScriptByName(value);
		return existing == null ? newShellScript().setName(value) : existing;
	}

	public java.util.stream.Stream<ShellScript> findAllShellScriptByName(String value) {
		return db.findNodes(ShellScriptLabel, "name", value).stream().map(this::newShellScript);
	}

	private static final org.neo4j.graphdb.Label ShellSnippetLabel = org.neo4j.graphdb.Label.label("ShellSnippet");

	public static boolean isShellSnippet(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(ShellSnippetLabel);
	}

	public ShellSnippet newShellSnippet() {
		return newShellSnippet(db.createNode(ShellSnippetLabel));
	}

	public ShellSnippet newShellSnippet(org.neo4j.graphdb.Node node) {
		return new ShellSnippet(node);
	}

	public java.util.stream.Stream<ShellSnippet> findAllShellSnippet() {
		return db.findNodes(ShellSnippetLabel).stream().map(this::newShellSnippet);
	}

	public ShellSnippet findShellSnippetById(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(ShellSnippetLabel, "id", value);
		return node == null ? null : newShellSnippet(node);
	}

	public ShellSnippet findOrCreateShellSnippetById(String value) {
		final ShellSnippet existing = findShellSnippetById(value);
		return existing == null ? newShellSnippet().setId(value) : existing;
	}

	public java.util.stream.Stream<ShellSnippet> findAllShellSnippetById(String value) {
		return db.findNodes(ShellSnippetLabel, "id", value).stream().map(this::newShellSnippet);
	}

	public ShellSnippet findShellSnippetBySource(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(ShellSnippetLabel, "source", value);
		return node == null ? null : newShellSnippet(node);
	}

	public ShellSnippet findOrCreateShellSnippetBySource(String value) {
		final ShellSnippet existing = findShellSnippetBySource(value);
		return existing == null ? newShellSnippet().setSource(value) : existing;
	}

	public java.util.stream.Stream<ShellSnippet> findAllShellSnippetBySource(String value) {
		return db.findNodes(ShellSnippetLabel, "source", value).stream().map(this::newShellSnippet);
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