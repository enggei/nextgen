package nextgen.events;

public final class NewFileSink {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewFileSink.class);

	public static void post(nextgen.model.STModel stModel, nextgen.model.STFile stFile) {
		//log.info("post NewFileSink");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewFileSink(stModel, stFile));
	}

	public final nextgen.model.STModel stModel;
	public final nextgen.model.STFile stFile;

	public NewFileSink(nextgen.model.STModel stModel, nextgen.model.STFile stFile) {
		this.stModel = stModel;
		this.stFile = stFile;
	}
}