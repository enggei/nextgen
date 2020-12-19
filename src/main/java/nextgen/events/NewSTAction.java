package nextgen.events;

public final class NewSTAction {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTAction.class);

	public static void post(nextgen.model.STGroupAction action, nextgen.model.STGroupModel stGroup) {
		log.info("NewSTAction" + " action" + " stGroup");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTAction(action, stGroup));
	}

	public final nextgen.model.STGroupAction action;
	public final nextgen.model.STGroupModel stGroup;

	public NewSTAction(nextgen.model.STGroupAction action, nextgen.model.STGroupModel stGroup) {
		this.action = action;
		this.stGroup = stGroup;
	}
}