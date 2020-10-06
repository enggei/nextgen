package nextgen.workflow;

public class WorkFlowNeoFactory {

	private final org.neo4j.graphdb.GraphDatabaseService db;

	public WorkFlowNeoFactory(java.lang.String dir) {
		this(new org.neo4j.graphdb.factory.GraphDatabaseFactory()
				.newEmbeddedDatabaseBuilder(new java.io.File(dir))
				.setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_upgrade, "true")
				.newGraphDatabase());
		Runtime.getRuntime().addShutdownHook(new java.lang.Thread(db::shutdown));
	}

	public WorkFlowNeoFactory(org.neo4j.graphdb.GraphDatabaseService db) {
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

	private static final org.neo4j.graphdb.Label WorkLabel = org.neo4j.graphdb.Label.label("Work");

	public static boolean isWork(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(WorkLabel);
	}

	public Work newWork() { 
		return newWork(db.createNode(WorkLabel));
	}

	public Work newWork(org.neo4j.graphdb.Node node) { 
		return new Work(node);
	}

	public java.util.stream.Stream<Work> findAllWork() { 
		return db.findNodes(WorkLabel).stream().map(this::newWork);
	}

	public Work findWorkByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(WorkLabel, "uuid", value);
		return node == null ? null : newWork(node);
	}

	public Work findOrCreateWorkByUuid(String value) {
		final Work existing = findWorkByUuid(value);
		return existing == null ? newWork().setUuid(value) : existing;
	}

	public java.util.stream.Stream<Work> findAllWorkByUuid(String value) {
		return db.findNodes(WorkLabel, "uuid", value).stream().map(this::newWork);
	}

	public Work findWorkByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(WorkLabel, "name", value);
		return node == null ? null : newWork(node);
	}

	public Work findOrCreateWorkByName(String value) {
		final Work existing = findWorkByName(value);
		return existing == null ? newWork().setName(value) : existing;
	}

	public java.util.stream.Stream<Work> findAllWorkByName(String value) {
		return db.findNodes(WorkLabel, "name", value).stream().map(this::newWork);
	}

	public Work findWorkByPackage(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(WorkLabel, "package", value);
		return node == null ? null : newWork(node);
	}

	public Work findOrCreateWorkByPackage(String value) {
		final Work existing = findWorkByPackage(value);
		return existing == null ? newWork().setPackage(value) : existing;
	}

	public java.util.stream.Stream<Work> findAllWorkByPackage(String value) {
		return db.findNodes(WorkLabel, "package", value).stream().map(this::newWork);
	}

	private static final org.neo4j.graphdb.Label WorkInputLabel = org.neo4j.graphdb.Label.label("WorkInput");

	public static boolean isWorkInput(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(WorkInputLabel);
	}

	public WorkInput newWorkInput() { 
		return newWorkInput(db.createNode(WorkInputLabel));
	}

	public WorkInput newWorkInput(org.neo4j.graphdb.Node node) { 
		return new WorkInput(node);
	}

	public java.util.stream.Stream<WorkInput> findAllWorkInput() { 
		return db.findNodes(WorkInputLabel).stream().map(this::newWorkInput);
	}

	public WorkInput findWorkInputByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(WorkInputLabel, "uuid", value);
		return node == null ? null : newWorkInput(node);
	}

	public WorkInput findOrCreateWorkInputByUuid(String value) {
		final WorkInput existing = findWorkInputByUuid(value);
		return existing == null ? newWorkInput().setUuid(value) : existing;
	}

	public java.util.stream.Stream<WorkInput> findAllWorkInputByUuid(String value) {
		return db.findNodes(WorkInputLabel, "uuid", value).stream().map(this::newWorkInput);
	}

	public WorkInput findWorkInputByType(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(WorkInputLabel, "type", value);
		return node == null ? null : newWorkInput(node);
	}

	public WorkInput findOrCreateWorkInputByType(String value) {
		final WorkInput existing = findWorkInputByType(value);
		return existing == null ? newWorkInput().setType(value) : existing;
	}

	public java.util.stream.Stream<WorkInput> findAllWorkInputByType(String value) {
		return db.findNodes(WorkInputLabel, "type", value).stream().map(this::newWorkInput);
	}

	public WorkInput findWorkInputByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(WorkInputLabel, "name", value);
		return node == null ? null : newWorkInput(node);
	}

	public WorkInput findOrCreateWorkInputByName(String value) {
		final WorkInput existing = findWorkInputByName(value);
		return existing == null ? newWorkInput().setName(value) : existing;
	}

	public java.util.stream.Stream<WorkInput> findAllWorkInputByName(String value) {
		return db.findNodes(WorkInputLabel, "name", value).stream().map(this::newWorkInput);
	}

	private static final org.neo4j.graphdb.Label WorkStatementLabel = org.neo4j.graphdb.Label.label("WorkStatement");

	public static boolean isWorkStatement(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(WorkStatementLabel);
	}

	public WorkStatement newWorkStatement() { 
		return newWorkStatement(db.createNode(WorkStatementLabel));
	}

	public WorkStatement newWorkStatement(org.neo4j.graphdb.Node node) { 
		return new WorkStatement(node);
	}

	public java.util.stream.Stream<WorkStatement> findAllWorkStatement() { 
		return db.findNodes(WorkStatementLabel).stream().map(this::newWorkStatement);
	}

	public WorkStatement findWorkStatementByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(WorkStatementLabel, "uuid", value);
		return node == null ? null : newWorkStatement(node);
	}

	public WorkStatement findOrCreateWorkStatementByUuid(String value) {
		final WorkStatement existing = findWorkStatementByUuid(value);
		return existing == null ? newWorkStatement().setUuid(value) : existing;
	}

	public java.util.stream.Stream<WorkStatement> findAllWorkStatementByUuid(String value) {
		return db.findNodes(WorkStatementLabel, "uuid", value).stream().map(this::newWorkStatement);
	}

	public WorkStatement findWorkStatementByStatement(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(WorkStatementLabel, "statement", value);
		return node == null ? null : newWorkStatement(node);
	}

	public WorkStatement findOrCreateWorkStatementByStatement(String value) {
		final WorkStatement existing = findWorkStatementByStatement(value);
		return existing == null ? newWorkStatement().setStatement(value) : existing;
	}

	public java.util.stream.Stream<WorkStatement> findAllWorkStatementByStatement(String value) {
		return db.findNodes(WorkStatementLabel, "statement", value).stream().map(this::newWorkStatement);
	}

	private static final org.neo4j.graphdb.Label WorkInstanceLabel = org.neo4j.graphdb.Label.label("WorkInstance");

	public static boolean isWorkInstance(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(WorkInstanceLabel);
	}

	public WorkInstance newWorkInstance() { 
		return newWorkInstance(db.createNode(WorkInstanceLabel));
	}

	public WorkInstance newWorkInstance(org.neo4j.graphdb.Node node) { 
		return new WorkInstance(node);
	}

	public java.util.stream.Stream<WorkInstance> findAllWorkInstance() { 
		return db.findNodes(WorkInstanceLabel).stream().map(this::newWorkInstance);
	}

	public WorkInstance findWorkInstanceByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(WorkInstanceLabel, "uuid", value);
		return node == null ? null : newWorkInstance(node);
	}

	public WorkInstance findOrCreateWorkInstanceByUuid(String value) {
		final WorkInstance existing = findWorkInstanceByUuid(value);
		return existing == null ? newWorkInstance().setUuid(value) : existing;
	}

	public java.util.stream.Stream<WorkInstance> findAllWorkInstanceByUuid(String value) {
		return db.findNodes(WorkInstanceLabel, "uuid", value).stream().map(this::newWorkInstance);
	}

	public WorkInstance findWorkInstanceByType(WorkType value) {
		final org.neo4j.graphdb.Node node = db.findNode(WorkInstanceLabel, "type", value.name());
		return node == null ? null : newWorkInstance(node);
	}

	public WorkInstance findOrCreateWorkInstanceByType(WorkType value) {
		final WorkInstance existing = findWorkInstanceByType(value);
		return existing == null ? newWorkInstance().setType(value) : existing;
	}

	public java.util.stream.Stream<WorkInstance> findAllWorkInstanceByType(WorkType value) {
		return db.findNodes(WorkInstanceLabel, "type", value.name()).stream().map(this::newWorkInstance);
	}

	private static final org.neo4j.graphdb.Label ConditionalFlowLabel = org.neo4j.graphdb.Label.label("ConditionalFlow");

	public static boolean isConditionalFlow(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(ConditionalFlowLabel);
	}

	public ConditionalFlow newConditionalFlow() { 
		return newConditionalFlow(db.createNode(ConditionalFlowLabel));
	}

	public ConditionalFlow newConditionalFlow(org.neo4j.graphdb.Node node) { 
		return new ConditionalFlow(node);
	}

	public java.util.stream.Stream<ConditionalFlow> findAllConditionalFlow() { 
		return db.findNodes(ConditionalFlowLabel).stream().map(this::newConditionalFlow);
	}

	public ConditionalFlow findConditionalFlowByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(ConditionalFlowLabel, "uuid", value);
		return node == null ? null : newConditionalFlow(node);
	}

	public ConditionalFlow findOrCreateConditionalFlowByUuid(String value) {
		final ConditionalFlow existing = findConditionalFlowByUuid(value);
		return existing == null ? newConditionalFlow().setUuid(value) : existing;
	}

	public java.util.stream.Stream<ConditionalFlow> findAllConditionalFlowByUuid(String value) {
		return db.findNodes(ConditionalFlowLabel, "uuid", value).stream().map(this::newConditionalFlow);
	}

	public ConditionalFlow findConditionalFlowByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(ConditionalFlowLabel, "name", value);
		return node == null ? null : newConditionalFlow(node);
	}

	public ConditionalFlow findOrCreateConditionalFlowByName(String value) {
		final ConditionalFlow existing = findConditionalFlowByName(value);
		return existing == null ? newConditionalFlow().setName(value) : existing;
	}

	public java.util.stream.Stream<ConditionalFlow> findAllConditionalFlowByName(String value) {
		return db.findNodes(ConditionalFlowLabel, "name", value).stream().map(this::newConditionalFlow);
	}

	private static final org.neo4j.graphdb.Label SequentialFlowLabel = org.neo4j.graphdb.Label.label("SequentialFlow");

	public static boolean isSequentialFlow(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(SequentialFlowLabel);
	}

	public SequentialFlow newSequentialFlow() { 
		return newSequentialFlow(db.createNode(SequentialFlowLabel));
	}

	public SequentialFlow newSequentialFlow(org.neo4j.graphdb.Node node) { 
		return new SequentialFlow(node);
	}

	public java.util.stream.Stream<SequentialFlow> findAllSequentialFlow() { 
		return db.findNodes(SequentialFlowLabel).stream().map(this::newSequentialFlow);
	}

	public SequentialFlow findSequentialFlowByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(SequentialFlowLabel, "uuid", value);
		return node == null ? null : newSequentialFlow(node);
	}

	public SequentialFlow findOrCreateSequentialFlowByUuid(String value) {
		final SequentialFlow existing = findSequentialFlowByUuid(value);
		return existing == null ? newSequentialFlow().setUuid(value) : existing;
	}

	public java.util.stream.Stream<SequentialFlow> findAllSequentialFlowByUuid(String value) {
		return db.findNodes(SequentialFlowLabel, "uuid", value).stream().map(this::newSequentialFlow);
	}

	public SequentialFlow findSequentialFlowByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(SequentialFlowLabel, "name", value);
		return node == null ? null : newSequentialFlow(node);
	}

	public SequentialFlow findOrCreateSequentialFlowByName(String value) {
		final SequentialFlow existing = findSequentialFlowByName(value);
		return existing == null ? newSequentialFlow().setName(value) : existing;
	}

	public java.util.stream.Stream<SequentialFlow> findAllSequentialFlowByName(String value) {
		return db.findNodes(SequentialFlowLabel, "name", value).stream().map(this::newSequentialFlow);
	}

	private static final org.neo4j.graphdb.Label ParallelFlowLabel = org.neo4j.graphdb.Label.label("ParallelFlow");

	public static boolean isParallelFlow(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(ParallelFlowLabel);
	}

	public ParallelFlow newParallelFlow() { 
		return newParallelFlow(db.createNode(ParallelFlowLabel));
	}

	public ParallelFlow newParallelFlow(org.neo4j.graphdb.Node node) { 
		return new ParallelFlow(node);
	}

	public java.util.stream.Stream<ParallelFlow> findAllParallelFlow() { 
		return db.findNodes(ParallelFlowLabel).stream().map(this::newParallelFlow);
	}

	public ParallelFlow findParallelFlowByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(ParallelFlowLabel, "uuid", value);
		return node == null ? null : newParallelFlow(node);
	}

	public ParallelFlow findOrCreateParallelFlowByUuid(String value) {
		final ParallelFlow existing = findParallelFlowByUuid(value);
		return existing == null ? newParallelFlow().setUuid(value) : existing;
	}

	public java.util.stream.Stream<ParallelFlow> findAllParallelFlowByUuid(String value) {
		return db.findNodes(ParallelFlowLabel, "uuid", value).stream().map(this::newParallelFlow);
	}

	public ParallelFlow findParallelFlowByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(ParallelFlowLabel, "name", value);
		return node == null ? null : newParallelFlow(node);
	}

	public ParallelFlow findOrCreateParallelFlowByName(String value) {
		final ParallelFlow existing = findParallelFlowByName(value);
		return existing == null ? newParallelFlow().setName(value) : existing;
	}

	public java.util.stream.Stream<ParallelFlow> findAllParallelFlowByName(String value) {
		return db.findNodes(ParallelFlowLabel, "name", value).stream().map(this::newParallelFlow);
	}

	private static final org.neo4j.graphdb.Label RepeatFlowLabel = org.neo4j.graphdb.Label.label("RepeatFlow");

	public static boolean isRepeatFlow(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(RepeatFlowLabel);
	}

	public RepeatFlow newRepeatFlow() { 
		return newRepeatFlow(db.createNode(RepeatFlowLabel));
	}

	public RepeatFlow newRepeatFlow(org.neo4j.graphdb.Node node) { 
		return new RepeatFlow(node);
	}

	public java.util.stream.Stream<RepeatFlow> findAllRepeatFlow() { 
		return db.findNodes(RepeatFlowLabel).stream().map(this::newRepeatFlow);
	}

	public RepeatFlow findRepeatFlowByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(RepeatFlowLabel, "uuid", value);
		return node == null ? null : newRepeatFlow(node);
	}

	public RepeatFlow findOrCreateRepeatFlowByUuid(String value) {
		final RepeatFlow existing = findRepeatFlowByUuid(value);
		return existing == null ? newRepeatFlow().setUuid(value) : existing;
	}

	public java.util.stream.Stream<RepeatFlow> findAllRepeatFlowByUuid(String value) {
		return db.findNodes(RepeatFlowLabel, "uuid", value).stream().map(this::newRepeatFlow);
	}

	public RepeatFlow findRepeatFlowByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNode(RepeatFlowLabel, "name", value);
		return node == null ? null : newRepeatFlow(node);
	}

	public RepeatFlow findOrCreateRepeatFlowByName(String value) {
		final RepeatFlow existing = findRepeatFlowByName(value);
		return existing == null ? newRepeatFlow().setName(value) : existing;
	}

	public java.util.stream.Stream<RepeatFlow> findAllRepeatFlowByName(String value) {
		return db.findNodes(RepeatFlowLabel, "name", value).stream().map(this::newRepeatFlow);
	}

	public RepeatFlow findRepeatFlowByTimes(Integer value) {
		final org.neo4j.graphdb.Node node = db.findNode(RepeatFlowLabel, "times", value);
		return node == null ? null : newRepeatFlow(node);
	}

	public RepeatFlow findOrCreateRepeatFlowByTimes(Integer value) {
		final RepeatFlow existing = findRepeatFlowByTimes(value);
		return existing == null ? newRepeatFlow().setTimes(value) : existing;
	}

	public java.util.stream.Stream<RepeatFlow> findAllRepeatFlowByTimes(Integer value) {
		return db.findNodes(RepeatFlowLabel, "times", value).stream().map(this::newRepeatFlow);
	}

	public RepeatFlow findRepeatFlowByUntil(UntilPredicate value) {
		final org.neo4j.graphdb.Node node = db.findNode(RepeatFlowLabel, "until", value.name());
		return node == null ? null : newRepeatFlow(node);
	}

	public RepeatFlow findOrCreateRepeatFlowByUntil(UntilPredicate value) {
		final RepeatFlow existing = findRepeatFlowByUntil(value);
		return existing == null ? newRepeatFlow().setUntil(value) : existing;
	}

	public java.util.stream.Stream<RepeatFlow> findAllRepeatFlowByUntil(UntilPredicate value) {
		return db.findNodes(RepeatFlowLabel, "until", value.name()).stream().map(this::newRepeatFlow);
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