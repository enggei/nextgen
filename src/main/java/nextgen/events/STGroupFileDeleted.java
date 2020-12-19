package nextgen.events;

public final class STGroupFileDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupFileDeleted.class);

	public static void post(String uuid) {
		log.info("STGroupFileDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupFileDeleted(uuid));
	}

	public final String uuid;

	public STGroupFileDeleted(String uuid) {
		this.uuid = uuid;
	}
}