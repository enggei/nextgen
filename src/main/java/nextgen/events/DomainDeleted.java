package nextgen.events;

public final class DomainDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainDeleted.class);

	public static void post(String uuid) {
		log.info("DomainDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainDeleted(uuid));
	}

	public final String uuid;

	public DomainDeleted(String uuid) {
		this.uuid = uuid;
	}
}  