package nextgen.events;

public final class ModelNavigatorSTParameterTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorSTParameterTreeNodeClicked.class);

	public static void post(nextgen.st.model.STParameter stParmeter) {
		log.info("post ModelNavigatorSTParameterTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorSTParameterTreeNodeClicked(stParmeter));
	}

	public final nextgen.st.model.STParameter stParmeter;

	public ModelNavigatorSTParameterTreeNodeClicked(nextgen.st.model.STParameter stParmeter) {
		this.stParmeter = stParmeter;
	}
}