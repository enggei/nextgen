package nextgen.events;

public final class STEnumDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STEnumDeleted.class);

	public static void post(String uuid) {
		//log.info("post STEnumDeleted");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STEnumDeleted(uuid));
	}

	public final String uuid;

	public STEnumDeleted(String uuid) {
		this.uuid = uuid;
	}
}