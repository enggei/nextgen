package nextgen.events;

public final class ModelEditorStTemplateTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelEditorStTemplateTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STTemplate stTemplate) {
		log.info("post ModelEditorStTemplateTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelEditorStTemplateTreeNodeClicked(stTemplate));
	}

	public final nextgen.st.domain.STTemplate stTemplate;

	public ModelEditorStTemplateTreeNodeClicked(nextgen.st.domain.STTemplate stTemplate) {
		this.stTemplate = stTemplate;
	}
}