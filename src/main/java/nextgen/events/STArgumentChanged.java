package nextgen.events;

public final class STArgumentChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STArgumentChanged.class);

	public static void post(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument) {
		log.info("STArgumentChanged" + " stModel" + " stArgument");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STArgumentChanged(stModel, stArgument));
	}

	public final nextgen.model.STModel stModel;
	public final nextgen.model.STArgument stArgument;

	public STArgumentChanged(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument) {
		this.stModel = stModel;
		this.stArgument = stArgument;
	}
}