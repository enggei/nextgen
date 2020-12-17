package nextgen.events;

public final class ShowSTProjectInCanvas {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ShowSTProjectInCanvas.class);

	public static void post(nextgen.model.STProject stProject) {
		System.out.println("ShowSTProjectInCanvas" + " stProject");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ShowSTProjectInCanvas(stProject));
	}

	public final nextgen.model.STProject stProject;

	public ShowSTProjectInCanvas(nextgen.model.STProject stProject) {
		this.stProject = stProject;
	}
}