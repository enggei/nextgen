package nextgen.events;

public final class STParameterEditorTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STParameterEditorTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STParameter stParameter, nextgen.st.model.STModel stModel) {
		log.info("post STParameterEditorTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STParameterEditorTreeNodeClicked(stParameter, stModel));
	}

	public final nextgen.st.domain.STParameter stParameter;
	public final nextgen.st.model.STModel stModel;

	public STParameterEditorTreeNodeClicked(nextgen.st.domain.STParameter stParameter, nextgen.st.model.STModel stModel) {
		this.stParameter = stParameter;
		this.stModel = stModel;
	}
}