package nextgen.events;

public final class ModelNavigatorSTProjectTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorSTProjectTreeNodeClicked.class);

	public static void post(nextgen.st.model.STProject stProject) {
		//log.info("post ModelNavigatorSTProjectTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorSTProjectTreeNodeClicked(stProject));
	}

	public final nextgen.st.model.STProject stProject;

	public ModelNavigatorSTProjectTreeNodeClicked(nextgen.st.model.STProject stProject) {
		this.stProject = stProject;
	}
}