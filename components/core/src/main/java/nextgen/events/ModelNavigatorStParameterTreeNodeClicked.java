package nextgen.events;

public final class ModelNavigatorStParameterTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorStParameterTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STParameter stParmeter) {
		log.info("post ModelNavigatorStParameterTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorStParameterTreeNodeClicked(stParmeter));
	}

	public final nextgen.st.domain.STParameter stParmeter;

	public ModelNavigatorStParameterTreeNodeClicked(nextgen.st.domain.STParameter stParmeter) {
		this.stParmeter = stParmeter;
	}
}