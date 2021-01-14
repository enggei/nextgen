package nextgen.events;

public final class STParameterDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STParameterDeleted.class);

	public static void post(String uuid) {
		log.info("STParameterDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STParameterDeleted(uuid));
	}

	public final String uuid;

	public STParameterDeleted(String uuid) {
		this.uuid = uuid;
	}
}  