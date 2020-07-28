package nextgen.st.canvas.layout;

public class LayoutNeoFactory {

	private final org.neo4j.graphdb.GraphDatabaseService db;

	public LayoutNeoFactory(java.lang.String dir) { 
		this(new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabaseBuilder(new java.io.File(dir)).setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_upgrade, "true").newGraphDatabase());
		Runtime.getRuntime().addShutdownHook(new java.lang.Thread(db::shutdown));
	}

	public LayoutNeoFactory(org.neo4j.graphdb.GraphDatabaseService db) { 
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

	private static final org.neo4j.graphdb.Label LayoutLabel = org.neo4j.graphdb.Label.label("Layout");

	public boolean isLayout(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(LayoutLabel);
	}

	public Layout newLayout() {
		return newLayout(db.createNode(LayoutLabel));
	}

	public Layout newLayout(org.neo4j.graphdb.Node node) {
		return new Layout(node);
	}

	public java.util.stream.Stream<Layout> findAllLayout() {
		return db.findNodes(LayoutLabel).stream().map(this::newLayout);
	}

	public Layout findLayoutByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("Layout"), "uuid", value);
		return node == null ? null : newLayout(node);
	}

	public Layout findOrCreateLayoutByUuid(String value) {
		final Layout existing = findLayoutByUuid(value);
		return existing == null ? newLayout().setUuid(value) : existing;
	}

	public java.util.stream.Stream<Layout> findAllLayoutByUuid(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("Layout"), "uuid", value).stream().map(this::newLayout);
	}

	public Layout findLayoutByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("Layout"), "name", value);
		return node == null ? null : newLayout(node);
	}

	public Layout findOrCreateLayoutByName(String value) {
		final Layout existing = findLayoutByName(value);
		return existing == null ? newLayout().setName(value) : existing;
	}

	public java.util.stream.Stream<Layout> findAllLayoutByName(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("Layout"), "name", value).stream().map(this::newLayout);
	}

	private static final org.neo4j.graphdb.Label LayoutNodeLabel = org.neo4j.graphdb.Label.label("LayoutNode");

	public boolean isLayoutNode(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(LayoutNodeLabel);
	}

	public LayoutNode newLayoutNode() {
		return newLayoutNode(db.createNode(LayoutNodeLabel));
	}

	public LayoutNode newLayoutNode(org.neo4j.graphdb.Node node) {
		return new LayoutNode(node);
	}

	public java.util.stream.Stream<LayoutNode> findAllLayoutNode() {
		return db.findNodes(LayoutNodeLabel).stream().map(this::newLayoutNode);
	}

	public LayoutNode findLayoutNodeByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("LayoutNode"), "uuid", value);
		return node == null ? null : newLayoutNode(node);
	}

	public LayoutNode findOrCreateLayoutNodeByUuid(String value) {
		final LayoutNode existing = findLayoutNodeByUuid(value);
		return existing == null ? newLayoutNode().setUuid(value) : existing;
	}

	public java.util.stream.Stream<LayoutNode> findAllLayoutNodeByUuid(String value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("LayoutNode"), "uuid", value).stream().map(this::newLayoutNode);
	}

	public LayoutNode findLayoutNodeByX(Double value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("LayoutNode"), "x", value);
		return node == null ? null : newLayoutNode(node);
	}

	public LayoutNode findOrCreateLayoutNodeByX(Double value) {
		final LayoutNode existing = findLayoutNodeByX(value);
		return existing == null ? newLayoutNode().setX(value) : existing;
	}

	public java.util.stream.Stream<LayoutNode> findAllLayoutNodeByX(Double value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("LayoutNode"), "x", value).stream().map(this::newLayoutNode);
	}

	public LayoutNode findLayoutNodeByY(Double value) {
		final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label("LayoutNode"), "y", value);
		return node == null ? null : newLayoutNode(node);
	}

	public LayoutNode findOrCreateLayoutNodeByY(Double value) {
		final LayoutNode existing = findLayoutNodeByY(value);
		return existing == null ? newLayoutNode().setY(value) : existing;
	}

	public java.util.stream.Stream<LayoutNode> findAllLayoutNodeByY(Double value) {
		return db.findNodes(org.neo4j.graphdb.Label.label("LayoutNode"), "y", value).stream().map(this::newLayoutNode);
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