package nextgen.events;

public final class STInterfaceDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STInterfaceDeleted.class);

	public static void post(String uuid) {
		System.out.println("STInterfaceDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STInterfaceDeleted(uuid));
	}

	public final String uuid;

	public STInterfaceDeleted(String uuid) {
		this.uuid = uuid;
	}
}