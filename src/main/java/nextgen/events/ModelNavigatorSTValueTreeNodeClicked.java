package nextgen.events;

public final class ModelNavigatorSTValueTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorSTValueTreeNodeClicked.class);

	public static void post(nextgen.st.model.STValue stValue) {
		//log.info("post ModelNavigatorSTValueTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorSTValueTreeNodeClicked(stValue));
	}

	public final nextgen.st.model.STValue stValue;

	public ModelNavigatorSTValueTreeNodeClicked(nextgen.st.model.STValue stValue) {
		this.stValue = stValue;
	}
}