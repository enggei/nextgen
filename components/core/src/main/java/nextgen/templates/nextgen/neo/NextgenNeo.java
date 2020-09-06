package nextgen.templates.nextgen.neo;

import nextgen.st.model.*;
import org.neo4j.graphdb.Node;
import java.util.Optional;

public class NextgenNeo {

	private final STModelDB db;

	public NextgenNeo(STModelDB db) {
		this.db = db;
	}

	public TreeNavigatorModel newTreeNavigatorModel() {
		return new TreeNavigatorModel(db);
	}

	public TreeNavigatorModel newTreeNavigatorModel(STModel stModel) {
		return new TreeNavigatorModel(db, stModel);
	}

	public TreeNavigatorModel newTreeNavigatorModel(Node node) {
		return new TreeNavigatorModel(db, node);
	}


	public BaseTreeNodeModel newBaseTreeNodeModel() {
		return new BaseTreeNodeModel(db);
	}

	public BaseTreeNodeModel newBaseTreeNodeModel(STModel stModel) {
		return new BaseTreeNodeModel(db, stModel);
	}

	public BaseTreeNodeModel newBaseTreeNodeModel(Node node) {
		return new BaseTreeNodeModel(db, node);
	}


	public TreeNodeModel newTreeNodeModel() {
		return new TreeNodeModel(db);
	}

	public TreeNodeModel newTreeNodeModel(STModel stModel) {
		return new TreeNodeModel(db, stModel);
	}

	public TreeNodeModel newTreeNodeModel(Node node) {
		return new TreeNodeModel(db, node);
	}


	public TreeNodeActionModel newTreeNodeActionModel() {
		return new TreeNodeActionModel(db);
	}

	public TreeNodeActionModel newTreeNodeActionModel(STModel stModel) {
		return new TreeNodeActionModel(db, stModel);
	}

	public TreeNodeActionModel newTreeNodeActionModel(Node node) {
		return new TreeNodeActionModel(db, node);
	}


	public CanvasModel newCanvasModel() {
		return new CanvasModel(db);
	}

	public CanvasModel newCanvasModel(STModel stModel) {
		return new CanvasModel(db, stModel);
	}

	public CanvasModel newCanvasModel(Node node) {
		return new CanvasModel(db, node);
	}


	public BaseCanvasNodeModel newBaseCanvasNodeModel() {
		return new BaseCanvasNodeModel(db);
	}

	public BaseCanvasNodeModel newBaseCanvasNodeModel(STModel stModel) {
		return new BaseCanvasNodeModel(db, stModel);
	}

	public BaseCanvasNodeModel newBaseCanvasNodeModel(Node node) {
		return new BaseCanvasNodeModel(db, node);
	}


	public CanvasNodeModel newCanvasNodeModel() {
		return new CanvasNodeModel(db);
	}

	public CanvasNodeModel newCanvasNodeModel(STModel stModel) {
		return new CanvasNodeModel(db, stModel);
	}

	public CanvasNodeModel newCanvasNodeModel(Node node) {
		return new CanvasNodeModel(db, node);
	}


	public CanvasNodeActionModel newCanvasNodeActionModel() {
		return new CanvasNodeActionModel(db);
	}

	public CanvasNodeActionModel newCanvasNodeActionModel(STModel stModel) {
		return new CanvasNodeActionModel(db, stModel);
	}

	public CanvasNodeActionModel newCanvasNodeActionModel(Node node) {
		return new CanvasNodeActionModel(db, node);
	}


	public BaseCanvasRelationModel newBaseCanvasRelationModel() {
		return new BaseCanvasRelationModel(db);
	}

	public BaseCanvasRelationModel newBaseCanvasRelationModel(STModel stModel) {
		return new BaseCanvasRelationModel(db, stModel);
	}

	public BaseCanvasRelationModel newBaseCanvasRelationModel(Node node) {
		return new BaseCanvasRelationModel(db, node);
	}


	public CanvasRelationModel newCanvasRelationModel() {
		return new CanvasRelationModel(db);
	}

	public CanvasRelationModel newCanvasRelationModel(STModel stModel) {
		return new CanvasRelationModel(db, stModel);
	}

	public CanvasRelationModel newCanvasRelationModel(Node node) {
		return new CanvasRelationModel(db, node);
	}


	public CanvasRelationActionModel newCanvasRelationActionModel() {
		return new CanvasRelationActionModel(db);
	}

	public CanvasRelationActionModel newCanvasRelationActionModel(STModel stModel) {
		return new CanvasRelationActionModel(db, stModel);
	}

	public CanvasRelationActionModel newCanvasRelationActionModel(Node node) {
		return new CanvasRelationActionModel(db, node);
	}


	public CanvasActionModel newCanvasActionModel() {
		return new CanvasActionModel(db);
	}

	public CanvasActionModel newCanvasActionModel(STModel stModel) {
		return new CanvasActionModel(db, stModel);
	}

	public CanvasActionModel newCanvasActionModel(Node node) {
		return new CanvasActionModel(db, node);
	}


	public AppEventsModel newAppEventsModel() {
		return new AppEventsModel(db);
	}

