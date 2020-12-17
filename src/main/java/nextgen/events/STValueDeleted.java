package nextgen.events;

public final class STValueDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STValueDeleted.class);

	public static void post(String uuid) {
		System.out.println("STValueDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STValueDeleted(uuid));
	}

	public final String uuid;

	public STValueDeleted(String uuid) {
		this.uuid = uuid;
	}
}