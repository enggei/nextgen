package nextgen.events;

public final class NewFileSink {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewFileSink.class);

	public static void post(nextgen.st.model.STModel stModel, nextgen.st.model.STFile stFile) {
		//log.info("post NewFileSink");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewFileSink(stModel, stFile));
	}

	public final nextgen.st.model.STModel stModel;
	public final nextgen.st.model.STFile stFile;

	public NewFileSink(nextgen.st.model.STModel stModel, nextgen.st.model.STFile stFile) {
		this.stModel = stModel;
		this.stFile = stFile;
	}
}