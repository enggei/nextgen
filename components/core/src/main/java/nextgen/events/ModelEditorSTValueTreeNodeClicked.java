package nextgen.events;

public final class ModelEditorSTValueTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelEditorSTValueTreeNodeClicked.class);

	public static void post(nextgen.st.model.STValue stValue) {
		log.info("post ModelEditorSTValueTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelEditorSTValueTreeNodeClicked(stValue));
	}

	public final nextgen.st.model.STValue stValue;

	public ModelEditorSTValueTreeNodeClicked(nextgen.st.model.STValue stValue) {
		this.stValue = stValue;
	}
}