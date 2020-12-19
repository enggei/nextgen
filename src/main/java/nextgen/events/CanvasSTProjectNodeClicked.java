package nextgen.events;

public final class CanvasSTProjectNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CanvasSTProjectNodeClicked.class);

	public static void post(nextgen.model.STProject stProject) {
		log.info("CanvasSTProjectNodeClicked" + " stProject");
		org.greenrobot.eventbus.EventBus.getDefault().post(new CanvasSTProjectNodeClicked(stProject));
	}

	public final nextgen.model.STProject stProject;

	public CanvasSTProjectNodeClicked(nextgen.model.STProject stProject) {
		this.stProject = stProject;
	}
}