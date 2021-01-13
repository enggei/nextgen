package nextgen.events;

public final class STFileTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STFileTreeNodeClicked.class);

	public static void post(nextgen.model.STFile stFile) {
		log.info("STFileTreeNodeClicked" + " stFile");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STFileTreeNodeClicked(stFile));
	}

	public final nextgen.model.STFile stFile;

	public STFileTreeNodeClicked(nextgen.model.STFile stFile) {
		this.stFile = stFile;
	}
}