package nextgen.events;

public final class ModelNavigatorSTProjectTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorSTProjectTreeNodeClicked.class);

	public static void post(nextgen.model.STProject stProject) {
		log.info("ModelNavigatorSTProjectTreeNodeClicked" + " stProject");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorSTProjectTreeNodeClicked(stProject));
	}

	public final nextgen.model.STProject stProject;

	public ModelNavigatorSTProjectTreeNodeClicked(nextgen.model.STProject stProject) {
		this.stProject = stProject;
	}
}