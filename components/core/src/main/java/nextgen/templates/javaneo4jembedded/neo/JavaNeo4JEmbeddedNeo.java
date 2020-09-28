package nextgen.templates.javaneo4jembedded.neo;

import nextgen.st.model.*;
import org.neo4j.graphdb.Node;
import java.util.Optional;
import java.util.stream.Stream;

public class JavaNeo4JEmbeddedNeo {

	private final STModelDB db;

	public JavaNeo4JEmbeddedNeo(STModelDB db) {
		this.db = db;
	}

	public EntitiesModel newEntitiesModel() {
		return new EntitiesModel(db);
	}

	public EntitiesModel newEntitiesModel(STModel stModel) {
		return new EntitiesModel(db, stModel);
	}

	public EntitiesModel newEntitiesModel(Node node) {
		return new EntitiesModel(db, node);
	}

	public Stream<EntitiesModel> findAllEntitiesModel() {
		return db.findAllSTModelByStTemplate(EntitiesModel.stTemplateUuid)
				.map(stModel -> new EntitiesModel(db, stModel));
	}

	public EntitiesModel findEntitiesModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new EntitiesModel(db, uuid) : new EntitiesModel(db, stModel);
	}


	public NodeWrapperModel newNodeWrapperModel() {
		return new NodeWrapperModel(db);
	}

	public NodeWrapperModel newNodeWrapperModel(STModel stModel) {
		return new NodeWrapperModel(db, stModel);
	}

	public NodeWrapperModel newNodeWrapperModel(Node node) {
		return new NodeWrapperModel(db, node);
	}

	public Stream<NodeWrapperModel> findAllNodeWrapperModel() {
		return db.findAllSTModelByStTemplate(NodeWrapperModel.stTemplateUuid)
				.map(stModel -> new NodeWrapperModel(db, stModel));
	}

	public NodeWrapperModel findNodeWrapperModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new NodeWrapperModel(db, uuid) : new NodeWrapperModel(db, stModel);
	}


	public PrimitiveAccessorsModel newPrimitiveAccessorsModel() {
		return new PrimitiveAccessorsModel(db);
	}

	public PrimitiveAccessorsModel newPrimitiveAccessorsModel(STModel stModel) {
		return new PrimitiveAccessorsModel(db, stModel);
	}

	public PrimitiveAccessorsModel newPrimitiveAccessorsModel(Node node) {
		return new PrimitiveAccessorsModel(db, node);
	}

	public Stream<PrimitiveAccessorsModel> findAllPrimitiveAccessorsModel() {
		return db.findAllSTModelByStTemplate(PrimitiveAccessorsModel.stTemplateUuid)
				.map(stModel -> new PrimitiveAccessorsModel(db, stModel));
	}

	public PrimitiveAccessorsModel findPrimitiveAccessorsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PrimitiveAccessorsModel(db, uuid) : new PrimitiveAccessorsModel(db, stModel);
	}


	public ListReferenceAccessorsModel newListReferenceAccessorsModel() {
		return new ListReferenceAccessorsModel(db);
	}

	public ListReferenceAccessorsModel newListReferenceAccessorsModel(STModel stModel) {
		return new ListReferenceAccessorsModel(db, stModel);
	}

	public ListReferenceAccessorsModel newListReferenceAccessorsModel(Node node) {
		return new ListReferenceAccessorsModel(db, node);
	}

	public Stream<ListReferenceAccessorsModel> findAllListReferenceAccessorsModel() {
		return db.findAllSTModelByStTemplate(ListReferenceAccessorsModel.stTemplateUuid)
				.map(stModel -> new ListReferenceAccessorsModel(db, stModel));
	}

	public ListReferenceAccessorsModel findListReferenceAccessorsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListReferenceAccessorsModel(db, uuid) : new ListReferenceAccessorsModel(db, stModel);
	}


	public ListPrimitiveAccessorsModel newListPrimitiveAccessorsModel() {
		return new ListPrimitiveAccessorsModel(db);
	}

	public ListPrimitiveAccessorsModel newListPrimitiveAccessorsModel(STModel stModel) {
		return new ListPrimitiveAccessorsModel(db, stModel);
	}

	public ListPrimitiveAccessorsModel newListPrimitiveAccessorsModel(Node node) {
		return new ListPrimitiveAccessorsModel(db, node);
	}

	public Stream<ListPrimitiveAccessorsModel> findAllListPrimitiveAccessorsModel() {
		return db.findAllSTModelByStTemplate(ListPrimitiveAccessorsModel.stTemplateUuid)
				.map(stModel -> new ListPrimitiveAccessorsModel(db, stModel));
	}

	public ListPrimitiveAccessorsModel findListPrimitiveAccessorsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListPrimitiveAccessorsModel(db, uuid) : new ListPrimitiveAccessorsModel(db, stModel);
	}


	public EnumAccessorsModel newEnumAccessorsModel() {
		return new EnumAccessorsModel(db);
	}

	public EnumAccessorsModel newEnumAccessorsModel(STModel stModel) {
		return new EnumAccessorsModel(db, stModel);
	}

	public EnumAccessorsModel newEnumAccessorsModel(Node node) {
		return new EnumAccessorsModel(db, node);
	}

	public Stream<EnumAccessorsModel> findAllEnumAccessorsModel() {
		return db.findAllSTModelByStTemplate(EnumAccessorsModel.stTemplateUuid)
				.map(stModel -> new EnumAccessorsModel(db, stModel));
	}

	public EnumAccessorsModel findEnumAccessorsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new EnumAccessorsModel(db, uuid) : new EnumAccessorsModel(db, stModel);
	}


	public ReferenceAccessorsModel newReferenceAccessorsModel() {
		return new ReferenceAccessorsModel(db);
	}

	public ReferenceAccessorsModel newReferenceAccessorsModel(STModel stModel) {
		return new ReferenceAccessorsModel(db, stModel);
	}

	public ReferenceAccessorsModel newReferenceAccessorsModel(Node node) {
		return new ReferenceAccessorsModel(db, node);
	}

	public Stream<ReferenceAccessorsModel> findAllReferenceAccessorsModel() {
		return db.findAllSTModelByStTemplate(ReferenceAccessorsModel.stTemplateUuid)
				.map(stModel -> new ReferenceAccessorsModel(db, stModel));
	}

	public ReferenceAccessorsModel findReferenceAccessorsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ReferenceAccessorsModel(db, uuid) : new ReferenceAccessorsModel(db, stModel);
	}


	public ExternalAccessorsModel newExternalAccessorsModel() {
		return new ExternalAccessorsModel(db);
	}

	public ExternalAccessorsModel newExternalAccessorsModel(STModel stModel) {
		return new ExternalAccessorsModel(db, stModel);
	}

	public ExternalAccessorsModel newExternalAccessorsModel(Node node) {
		return new ExternalAccessorsModel(db, node);
	}

	public Stream<ExternalAccessorsModel> findAllExternalAccessorsModel() {
		return db.findAllSTModelByStTemplate(ExternalAccessorsModel.stTemplateUuid)
				.map(stModel -> new ExternalAccessorsModel(db, stModel));
	}

	public ExternalAccessorsModel findExternalAccessorsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ExternalAccessorsModel(db, uuid) : new ExternalAccessorsModel(db, stModel);
	}


	public IncomingReferenceStreamModel newIncomingReferenceStreamModel() {
		return new IncomingReferenceStreamModel(db);
	}

	public IncomingReferenceStreamModel newIncomingReferenceStreamModel(STModel stModel) {
		return new IncomingReferenceStreamModel(db, stModel);
	}

	public IncomingReferenceStreamModel newIncomingReferenceStreamModel(Node node) {
		return new IncomingReferenceStreamModel(db, node);
	}

	public Stream<IncomingReferenceStreamModel> findAllIncomingReferenceStreamModel() {
		return db.findAllSTModelByStTemplate(IncomingReferenceStreamModel.stTemplateUuid)
				.map(stModel -> new IncomingReferenceStreamModel(db, stModel));
	}

	public IncomingReferenceStreamModel findIncomingReferenceStreamModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new IncomingReferenceStreamModel(db, uuid) : new IncomingReferenceStreamModel(db, stModel);
	}


	public EnumListAccessorsModel newEnumListAccessorsModel() {
		return new EnumListAccessorsModel(db);
	}

	public EnumListAccessorsModel newEnumListAccessorsModel(STModel stModel) {
		return new EnumListAccessorsModel(db, stModel);
	}

	public EnumListAccessorsModel newEnumListAccessorsModel(Node node) {
		return new EnumListAccessorsModel(db, node);
	}

	public Stream<EnumListAccessorsModel> findAllEnumListAccessorsModel() {
		return db.findAllSTModelByStTemplate(EnumListAccessorsModel.stTemplateUuid)
				.map(stModel -> new EnumListAccessorsModel(db, stModel));
	}

	public EnumListAccessorsModel findEnumListAccessorsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new EnumListAccessorsModel(db, uuid) : new EnumListAccessorsModel(db, stModel);
	}


	public NodeToJsonObjectModel newNodeToJsonObjectModel() {
		return new NodeToJsonObjectModel(db);
	}

	public NodeToJsonObjectModel newNodeToJsonObjectModel(STModel stModel) {
		return new NodeToJsonObjectModel(db, stModel);
	}

	public NodeToJsonObjectModel newNodeToJsonObjectModel(Node node) {
		return new NodeToJsonObjectModel(db, node);
	}

	public Stream<NodeToJsonObjectModel> findAllNodeToJsonObjectModel() {
		return db.findAllSTModelByStTemplate(NodeToJsonObjectModel.stTemplateUuid)
				.map(stModel -> new NodeToJsonObjectModel(db, stModel));
	}

	public NodeToJsonObjectModel findNodeToJsonObjectModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new NodeToJsonObjectModel(db, uuid) : new NodeToJsonObjectModel(db, stModel);
	}


	public DeleteNodeModel newDeleteNodeModel() {
		return new DeleteNodeModel(db);
	}

	public DeleteNodeModel newDeleteNodeModel(STModel stModel) {
		return new DeleteNodeModel(db, stModel);
	}

	public DeleteNodeModel newDeleteNodeModel(Node node) {
		return new DeleteNodeModel(db, node);
	}

	public Stream<DeleteNodeModel> findAllDeleteNodeModel() {
		return db.findAllSTModelByStTemplate(DeleteNodeModel.stTemplateUuid)
				.map(stModel -> new DeleteNodeModel(db, stModel));
	}

	public DeleteNodeModel findDeleteNodeModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DeleteNodeModel(db, uuid) : new DeleteNodeModel(db, stModel);
	}


	public NeoFactoryModel newNeoFactoryModel() {
		return new NeoFactoryModel(db);
	}

	public NeoFactoryModel newNeoFactoryModel(STModel stModel) {
		return new NeoFactoryModel(db, stModel);
	}

	public NeoFactoryModel newNeoFactoryModel(Node node) {
		return new NeoFactoryModel(db, node);
	}

	public Stream<NeoFactoryModel> findAllNeoFactoryModel() {
		return db.findAllSTModelByStTemplate(NeoFactoryModel.stTemplateUuid)
				.map(stModel -> new NeoFactoryModel(db, stModel));
	}

	public NeoFactoryModel findNeoFactoryModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new NeoFactoryModel(db, uuid) : new NeoFactoryModel(db, stModel);
	}


	public NeoFactoryAccessorsModel newNeoFactoryAccessorsModel() {
		return new NeoFactoryAccessorsModel(db);
	}

	public NeoFactoryAccessorsModel newNeoFactoryAccessorsModel(STModel stModel) {
		return new NeoFactoryAccessorsModel(db, stModel);
	}

	public NeoFactoryAccessorsModel newNeoFactoryAccessorsModel(Node node) {
		return new NeoFactoryAccessorsModel(db, node);
	}

	public Stream<NeoFactoryAccessorsModel> findAllNeoFactoryAccessorsModel() {
		return db.findAllSTModelByStTemplate(NeoFactoryAccessorsModel.stTemplateUuid)
				.map(stModel -> new NeoFactoryAccessorsModel(db, stModel));
	}

	public NeoFactoryAccessorsModel findNeoFactoryAccessorsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new NeoFactoryAccessorsModel(db, uuid) : new NeoFactoryAccessorsModel(db, stModel);
	}


	public NeoFactoryPropertyAccessorsModel newNeoFactoryPropertyAccessorsModel() {
		return new NeoFactoryPropertyAccessorsModel(db);
	}

	public NeoFactoryPropertyAccessorsModel newNeoFactoryPropertyAccessorsModel(STModel stModel) {
		return new NeoFactoryPropertyAccessorsModel(db, stModel);
	}

	public NeoFactoryPropertyAccessorsModel newNeoFactoryPropertyAccessorsModel(Node node) {
		return new NeoFactoryPropertyAccessorsModel(db, node);
	}

	public Stream<NeoFactoryPropertyAccessorsModel> findAllNeoFactoryPropertyAccessorsModel() {
		return db.findAllSTModelByStTemplate(NeoFactoryPropertyAccessorsModel.stTemplateUuid)
				.map(stModel -> new NeoFactoryPropertyAccessorsModel(db, stModel));
	}

	public NeoFactoryPropertyAccessorsModel findNeoFactoryPropertyAccessorsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new NeoFactoryPropertyAccessorsModel(db, uuid) : new NeoFactoryPropertyAccessorsModel(db, stModel);
	}


	public Optional<NodeWrapperModel> findNodeWrapperModelByPackage(STValue value) {
		return Optional.ofNullable(db.find("package", value, NodeWrapperModel.stTemplateUuid, NodeWrapperModel::new));
	}

	public Optional<NodeWrapperModel> findNodeWrapperModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, NodeWrapperModel.stTemplateUuid, NodeWrapperModel::new));
	}

	public Optional<PrimitiveAccessorsModel> findPrimitiveAccessorsModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, PrimitiveAccessorsModel.stTemplateUuid, PrimitiveAccessorsModel::new));
	}

	public Optional<PrimitiveAccessorsModel> findPrimitiveAccessorsModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, PrimitiveAccessorsModel.stTemplateUuid, PrimitiveAccessorsModel::new));
	}

	public Optional<PrimitiveAccessorsModel> findPrimitiveAccessorsModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, PrimitiveAccessorsModel.stTemplateUuid, PrimitiveAccessorsModel::new));
	}

	public Optional<ListReferenceAccessorsModel> findListReferenceAccessorsModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, ListReferenceAccessorsModel.stTemplateUuid, ListReferenceAccessorsModel::new));
	}

	public Optional<ListReferenceAccessorsModel> findListReferenceAccessorsModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ListReferenceAccessorsModel.stTemplateUuid, ListReferenceAccessorsModel::new));
	}

	public Optional<ListReferenceAccessorsModel> findListReferenceAccessorsModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, ListReferenceAccessorsModel.stTemplateUuid, ListReferenceAccessorsModel::new));
	}

	public Optional<ListPrimitiveAccessorsModel> findListPrimitiveAccessorsModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, ListPrimitiveAccessorsModel.stTemplateUuid, ListPrimitiveAccessorsModel::new));
	}

	public Optional<ListPrimitiveAccessorsModel> findListPrimitiveAccessorsModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ListPrimitiveAccessorsModel.stTemplateUuid, ListPrimitiveAccessorsModel::new));
	}

	public Optional<ListPrimitiveAccessorsModel> findListPrimitiveAccessorsModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, ListPrimitiveAccessorsModel.stTemplateUuid, ListPrimitiveAccessorsModel::new));
	}

	public Optional<EnumAccessorsModel> findEnumAccessorsModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, EnumAccessorsModel.stTemplateUuid, EnumAccessorsModel::new));
	}

	public Optional<EnumAccessorsModel> findEnumAccessorsModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, EnumAccessorsModel.stTemplateUuid, EnumAccessorsModel::new));
	}

	public Optional<EnumAccessorsModel> findEnumAccessorsModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, EnumAccessorsModel.stTemplateUuid, EnumAccessorsModel::new));
	}

	public Optional<ReferenceAccessorsModel> findReferenceAccessorsModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ReferenceAccessorsModel.stTemplateUuid, ReferenceAccessorsModel::new));
	}

	public Optional<ReferenceAccessorsModel> findReferenceAccessorsModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, ReferenceAccessorsModel.stTemplateUuid, ReferenceAccessorsModel::new));
	}

	public Optional<ReferenceAccessorsModel> findReferenceAccessorsModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, ReferenceAccessorsModel.stTemplateUuid, ReferenceAccessorsModel::new));
	}

	public Optional<ExternalAccessorsModel> findExternalAccessorsModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ExternalAccessorsModel.stTemplateUuid, ExternalAccessorsModel::new));
	}

	public Optional<ExternalAccessorsModel> findExternalAccessorsModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, ExternalAccessorsModel.stTemplateUuid, ExternalAccessorsModel::new));
	}

	public Optional<ExternalAccessorsModel> findExternalAccessorsModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, ExternalAccessorsModel.stTemplateUuid, ExternalAccessorsModel::new));
	}

	public Optional<IncomingReferenceStreamModel> findIncomingReferenceStreamModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, IncomingReferenceStreamModel.stTemplateUuid, IncomingReferenceStreamModel::new));
	}

	public Optional<IncomingReferenceStreamModel> findIncomingReferenceStreamModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, IncomingReferenceStreamModel.stTemplateUuid, IncomingReferenceStreamModel::new));
	}

	public Optional<EnumListAccessorsModel> findEnumListAccessorsModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, EnumListAccessorsModel.stTemplateUuid, EnumListAccessorsModel::new));
	}

	public Optional<EnumListAccessorsModel> findEnumListAccessorsModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, EnumListAccessorsModel.stTemplateUuid, EnumListAccessorsModel::new));
	}

	public Optional<EnumListAccessorsModel> findEnumListAccessorsModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, EnumListAccessorsModel.stTemplateUuid, EnumListAccessorsModel::new));
	}

	public Optional<NeoFactoryModel> findNeoFactoryModelByPackage(STValue value) {
		return Optional.ofNullable(db.find("package", value, NeoFactoryModel.stTemplateUuid, NeoFactoryModel::new));
	}

	public Optional<NeoFactoryModel> findNeoFactoryModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, NeoFactoryModel.stTemplateUuid, NeoFactoryModel::new));
	}

	public Optional<NeoFactoryAccessorsModel> findNeoFactoryAccessorsModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, NeoFactoryAccessorsModel.stTemplateUuid, NeoFactoryAccessorsModel::new));
	}

	public Optional<NeoFactoryPropertyAccessorsModel> findNeoFactoryPropertyAccessorsModelByEntity(STValue value) {
		return Optional.ofNullable(db.find("entity", value, NeoFactoryPropertyAccessorsModel.stTemplateUuid, NeoFactoryPropertyAccessorsModel::new));
	}

	public Optional<NeoFactoryPropertyAccessorsModel> findNeoFactoryPropertyAccessorsModelByPropertyName(STValue value) {
		return Optional.ofNullable(db.find("propertyName", value, NeoFactoryPropertyAccessorsModel.stTemplateUuid, NeoFactoryPropertyAccessorsModel::new));
	}

	public Optional<NeoFactoryPropertyAccessorsModel> findNeoFactoryPropertyAccessorsModelByPropertyType(STValue value) {
		return Optional.ofNullable(db.find("propertyType", value, NeoFactoryPropertyAccessorsModel.stTemplateUuid, NeoFactoryPropertyAccessorsModel::new));
	}

	public Optional<NeoFactoryPropertyAccessorsModel> findNeoFactoryPropertyAccessorsModelByIsEnum(STValue value) {
		return Optional.ofNullable(db.find("isEnum", value, NeoFactoryPropertyAccessorsModel.stTemplateUuid, NeoFactoryPropertyAccessorsModel::new));
	}
}