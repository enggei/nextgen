package nextgen.events;

public final class STParameterKeyDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STParameterKeyDeleted.class);

	public static void post(String uuid) {
		log.info("STParameterKeyDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STParameterKeyDeleted(uuid));
	}

	public final String uuid;

	public STParameterKeyDeleted(String uuid) {
		this.uuid = uuid;
	}
}  