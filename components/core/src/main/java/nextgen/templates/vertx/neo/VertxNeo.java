package nextgen.templates.vertx.neo;

import nextgen.st.model.*;
import org.neo4j.graphdb.Node;
import java.util.Optional;
import java.util.stream.Stream;

public class VertxNeo {

	private final STModelDB db;

	public VertxNeo(STModelDB db) {
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


	public JsonWrapperModel newJsonWrapperModel() {
		return new JsonWrapperModel(db);
	}

	public JsonWrapperModel newJsonWrapperModel(STModel stModel) {
		return new JsonWrapperModel(db, stModel);
	}

	public JsonWrapperModel newJsonWrapperModel(Node node) {
		return new JsonWrapperModel(db, node);
	}

	public Stream<JsonWrapperModel> findAllJsonWrapperModel() {
		return db.findAllSTModelByStTemplate(JsonWrapperModel.stTemplateUuid)
				.map(stModel -> new JsonWrapperModel(db, stModel));
	}

	public JsonWrapperModel findJsonWrapperModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new JsonWrapperModel(db, uuid) : new JsonWrapperModel(db, stModel);
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


	public ListEnumAccessorsModel newListEnumAccessorsModel() {
		return new ListEnumAccessorsModel(db);
	}

	public ListEnumAccessorsModel newListEnumAccessorsModel(STModel stModel) {
		return new ListEnumAccessorsModel(db, stModel);
	}

	public ListEnumAccessorsModel newListEnumAccessorsModel(Node node) {
		return new ListEnumAccessorsModel(db, node);
	}

	public Stream<ListEnumAccessorsModel> findAllListEnumAccessorsModel() {
		return db.findAllSTModelByStTemplate(ListEnumAccessorsModel.stTemplateUuid)
				.map(stModel -> new ListEnumAccessorsModel(db, stModel));
	}

	public ListEnumAccessorsModel findListEnumAccessorsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListEnumAccessorsModel(db, uuid) : new ListEnumAccessorsModel(db, stModel);
	}


	public JsonFactoryModel newJsonFactoryModel() {
		return new JsonFactoryModel(db);
	}

	public JsonFactoryModel newJsonFactoryModel(STModel stModel) {
		return new JsonFactoryModel(db, stModel);
	}

	public JsonFactoryModel newJsonFactoryModel(Node node) {
		return new JsonFactoryModel(db, node);
	}

	public Stream<JsonFactoryModel> findAllJsonFactoryModel() {
		return db.findAllSTModelByStTemplate(JsonFactoryModel.stTemplateUuid)
				.map(stModel -> new JsonFactoryModel(db, stModel));
	}

