package nextgen.events;

public final class STGroupFileChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupFileChanged.class);

	public static void post(nextgen.model.STGroupFile sTGroupFile) {
		log.info("STGroupFileChanged" + " sTGroupFile");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupFileChanged(sTGroupFile));
	}

	public final nextgen.model.STGroupFile sTGroupFile;

	public STGroupFileChanged(nextgen.model.STGroupFile sTGroupFile) {
		this.sTGroupFile = sTGroupFile;
	}
}  