package nextgen.events;

public final class NewSTAction {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTAction.class);

	public static void post(nextgen.st.model.STGroupAction action, nextgen.st.model.STGroupModel stGroup) {
		//log.info("post NewSTAction");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTAction(action, stGroup));
	}

	public final nextgen.st.model.STGroupAction action;
	public final nextgen.st.model.STGroupModel stGroup;

	public NewSTAction(nextgen.st.model.STGroupAction action, nextgen.st.model.STGroupModel stGroup) {
		this.action = action;
		this.stGroup = stGroup;
	}
}