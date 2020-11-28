package nextgen.events;

public final class NewSTProjectSTModel {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTProjectSTModel.class);

	public static void post(nextgen.model.STModel model, nextgen.model.STProject project, nextgen.model.STTemplate template) {
		//log.info("post NewSTProjectSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTProjectSTModel(model, project, template));
	}

	public final nextgen.model.STModel model;
	public final nextgen.model.STProject project;
	public final nextgen.model.STTemplate template;

	public NewSTProjectSTModel(nextgen.model.STModel model, nextgen.model.STProject project, nextgen.model.STTemplate template) {
		this.model = model;
		this.project = project;
		this.template = template;
	}
}