package nextgen.events;

public final class STFileChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STFileChanged.class);

	public static void post(nextgen.model.STFile sTFile) {
		log.info("STFileChanged" + " sTFile");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STFileChanged(sTFile));
	}

	public final nextgen.model.STFile sTFile;

	public STFileChanged(nextgen.model.STFile sTFile) {
		this.sTFile = sTFile;
	}
}  