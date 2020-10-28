package nextgen.events;

public final class ModelEditorSTFileTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelEditorSTFileTreeNodeClicked.class);

	public static void post(nextgen.st.model.STFile stFile) {
		log.info("post ModelEditorSTFileTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelEditorSTFileTreeNodeClicked(stFile));
	}

	public final nextgen.st.model.STFile stFile;

	public ModelEditorSTFileTreeNodeClicked(nextgen.st.model.STFile stFile) {
		this.stFile = stFile;
	}
}