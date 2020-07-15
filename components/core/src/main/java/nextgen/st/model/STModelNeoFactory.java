package nextgen.st.model;

public class STModelNeoFactory {

	private final org.neo4j.graphdb.GraphDatabaseService db;

	public STModelNeoFactory(java.lang.String dir) { 
		this(new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabaseBuilder(new java.io.File(dir)).setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_upgrade, "true").newGraphDatabase());
		Runtime.getRuntime().addShutdownHook(new java.lang.Thread(db::shutdown));
	}

	public STModelNeoFactory(org.neo4j.graphdb.GraphDatabaseService db) { 
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

	public STModel newSTModel() { 
		return newSTModel(db.createNode(org.neo4j.graphdb.Label.label("STModel")));
	}

	public STModel newSTModel(org.neo4j.graphdb.Node node) { 
		return new STModel(node);
	}

	public java.util.stream.Stream<STModel> findAllSTModel() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("STModel")).stream().map(this::newSTModel);
	}

	public STModel findSTModelByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STModel"), "uuid", value);
		return node == null ? null : newSTModel(node);
	}

	public STModel findOrCreateSTModelByUuid(String value) {
		final STModel existing = findSTModelByUuid(value);
		return existing == null ? newSTModel().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STModel> findAllSTModelByUuid(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STModel"), "uuid", value).stream().map(this::newSTModel);
	}

	public STModel findSTModelByStGroup(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STModel"), "stGroup", value);
		return node == null ? null : newSTModel(node);
	}

	public STModel findOrCreateSTModelByStGroup(String value) {
		final STModel existing = findSTModelByStGroup(value);
		return existing == null ? newSTModel().setStGroup(value) : existing;
	}

	public java.util.stream.Stream<STModel> findAllSTModelByStGroup(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STModel"), "stGroup", value).stream().map(this::newSTModel);
	}

	public STModel findSTModelByStTemplate(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STModel"), "stTemplate", value);
		return node == null ? null : newSTModel(node);
	}

	public STModel findOrCreateSTModelByStTemplate(String value) {
		final STModel existing = findSTModelByStTemplate(value);
		return existing == null ? newSTModel().setStTemplate(value) : existing;
	}

	public java.util.stream.Stream<STModel> findAllSTModelByStTemplate(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STModel"), "stTemplate", value).stream().map(this::newSTModel);
	}

	public STFile newSTFile() { 
		return newSTFile(db.createNode(org.neo4j.graphdb.Label.label("STFile")));
	}

	public STFile newSTFile(org.neo4j.graphdb.Node node) { 
		return new STFile(node);
	}

	public java.util.stream.Stream<STFile> findAllSTFile() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("STFile")).stream().map(this::newSTFile);
	}

	public STFile findSTFileByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STFile"), "uuid", value);
		return node == null ? null : newSTFile(node);
	}

	public STFile findOrCreateSTFileByUuid(String value) {
		final STFile existing = findSTFileByUuid(value);
		return existing == null ? newSTFile().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STFile> findAllSTFileByUuid(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STFile"), "uuid", value).stream().map(this::newSTFile);
	}

	public STFile findSTFileByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STFile"), "name", value);
		return node == null ? null : newSTFile(node);
	}

	public STFile findOrCreateSTFileByName(String value) {
		final STFile existing = findSTFileByName(value);
		return existing == null ? newSTFile().setName(value) : existing;
	}

	public java.util.stream.Stream<STFile> findAllSTFileByName(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STFile"), "name", value).stream().map(this::newSTFile);
	}

	public STFile findSTFileByType(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STFile"), "type", value);
		return node == null ? null : newSTFile(node);
	}

	public STFile findOrCreateSTFileByType(String value) {
		final STFile existing = findSTFileByType(value);
		return existing == null ? newSTFile().setType(value) : existing;
	}

	public java.util.stream.Stream<STFile> findAllSTFileByType(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STFile"), "type", value).stream().map(this::newSTFile);
	}

	public STFile findSTFileByPackageName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STFile"), "packageName", value);
		return node == null ? null : newSTFile(node);
	}

	public STFile findOrCreateSTFileByPackageName(String value) {
		final STFile existing = findSTFileByPackageName(value);
		return existing == null ? newSTFile().setPackageName(value) : existing;
	}

	public java.util.stream.Stream<STFile> findAllSTFileByPackageName(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STFile"), "packageName", value).stream().map(this::newSTFile);
	}

	public STFile findSTFileByPath(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STFile"), "path", value);
		return node == null ? null : newSTFile(node);
	}

	public STFile findOrCreateSTFileByPath(String value) {
		final STFile existing = findSTFileByPath(value);
		return existing == null ? newSTFile().setPath(value) : existing;
	}

	public java.util.stream.Stream<STFile> findAllSTFileByPath(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STFile"), "path", value).stream().map(this::newSTFile);
	}

	public STArgument newSTArgument() { 
		return newSTArgument(db.createNode(org.neo4j.graphdb.Label.label("STArgument")));
	}

	public STArgument newSTArgument(org.neo4j.graphdb.Node node) { 
		return new STArgument(node);
	}

	public java.util.stream.Stream<STArgument> findAllSTArgument() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("STArgument")).stream().map(this::newSTArgument);
	}

	public STArgument findSTArgumentByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STArgument"), "uuid", value);
		return node == null ? null : newSTArgument(node);
	}

	public STArgument findOrCreateSTArgumentByUuid(String value) {
		final STArgument existing = findSTArgumentByUuid(value);
		return existing == null ? newSTArgument().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STArgument> findAllSTArgumentByUuid(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STArgument"), "uuid", value).stream().map(this::newSTArgument);
	}

	public STArgument findSTArgumentByStParameter(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STArgument"), "stParameter", value);
		return node == null ? null : newSTArgument(node);
	}

	public STArgument findOrCreateSTArgumentByStParameter(String value) {
		final STArgument existing = findSTArgumentByStParameter(value);
		return existing == null ? newSTArgument().setStParameter(value) : existing;
	}

	public java.util.stream.Stream<STArgument> findAllSTArgumentByStParameter(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STArgument"), "stParameter", value).stream().map(this::newSTArgument);
	}

	public STValue newSTValue() { 
		return newSTValue(db.createNode(org.neo4j.graphdb.Label.label("STValue")));
	}

	public STValue newSTValue(org.neo4j.graphdb.Node node) { 
		return new STValue(node);
	}

	public java.util.stream.Stream<STValue> findAllSTValue() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("STValue")).stream().map(this::newSTValue);
	}

	public STValue findSTValueByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STValue"), "uuid", value);
		return node == null ? null : newSTValue(node);
	}

	public STValue findOrCreateSTValueByUuid(String value) {
		final STValue existing = findSTValueByUuid(value);
		return existing == null ? newSTValue().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STValue> findAllSTValueByUuid(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STValue"), "uuid", value).stream().map(this::newSTValue);
	}

	public STValue findSTValueByValue(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STValue"), "value", value);
		return node == null ? null : newSTValue(node);
	}

	public STValue findOrCreateSTValueByValue(String value) {
		final STValue existing = findSTValueByValue(value);
		return existing == null ? newSTValue().setValue(value) : existing;
	}

	public java.util.stream.Stream<STValue> findAllSTValueByValue(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STValue"), "value", value).stream().map(this::newSTValue);
	}

	public STValue findSTValueByType(STValueType value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STValue"), "type", value.name());
		return node == null ? null : newSTValue(node);
	}

	public STValue findOrCreateSTValueByType(STValueType value) {
		final STValue existing = findSTValueByType(value);
		return existing == null ? newSTValue().setType(value) : existing;
	}

	public java.util.stream.Stream<STValue> findAllSTValueByType(STValueType value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STValue"), "type", value.name()).stream().map(this::newSTValue);
	}

	public STArgumentKV newSTArgumentKV() { 
		return newSTArgumentKV(db.createNode(org.neo4j.graphdb.Label.label("STArgumentKV")));
	}

	public STArgumentKV newSTArgumentKV(org.neo4j.graphdb.Node node) { 
		return new STArgumentKV(node);
	}

	public java.util.stream.Stream<STArgumentKV> findAllSTArgumentKV() { 
		return db.findNodes(org.neo4j.graphdb.Label.label("STArgumentKV")).stream().map(this::newSTArgumentKV);
	}

	public STArgumentKV findSTArgumentKVByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STArgumentKV"), "uuid", value);
		return node == null ? null : newSTArgumentKV(node);
	}

	public STArgumentKV findOrCreateSTArgumentKVByUuid(String value) {
		final STArgumentKV existing = findSTArgumentKVByUuid(value);
		return existing == null ? newSTArgumentKV().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STArgumentKV> findAllSTArgumentKVByUuid(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STArgumentKV"), "uuid", value).stream().map(this::newSTArgumentKV);
	}

	public STArgumentKV findSTArgumentKVByStParameterKey(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("STArgumentKV"), "stParameterKey", value);
		return node == null ? null : newSTArgumentKV(node);
	}

	public STArgumentKV findOrCreateSTArgumentKVByStParameterKey(String value) {
		final STArgumentKV existing = findSTArgumentKVByStParameterKey(value);
		return existing == null ? newSTArgumentKV().setStParameterKey(value) : existing;
	}

	public java.util.stream.Stream<STArgumentKV> findAllSTArgumentKVByStParameterKey(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("STArgumentKV"), "stParameterKey", value).stream().map(this::newSTArgumentKV);
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