	public JsonFactoryModel findJsonFactoryModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new JsonFactoryModel(db, uuid) : new JsonFactoryModel(db, stModel);
	}


	public DomainVerticleModel newDomainVerticleModel() {
		return new DomainVerticleModel(db);
	}

	public DomainVerticleModel newDomainVerticleModel(STModel stModel) {
		return new DomainVerticleModel(db, stModel);
	}

	public DomainVerticleModel newDomainVerticleModel(Node node) {
		return new DomainVerticleModel(db, node);
	}

	public Stream<DomainVerticleModel> findAllDomainVerticleModel() {
		return db.findAllSTModelByStTemplate(DomainVerticleModel.stTemplateUuid)
				.map(stModel -> new DomainVerticleModel(db, stModel));
	}

	public DomainVerticleModel findDomainVerticleModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DomainVerticleModel(db, uuid) : new DomainVerticleModel(db, stModel);
	}


	public DomainActionModel newDomainActionModel() {
		return new DomainActionModel(db);
	}

	public DomainActionModel newDomainActionModel(STModel stModel) {
		return new DomainActionModel(db, stModel);
	}

	public DomainActionModel newDomainActionModel(Node node) {
		return new DomainActionModel(db, node);
	}

	public Stream<DomainActionModel> findAllDomainActionModel() {
		return db.findAllSTModelByStTemplate(DomainActionModel.stTemplateUuid)
				.map(stModel -> new DomainActionModel(db, stModel));
	}

	public DomainActionModel findDomainActionModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DomainActionModel(db, uuid) : new DomainActionModel(db, stModel);
	}


	public WebVerticleModel newWebVerticleModel() {
		return new WebVerticleModel(db);
	}

	public WebVerticleModel newWebVerticleModel(STModel stModel) {
		return new WebVerticleModel(db, stModel);
	}

	public WebVerticleModel newWebVerticleModel(Node node) {
		return new WebVerticleModel(db, node);
	}

	public Stream<WebVerticleModel> findAllWebVerticleModel() {
		return db.findAllSTModelByStTemplate(WebVerticleModel.stTemplateUuid)
				.map(stModel -> new WebVerticleModel(db, stModel));
	}

	public WebVerticleModel findWebVerticleModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new WebVerticleModel(db, uuid) : new WebVerticleModel(db, stModel);
	}


	public SendEventBusActionModel newSendEventBusActionModel() {
		return new SendEventBusActionModel(db);
	}

	public SendEventBusActionModel newSendEventBusActionModel(STModel stModel) {
		return new SendEventBusActionModel(db, stModel);
	}

	public SendEventBusActionModel newSendEventBusActionModel(Node node) {
		return new SendEventBusActionModel(db, node);
	}

	public Stream<SendEventBusActionModel> findAllSendEventBusActionModel() {
		return db.findAllSTModelByStTemplate(SendEventBusActionModel.stTemplateUuid)
				.map(stModel -> new SendEventBusActionModel(db, stModel));
	}

	public SendEventBusActionModel findSendEventBusActionModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SendEventBusActionModel(db, uuid) : new SendEventBusActionModel(db, stModel);
	}


	public RouteHandlerModel newRouteHandlerModel() {
		return new RouteHandlerModel(db);
	}

	public RouteHandlerModel newRouteHandlerModel(STModel stModel) {
		return new RouteHandlerModel(db, stModel);
	}

	public RouteHandlerModel newRouteHandlerModel(Node node) {
		return new RouteHandlerModel(db, node);
	}

	public Stream<RouteHandlerModel> findAllRouteHandlerModel() {
		return db.findAllSTModelByStTemplate(RouteHandlerModel.stTemplateUuid)
				.map(stModel -> new RouteHandlerModel(db, stModel));
	}

	public RouteHandlerModel findRouteHandlerModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new RouteHandlerModel(db, uuid) : new RouteHandlerModel(db, stModel);
	}


	public ServerModel newServerModel() {
		return new ServerModel(db);
	}

	public ServerModel newServerModel(STModel stModel) {
		return new ServerModel(db, stModel);
	}

	public ServerModel newServerModel(Node node) {
		return new ServerModel(db, node);
	}

	public Stream<ServerModel> findAllServerModel() {
		return db.findAllSTModelByStTemplate(ServerModel.stTemplateUuid)
				.map(stModel -> new ServerModel(db, stModel));
	}

	public ServerModel findServerModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ServerModel(db, uuid) : new ServerModel(db, stModel);
	}


	public Optional<JsonWrapperModel> findJsonWrapperModelByPackage(STValue value) {
		return Optional.ofNullable(db.find("package", value, JsonWrapperModel.stTemplateUuid, JsonWrapperModel::new));
	}

	public Optional<JsonWrapperModel> findJsonWrapperModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, JsonWrapperModel.stTemplateUuid, JsonWrapperModel::new));
	}

	public Optional<JsonWrapperModel> findJsonWrapperModelByNeoNodeMapper(STValue value) {
		return Optional.ofNullable(db.find("neoNodeMapper", value, JsonWrapperModel.stTemplateUuid, JsonWrapperModel::new));
	}

	public Optional<JsonWrapperModel> findJsonWrapperModelByLexical(STValue value) {
		return Optional.ofNullable(db.find("lexical", value, JsonWrapperModel.stTemplateUuid, JsonWrapperModel::new));
	}

	public Optional<PrimitiveAccessorsModel> findPrimitiveAccessorsModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, PrimitiveAccessorsModel.stTemplateUuid, PrimitiveAccessorsModel::new));
	}

	public Optional<PrimitiveAccessorsModel> findPrimitiveAccessorsModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, PrimitiveAccessorsModel.stTemplateUuid, PrimitiveAccessorsModel::new));
	}

	public Optional<PrimitiveAccessorsModel> findPrimitiveAccessorsModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, PrimitiveAccessorsModel.stTemplateUuid, PrimitiveAccessorsModel::new));
	}

	public Optional<ListReferenceAccessorsModel> findListReferenceAccessorsModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ListReferenceAccessorsModel.stTemplateUuid, ListReferenceAccessorsModel::new));
	}

	public Optional<ListReferenceAccessorsModel> findListReferenceAccessorsModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, ListReferenceAccessorsModel.stTemplateUuid, ListReferenceAccessorsModel::new));
	}

	public Optional<ListReferenceAccessorsModel> findListReferenceAccessorsModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, ListReferenceAccessorsModel.stTemplateUuid, ListReferenceAccessorsModel::new));
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

	public Optional<ListPrimitiveAccessorsModel> findListPrimitiveAccessorsModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ListPrimitiveAccessorsModel.stTemplateUuid, ListPrimitiveAccessorsModel::new));
	}

	public Optional<ListPrimitiveAccessorsModel> findListPrimitiveAccessorsModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, ListPrimitiveAccessorsModel.stTemplateUuid, ListPrimitiveAccessorsModel::new));
	}

	public Optional<ListPrimitiveAccessorsModel> findListPrimitiveAccessorsModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, ListPrimitiveAccessorsModel.stTemplateUuid, ListPrimitiveAccessorsModel::new));
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

	public Optional<EnumAccessorsModel> findEnumAccessorsModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, EnumAccessorsModel.stTemplateUuid, EnumAccessorsModel::new));
	}

	public Optional<EnumAccessorsModel> findEnumAccessorsModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, EnumAccessorsModel.stTemplateUuid, EnumAccessorsModel::new));
	}

	public Optional<EnumAccessorsModel> findEnumAccessorsModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, EnumAccessorsModel.stTemplateUuid, EnumAccessorsModel::new));
	}

	public Optional<ListEnumAccessorsModel> findListEnumAccessorsModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ListEnumAccessorsModel.stTemplateUuid, ListEnumAccessorsModel::new));
	}

	public Optional<ListEnumAccessorsModel> findListEnumAccessorsModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, ListEnumAccessorsModel.stTemplateUuid, ListEnumAccessorsModel::new));
	}

	public Optional<ListEnumAccessorsModel> findListEnumAccessorsModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, ListEnumAccessorsModel.stTemplateUuid, ListEnumAccessorsModel::new));
	}

	public Optional<JsonFactoryModel> findJsonFactoryModelByPackage(STValue value) {
		return Optional.ofNullable(db.find("package", value, JsonFactoryModel.stTemplateUuid, JsonFactoryModel::new));
	}

	public Optional<JsonFactoryModel> findJsonFactoryModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, JsonFactoryModel.stTemplateUuid, JsonFactoryModel::new));
	}

	public Optional<DomainVerticleModel> findDomainVerticleModelByPackageName(STValue value) {
		return Optional.ofNullable(db.find("packageName", value, DomainVerticleModel.stTemplateUuid, DomainVerticleModel::new));
	}

	public Optional<DomainVerticleModel> findDomainVerticleModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, DomainVerticleModel.stTemplateUuid, DomainVerticleModel::new));
	}

	public Optional<DomainVerticleModel> findDomainVerticleModelByDomainFactory(STValue value) {
		return Optional.ofNullable(db.find("domainFactory", value, DomainVerticleModel.stTemplateUuid, DomainVerticleModel::new));
	}

	public Optional<DomainVerticleModel> findDomainVerticleModelByDbPath(STValue value) {
		return Optional.ofNullable(db.find("dbPath", value, DomainVerticleModel.stTemplateUuid, DomainVerticleModel::new));
	}

	public Optional<DomainVerticleModel> findDomainVerticleModelByAddress(STValue value) {
		return Optional.ofNullable(db.find("address", value, DomainVerticleModel.stTemplateUuid, DomainVerticleModel::new));
	}

	public Optional<DomainActionModel> findDomainActionModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, DomainActionModel.stTemplateUuid, DomainActionModel::new));
	}

	public Optional<WebVerticleModel> findWebVerticleModelByPackageName(STValue value) {
		return Optional.ofNullable(db.find("packageName", value, WebVerticleModel.stTemplateUuid, WebVerticleModel::new));
	}

	public Optional<WebVerticleModel> findWebVerticleModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, WebVerticleModel.stTemplateUuid, WebVerticleModel::new));
	}

	public Optional<SendEventBusActionModel> findSendEventBusActionModelByActionName(STValue value) {
		return Optional.ofNullable(db.find("actionName", value, SendEventBusActionModel.stTemplateUuid, SendEventBusActionModel::new));
	}

	public Optional<RouteHandlerModel> findRouteHandlerModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, RouteHandlerModel.stTemplateUuid, RouteHandlerModel::new));
	}

	public Optional<ServerModel> findServerModelByPackageName(STValue value) {
		return Optional.ofNullable(db.find("packageName", value, ServerModel.stTemplateUuid, ServerModel::new));
	}

	public Optional<ServerModel> findServerModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, ServerModel.stTemplateUuid, ServerModel::new));
	}
}