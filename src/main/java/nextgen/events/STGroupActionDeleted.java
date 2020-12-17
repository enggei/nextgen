package nextgen.events;

public final class STGroupActionDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupActionDeleted.class);

	public static void post(String uuid) {
		System.out.println("STGroupActionDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupActionDeleted(uuid));
	}

	public final String uuid;

	public STGroupActionDeleted(String uuid) {
		this.uuid = uuid;
	}
}