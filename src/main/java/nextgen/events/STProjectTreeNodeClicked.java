package nextgen.events;

public final class STProjectTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STProjectTreeNodeClicked.class);

	public static void post(nextgen.model.STProject stProject) {
		log.info("STProjectTreeNodeClicked" + " stProject");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STProjectTreeNodeClicked(stProject));
	}

	public final nextgen.model.STProject stProject;

	public STProjectTreeNodeClicked(nextgen.model.STProject stProject) {
		this.stProject = stProject;
	}
}