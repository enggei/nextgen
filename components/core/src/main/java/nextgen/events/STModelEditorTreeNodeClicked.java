package nextgen.events;

public final class STModelEditorTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelEditorTreeNodeClicked.class);

	public static void post(nextgen.st.model.STModel model) {
		log.info("post STModelEditorTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STModelEditorTreeNodeClicked(model));
	}

	public final nextgen.st.model.STModel model;

	public STModelEditorTreeNodeClicked(nextgen.st.model.STModel model) {
		this.model = model;
	}
}