package nextgen.events;

public final class DomainPropertyDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainPropertyDeleted.class);

	public static void post(String uuid) {
		log.info("DomainPropertyDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainPropertyDeleted(uuid));
	}

	public final String uuid;

	public DomainPropertyDeleted(String uuid) {
		this.uuid = uuid;
	}
}