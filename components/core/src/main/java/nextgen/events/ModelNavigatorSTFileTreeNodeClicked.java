package nextgen.events;

public final class ModelNavigatorSTFileTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorSTFileTreeNodeClicked.class);

	public static void post(nextgen.st.model.STFile stFile) {
		log.info("post ModelNavigatorSTFileTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorSTFileTreeNodeClicked(stFile));
	}

	public final nextgen.st.model.STFile stFile;

	public ModelNavigatorSTFileTreeNodeClicked(nextgen.st.model.STFile stFile) {
		this.stFile = stFile;
	}
}