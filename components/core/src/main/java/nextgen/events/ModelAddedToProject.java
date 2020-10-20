package nextgen.events;

public final class ModelAddedToProject {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelAddedToProject.class);

	public static void post(nextgen.st.model.STModel stModel, nextgen.st.model.STProject project) {
		log.info("post ModelAddedToProject");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelAddedToProject(stModel, project));
	}

	public final nextgen.st.model.STModel stModel;
	public final nextgen.st.model.STProject project;

	public ModelAddedToProject(nextgen.st.model.STModel stModel, nextgen.st.model.STProject project) {
		this.stModel = stModel;
		this.project = project;
	}
}