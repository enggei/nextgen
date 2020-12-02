package nextgen.events;

public final class ShowSTProjectInCanvas {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ShowSTProjectInCanvas.class);

	public static void post(nextgen.model.STProject stProject) {
		//log.info("post ShowSTProjectInCanvas");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ShowSTProjectInCanvas(stProject));
	}

	public final nextgen.model.STProject stProject;

	public ShowSTProjectInCanvas(nextgen.model.STProject stProject) {
		this.stProject = stProject;
	}
}