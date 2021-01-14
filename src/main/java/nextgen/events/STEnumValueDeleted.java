package nextgen.events;

public final class STEnumValueDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STEnumValueDeleted.class);

	public static void post(String uuid) {
		log.info("STEnumValueDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STEnumValueDeleted(uuid));
	}

	public final String uuid;

	public STEnumValueDeleted(String uuid) {
		this.uuid = uuid;
	}
}  