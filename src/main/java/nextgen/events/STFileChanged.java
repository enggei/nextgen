package nextgen.events;

public final class STFileChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STFileChanged.class);

	public static void post(nextgen.model.STFile stFile) {
		log.info("STFileChanged" + " stFile");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STFileChanged(stFile));
	}

	public final nextgen.model.STFile stFile;

	public STFileChanged(nextgen.model.STFile stFile) {
		this.stFile = stFile;
	}
}