package nextgen.events;

public final class STGroupFileChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupFileChanged.class);

	public static void post(nextgen.model.STGroupFile model) {
		log.info("STGroupFileChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupFileChanged(model));
	}

	public final nextgen.model.STGroupFile model;

	public STGroupFileChanged(nextgen.model.STGroupFile model) {
		this.model = model;
	}
}  