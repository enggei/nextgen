package nextgen.events;

public final class DomainEntityDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainEntityDeleted.class);

	public static void post(String uuid) {
		log.info("DomainEntityDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainEntityDeleted(uuid));
	}

	public final String uuid;

	public DomainEntityDeleted(String uuid) {
		this.uuid = uuid;
	}
}  