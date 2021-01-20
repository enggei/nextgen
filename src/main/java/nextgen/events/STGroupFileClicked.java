package nextgen.events;

public final class STGroupFileClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupFileClicked.class);

	public static void post(nextgen.model.STGroupFile stGroupFile) {
		log.info("STGroupFileClicked" + " stGroupFile");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupFileClicked(stGroupFile));
	}

	public final nextgen.model.STGroupFile stGroupFile;

	public STGroupFileClicked(nextgen.model.STGroupFile stGroupFile) {
		this.stGroupFile = stGroupFile;
	}
}