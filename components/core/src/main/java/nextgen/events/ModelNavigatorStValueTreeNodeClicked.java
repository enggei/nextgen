package nextgen.events;

public final class ModelNavigatorStValueTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorStValueTreeNodeClicked.class);

	public static void post(nextgen.st.model.STValue stValue) {
		log.info("post ModelNavigatorStValueTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorStValueTreeNodeClicked(stValue));
	}

	public final nextgen.st.model.STValue stValue;

	public ModelNavigatorStValueTreeNodeClicked(nextgen.st.model.STValue stValue) {
		this.stValue = stValue;
	}
}