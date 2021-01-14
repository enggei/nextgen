package nextgen.events;

public final class DomainVisitorDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainVisitorDeleted.class);

	public static void post(String uuid) {
		log.info("DomainVisitorDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainVisitorDeleted(uuid));
	}

	public final String uuid;

	public DomainVisitorDeleted(String uuid) {
		this.uuid = uuid;
	}
}  