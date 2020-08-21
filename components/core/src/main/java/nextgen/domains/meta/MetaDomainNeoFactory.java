package nextgen.domains.meta;

public class MetaDomainNeoFactory {

	private final org.neo4j.graphdb.GraphDatabaseService db;

	public MetaDomainNeoFactory(java.lang.String dir) { 
		this(new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabaseBuilder(new java.io.File(dir)).setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_upgrade, "true").newGraphDatabase());
		Runtime.getRuntime().addShutdownHook(new java.lang.Thread(db::shutdown));
	}

	public MetaDomainNeoFactory(org.neo4j.graphdb.GraphDatabaseService db) { 
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

	private static final org.neo4j.graphdb.Label MetaDomainLabel = org.neo4j.graphdb.Label.label("MetaDomain");

	public static boolean isMetaDomain(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(MetaDomainLabel);
	}

	public MetaDomain newMetaDomain() { 
		return newMetaDomain(db.createNode(MetaDomainLabel));
	}

	public MetaDomain newMetaDomain(org.neo4j.graphdb.Node node) { 
		return new MetaDomain(node);
	}

	public java.util.stream.Stream<MetaDomain> findAllMetaDomain() { 
		return db.findNodes(MetaDomainLabel).stream().map(this::newMetaDomain);
	}

	public MetaDomain findMetaDomainByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(MetaDomainLabel, "uuid", value);
		return node == null ? null : newMetaDomain(node);
	}

	public MetaDomain findOrCreateMetaDomainByUuid(String value) {
		final MetaDomain existing = findMetaDomainByUuid(value);
		return existing == null ? newMetaDomain().setUuid(value) : existing;
	}

	public java.util.stream.Stream<MetaDomain> findAllMetaDomainByUuid(String value) {
		return db.findNodes(MetaDomainLabel, "uuid", value).stream().map(this::newMetaDomain);
	}

	public MetaDomain findMetaDomainByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(MetaDomainLabel, "name", value);
		return node == null ? null : newMetaDomain(node);
	}

	public MetaDomain findOrCreateMetaDomainByName(String value) {
		final MetaDomain existing = findMetaDomainByName(value);
		return existing == null ? newMetaDomain().setName(value) : existing;
	}

	public java.util.stream.Stream<MetaDomain> findAllMetaDomainByName(String value) {
		return db.findNodes(MetaDomainLabel, "name", value).stream().map(this::newMetaDomain);
	}

	private static final org.neo4j.graphdb.Label MetaEntityLabel = org.neo4j.graphdb.Label.label("MetaEntity");

	public static boolean isMetaEntity(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(MetaEntityLabel);
	}

	public MetaEntity newMetaEntity() { 
		return newMetaEntity(db.createNode(MetaEntityLabel));
	}

	public MetaEntity newMetaEntity(org.neo4j.graphdb.Node node) { 
		return new MetaEntity(node);
	}

	public java.util.stream.Stream<MetaEntity> findAllMetaEntity() { 
		return db.findNodes(MetaEntityLabel).stream().map(this::newMetaEntity);
	}

	public MetaEntity findMetaEntityByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(MetaEntityLabel, "uuid", value);
		return node == null ? null : newMetaEntity(node);
	}

	public MetaEntity findOrCreateMetaEntityByUuid(String value) {
		final MetaEntity existing = findMetaEntityByUuid(value);
		return existing == null ? newMetaEntity().setUuid(value) : existing;
	}

	public java.util.stream.Stream<MetaEntity> findAllMetaEntityByUuid(String value) {
		return db.findNodes(MetaEntityLabel, "uuid", value).stream().map(this::newMetaEntity);
	}

	public MetaEntity findMetaEntityByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(MetaEntityLabel, "name", value);
		return node == null ? null : newMetaEntity(node);
	}

	public MetaEntity findOrCreateMetaEntityByName(String value) {
		final MetaEntity existing = findMetaEntityByName(value);
		return existing == null ? newMetaEntity().setName(value) : existing;
	}

	public java.util.stream.Stream<MetaEntity> findAllMetaEntityByName(String value) {
		return db.findNodes(MetaEntityLabel, "name", value).stream().map(this::newMetaEntity);
	}

	private static final org.neo4j.graphdb.Label MetaPropertyLabel = org.neo4j.graphdb.Label.label("MetaProperty");

	public static boolean isMetaProperty(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(MetaPropertyLabel);
	}

	public MetaProperty newMetaProperty() { 
		return newMetaProperty(db.createNode(MetaPropertyLabel));
	}

	public MetaProperty newMetaProperty(org.neo4j.graphdb.Node node) { 
		return new MetaProperty(node);
	}

	public java.util.stream.Stream<MetaProperty> findAllMetaProperty() { 
		return db.findNodes(MetaPropertyLabel).stream().map(this::newMetaProperty);
	}

	public MetaProperty findMetaPropertyByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(MetaPropertyLabel, "uuid", value);
		return node == null ? null : newMetaProperty(node);
	}

	public MetaProperty findOrCreateMetaPropertyByUuid(String value) {
		final MetaProperty existing = findMetaPropertyByUuid(value);
		return existing == null ? newMetaProperty().setUuid(value) : existing;
	}

	public java.util.stream.Stream<MetaProperty> findAllMetaPropertyByUuid(String value) {
		return db.findNodes(MetaPropertyLabel, "uuid", value).stream().map(this::newMetaProperty);
	}

	public MetaProperty findMetaPropertyByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(MetaPropertyLabel, "name", value);
		return node == null ? null : newMetaProperty(node);
	}

	public MetaProperty findOrCreateMetaPropertyByName(String value) {
		final MetaProperty existing = findMetaPropertyByName(value);
		return existing == null ? newMetaProperty().setName(value) : existing;
	}

	public java.util.stream.Stream<MetaProperty> findAllMetaPropertyByName(String value) {
		return db.findNodes(MetaPropertyLabel, "name", value).stream().map(this::newMetaProperty);
	}

	public MetaProperty findMetaPropertyByType(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(MetaPropertyLabel, "type", value);
		return node == null ? null : newMetaProperty(node);
	}

	public MetaProperty findOrCreateMetaPropertyByType(String value) {
		final MetaProperty existing = findMetaPropertyByType(value);
		return existing == null ? newMetaProperty().setType(value) : existing;
	}

	public java.util.stream.Stream<MetaProperty> findAllMetaPropertyByType(String value) {
		return db.findNodes(MetaPropertyLabel, "type", value).stream().map(this::newMetaProperty);
	}

	private static final org.neo4j.graphdb.Label MetaRelationLabel = org.neo4j.graphdb.Label.label("MetaRelation");

	public static boolean isMetaRelation(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(MetaRelationLabel);
	}

	public MetaRelation newMetaRelation() { 
		return newMetaRelation(db.createNode(MetaRelationLabel));
	}

	public MetaRelation newMetaRelation(org.neo4j.graphdb.Node node) { 
		return new MetaRelation(node);
	}

	public java.util.stream.Stream<MetaRelation> findAllMetaRelation() { 
		return db.findNodes(MetaRelationLabel).stream().map(this::newMetaRelation);
	}

	public MetaRelation findMetaRelationByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(MetaRelationLabel, "uuid", value);
		return node == null ? null : newMetaRelation(node);
	}

	public MetaRelation findOrCreateMetaRelationByUuid(String value) {
		final MetaRelation existing = findMetaRelationByUuid(value);
		return existing == null ? newMetaRelation().setUuid(value) : existing;
	}

	public java.util.stream.Stream<MetaRelation> findAllMetaRelationByUuid(String value) {
		return db.findNodes(MetaRelationLabel, "uuid", value).stream().map(this::newMetaRelation);
	}

	public MetaRelation findMetaRelationByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(MetaRelationLabel, "name", value);
		return node == null ? null : newMetaRelation(node);
	}

	public MetaRelation findOrCreateMetaRelationByName(String value) {
		final MetaRelation existing = findMetaRelationByName(value);
		return existing == null ? newMetaRelation().setName(value) : existing;
	}

	public java.util.stream.Stream<MetaRelation> findAllMetaRelationByName(String value) {
		return db.findNodes(MetaRelationLabel, "name", value).stream().map(this::newMetaRelation);
	}

	public MetaRelation findMetaRelationByCardinality(Cardinality value) {
		final org.neo4j.graphdb.Node node = db.findNode(MetaRelationLabel, "cardinality", value.name());
		return node == null ? null : newMetaRelation(node);
	}

	public MetaRelation findOrCreateMetaRelationByCardinality(Cardinality value) {
		final MetaRelation existing = findMetaRelationByCardinality(value);
		return existing == null ? newMetaRelation().setCardinality(value) : existing;
	}

	public java.util.stream.Stream<MetaRelation> findAllMetaRelationByCardinality(Cardinality value) {
		return db.findNodes(MetaRelationLabel, "cardinality", value.name()).stream().map(this::newMetaRelation);
	}

	private static final org.neo4j.graphdb.Label DomainVisitorLabel = org.neo4j.graphdb.Label.label("DomainVisitor");

	public static boolean isDomainVisitor(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(DomainVisitorLabel);
	}

	public DomainVisitor newDomainVisitor() { 
		return newDomainVisitor(db.createNode(DomainVisitorLabel));
	}

	public DomainVisitor newDomainVisitor(org.neo4j.graphdb.Node node) { 
		return new DomainVisitor(node);
	}

	public java.util.stream.Stream<DomainVisitor> findAllDomainVisitor() { 
		return db.findNodes(DomainVisitorLabel).stream().map(this::newDomainVisitor);
	}

	public DomainVisitor findDomainVisitorByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(DomainVisitorLabel, "uuid", value);
		return node == null ? null : newDomainVisitor(node);
	}

	public DomainVisitor findOrCreateDomainVisitorByUuid(String value) {
		final DomainVisitor existing = findDomainVisitorByUuid(value);
		return existing == null ? newDomainVisitor().setUuid(value) : existing;
	}

	public java.util.stream.Stream<DomainVisitor> findAllDomainVisitorByUuid(String value) {
		return db.findNodes(DomainVisitorLabel, "uuid", value).stream().map(this::newDomainVisitor);
	}

	public DomainVisitor findDomainVisitorByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(DomainVisitorLabel, "name", value);
		return node == null ? null : newDomainVisitor(node);
	}

	public DomainVisitor findOrCreateDomainVisitorByName(String value) {
		final DomainVisitor existing = findDomainVisitorByName(value);
		return existing == null ? newDomainVisitor().setName(value) : existing;
	}

	public java.util.stream.Stream<DomainVisitor> findAllDomainVisitorByName(String value) {
		return db.findNodes(DomainVisitorLabel, "name", value).stream().map(this::newDomainVisitor);
	}

	private static final org.neo4j.graphdb.Label VisitorFieldLabel = org.neo4j.graphdb.Label.label("VisitorField");

	public static boolean isVisitorField(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(VisitorFieldLabel);
	}

	public VisitorField newVisitorField() { 
		return newVisitorField(db.createNode(VisitorFieldLabel));
	}

	public VisitorField newVisitorField(org.neo4j.graphdb.Node node) { 
		return new VisitorField(node);
	}

	public java.util.stream.Stream<VisitorField> findAllVisitorField() { 
		return db.findNodes(VisitorFieldLabel).stream().map(this::newVisitorField);
	}

	public VisitorField findVisitorFieldByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(VisitorFieldLabel, "uuid", value);
		return node == null ? null : newVisitorField(node);
	}

	public VisitorField findOrCreateVisitorFieldByUuid(String value) {
		final VisitorField existing = findVisitorFieldByUuid(value);
		return existing == null ? newVisitorField().setUuid(value) : existing;
	}

	public java.util.stream.Stream<VisitorField> findAllVisitorFieldByUuid(String value) {
		return db.findNodes(VisitorFieldLabel, "uuid", value).stream().map(this::newVisitorField);
	}

	public VisitorField findVisitorFieldByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(VisitorFieldLabel, "name", value);
		return node == null ? null : newVisitorField(node);
	}

	public VisitorField findOrCreateVisitorFieldByName(String value) {
		final VisitorField existing = findVisitorFieldByName(value);
		return existing == null ? newVisitorField().setName(value) : existing;
	}

	public java.util.stream.Stream<VisitorField> findAllVisitorFieldByName(String value) {
		return db.findNodes(VisitorFieldLabel, "name", value).stream().map(this::newVisitorField);
	}

	public VisitorField findVisitorFieldByType(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(VisitorFieldLabel, "type", value);
		return node == null ? null : newVisitorField(node);
	}

	public VisitorField findOrCreateVisitorFieldByType(String value) {
		final VisitorField existing = findVisitorFieldByType(value);
		return existing == null ? newVisitorField().setType(value) : existing;
	}

	public java.util.stream.Stream<VisitorField> findAllVisitorFieldByType(String value) {
		return db.findNodes(VisitorFieldLabel, "type", value).stream().map(this::newVisitorField);
	}

	private static final org.neo4j.graphdb.Label EntityVisitorMethodLabel = org.neo4j.graphdb.Label.label("EntityVisitorMethod");

	public static boolean isEntityVisitorMethod(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(EntityVisitorMethodLabel);
	}

	public EntityVisitorMethod newEntityVisitorMethod() { 
		return newEntityVisitorMethod(db.createNode(EntityVisitorMethodLabel));
	}

	public EntityVisitorMethod newEntityVisitorMethod(org.neo4j.graphdb.Node node) { 
		return new EntityVisitorMethod(node);
	}

	public java.util.stream.Stream<EntityVisitorMethod> findAllEntityVisitorMethod() { 
		return db.findNodes(EntityVisitorMethodLabel).stream().map(this::newEntityVisitorMethod);
	}

	public EntityVisitorMethod findEntityVisitorMethodByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(EntityVisitorMethodLabel, "uuid", value);
		return node == null ? null : newEntityVisitorMethod(node);
	}

	public EntityVisitorMethod findOrCreateEntityVisitorMethodByUuid(String value) {
		final EntityVisitorMethod existing = findEntityVisitorMethodByUuid(value);
		return existing == null ? newEntityVisitorMethod().setUuid(value) : existing;
	}

	public java.util.stream.Stream<EntityVisitorMethod> findAllEntityVisitorMethodByUuid(String value) {
		return db.findNodes(EntityVisitorMethodLabel, "uuid", value).stream().map(this::newEntityVisitorMethod);
	}

	public EntityVisitorMethod findEntityVisitorMethodByStatements(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(EntityVisitorMethodLabel, "statements", value);
		return node == null ? null : newEntityVisitorMethod(node);
	}

	public EntityVisitorMethod findOrCreateEntityVisitorMethodByStatements(String value) {
		final EntityVisitorMethod existing = findEntityVisitorMethodByStatements(value);
		return existing == null ? newEntityVisitorMethod().setStatements(value) : existing;
	}

	public java.util.stream.Stream<EntityVisitorMethod> findAllEntityVisitorMethodByStatements(String value) {
		return db.findNodes(EntityVisitorMethodLabel, "statements", value).stream().map(this::newEntityVisitorMethod);
	}

	private static final org.neo4j.graphdb.Label RelationVisitorMethodLabel = org.neo4j.graphdb.Label.label("RelationVisitorMethod");

	public static boolean isRelationVisitorMethod(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(RelationVisitorMethodLabel);
	}

	public RelationVisitorMethod newRelationVisitorMethod() { 
		return newRelationVisitorMethod(db.createNode(RelationVisitorMethodLabel));
	}

	public RelationVisitorMethod newRelationVisitorMethod(org.neo4j.graphdb.Node node) { 
		return new RelationVisitorMethod(node);
	}

	public java.util.stream.Stream<RelationVisitorMethod> findAllRelationVisitorMethod() { 
		return db.findNodes(RelationVisitorMethodLabel).stream().map(this::newRelationVisitorMethod);
	}

	public RelationVisitorMethod findRelationVisitorMethodByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(RelationVisitorMethodLabel, "uuid", value);
		return node == null ? null : newRelationVisitorMethod(node);
	}

	public RelationVisitorMethod findOrCreateRelationVisitorMethodByUuid(String value) {
		final RelationVisitorMethod existing = findRelationVisitorMethodByUuid(value);
		return existing == null ? newRelationVisitorMethod().setUuid(value) : existing;
	}

	public java.util.stream.Stream<RelationVisitorMethod> findAllRelationVisitorMethodByUuid(String value) {
		return db.findNodes(RelationVisitorMethodLabel, "uuid", value).stream().map(this::newRelationVisitorMethod);
	}

	public RelationVisitorMethod findRelationVisitorMethodByStatements(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(RelationVisitorMethodLabel, "statements", value);
		return node == null ? null : newRelationVisitorMethod(node);
	}

	public RelationVisitorMethod findOrCreateRelationVisitorMethodByStatements(String value) {
		final RelationVisitorMethod existing = findRelationVisitorMethodByStatements(value);
		return existing == null ? newRelationVisitorMethod().setStatements(value) : existing;
	}

	public java.util.stream.Stream<RelationVisitorMethod> findAllRelationVisitorMethodByStatements(String value) {
		return db.findNodes(RelationVisitorMethodLabel, "statements", value).stream().map(this::newRelationVisitorMethod);
	}

	private static final org.neo4j.graphdb.Label DomainEntityLabel = org.neo4j.graphdb.Label.label("DomainEntity");

	public static boolean isDomainEntity(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(DomainEntityLabel);
	}

	public DomainEntity newDomainEntity() { 
		return newDomainEntity(db.createNode(DomainEntityLabel));
	}

	public DomainEntity newDomainEntity(org.neo4j.graphdb.Node node) { 
		return new DomainEntity(node);
	}

	public java.util.stream.Stream<DomainEntity> findAllDomainEntity() { 
		return db.findNodes(DomainEntityLabel).stream().map(this::newDomainEntity);
	}

	public DomainEntity findDomainEntityByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(DomainEntityLabel, "uuid", value);
		return node == null ? null : newDomainEntity(node);
	}

	public DomainEntity findOrCreateDomainEntityByUuid(String value) {
		final DomainEntity existing = findDomainEntityByUuid(value);
		return existing == null ? newDomainEntity().setUuid(value) : existing;
	}

	public java.util.stream.Stream<DomainEntity> findAllDomainEntityByUuid(String value) {
		return db.findNodes(DomainEntityLabel, "uuid", value).stream().map(this::newDomainEntity);
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