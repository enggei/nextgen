package nextgen.events;

public final class ModelEditorStValueTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelEditorStValueTreeNodeClicked.class);

	public static void post(nextgen.st.model.STValue stValue) {
		log.info("post ModelEditorStValueTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelEditorStValueTreeNodeClicked(stValue));
	}

	public final nextgen.st.model.STValue stValue;

	public ModelEditorStValueTreeNodeClicked(nextgen.st.model.STValue stValue) {
		this.stValue = stValue;
	}
}