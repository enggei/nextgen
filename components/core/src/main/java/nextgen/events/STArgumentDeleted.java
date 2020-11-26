package nextgen.events;

public final class STArgumentDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STArgumentDeleted.class);

	public static void post(nextgen.st.model.STModel stModel, String uuid) {
		//log.info("post STArgumentDeleted");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STArgumentDeleted(stModel, uuid));
	}

	public final nextgen.st.model.STModel stModel;
	public final String uuid;

	public STArgumentDeleted(nextgen.st.model.STModel stModel, String uuid) {
		this.stModel = stModel;
		this.uuid = uuid;
	}
}