	public AppEventsModel newAppEventsModel(STModel stModel) {
		return new AppEventsModel(db, stModel);
	}

	public AppEventsModel newAppEventsModel(Node node) {
		return new AppEventsModel(db, node);
	}


	public AppEventModel newAppEventModel() {
		return new AppEventModel(db);
	}

	public AppEventModel newAppEventModel(STModel stModel) {
		return new AppEventModel(db, stModel);
	}

	public AppEventModel newAppEventModel(Node node) {
		return new AppEventModel(db, node);
	}


	public NewOpenRemovedEventsModel newNewOpenRemovedEventsModel() {
		return new NewOpenRemovedEventsModel(db);
	}

	public NewOpenRemovedEventsModel newNewOpenRemovedEventsModel(STModel stModel) {
		return new NewOpenRemovedEventsModel(db, stModel);
	}

	public NewOpenRemovedEventsModel newNewOpenRemovedEventsModel(Node node) {
		return new NewOpenRemovedEventsModel(db, node);
	}


	public EventSubscriberModel newEventSubscriberModel() {
		return new EventSubscriberModel(db);
	}

	public EventSubscriberModel newEventSubscriberModel(STModel stModel) {
		return new EventSubscriberModel(db, stModel);
	}

	public EventSubscriberModel newEventSubscriberModel(Node node) {
		return new EventSubscriberModel(db, node);
	}


	public STWorkspaceModel newSTWorkspaceModel() {
		return new STWorkspaceModel(db);
	}

	public STWorkspaceModel newSTWorkspaceModel(STModel stModel) {
		return new STWorkspaceModel(db, stModel);
	}

	public STWorkspaceModel newSTWorkspaceModel(Node node) {
		return new STWorkspaceModel(db, node);
	}


	public Optional<TreeNavigatorModel> findTreeNavigatorModelByPackageName(STValue value) {
		return Optional.ofNullable(db.find("packageName", value, TreeNavigatorModel.stTemplateUuid, TreeNavigatorModel::new));
	}

