package nextgen.events;

public final class STModelDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelDeleted.class);

	public static void post(String uuid) {
		log.info("STModelDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STModelDeleted(uuid));
	}

	public final String uuid;

	public STModelDeleted(String uuid) {
		this.uuid = uuid;
	}
}