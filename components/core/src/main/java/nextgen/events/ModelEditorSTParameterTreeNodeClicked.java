package nextgen.events;

public final class ModelEditorSTParameterTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelEditorSTParameterTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STParameter stParameter, nextgen.st.model.STModel stModel) {
		log.info("post ModelEditorSTParameterTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelEditorSTParameterTreeNodeClicked(stParameter, stModel));
	}

	public final nextgen.st.domain.STParameter stParameter;
	public final nextgen.st.model.STModel stModel;

	public ModelEditorSTParameterTreeNodeClicked(nextgen.st.domain.STParameter stParameter, nextgen.st.model.STModel stModel) {
		this.stParameter = stParameter;
		this.stModel = stModel;
	}
}