package nextgen.events;

public final class STProjectChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STProjectChanged.class);

	public static void post(nextgen.model.STProject model) {
		log.info("STProjectChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STProjectChanged(model));
	}

	public final nextgen.model.STProject model;

	public STProjectChanged(nextgen.model.STProject model) {
		this.model = model;
	}
}  