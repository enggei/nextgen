package nextgen.events;

public final class ModelNavigatorStProjectTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorStProjectTreeNodeClicked.class);

	public static void post(nextgen.st.model.STProject stProject) {
		log.info("post ModelNavigatorStProjectTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorStProjectTreeNodeClicked(stProject));
	}

	public final nextgen.st.model.STProject stProject;

	public ModelNavigatorStProjectTreeNodeClicked(nextgen.st.model.STProject stProject) {
		this.stProject = stProject;
	}
}