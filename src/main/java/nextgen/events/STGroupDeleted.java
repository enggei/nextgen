package nextgen.events;

public final class STGroupDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupDeleted.class);

	public static void post(String uuid) {
		System.out.println("STGroupDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupDeleted(uuid));
	}

	public final String uuid;

	public STGroupDeleted(String uuid) {
		this.uuid = uuid;
	}
}