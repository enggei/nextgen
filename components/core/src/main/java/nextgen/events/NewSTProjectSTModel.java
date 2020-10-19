package nextgen.events;

public final class NewSTProjectSTModel {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTProjectSTModel.class);

	public static void post(nextgen.st.model.STModel stModel, nextgen.st.model.STProject stProject) {
		log.info("post NewSTProjectSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTProjectSTModel(stModel, stProject));
	}

	public final nextgen.st.model.STModel stModel;
	public final nextgen.st.model.STProject stProject;

	public NewSTProjectSTModel(nextgen.st.model.STModel stModel, nextgen.st.model.STProject stProject) {
		this.stModel = stModel;
		this.stProject = stProject;
	}
}