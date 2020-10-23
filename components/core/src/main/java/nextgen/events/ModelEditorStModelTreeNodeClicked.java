package nextgen.events;

public final class ModelEditorStModelTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelEditorStModelTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STModel stModel) {
		log.info("post ModelEditorStModelTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelEditorStModelTreeNodeClicked(stTemplate, stModel));
	}

	public final nextgen.st.domain.STTemplate stTemplate;
	public final nextgen.st.model.STModel stModel;

	public ModelEditorStModelTreeNodeClicked(nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STModel stModel) {
		this.stTemplate = stTemplate;
		this.stModel = stModel;
	}
}