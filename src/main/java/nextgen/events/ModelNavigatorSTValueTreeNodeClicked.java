package nextgen.events;

public final class ModelNavigatorSTValueTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorSTValueTreeNodeClicked.class);

	public static void post(nextgen.model.STValue stValue) {
		System.out.println("ModelNavigatorSTValueTreeNodeClicked" + " stValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorSTValueTreeNodeClicked(stValue));
	}

	public final nextgen.model.STValue stValue;

	public ModelNavigatorSTValueTreeNodeClicked(nextgen.model.STValue stValue) {
		this.stValue = stValue;
	}
}