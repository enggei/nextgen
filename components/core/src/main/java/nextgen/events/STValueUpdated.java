package nextgen.events;

public final class STValueUpdated {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STValueUpdated.class);

	public static void post() {
		log.info("post STValueUpdated");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STValueUpdated());
	}


	public STValueUpdated() {
	}
}