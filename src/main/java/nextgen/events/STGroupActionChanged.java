package nextgen.events;

public final class STGroupActionChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupActionChanged.class);

	public static void post(nextgen.st.model.STGroupAction action) {
		//log.info("post STGroupActionChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupActionChanged(action));
	}

	public final nextgen.st.model.STGroupAction action;

	public STGroupActionChanged(nextgen.st.model.STGroupAction action) {
		this.action = action;
	}
}