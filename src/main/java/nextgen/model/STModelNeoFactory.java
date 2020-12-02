package nextgen.model;

public class STModelNeoFactory {

	private final org.neo4j.graphdb.GraphDatabaseService db;

	public STModelNeoFactory(java.lang.String dir) { 
		this(new org.neo4j.graphdb.factory.GraphDatabaseFactory()
				.newEmbeddedDatabaseBuilder(new java.io.File(dir))
				.setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_upgrade, "true")
				.newGraphDatabase());
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

	private static final org.neo4j.graphdb.Label STGroupModelLabel = org.neo4j.graphdb.Label.label("STGroupModel");

	public static boolean isSTGroupModel(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(STGroupModelLabel);
	}

	public STGroupModel newSTGroupModel() { 
		STGroupModel newInstance = newSTGroupModel(db.createNode(STGroupModelLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public STGroupModel newSTGroupModel(org.neo4j.graphdb.Node node) { 
		return new STGroupModel(node);
	}

	public java.util.stream.Stream<STGroupModel> findAllSTGroupModel() { 
		return db.findNodes(STGroupModelLabel).stream().map(this::newSTGroupModel);
	}

	public STGroupModel findSTGroupModelByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STGroupModelLabel, "uuid", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTGroupModel(node);
	}

	public STGroupModel findOrCreateSTGroupModelByUuid(String value) {
		final STGroupModel existing = findSTGroupModelByUuid(value);
		return existing == null ? newSTGroupModel().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STGroupModel> findAllSTGroupModelByUuid(String value) {
		return db.findNodes(STGroupModelLabel, "uuid", value).stream().map(this::newSTGroupModel);
	}

	public STGroupModel findSTGroupModelByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STGroupModelLabel, "name", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTGroupModel(node);
	}

	public STGroupModel findOrCreateSTGroupModelByName(String value) {
		final STGroupModel existing = findSTGroupModelByName(value);
		return existing == null ? newSTGroupModel().setName(value) : existing;
	}

	public java.util.stream.Stream<STGroupModel> findAllSTGroupModelByName(String value) {
		return db.findNodes(STGroupModelLabel, "name", value).stream().map(this::newSTGroupModel);
	}

	public STGroupModel findSTGroupModelByDelimiter(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STGroupModelLabel, "delimiter", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTGroupModel(node);
	}

	public STGroupModel findOrCreateSTGroupModelByDelimiter(String value) {
		final STGroupModel existing = findSTGroupModelByDelimiter(value);
		return existing == null ? newSTGroupModel().setDelimiter(value) : existing;
	}

	public java.util.stream.Stream<STGroupModel> findAllSTGroupModelByDelimiter(String value) {
		return db.findNodes(STGroupModelLabel, "delimiter", value).stream().map(this::newSTGroupModel);
	}

	public STGroupModel findSTGroupModelByIcon(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STGroupModelLabel, "icon", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTGroupModel(node);
	}

	public STGroupModel findOrCreateSTGroupModelByIcon(String value) {
		final STGroupModel existing = findSTGroupModelByIcon(value);
		return existing == null ? newSTGroupModel().setIcon(value) : existing;
	}

	public java.util.stream.Stream<STGroupModel> findAllSTGroupModelByIcon(String value) {
		return db.findNodes(STGroupModelLabel, "icon", value).stream().map(this::newSTGroupModel);
	}

	public STGroupModel findSTGroupModelByLanguage(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STGroupModelLabel, "language", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTGroupModel(node);
	}

	public STGroupModel findOrCreateSTGroupModelByLanguage(String value) {
		final STGroupModel existing = findSTGroupModelByLanguage(value);
		return existing == null ? newSTGroupModel().setLanguage(value) : existing;
	}

	public java.util.stream.Stream<STGroupModel> findAllSTGroupModelByLanguage(String value) {
		return db.findNodes(STGroupModelLabel, "language", value).stream().map(this::newSTGroupModel);
	}

	private static final org.neo4j.graphdb.Label STGroupFileLabel = org.neo4j.graphdb.Label.label("STGroupFile");

	public static boolean isSTGroupFile(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(STGroupFileLabel);
	}

	public STGroupFile newSTGroupFile() { 
		STGroupFile newInstance = newSTGroupFile(db.createNode(STGroupFileLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public STGroupFile newSTGroupFile(org.neo4j.graphdb.Node node) { 
		return new STGroupFile(node);
	}

	public java.util.stream.Stream<STGroupFile> findAllSTGroupFile() { 
		return db.findNodes(STGroupFileLabel).stream().map(this::newSTGroupFile);
	}

	public STGroupFile findSTGroupFileByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STGroupFileLabel, "uuid", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTGroupFile(node);
	}

	public STGroupFile findOrCreateSTGroupFileByUuid(String value) {
		final STGroupFile existing = findSTGroupFileByUuid(value);
		return existing == null ? newSTGroupFile().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STGroupFile> findAllSTGroupFileByUuid(String value) {
		return db.findNodes(STGroupFileLabel, "uuid", value).stream().map(this::newSTGroupFile);
	}

	private static final org.neo4j.graphdb.Label STValueLabel = org.neo4j.graphdb.Label.label("STValue");

	public static boolean isSTValue(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(STValueLabel);
	}

	public STValue newSTValue() { 
		STValue newInstance = newSTValue(db.createNode(STValueLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public STValue newSTValue(org.neo4j.graphdb.Node node) { 
		return new STValue(node);
	}

	public java.util.stream.Stream<STValue> findAllSTValue() { 
		return db.findNodes(STValueLabel).stream().map(this::newSTValue);
	}

	public STValue findSTValueByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STValueLabel, "uuid", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTValue(node);
	}

	public STValue findOrCreateSTValueByUuid(String value) {
		final STValue existing = findSTValueByUuid(value);
		return existing == null ? newSTValue().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STValue> findAllSTValueByUuid(String value) {
		return db.findNodes(STValueLabel, "uuid", value).stream().map(this::newSTValue);
	}

	public STValue findSTValueByValue(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STValueLabel, "value", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTValue(node);
	}

	public STValue findOrCreateSTValueByValue(String value) {
		final STValue existing = findSTValueByValue(value);
		return existing == null ? newSTValue().setValue(value) : existing;
	}

	public java.util.stream.Stream<STValue> findAllSTValueByValue(String value) {
		return db.findNodes(STValueLabel, "value", value).stream().map(this::newSTValue);
	}

	public STValue findSTValueByType(STValueType value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STValueLabel, "type", value.name()).stream().findFirst().orElse(null);
		return node == null ? null : newSTValue(node);
	}

	public STValue findOrCreateSTValueByType(STValueType value) {
		final STValue existing = findSTValueByType(value);
		return existing == null ? newSTValue().setType(value) : existing;
	}

	public java.util.stream.Stream<STValue> findAllSTValueByType(STValueType value) {
		return db.findNodes(STValueLabel, "type", value.name()).stream().map(this::newSTValue);
	}

	private static final org.neo4j.graphdb.Label STModelLabel = org.neo4j.graphdb.Label.label("STModel");

	public static boolean isSTModel(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(STModelLabel);
	}

	public STModel newSTModel() { 
		STModel newInstance = newSTModel(db.createNode(STModelLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public STModel newSTModel(org.neo4j.graphdb.Node node) { 
		return new STModel(node);
	}

	public java.util.stream.Stream<STModel> findAllSTModel() { 
		return db.findNodes(STModelLabel).stream().map(this::newSTModel);
	}

	public STModel findSTModelByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STModelLabel, "uuid", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTModel(node);
	}

	public STModel findOrCreateSTModelByUuid(String value) {
		final STModel existing = findSTModelByUuid(value);
		return existing == null ? newSTModel().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STModel> findAllSTModelByUuid(String value) {
		return db.findNodes(STModelLabel, "uuid", value).stream().map(this::newSTModel);
	}

	private static final org.neo4j.graphdb.Label STTemplateLabel = org.neo4j.graphdb.Label.label("STTemplate");

	public static boolean isSTTemplate(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(STTemplateLabel);
	}

	public STTemplate newSTTemplate() { 
		STTemplate newInstance = newSTTemplate(db.createNode(STTemplateLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public STTemplate newSTTemplate(org.neo4j.graphdb.Node node) { 
		return new STTemplate(node);
	}

	public java.util.stream.Stream<STTemplate> findAllSTTemplate() { 
		return db.findNodes(STTemplateLabel).stream().map(this::newSTTemplate);
	}

	public STTemplate findSTTemplateByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STTemplateLabel, "uuid", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTTemplate(node);
	}

	public STTemplate findOrCreateSTTemplateByUuid(String value) {
		final STTemplate existing = findSTTemplateByUuid(value);
		return existing == null ? newSTTemplate().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STTemplate> findAllSTTemplateByUuid(String value) {
		return db.findNodes(STTemplateLabel, "uuid", value).stream().map(this::newSTTemplate);
	}

	public STTemplate findSTTemplateByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STTemplateLabel, "name", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTTemplate(node);
	}

	public STTemplate findOrCreateSTTemplateByName(String value) {
		final STTemplate existing = findSTTemplateByName(value);
		return existing == null ? newSTTemplate().setName(value) : existing;
	}

	public java.util.stream.Stream<STTemplate> findAllSTTemplateByName(String value) {
		return db.findNodes(STTemplateLabel, "name", value).stream().map(this::newSTTemplate);
	}

	public STTemplate findSTTemplateByText(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STTemplateLabel, "text", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTTemplate(node);
	}

	public STTemplate findOrCreateSTTemplateByText(String value) {
		final STTemplate existing = findSTTemplateByText(value);
		return existing == null ? newSTTemplate().setText(value) : existing;
	}

	public java.util.stream.Stream<STTemplate> findAllSTTemplateByText(String value) {
		return db.findNodes(STTemplateLabel, "text", value).stream().map(this::newSTTemplate);
	}

	private static final org.neo4j.graphdb.Label STParameterLabel = org.neo4j.graphdb.Label.label("STParameter");

	public static boolean isSTParameter(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(STParameterLabel);
	}

	public STParameter newSTParameter() { 
		STParameter newInstance = newSTParameter(db.createNode(STParameterLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public STParameter newSTParameter(org.neo4j.graphdb.Node node) { 
		return new STParameter(node);
	}

	public java.util.stream.Stream<STParameter> findAllSTParameter() { 
		return db.findNodes(STParameterLabel).stream().map(this::newSTParameter);
	}

	public STParameter findSTParameterByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STParameterLabel, "uuid", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTParameter(node);
	}

	public STParameter findOrCreateSTParameterByUuid(String value) {
		final STParameter existing = findSTParameterByUuid(value);
		return existing == null ? newSTParameter().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STParameter> findAllSTParameterByUuid(String value) {
		return db.findNodes(STParameterLabel, "uuid", value).stream().map(this::newSTParameter);
	}

	public STParameter findSTParameterByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STParameterLabel, "name", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTParameter(node);
	}

	public STParameter findOrCreateSTParameterByName(String value) {
		final STParameter existing = findSTParameterByName(value);
		return existing == null ? newSTParameter().setName(value) : existing;
	}

	public java.util.stream.Stream<STParameter> findAllSTParameterByName(String value) {
		return db.findNodes(STParameterLabel, "name", value).stream().map(this::newSTParameter);
	}

	public STParameter findSTParameterByType(STParameterType value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STParameterLabel, "type", value.name()).stream().findFirst().orElse(null);
		return node == null ? null : newSTParameter(node);
	}

	public STParameter findOrCreateSTParameterByType(STParameterType value) {
		final STParameter existing = findSTParameterByType(value);
		return existing == null ? newSTParameter().setType(value) : existing;
	}

	public java.util.stream.Stream<STParameter> findAllSTParameterByType(STParameterType value) {
		return db.findNodes(STParameterLabel, "type", value.name()).stream().map(this::newSTParameter);
	}

	public STParameter findSTParameterByArgumentType(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STParameterLabel, "argumentType", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTParameter(node);
	}

	public STParameter findOrCreateSTParameterByArgumentType(String value) {
		final STParameter existing = findSTParameterByArgumentType(value);
		return existing == null ? newSTParameter().setArgumentType(value) : existing;
	}

	public java.util.stream.Stream<STParameter> findAllSTParameterByArgumentType(String value) {
		return db.findNodes(STParameterLabel, "argumentType", value).stream().map(this::newSTParameter);
	}

	private static final org.neo4j.graphdb.Label STParameterKeyLabel = org.neo4j.graphdb.Label.label("STParameterKey");

	public static boolean isSTParameterKey(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(STParameterKeyLabel);
	}

	public STParameterKey newSTParameterKey() { 
		STParameterKey newInstance = newSTParameterKey(db.createNode(STParameterKeyLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public STParameterKey newSTParameterKey(org.neo4j.graphdb.Node node) { 
		return new STParameterKey(node);
	}

	public java.util.stream.Stream<STParameterKey> findAllSTParameterKey() { 
		return db.findNodes(STParameterKeyLabel).stream().map(this::newSTParameterKey);
	}

	public STParameterKey findSTParameterKeyByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STParameterKeyLabel, "uuid", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTParameterKey(node);
	}

	public STParameterKey findOrCreateSTParameterKeyByUuid(String value) {
		final STParameterKey existing = findSTParameterKeyByUuid(value);
		return existing == null ? newSTParameterKey().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STParameterKey> findAllSTParameterKeyByUuid(String value) {
		return db.findNodes(STParameterKeyLabel, "uuid", value).stream().map(this::newSTParameterKey);
	}

	public STParameterKey findSTParameterKeyByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STParameterKeyLabel, "name", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTParameterKey(node);
	}

	public STParameterKey findOrCreateSTParameterKeyByName(String value) {
		final STParameterKey existing = findSTParameterKeyByName(value);
		return existing == null ? newSTParameterKey().setName(value) : existing;
	}

	public java.util.stream.Stream<STParameterKey> findAllSTParameterKeyByName(String value) {
		return db.findNodes(STParameterKeyLabel, "name", value).stream().map(this::newSTParameterKey);
	}

	public STParameterKey findSTParameterKeyByArgumentType(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STParameterKeyLabel, "argumentType", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTParameterKey(node);
	}

	public STParameterKey findOrCreateSTParameterKeyByArgumentType(String value) {
		final STParameterKey existing = findSTParameterKeyByArgumentType(value);
		return existing == null ? newSTParameterKey().setArgumentType(value) : existing;
	}

	public java.util.stream.Stream<STParameterKey> findAllSTParameterKeyByArgumentType(String value) {
		return db.findNodes(STParameterKeyLabel, "argumentType", value).stream().map(this::newSTParameterKey);
	}

	private static final org.neo4j.graphdb.Label STFileLabel = org.neo4j.graphdb.Label.label("STFile");

	public static boolean isSTFile(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(STFileLabel);
	}

	public STFile newSTFile() { 
		STFile newInstance = newSTFile(db.createNode(STFileLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public STFile newSTFile(org.neo4j.graphdb.Node node) { 
		return new STFile(node);
	}

	public java.util.stream.Stream<STFile> findAllSTFile() { 
		return db.findNodes(STFileLabel).stream().map(this::newSTFile);
	}

	public STFile findSTFileByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STFileLabel, "uuid", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTFile(node);
	}

	public STFile findOrCreateSTFileByUuid(String value) {
		final STFile existing = findSTFileByUuid(value);
		return existing == null ? newSTFile().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STFile> findAllSTFileByUuid(String value) {
		return db.findNodes(STFileLabel, "uuid", value).stream().map(this::newSTFile);
	}

	private static final org.neo4j.graphdb.Label STArgumentLabel = org.neo4j.graphdb.Label.label("STArgument");

	public static boolean isSTArgument(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(STArgumentLabel);
	}

	public STArgument newSTArgument() { 
		STArgument newInstance = newSTArgument(db.createNode(STArgumentLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public STArgument newSTArgument(org.neo4j.graphdb.Node node) { 
		return new STArgument(node);
	}

	public java.util.stream.Stream<STArgument> findAllSTArgument() { 
		return db.findNodes(STArgumentLabel).stream().map(this::newSTArgument);
	}

	public STArgument findSTArgumentByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STArgumentLabel, "uuid", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTArgument(node);
	}

	public STArgument findOrCreateSTArgumentByUuid(String value) {
		final STArgument existing = findSTArgumentByUuid(value);
		return existing == null ? newSTArgument().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STArgument> findAllSTArgumentByUuid(String value) {
		return db.findNodes(STArgumentLabel, "uuid", value).stream().map(this::newSTArgument);
	}

	private static final org.neo4j.graphdb.Label STArgumentKVLabel = org.neo4j.graphdb.Label.label("STArgumentKV");

	public static boolean isSTArgumentKV(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(STArgumentKVLabel);
	}

	public STArgumentKV newSTArgumentKV() { 
		STArgumentKV newInstance = newSTArgumentKV(db.createNode(STArgumentKVLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public STArgumentKV newSTArgumentKV(org.neo4j.graphdb.Node node) { 
		return new STArgumentKV(node);
	}

	public java.util.stream.Stream<STArgumentKV> findAllSTArgumentKV() { 
		return db.findNodes(STArgumentKVLabel).stream().map(this::newSTArgumentKV);
	}

	public STArgumentKV findSTArgumentKVByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STArgumentKVLabel, "uuid", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTArgumentKV(node);
	}

	public STArgumentKV findOrCreateSTArgumentKVByUuid(String value) {
		final STArgumentKV existing = findSTArgumentKVByUuid(value);
		return existing == null ? newSTArgumentKV().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STArgumentKV> findAllSTArgumentKVByUuid(String value) {
		return db.findNodes(STArgumentKVLabel, "uuid", value).stream().map(this::newSTArgumentKV);
	}

	private static final org.neo4j.graphdb.Label STEnumValueLabel = org.neo4j.graphdb.Label.label("STEnumValue");

	public static boolean isSTEnumValue(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(STEnumValueLabel);
	}

	public STEnumValue newSTEnumValue() { 
		STEnumValue newInstance = newSTEnumValue(db.createNode(STEnumValueLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public STEnumValue newSTEnumValue(org.neo4j.graphdb.Node node) { 
		return new STEnumValue(node);
	}

	public java.util.stream.Stream<STEnumValue> findAllSTEnumValue() { 
		return db.findNodes(STEnumValueLabel).stream().map(this::newSTEnumValue);
	}

	public STEnumValue findSTEnumValueByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STEnumValueLabel, "uuid", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTEnumValue(node);
	}

	public STEnumValue findOrCreateSTEnumValueByUuid(String value) {
		final STEnumValue existing = findSTEnumValueByUuid(value);
		return existing == null ? newSTEnumValue().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STEnumValue> findAllSTEnumValueByUuid(String value) {
		return db.findNodes(STEnumValueLabel, "uuid", value).stream().map(this::newSTEnumValue);
	}

	public STEnumValue findSTEnumValueByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STEnumValueLabel, "name", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTEnumValue(node);
	}

	public STEnumValue findOrCreateSTEnumValueByName(String value) {
		final STEnumValue existing = findSTEnumValueByName(value);
		return existing == null ? newSTEnumValue().setName(value) : existing;
	}

	public java.util.stream.Stream<STEnumValue> findAllSTEnumValueByName(String value) {
		return db.findNodes(STEnumValueLabel, "name", value).stream().map(this::newSTEnumValue);
	}

	public STEnumValue findSTEnumValueByLexical(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STEnumValueLabel, "lexical", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTEnumValue(node);
	}

	public STEnumValue findOrCreateSTEnumValueByLexical(String value) {
		final STEnumValue existing = findSTEnumValueByLexical(value);
		return existing == null ? newSTEnumValue().setLexical(value) : existing;
	}

	public java.util.stream.Stream<STEnumValue> findAllSTEnumValueByLexical(String value) {
		return db.findNodes(STEnumValueLabel, "lexical", value).stream().map(this::newSTEnumValue);
	}

	private static final org.neo4j.graphdb.Label STInterfaceLabel = org.neo4j.graphdb.Label.label("STInterface");

	public static boolean isSTInterface(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(STInterfaceLabel);
	}

	public STInterface newSTInterface() { 
		STInterface newInstance = newSTInterface(db.createNode(STInterfaceLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public STInterface newSTInterface(org.neo4j.graphdb.Node node) { 
		return new STInterface(node);
	}

	public java.util.stream.Stream<STInterface> findAllSTInterface() { 
		return db.findNodes(STInterfaceLabel).stream().map(this::newSTInterface);
	}

	public STInterface findSTInterfaceByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STInterfaceLabel, "uuid", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTInterface(node);
	}

	public STInterface findOrCreateSTInterfaceByUuid(String value) {
		final STInterface existing = findSTInterfaceByUuid(value);
		return existing == null ? newSTInterface().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STInterface> findAllSTInterfaceByUuid(String value) {
		return db.findNodes(STInterfaceLabel, "uuid", value).stream().map(this::newSTInterface);
	}

	public STInterface findSTInterfaceByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STInterfaceLabel, "name", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTInterface(node);
	}

	public STInterface findOrCreateSTInterfaceByName(String value) {
		final STInterface existing = findSTInterfaceByName(value);
		return existing == null ? newSTInterface().setName(value) : existing;
	}

	public java.util.stream.Stream<STInterface> findAllSTInterfaceByName(String value) {
		return db.findNodes(STInterfaceLabel, "name", value).stream().map(this::newSTInterface);
	}

	private static final org.neo4j.graphdb.Label STEnumLabel = org.neo4j.graphdb.Label.label("STEnum");

	public static boolean isSTEnum(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(STEnumLabel);
	}

	public STEnum newSTEnum() { 
		STEnum newInstance = newSTEnum(db.createNode(STEnumLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public STEnum newSTEnum(org.neo4j.graphdb.Node node) { 
		return new STEnum(node);
	}

	public java.util.stream.Stream<STEnum> findAllSTEnum() { 
		return db.findNodes(STEnumLabel).stream().map(this::newSTEnum);
	}

	public STEnum findSTEnumByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STEnumLabel, "uuid", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTEnum(node);
	}

	public STEnum findOrCreateSTEnumByUuid(String value) {
		final STEnum existing = findSTEnumByUuid(value);
		return existing == null ? newSTEnum().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STEnum> findAllSTEnumByUuid(String value) {
		return db.findNodes(STEnumLabel, "uuid", value).stream().map(this::newSTEnum);
	}

	public STEnum findSTEnumByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STEnumLabel, "name", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTEnum(node);
	}

	public STEnum findOrCreateSTEnumByName(String value) {
		final STEnum existing = findSTEnumByName(value);
		return existing == null ? newSTEnum().setName(value) : existing;
	}

	public java.util.stream.Stream<STEnum> findAllSTEnumByName(String value) {
		return db.findNodes(STEnumLabel, "name", value).stream().map(this::newSTEnum);
	}

	private static final org.neo4j.graphdb.Label STGroupActionLabel = org.neo4j.graphdb.Label.label("STGroupAction");

	public static boolean isSTGroupAction(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(STGroupActionLabel);
	}

	public STGroupAction newSTGroupAction() { 
		STGroupAction newInstance = newSTGroupAction(db.createNode(STGroupActionLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public STGroupAction newSTGroupAction(org.neo4j.graphdb.Node node) { 
		return new STGroupAction(node);
	}

	public java.util.stream.Stream<STGroupAction> findAllSTGroupAction() { 
		return db.findNodes(STGroupActionLabel).stream().map(this::newSTGroupAction);
	}

	public STGroupAction findSTGroupActionByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STGroupActionLabel, "uuid", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTGroupAction(node);
	}

	public STGroupAction findOrCreateSTGroupActionByUuid(String value) {
		final STGroupAction existing = findSTGroupActionByUuid(value);
		return existing == null ? newSTGroupAction().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STGroupAction> findAllSTGroupActionByUuid(String value) {
		return db.findNodes(STGroupActionLabel, "uuid", value).stream().map(this::newSTGroupAction);
	}

	public STGroupAction findSTGroupActionByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STGroupActionLabel, "name", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTGroupAction(node);
	}

	public STGroupAction findOrCreateSTGroupActionByName(String value) {
		final STGroupAction existing = findSTGroupActionByName(value);
		return existing == null ? newSTGroupAction().setName(value) : existing;
	}

	public java.util.stream.Stream<STGroupAction> findAllSTGroupActionByName(String value) {
		return db.findNodes(STGroupActionLabel, "name", value).stream().map(this::newSTGroupAction);
	}

	private static final org.neo4j.graphdb.Label STProjectLabel = org.neo4j.graphdb.Label.label("STProject");

	public static boolean isSTProject(org.neo4j.graphdb.Node node) {
		return node != null && node.hasLabel(STProjectLabel);
	}

	public STProject newSTProject() { 
		STProject newInstance = newSTProject(db.createNode(STProjectLabel));
		newInstance.setUuid(java.util.UUID.randomUUID().toString());
		return newInstance;
	}

	public STProject newSTProject(org.neo4j.graphdb.Node node) { 
		return new STProject(node);
	}

	public java.util.stream.Stream<STProject> findAllSTProject() { 
		return db.findNodes(STProjectLabel).stream().map(this::newSTProject);
	}

	public STProject findSTProjectByUuid(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STProjectLabel, "uuid", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTProject(node);
	}

	public STProject findOrCreateSTProjectByUuid(String value) {
		final STProject existing = findSTProjectByUuid(value);
		return existing == null ? newSTProject().setUuid(value) : existing;
	}

	public java.util.stream.Stream<STProject> findAllSTProjectByUuid(String value) {
		return db.findNodes(STProjectLabel, "uuid", value).stream().map(this::newSTProject);
	}

	public STProject findSTProjectByName(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STProjectLabel, "name", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTProject(node);
	}

	public STProject findOrCreateSTProjectByName(String value) {
		final STProject existing = findSTProjectByName(value);
		return existing == null ? newSTProject().setName(value) : existing;
	}

	public java.util.stream.Stream<STProject> findAllSTProjectByName(String value) {
		return db.findNodes(STProjectLabel, "name", value).stream().map(this::newSTProject);
	}

	public STProject findSTProjectByRoot(String value) {
		final org.neo4j.graphdb.Node node = db.findNodes(STProjectLabel, "root", value).stream().findFirst().orElse(null);
		return node == null ? null : newSTProject(node);
	}

	public STProject findOrCreateSTProjectByRoot(String value) {
		final STProject existing = findSTProjectByRoot(value);
		return existing == null ? newSTProject().setRoot(value) : existing;
	}

	public java.util.stream.Stream<STProject> findAllSTProjectByRoot(String value) {
		return db.findNodes(STProjectLabel, "root", value).stream().map(this::newSTProject);
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