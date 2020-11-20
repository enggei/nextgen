package nextgen.events;

public final class STGroupFileChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupFileChanged.class);

	public static void post(nextgen.st.model.STGroupFile stGroupFile) {
		log.info("post STGroupFileChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupFileChanged(stGroupFile));
	}

	public final nextgen.st.model.STGroupFile stGroupFile;

	public STGroupFileChanged(nextgen.st.model.STGroupFile stGroupFile) {
		this.stGroupFile = stGroupFile;
	}
}