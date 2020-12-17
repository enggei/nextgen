package nextgen.events;

public final class KVDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(KVDeleted.class);

	public static void post(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, String uuid) {
		System.out.println("KVDeleted" + " stModel" + " stArgument" + " uuid");
		org.greenrobot.eventbus.EventBus.getDefault().post(new KVDeleted(stModel, stArgument, uuid));
	}

	public final nextgen.model.STModel stModel;
	public final nextgen.model.STArgument stArgument;
	public final String uuid;

	public KVDeleted(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, String uuid) {
		this.stModel = stModel;
		this.stArgument = stArgument;
		this.uuid = uuid;
	}
}