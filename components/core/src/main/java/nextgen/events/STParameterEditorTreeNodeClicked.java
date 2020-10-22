package nextgen.events;

public final class STParameterEditorTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STParameterEditorTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STParameter parameter, nextgen.st.model.STModel model) {
		log.info("post STParameterEditorTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STParameterEditorTreeNodeClicked(parameter, model));
	}

	public final nextgen.st.domain.STParameter parameter;
	public final nextgen.st.model.STModel model;

	public STParameterEditorTreeNodeClicked(nextgen.st.domain.STParameter parameter, nextgen.st.model.STModel model) {
		this.parameter = parameter;
		this.model = model;
	}
}