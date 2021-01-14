package nextgen.events;

public final class STFileChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STFileChanged.class);

	public static void post(nextgen.model.STFile model) {
		log.info("STFileChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STFileChanged(model));
	}

	public final nextgen.model.STFile model;

	public STFileChanged(nextgen.model.STFile model) {
		this.model = model;
	}
}  