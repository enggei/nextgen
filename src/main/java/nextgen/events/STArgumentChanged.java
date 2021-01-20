package nextgen.events;

public final class STArgumentChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STArgumentChanged.class);

	public static void post(nextgen.model.STArgument sTArgument) {
		log.info("STArgumentChanged" + " sTArgument");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STArgumentChanged(sTArgument));
	}

	public final nextgen.model.STArgument sTArgument;

	public STArgumentChanged(nextgen.model.STArgument sTArgument) {
		this.sTArgument = sTArgument;
	}
}  