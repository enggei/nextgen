package nextgen.events;

public final class STTemplateDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateDeleted.class);

	public static void post(String uuid) {
		System.out.println("STTemplateDeleted" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateDeleted(uuid));
	}

	public final String uuid;

	public STTemplateDeleted(String uuid) {
		this.uuid = uuid;
	}
}