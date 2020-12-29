package nextgen.events;

public final class STKVArgumentChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STKVArgumentChanged.class);

	public static void post(nextgen.model.STArgumentKV stArgument, nextgen.model.STModel stModel) {
		log.info("STKVArgumentChanged" + " stArgument" + " stModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STKVArgumentChanged(stArgument, stModel));
	}

	public final nextgen.model.STArgumentKV stArgument;
	public final nextgen.model.STModel stModel;

	public STKVArgumentChanged(nextgen.model.STArgumentKV stArgument, nextgen.model.STModel stModel) {
		this.stArgument = stArgument;
		this.stModel = stModel;
	}
}