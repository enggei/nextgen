package nextgen.events;

public final class ModelEditorSTTemplateTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelEditorSTTemplateTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STTemplate stTemplate) {
		log.info("post ModelEditorSTTemplateTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelEditorSTTemplateTreeNodeClicked(stTemplate));
	}

	public final nextgen.st.domain.STTemplate stTemplate;

	public ModelEditorSTTemplateTreeNodeClicked(nextgen.st.domain.STTemplate stTemplate) {
		this.stTemplate = stTemplate;
	}
}