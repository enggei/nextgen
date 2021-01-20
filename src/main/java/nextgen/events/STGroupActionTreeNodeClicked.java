package nextgen.events;

public final class STGroupActionTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupActionTreeNodeClicked.class);

	public static void post(nextgen.model.STGroupAction action) {
		log.info("STGroupActionTreeNodeClicked" + " action");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupActionTreeNodeClicked(action));
	}

	public final nextgen.model.STGroupAction action;

	public STGroupActionTreeNodeClicked(nextgen.model.STGroupAction action) {
		this.action = action;
	}
}