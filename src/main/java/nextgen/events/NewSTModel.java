package nextgen.events;

public final class NewSTModel {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTModel.class);

	public static void post(nextgen.model.STModel model, nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate template) {
		log.info("NewSTModel" + " model" + " stGroup" + " template");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTModel(model, stGroup, template));
	}

	public final nextgen.model.STModel model;
	public final nextgen.model.STGroupModel stGroup;
	public final nextgen.model.STTemplate template;

	public NewSTModel(nextgen.model.STModel model, nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate template) {
		this.model = model;
		this.stGroup = stGroup;
		this.template = template;
	}
}