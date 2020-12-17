package nextgen.events;

public final class STFileDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STFileDeleted.class);

	public static void post(String uuid) {
		System.out.println("STFileDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STFileDeleted(uuid));
	}

	public final String uuid;

	public STFileDeleted(String uuid) {
		this.uuid = uuid;
	}
}