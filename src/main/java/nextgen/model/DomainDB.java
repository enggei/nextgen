package nextgen.model;

public class DomainDB {

	private final org.neo4j.graphdb.GraphDatabaseService db;

	public DomainDB(java.lang.String dir) { 
		this(new org.neo4j.graphdb.factory.GraphDatabaseFactory()
				.newEmbeddedDatabaseBuilder(new java.io.File(dir))
				.setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_upgrade, "true")
				.newGraphDatabase());
		Runtime.getRuntime().addShutdownHook(new java.lang.Thread(db::shutdown));
	}

	public DomainDB(org.neo4j.graphdb.GraphDatabaseService db) { 
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

	private static final org.neo4j.graphdb.Label DomainLabel = org.neo4j.graphdb.Label.label("Domain");

	public static boolean isDomain(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(DomainLabel);
	}

	public Domain newDomain() { 
		Domain newInstance = newDomain(db.createNode(DomainLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public Domain newDomain(org.neo4j.graphdb.Node node) { 
		return new Domain(node);
	}

	public java.util.stream.Stream<Domain> findAllDomain() { 
		return db.findNodes(DomainLabel).stream().map(this::newDomain);
	}

	public Domain findDomainByName(STValue value) {
		final org.neo4j.graphdb.Node node = db.findNodes(DomainLabel, "name", value).stream().findFirst().orElse(null);
		return node == null ? null : newDomain(node);
	}

	public Domain findOrCreateDomainByName(STValue value) {
		final Domain existing = findDomainByName(value);
		return existing == null ? newDomain().setName(value) : existing;
	}

	public java.util.stream.Stream<Domain> findAllDomainByName(STValue value) {
		return db.findNodes(DomainLabel, "name", value).stream().map(this::newDomain);
	}

	public Domain findDomainByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(DomainLabel, "uuid", value).stream().findFirst().orElse(null);
		return node == null ? null : newDomain(node);
	}

	public Domain findOrCreateDomainByUuid(String value) {
		final Domain existing = findDomainByUuid(value);
		return existing == null ? newDomain().setUuid(value) : existing;
	}

	public java.util.stream.Stream<Domain> findAllDomainByUuid(String value) {
		return db.findNodes(DomainLabel, "uuid", value).stream().map(this::newDomain);
	}

	private static final org.neo4j.graphdb.Label DomainEntityLabel = org.neo4j.graphdb.Label.label("DomainEntity");

	public static boolean isDomainEntity(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(DomainEntityLabel);
	}

	public DomainEntity newDomainEntity() { 
		DomainEntity newInstance = newDomainEntity(db.createNode(DomainEntityLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public DomainEntity newDomainEntity(org.neo4j.graphdb.Node node) { 
		return new DomainEntity(node);
	}

	public java.util.stream.Stream<DomainEntity> findAllDomainEntity() { 
		return db.findNodes(DomainEntityLabel).stream().map(this::newDomainEntity);
	}

	private static final org.neo4j.graphdb.Label DomainPropertyLabel = org.neo4j.graphdb.Label.label("DomainProperty");

	public static boolean isDomainProperty(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(DomainPropertyLabel);
	}

	public DomainProperty newDomainProperty() { 
		DomainProperty newInstance = newDomainProperty(db.createNode(DomainPropertyLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public DomainProperty newDomainProperty(org.neo4j.graphdb.Node node) { 
		return new DomainProperty(node);
	}

	public java.util.stream.Stream<DomainProperty> findAllDomainProperty() { 
		return db.findNodes(DomainPropertyLabel).stream().map(this::newDomainProperty);
	}

	private static final org.neo4j.graphdb.Label DomainRelationLabel = org.neo4j.graphdb.Label.label("DomainRelation");

	public static boolean isDomainRelation(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(DomainRelationLabel);
	}

	public DomainRelation newDomainRelation() { 
		DomainRelation newInstance = newDomainRelation(db.createNode(DomainRelationLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public DomainRelation newDomainRelation(org.neo4j.graphdb.Node node) { 
		return new DomainRelation(node);
	}

	public java.util.stream.Stream<DomainRelation> findAllDomainRelation() { 
		return db.findNodes(DomainRelationLabel).stream().map(this::newDomainRelation);
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

	public static String toString(org.neo4j.graphdb.Node node) {
		final StringBuilder out = new StringBuilder();
		out.append("Node : ").append(node.getId()).append(" ");
		node.getLabels().forEach(label -> out.append(label.name()).append(" "));
		out.append("(");
		node.getPropertyKeys().forEach(s -> out.append(" ").append(s).append(":").append(node.getProperty(s)));
		out.append(")");
		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(relationship -> relationship.getPropertyKeys().forEach(s -> out.append("\n\t\t -> ").append(s).append(":").append(relationship.getProperty(s))));
		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(relationship -> relationship.getPropertyKeys().forEach(s -> out.append("\n\t\t <- ").append(s).append(":").append(relationship.getProperty(s))));
		return out.toString().trim();
	}

	public static String toString(org.neo4j.graphdb.Relationship relationship) {
		final StringBuilder out = new StringBuilder();
		out.append("Relationship : ").append(relationship.getType()).append(" ");
		out.append("(");
		relationship.getPropertyKeys().forEach(s -> out.append(" ").append(s).append(":").append(relationship.getProperty(s)));
		out.append(")");
		out.append(" ").append(toString(relationship.getStartNode())).append(" -> ").append(toString(relationship.getEndNode()));
		return out.toString().trim();
	}
}