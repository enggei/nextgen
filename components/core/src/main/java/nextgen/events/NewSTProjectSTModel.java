package nextgen.events;

public final class NewSTProjectSTModel {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTProjectSTModel.class);

	public static void post(nextgen.st.model.STModel model, nextgen.st.model.STProject project, nextgen.st.model.STTemplate template) {
		log.info("post NewSTProjectSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTProjectSTModel(model, project, template));
	}

	public final nextgen.st.model.STModel model;
	public final nextgen.st.model.STProject project;
	public final nextgen.st.model.STTemplate template;

	public NewSTProjectSTModel(nextgen.st.model.STModel model, nextgen.st.model.STProject project, nextgen.st.model.STTemplate template) {
		this.model = model;
		this.project = project;
		this.template = template;
	}
}