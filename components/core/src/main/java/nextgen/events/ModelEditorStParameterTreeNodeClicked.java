package nextgen.events;

public final class ModelEditorStParameterTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelEditorStParameterTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STParameter stParameter, nextgen.st.model.STModel stModel) {
		log.info("post ModelEditorStParameterTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelEditorStParameterTreeNodeClicked(stParameter, stModel));
	}

	public final nextgen.st.domain.STParameter stParameter;
	public final nextgen.st.model.STModel stModel;

	public ModelEditorStParameterTreeNodeClicked(nextgen.st.domain.STParameter stParameter, nextgen.st.model.STModel stModel) {
		this.stParameter = stParameter;
		this.stModel = stModel;
	}
}