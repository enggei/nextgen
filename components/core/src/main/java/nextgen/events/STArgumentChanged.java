package nextgen.events;

public final class STArgumentChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STArgumentChanged.class);

	public static void post(nextgen.st.model.STModel stModel, nextgen.st.model.STArgument stArgument) {
		//log.info("post STArgumentChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STArgumentChanged(stModel, stArgument));
	}

	public final nextgen.st.model.STModel stModel;
	public final nextgen.st.model.STArgument stArgument;

	public STArgumentChanged(nextgen.st.model.STModel stModel, nextgen.st.model.STArgument stArgument) {
		this.stModel = stModel;
		this.stArgument = stArgument;
	}
}