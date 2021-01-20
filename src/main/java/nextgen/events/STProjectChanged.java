package nextgen.events;

public final class STProjectChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STProjectChanged.class);

	public static void post(nextgen.model.STProject sTProject) {
		log.info("STProjectChanged" + " sTProject");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STProjectChanged(sTProject));
	}

	public final nextgen.model.STProject sTProject;

	public STProjectChanged(nextgen.model.STProject sTProject) {
		this.sTProject = sTProject;
	}
}  