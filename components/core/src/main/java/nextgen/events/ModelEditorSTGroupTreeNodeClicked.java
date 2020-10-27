package nextgen.events;

public final class ModelEditorSTGroupTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelEditorSTGroupTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup) {
		log.info("post ModelEditorSTGroupTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelEditorSTGroupTreeNodeClicked(stGroup));
	}

	public final nextgen.st.domain.STGroupModel stGroup;

	public ModelEditorSTGroupTreeNodeClicked(nextgen.st.domain.STGroupModel stGroup) {
		this.stGroup = stGroup;
	}
}