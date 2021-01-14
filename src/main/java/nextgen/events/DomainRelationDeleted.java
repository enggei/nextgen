package nextgen.events;

public final class DomainRelationDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainRelationDeleted.class);

	public static void post(String uuid) {
		log.info("DomainRelationDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainRelationDeleted(uuid));
	}

	public final String uuid;

	public DomainRelationDeleted(String uuid) {
		this.uuid = uuid;
	}
}  