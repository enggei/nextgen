package nextgen.events;

public final class STGroupModelDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupModelDeleted.class);

	public static void post(String uuid) {
		log.info("STGroupModelDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupModelDeleted(uuid));
	}

	public final String uuid;

	public STGroupModelDeleted(String uuid) {
		this.uuid = uuid;
	}
}  