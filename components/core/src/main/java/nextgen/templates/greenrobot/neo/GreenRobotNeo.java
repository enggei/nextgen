package nextgen.templates.greenrobot.neo;

import nextgen.st.model.*;
import org.neo4j.graphdb.Node;
import java.util.Optional;
import java.util.stream.Stream;

public class GreenRobotNeo {

	private final STModelDB db;

	public GreenRobotNeo(STModelDB db) {
		this.db = db;
	}

	public EventModel newEventModel() {
		return new EventModel(db);
	}

	public EventModel newEventModel(STModel stModel) {
		return new EventModel(db, stModel);
	}

	public EventModel newEventModel(Node node) {
		return new EventModel(db, node);
	}

	public EventModel newEventModel(nextgen.templates.greenrobot.Event template) {
		return new EventModel(db, template);
	}

	public Stream<EventModel> findAllEventModel() {
		return db.findAllSTModelByStTemplate(EventModel.stTemplateUuid)
				.map(stModel -> new EventModel(db, stModel));
	}

	public EventModel findEventModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new EventModel(db, uuid) : new EventModel(db, stModel);
	}


	public SubscribeModel newSubscribeModel() {
		return new SubscribeModel(db);
	}

	public SubscribeModel newSubscribeModel(STModel stModel) {
		return new SubscribeModel(db, stModel);
	}

	public SubscribeModel newSubscribeModel(Node node) {
		return new SubscribeModel(db, node);
	}

	public Stream<SubscribeModel> findAllSubscribeModel() {
		return db.findAllSTModelByStTemplate(SubscribeModel.stTemplateUuid)
				.map(stModel -> new SubscribeModel(db, stModel));
	}

	public SubscribeModel findSubscribeModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SubscribeModel(db, uuid) : new SubscribeModel(db, stModel);
	}


	public RegisterModel newRegisterModel() {
		return new RegisterModel(db);
	}

	public RegisterModel newRegisterModel(STModel stModel) {
		return new RegisterModel(db, stModel);
	}

	public RegisterModel newRegisterModel(Node node) {
		return new RegisterModel(db, node);
	}

	public Stream<RegisterModel> findAllRegisterModel() {
		return db.findAllSTModelByStTemplate(RegisterModel.stTemplateUuid)
				.map(stModel -> new RegisterModel(db, stModel));
	}

	public RegisterModel findRegisterModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new RegisterModel(db, uuid) : new RegisterModel(db, stModel);
	}


	public PostModel newPostModel() {
		return new PostModel(db);
	}

	public PostModel newPostModel(STModel stModel) {
		return new PostModel(db, stModel);
	}

	public PostModel newPostModel(Node node) {
		return new PostModel(db, node);
	}

	public Stream<PostModel> findAllPostModel() {
		return db.findAllSTModelByStTemplate(PostModel.stTemplateUuid)
				.map(stModel -> new PostModel(db, stModel));
	}

	public PostModel findPostModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PostModel(db, uuid) : new PostModel(db, stModel);
	}


	public MavenModel newMavenModel() {
		return new MavenModel(db);
	}

	public MavenModel newMavenModel(STModel stModel) {
		return new MavenModel(db, stModel);
	}

	public MavenModel newMavenModel(Node node) {
		return new MavenModel(db, node);
	}

	public Stream<MavenModel> findAllMavenModel() {
		return db.findAllSTModelByStTemplate(MavenModel.stTemplateUuid)
				.map(stModel -> new MavenModel(db, stModel));
	}

	public MavenModel findMavenModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MavenModel(db, uuid) : new MavenModel(db, stModel);
	}


	public Optional<EventModel> findEventModelByPackageName(STValue value) {
		return value == null ? Optional.empty() : Optional.ofNullable(db.find("packageName", value, EventModel.stTemplateUuid, EventModel::new));
	}

	public EventModel findOrCreateEventModelByPackageName(STValue value) {
		return findEventModelByPackageName(value).orElseGet(() -> new EventModel(db).setPackageName(value));
	}

	public Optional<EventModel> findEventModelByName(STValue value) {
		return value == null ? Optional.empty() : Optional.ofNullable(db.find("name", value, EventModel.stTemplateUuid, EventModel::new));
	}

	public EventModel findOrCreateEventModelByName(STValue value) {
		return findEventModelByName(value).orElseGet(() -> new EventModel(db).setName(value));
	}

	public Optional<SubscribeModel> findSubscribeModelByThreadMode(STValue value) {
		return value == null ? Optional.empty() : Optional.ofNullable(db.find("threadMode", value, SubscribeModel.stTemplateUuid, SubscribeModel::new));
	}

	public SubscribeModel findOrCreateSubscribeModelByThreadMode(STValue value) {
		return findSubscribeModelByThreadMode(value).orElseGet(() -> new SubscribeModel(db).setThreadMode(value));
	}

	public Optional<SubscribeModel> findSubscribeModelByEventName(STValue value) {
		return value == null ? Optional.empty() : Optional.ofNullable(db.find("eventName", value, SubscribeModel.stTemplateUuid, SubscribeModel::new));
	}

	public SubscribeModel findOrCreateSubscribeModelByEventName(STValue value) {
		return findSubscribeModelByEventName(value).orElseGet(() -> new SubscribeModel(db).setEventName(value));
	}

	public Optional<SubscribeModel> findSubscribeModelByEventType(STValue value) {
		return value == null ? Optional.empty() : Optional.ofNullable(db.find("eventType", value, SubscribeModel.stTemplateUuid, SubscribeModel::new));
	}

	public SubscribeModel findOrCreateSubscribeModelByEventType(STValue value) {
		return findSubscribeModelByEventType(value).orElseGet(() -> new SubscribeModel(db).setEventType(value));
	}

	public Optional<PostModel> findPostModelByEvent(STValue value) {
		return value == null ? Optional.empty() : Optional.ofNullable(db.find("event", value, PostModel.stTemplateUuid, PostModel::new));
	}

	public PostModel findOrCreatePostModelByEvent(STValue value) {
		return findPostModelByEvent(value).orElseGet(() -> new PostModel(db).setEvent(value));
	}
}