package nextgen.events;

public final class STProjectDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STProjectDeleted.class);

	public static void post(String uuid) {
		log.info("STProjectDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STProjectDeleted(uuid));
	}

	public final String uuid;

	public STProjectDeleted(String uuid) {
		this.uuid = uuid;
	}
}  