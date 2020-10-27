package nextgen.events;

public final class ModelEditorSTModelTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelEditorSTModelTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STModel stModel) {
		log.info("post ModelEditorSTModelTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelEditorSTModelTreeNodeClicked(stTemplate, stModel));
	}

	public final nextgen.st.domain.STTemplate stTemplate;
	public final nextgen.st.model.STModel stModel;

	public ModelEditorSTModelTreeNodeClicked(nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STModel stModel) {
		this.stTemplate = stTemplate;
		this.stModel = stModel;
	}
}