	public Optional<TreeNavigatorModel> findTreeNavigatorModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, TreeNavigatorModel.stTemplateUuid, TreeNavigatorModel::new));
	}

	public Optional<TreeNavigatorModel> findTreeNavigatorModelByRootNodeExpression(STValue value) {
		return Optional.ofNullable(db.find("rootNodeExpression", value, TreeNavigatorModel.stTemplateUuid, TreeNavigatorModel::new));
	}

	public Optional<TreeNavigatorModel> findTreeNavigatorModelByPreferredWidth(STValue value) {
		return Optional.ofNullable(db.find("preferredWidth", value, TreeNavigatorModel.stTemplateUuid, TreeNavigatorModel::new));
	}

	public Optional<TreeNavigatorModel> findTreeNavigatorModelByPreferredHeight(STValue value) {
		return Optional.ofNullable(db.find("preferredHeight", value, TreeNavigatorModel.stTemplateUuid, TreeNavigatorModel::new));
	}

	public Optional<TreeNavigatorModel> findTreeNavigatorModelByBaseTreeNode(STValue value) {
		return Optional.ofNullable(db.find("baseTreeNode", value, TreeNavigatorModel.stTemplateUuid, TreeNavigatorModel::new));
	}

	public Optional<TreeNodeModel> findTreeNodeModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, TreeNodeModel.stTemplateUuid, TreeNodeModel::new));
	}

	public Optional<TreeNodeModel> findTreeNodeModelByModelType(STValue value) {
		return Optional.ofNullable(db.find("modelType", value, TreeNodeModel.stTemplateUuid, TreeNodeModel::new));
	}

	public Optional<TreeNodeModel> findTreeNodeModelByHasUuid(STValue value) {
		return Optional.ofNullable(db.find("hasUuid", value, TreeNodeModel.stTemplateUuid, TreeNodeModel::new));
	}

	public Optional<TreeNodeModel> findTreeNodeModelByIcon(STValue value) {
		return Optional.ofNullable(db.find("icon", value, TreeNodeModel.stTemplateUuid, TreeNodeModel::new));
	}

	public Optional<TreeNodeModel> findTreeNodeModelByLabelExpression(STValue value) {
		return Optional.ofNullable(db.find("labelExpression", value, TreeNodeModel.stTemplateUuid, TreeNodeModel::new));
	}

	public Optional<TreeNodeModel> findTreeNodeModelByTooltipExpression(STValue value) {
		return Optional.ofNullable(db.find("tooltipExpression", value, TreeNodeModel.stTemplateUuid, TreeNodeModel::new));
	}

	public Optional<TreeNodeActionModel> findTreeNodeActionModelByTitle(STValue value) {
		return Optional.ofNullable(db.find("title", value, TreeNodeActionModel.stTemplateUuid, TreeNodeActionModel::new));
	}

	public Optional<CanvasModel> findCanvasModelByPackageName(STValue value) {
		return Optional.ofNullable(db.find("packageName", value, CanvasModel.stTemplateUuid, CanvasModel::new));
	}

	public Optional<CanvasModel> findCanvasModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, CanvasModel.stTemplateUuid, CanvasModel::new));
	}

	public Optional<CanvasNodeModel> findCanvasNodeModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, CanvasNodeModel.stTemplateUuid, CanvasNodeModel::new));
	}

	public Optional<CanvasNodeModel> findCanvasNodeModelByModelType(STValue value) {
		return Optional.ofNullable(db.find("modelType", value, CanvasNodeModel.stTemplateUuid, CanvasNodeModel::new));
	}

	public Optional<CanvasNodeModel> findCanvasNodeModelByUuidExpression(STValue value) {
		return Optional.ofNullable(db.find("uuidExpression", value, CanvasNodeModel.stTemplateUuid, CanvasNodeModel::new));
	}

	public Optional<CanvasNodeModel> findCanvasNodeModelByLabelExpression(STValue value) {
		return Optional.ofNullable(db.find("labelExpression", value, CanvasNodeModel.stTemplateUuid, CanvasNodeModel::new));
	}

	public Optional<CanvasNodeActionModel> findCanvasNodeActionModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, CanvasNodeActionModel.stTemplateUuid, CanvasNodeActionModel::new));
	}

	public Optional<CanvasNodeActionModel> findCanvasNodeActionModelByTitleExpression(STValue value) {
		return Optional.ofNullable(db.find("titleExpression", value, CanvasNodeActionModel.stTemplateUuid, CanvasNodeActionModel::new));
	}

	public Optional<CanvasNodeActionModel> findCanvasNodeActionModelByTitle(STValue value) {
		return Optional.ofNullable(db.find("title", value, CanvasNodeActionModel.stTemplateUuid, CanvasNodeActionModel::new));
	}

	public Optional<CanvasNodeActionModel> findCanvasNodeActionModelByTransactional(STValue value) {
		return Optional.ofNullable(db.find("transactional", value, CanvasNodeActionModel.stTemplateUuid, CanvasNodeActionModel::new));
	}

	public Optional<CanvasRelationModel> findCanvasRelationModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, CanvasRelationModel.stTemplateUuid, CanvasRelationModel::new));
	}

	public Optional<CanvasRelationModel> findCanvasRelationModelByUuidExpression(STValue value) {
		return Optional.ofNullable(db.find("uuidExpression", value, CanvasRelationModel.stTemplateUuid, CanvasRelationModel::new));
	}

	public Optional<CanvasRelationModel> findCanvasRelationModelByLabelExpression(STValue value) {
		return Optional.ofNullable(db.find("labelExpression", value, CanvasRelationModel.stTemplateUuid, CanvasRelationModel::new));
	}

	public Optional<CanvasRelationActionModel> findCanvasRelationActionModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, CanvasRelationActionModel.stTemplateUuid, CanvasRelationActionModel::new));
	}

	public Optional<CanvasRelationActionModel> findCanvasRelationActionModelByTitle(STValue value) {
		return Optional.ofNullable(db.find("title", value, CanvasRelationActionModel.stTemplateUuid, CanvasRelationActionModel::new));
	}

	public Optional<CanvasActionModel> findCanvasActionModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, CanvasActionModel.stTemplateUuid, CanvasActionModel::new));
	}

	public Optional<CanvasActionModel> findCanvasActionModelByTitle(STValue value) {
		return Optional.ofNullable(db.find("title", value, CanvasActionModel.stTemplateUuid, CanvasActionModel::new));
	}

	public Optional<AppEventsModel> findAppEventsModelByPackageName(STValue value) {
		return Optional.ofNullable(db.find("packageName", value, AppEventsModel.stTemplateUuid, AppEventsModel::new));
	}

	public Optional<AppEventsModel> findAppEventsModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, AppEventsModel.stTemplateUuid, AppEventsModel::new));
	}

	public Optional<AppEventModel> findAppEventModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, AppEventModel.stTemplateUuid, AppEventModel::new));
	}

	public Optional<NewOpenRemovedEventsModel> findNewOpenRemovedEventsModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, NewOpenRemovedEventsModel.stTemplateUuid, NewOpenRemovedEventsModel::new));
	}

	public Optional<NewOpenRemovedEventsModel> findNewOpenRemovedEventsModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, NewOpenRemovedEventsModel.stTemplateUuid, NewOpenRemovedEventsModel::new));
	}

	public Optional<EventSubscriberModel> findEventSubscriberModelByEventName(STValue value) {
		return Optional.ofNullable(db.find("eventName", value, EventSubscriberModel.stTemplateUuid, EventSubscriberModel::new));
	}

	public Optional<EventSubscriberModel> findEventSubscriberModelByEventType(STValue value) {
		return Optional.ofNullable(db.find("eventType", value, EventSubscriberModel.stTemplateUuid, EventSubscriberModel::new));
	}

	public Optional<STWorkspaceModel> findSTWorkspaceModelByPackageName(STValue value) {
		return Optional.ofNullable(db.find("packageName", value, STWorkspaceModel.stTemplateUuid, STWorkspaceModel::new));
	}

	public Optional<STWorkspaceModel> findSTWorkspaceModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, STWorkspaceModel.stTemplateUuid, STWorkspaceModel::new));
	}
}