package nextgen.events;

public final class NewSTProject {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTProject.class);

	public static void post(nextgen.st.model.STProject project) {
		log.info("post NewSTProject");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTProject(project));
	}

	public final nextgen.st.model.STProject project;

	public NewSTProject(nextgen.st.model.STProject project) {
		this.project = project;
	}
}