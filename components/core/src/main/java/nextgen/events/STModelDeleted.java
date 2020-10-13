package nextgen.events;

public final class STModelDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelDeleted.class);

	public static void post(String model) {
		log.info("post STModelDeleted");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STModelDeleted(model));
	}

	public final String model;

	public STModelDeleted(String model) {
		this.model = model;
	}
}