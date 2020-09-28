package nextgen.templates.mobx.neo;

import nextgen.st.model.*;
import org.neo4j.graphdb.Node;
import java.util.Optional;
import java.util.stream.Stream;

public class MobXNeo {

	private final STModelDB db;

	public MobXNeo(STModelDB db) {
		this.db = db;
	}

	public StoreModel newStoreModel() {
		return new StoreModel(db);
	}

	public StoreModel newStoreModel(STModel stModel) {
		return new StoreModel(db, stModel);
	}

	public StoreModel newStoreModel(Node node) {
		return new StoreModel(db, node);
	}

	public Stream<StoreModel> findAllStoreModel() {
		return db.findAllSTModelByStTemplate(StoreModel.stTemplateUuid)
				.map(stModel -> new StoreModel(db, stModel));
	}

	public StoreModel findStoreModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StoreModel(db, uuid) : new StoreModel(db, stModel);
	}


	public ActionModel newActionModel() {
		return new ActionModel(db);
	}

	public ActionModel newActionModel(STModel stModel) {
		return new ActionModel(db, stModel);
	}

	public ActionModel newActionModel(Node node) {
		return new ActionModel(db, node);
	}

	public Stream<ActionModel> findAllActionModel() {
		return db.findAllSTModelByStTemplate(ActionModel.stTemplateUuid)
				.map(stModel -> new ActionModel(db, stModel));
	}

	public ActionModel findActionModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ActionModel(db, uuid) : new ActionModel(db, stModel);
	}


	public BackendStoreModel newBackendStoreModel() {
		return new BackendStoreModel(db);
	}

	public BackendStoreModel newBackendStoreModel(STModel stModel) {
		return new BackendStoreModel(db, stModel);
	}

	public BackendStoreModel newBackendStoreModel(Node node) {
		return new BackendStoreModel(db, node);
	}

	public Stream<BackendStoreModel> findAllBackendStoreModel() {
		return db.findAllSTModelByStTemplate(BackendStoreModel.stTemplateUuid)
				.map(stModel -> new BackendStoreModel(db, stModel));
	}

	public BackendStoreModel findBackendStoreModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BackendStoreModel(db, uuid) : new BackendStoreModel(db, stModel);
	}


	public BackendActionModel newBackendActionModel() {
		return new BackendActionModel(db);
	}

	public BackendActionModel newBackendActionModel(STModel stModel) {
		return new BackendActionModel(db, stModel);
	}

	public BackendActionModel newBackendActionModel(Node node) {
		return new BackendActionModel(db, node);
	}

	public Stream<BackendActionModel> findAllBackendActionModel() {
		return db.findAllSTModelByStTemplate(BackendActionModel.stTemplateUuid)
				.map(stModel -> new BackendActionModel(db, stModel));
	}

	public BackendActionModel findBackendActionModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BackendActionModel(db, uuid) : new BackendActionModel(db, stModel);
	}


	public InjectModel newInjectModel() {
		return new InjectModel(db);
	}

	public InjectModel newInjectModel(STModel stModel) {
		return new InjectModel(db, stModel);
	}

	public InjectModel newInjectModel(Node node) {
		return new InjectModel(db, node);
	}

	public Stream<InjectModel> findAllInjectModel() {
		return db.findAllSTModelByStTemplate(InjectModel.stTemplateUuid)
				.map(stModel -> new InjectModel(db, stModel));
	}

	public InjectModel findInjectModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new InjectModel(db, uuid) : new InjectModel(db, stModel);
	}


	public ObservableModel newObservableModel() {
		return new ObservableModel(db);
	}

	public ObservableModel newObservableModel(STModel stModel) {
		return new ObservableModel(db, stModel);
	}

	public ObservableModel newObservableModel(Node node) {
		return new ObservableModel(db, node);
	}

	public Stream<ObservableModel> findAllObservableModel() {
		return db.findAllSTModelByStTemplate(ObservableModel.stTemplateUuid)
				.map(stModel -> new ObservableModel(db, stModel));
	}

	public ObservableModel findObservableModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ObservableModel(db, uuid) : new ObservableModel(db, stModel);
	}


	public ReactionModel newReactionModel() {
		return new ReactionModel(db);
	}

	public ReactionModel newReactionModel(STModel stModel) {
		return new ReactionModel(db, stModel);
	}

	public ReactionModel newReactionModel(Node node) {
		return new ReactionModel(db, node);
	}

	public Stream<ReactionModel> findAllReactionModel() {
		return db.findAllSTModelByStTemplate(ReactionModel.stTemplateUuid)
				.map(stModel -> new ReactionModel(db, stModel));
	}

	public ReactionModel findReactionModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ReactionModel(db, uuid) : new ReactionModel(db, stModel);
	}


	public Optional<StoreModel> findStoreModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, StoreModel.stTemplateUuid, StoreModel::new));
	}

	public Optional<ActionModel> findActionModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, ActionModel.stTemplateUuid, ActionModel::new));
	}

	public Optional<BackendStoreModel> findBackendStoreModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, BackendStoreModel.stTemplateUuid, BackendStoreModel::new));
	}

	public Optional<BackendActionModel> findBackendActionModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, BackendActionModel.stTemplateUuid, BackendActionModel::new));
	}

	public Optional<BackendActionModel> findBackendActionModelByEndpoint(STValue value) {
		return Optional.ofNullable(db.find("endpoint", value, BackendActionModel.stTemplateUuid, BackendActionModel::new));
	}

	public Optional<BackendActionModel> findBackendActionModelByMethod(STValue value) {
		return Optional.ofNullable(db.find("method", value, BackendActionModel.stTemplateUuid, BackendActionModel::new));
	}

	public Optional<BackendActionModel> findBackendActionModelByObservable(STValue value) {
		return Optional.ofNullable(db.find("observable", value, BackendActionModel.stTemplateUuid, BackendActionModel::new));
	}

	public Optional<ObservableModel> findObservableModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, ObservableModel.stTemplateUuid, ObservableModel::new));
	}

	public Optional<ObservableModel> findObservableModelByInitializer(STValue value) {
		return Optional.ofNullable(db.find("initializer", value, ObservableModel.stTemplateUuid, ObservableModel::new));
	}

	public Optional<ReactionModel> findReactionModelByDataFunction(STValue value) {
		return Optional.ofNullable(db.find("dataFunction", value, ReactionModel.stTemplateUuid, ReactionModel::new));
	}

	public Optional<ReactionModel> findReactionModelByEffectFunction(STValue value) {
		return Optional.ofNullable(db.find("effectFunction", value, ReactionModel.stTemplateUuid, ReactionModel::new));
	}
}