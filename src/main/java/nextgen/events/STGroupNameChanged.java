package nextgen.events;

public final class STGroupNameChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupNameChanged.class);

	public static void post(nextgen.model.STGroupModel stGroup) {
		log.info("STGroupNameChanged" + " stGroup");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupNameChanged(stGroup));
	}

	public final nextgen.model.STGroupModel stGroup;

	public STGroupNameChanged(nextgen.model.STGroupModel stGroup) {
		this.stGroup = stGroup;
	}
}