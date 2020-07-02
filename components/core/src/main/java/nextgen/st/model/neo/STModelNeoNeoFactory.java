package nextgen.st.model.neo;

public class STModelNeoNeoFactory {

	private final org.neo4j.graphdb.GraphDatabaseService db;

	public STModelNeoNeoFactory(java.lang.String dir) { 
		this(new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabaseBuilder(new java.io.File(dir)).setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_upgrade, "true").newGraphDatabase());
		Runtime.getRuntime().addShutdownHook(new java.lang.Thread(db::shutdown));
	}

	public STModelNeoNeoFactory(org.neo4j.graphdb.GraphDatabaseService db) { 
		this.db = db;
	}

	public org.neo4j.graphdb.GraphDatabaseService getDatabaseService() { 
		return this.db;
	}

	public void doInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> action) { 
		doInTransaction(action, java.lang.Throwable::printStackTrace);
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

	public STModelNeo newSTModelNeo() { 
		return newSTModelNeo(db.createNode(org.neo4j.graphdb.Label.label("STModelNeo")));
	}

	public STModelNeo newSTModelNeo(org.neo4j.graphdb.Node node) { 
		return new STModelNeo(node);
	}

	public java.util.stream.Stream<STModelNeo> findAllSTModelNeo() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("STModelNeo")).stream().map(this::newSTModelNeo);
	}

	public STModelNeo findSTModelNeoByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STModelNeo"), "uuid", value);
		return node == null ? null : new STModelNeo(node);
	}

	public STModelNeo findOrCreateSTModelNeoByUuid(String value) {
		final STModelNeo existing = findSTModelNeoByUuid(value);
		return existing == null ? newSTModelNeo().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STModelNeo> findAllSTModelNeoByUuid(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STModelNeo"), "uuid", value).stream().map(this::newSTModelNeo);
	}

	public STModelNeo findSTModelNeoByStTemplate(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STModelNeo"), "stTemplate", value);
		return node == null ? null : new STModelNeo(node);
	}

	public STModelNeo findOrCreateSTModelNeoByStTemplate(String value) {
		final STModelNeo existing = findSTModelNeoByStTemplate(value);
		return existing == null ? newSTModelNeo().setStTemplate(value) : existing;
	}

	public java.util.stream.Stream<STModelNeo> findAllSTModelNeoByStTemplate(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STModelNeo"), "stTemplate", value).stream().map(this::newSTModelNeo);
	}

	public STFileNeo newSTFileNeo() { 
		return newSTFileNeo(db.createNode(org.neo4j.graphdb.Label.label("STFileNeo")));
	}

	public STFileNeo newSTFileNeo(org.neo4j.graphdb.Node node) { 
		return new STFileNeo(node);
	}

	public java.util.stream.Stream<STFileNeo> findAllSTFileNeo() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("STFileNeo")).stream().map(this::newSTFileNeo);
	}

	public STFileNeo findSTFileNeoByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STFileNeo"), "uuid", value);
		return node == null ? null : new STFileNeo(node);
	}

	public STFileNeo findOrCreateSTFileNeoByUuid(String value) {
		final STFileNeo existing = findSTFileNeoByUuid(value);
		return existing == null ? newSTFileNeo().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STFileNeo> findAllSTFileNeoByUuid(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STFileNeo"), "uuid", value).stream().map(this::newSTFileNeo);
	}

	public STFileNeo findSTFileNeoByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STFileNeo"), "name", value);
		return node == null ? null : new STFileNeo(node);
	}

	public STFileNeo findOrCreateSTFileNeoByName(String value) {
		final STFileNeo existing = findSTFileNeoByName(value);
		return existing == null ? newSTFileNeo().setName(value) : existing;
	}

	public java.util.stream.Stream<STFileNeo> findAllSTFileNeoByName(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STFileNeo"), "name", value).stream().map(this::newSTFileNeo);
	}

	public STFileNeo findSTFileNeoByType(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STFileNeo"), "type", value);
		return node == null ? null : new STFileNeo(node);
	}

	public STFileNeo findOrCreateSTFileNeoByType(String value) {
		final STFileNeo existing = findSTFileNeoByType(value);
		return existing == null ? newSTFileNeo().setType(value) : existing;
	}

	public java.util.stream.Stream<STFileNeo> findAllSTFileNeoByType(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STFileNeo"), "type", value).stream().map(this::newSTFileNeo);
	}

	public STFileNeo findSTFileNeoByPackageName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STFileNeo"), "packageName", value);
		return node == null ? null : new STFileNeo(node);
	}

	public STFileNeo findOrCreateSTFileNeoByPackageName(String value) {
		final STFileNeo existing = findSTFileNeoByPackageName(value);
		return existing == null ? newSTFileNeo().setPackageName(value) : existing;
	}

	public java.util.stream.Stream<STFileNeo> findAllSTFileNeoByPackageName(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STFileNeo"), "packageName", value).stream().map(this::newSTFileNeo);
	}

	public STFileNeo findSTFileNeoByPath(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STFileNeo"), "path", value);
		return node == null ? null : new STFileNeo(node);
	}

	public STFileNeo findOrCreateSTFileNeoByPath(String value) {
		final STFileNeo existing = findSTFileNeoByPath(value);
		return existing == null ? newSTFileNeo().setPath(value) : existing;
	}

	public java.util.stream.Stream<STFileNeo> findAllSTFileNeoByPath(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STFileNeo"), "path", value).stream().map(this::newSTFileNeo);
	}

	public STArgumentNeo newSTArgumentNeo() { 
		return newSTArgumentNeo(db.createNode(org.neo4j.graphdb.Label.label("STArgumentNeo")));
	}

	public STArgumentNeo newSTArgumentNeo(org.neo4j.graphdb.Node node) { 
		return new STArgumentNeo(node);
	}

	public java.util.stream.Stream<STArgumentNeo> findAllSTArgumentNeo() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("STArgumentNeo")).stream().map(this::newSTArgumentNeo);
	}

	public STArgumentNeo findSTArgumentNeoByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STArgumentNeo"), "uuid", value);
		return node == null ? null : new STArgumentNeo(node);
	}

	public STArgumentNeo findOrCreateSTArgumentNeoByUuid(String value) {
		final STArgumentNeo existing = findSTArgumentNeoByUuid(value);
		return existing == null ? newSTArgumentNeo().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STArgumentNeo> findAllSTArgumentNeoByUuid(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STArgumentNeo"), "uuid", value).stream().map(this::newSTArgumentNeo);
	}

	public STArgumentNeo findSTArgumentNeoByStParameter(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STArgumentNeo"), "stParameter", value);
		return node == null ? null : new STArgumentNeo(node);
	}

	public STArgumentNeo findOrCreateSTArgumentNeoByStParameter(String value) {
		final STArgumentNeo existing = findSTArgumentNeoByStParameter(value);
		return existing == null ? newSTArgumentNeo().setStParameter(value) : existing;
	}

	public java.util.stream.Stream<STArgumentNeo> findAllSTArgumentNeoByStParameter(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STArgumentNeo"), "stParameter", value).stream().map(this::newSTArgumentNeo);
	}

	public STValueNeo newSTValueNeo() { 
		return newSTValueNeo(db.createNode(org.neo4j.graphdb.Label.label("STValueNeo")));
	}

	public STValueNeo newSTValueNeo(org.neo4j.graphdb.Node node) { 
		return new STValueNeo(node);
	}

	public java.util.stream.Stream<STValueNeo> findAllSTValueNeo() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("STValueNeo")).stream().map(this::newSTValueNeo);
	}

	public STValueNeo findSTValueNeoByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STValueNeo"), "uuid", value);
		return node == null ? null : new STValueNeo(node);
	}

	public STValueNeo findOrCreateSTValueNeoByUuid(String value) {
		final STValueNeo existing = findSTValueNeoByUuid(value);
		return existing == null ? newSTValueNeo().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STValueNeo> findAllSTValueNeoByUuid(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STValueNeo"), "uuid", value).stream().map(this::newSTValueNeo);
	}

	public STValueNeo findSTValueNeoByValue(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STValueNeo"), "value", value);
		return node == null ? null : new STValueNeo(node);
	}

	public STValueNeo findOrCreateSTValueNeoByValue(String value) {
		final STValueNeo existing = findSTValueNeoByValue(value);
		return existing == null ? newSTValueNeo().setValue(value) : existing;
	}

	public java.util.stream.Stream<STValueNeo> findAllSTValueNeoByValue(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STValueNeo"), "value", value).stream().map(this::newSTValueNeo);
	}

	public STValueNeo findSTValueNeoByType(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STValueNeo"), "type", value);
		return node == null ? null : new STValueNeo(node);
	}

	public STValueNeo findOrCreateSTValueNeoByType(String value) {
		final STValueNeo existing = findSTValueNeoByType(value);
		return existing == null ? newSTValueNeo().setType(value) : existing;
	}

	public java.util.stream.Stream<STValueNeo> findAllSTValueNeoByType(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STValueNeo"), "type", value).stream().map(this::newSTValueNeo);
	}

	public STArgumentKVNeo newSTArgumentKVNeo() { 
		return newSTArgumentKVNeo(db.createNode(org.neo4j.graphdb.Label.label("STArgumentKVNeo")));
	}

	public STArgumentKVNeo newSTArgumentKVNeo(org.neo4j.graphdb.Node node) { 
		return new STArgumentKVNeo(node);
	}

	public java.util.stream.Stream<STArgumentKVNeo> findAllSTArgumentKVNeo() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("STArgumentKVNeo")).stream().map(this::newSTArgumentKVNeo);
	}

	public STArgumentKVNeo findSTArgumentKVNeoByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STArgumentKVNeo"), "uuid", value);
		return node == null ? null : new STArgumentKVNeo(node);
	}

	public STArgumentKVNeo findOrCreateSTArgumentKVNeoByUuid(String value) {
		final STArgumentKVNeo existing = findSTArgumentKVNeoByUuid(value);
		return existing == null ? newSTArgumentKVNeo().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STArgumentKVNeo> findAllSTArgumentKVNeoByUuid(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STArgumentKVNeo"), "uuid", value).stream().map(this::newSTArgumentKVNeo);
	}

	public STArgumentKVNeo findSTArgumentKVNeoByStParameterKey(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STArgumentKVNeo"), "stParameterKey", value);
		return node == null ? null : new STArgumentKVNeo(node);
	}

	public STArgumentKVNeo findOrCreateSTArgumentKVNeoByStParameterKey(String value) {
		final STArgumentKVNeo existing = findSTArgumentKVNeoByStParameterKey(value);
		return existing == null ? newSTArgumentKVNeo().setStParameterKey(value) : existing;
	}

	public java.util.stream.Stream<STArgumentKVNeo> findAllSTArgumentKVNeoByStParameterKey(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STArgumentKVNeo"), "stParameterKey", value).stream().map(this::newSTArgumentKVNeo);
	}
}