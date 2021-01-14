package nextgen.events;

public final class STArgumentKVDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STArgumentKVDeleted.class);

	public static void post(String uuid) {
		log.info("STArgumentKVDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STArgumentKVDeleted(uuid));
	}

	public final String uuid;

	public STArgumentKVDeleted(String uuid) {
		this.uuid = uuid;
	}
}  