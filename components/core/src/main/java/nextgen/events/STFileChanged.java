package nextgen.events;

public final class STFileChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STFileChanged.class);

	public static void post(nextgen.st.model.STFile stFile) {
		//log.info("post STFileChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STFileChanged(stFile));
	}

	public final nextgen.st.model.STFile stFile;

	public STFileChanged(nextgen.st.model.STFile stFile) {
		this.stFile = stFile;
	}
}