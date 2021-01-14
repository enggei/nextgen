package nextgen.events;

public final class STArgumentDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STArgumentDeleted.class);

	public static void post(String uuid) {
		log.info("STArgumentDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STArgumentDeleted(uuid));
	}

	public final String uuid;

	public STArgumentDeleted(String uuid) {
		this.uuid = uuid;
	}
}  