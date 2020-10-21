package nextgen.events;

public final class NewSTProjectSTModel {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTProjectSTModel.class);

	public static void post(nextgen.st.model.STModel model, nextgen.st.model.STProject project) {
		log.info("post NewSTProjectSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTProjectSTModel(model, project));
	}

	public final nextgen.st.model.STModel model;
	public final nextgen.st.model.STProject project;

	public NewSTProjectSTModel(nextgen.st.model.STModel model, nextgen.st.model.STProject project) {
		this.model = model;
		this.project = project;
	}
}