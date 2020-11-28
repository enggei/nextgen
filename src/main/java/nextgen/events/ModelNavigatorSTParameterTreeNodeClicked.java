package nextgen.events;

public final class ModelNavigatorSTParameterTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorSTParameterTreeNodeClicked.class);

	public static void post(nextgen.st.model.STParameter stParameter) {
		//log.info("post ModelNavigatorSTParameterTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorSTParameterTreeNodeClicked(stParameter));
	}

	public final nextgen.st.model.STParameter stParameter;

	public ModelNavigatorSTParameterTreeNodeClicked(nextgen.st.model.STParameter stParameter) {
		this.stParameter = stParameter;
	}
}