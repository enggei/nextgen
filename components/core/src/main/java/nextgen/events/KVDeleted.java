package nextgen.events;

public final class KVDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(KVDeleted.class);

	public static void post(nextgen.st.model.STModel stModel, nextgen.st.model.STArgument stArgument, String uuid) {
		//log.info("post KVDeleted");
		org.greenrobot.eventbus.EventBus.getDefault().post(new KVDeleted(stModel, stArgument, uuid));
	}

	public final nextgen.st.model.STModel stModel;
	public final nextgen.st.model.STArgument stArgument;
	public final String uuid;

	public KVDeleted(nextgen.st.model.STModel stModel, nextgen.st.model.STArgument stArgument, String uuid) {
		this.stModel = stModel;
		this.stArgument = stArgument;
		this.uuid = uuid;
	}
}