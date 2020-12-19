package nextgen.events;

public final class STGroupTagsChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupTagsChanged.class);

	public static void post(nextgen.model.STGroupModel stGroup) {
		log.info("STGroupTagsChanged" + " stGroup");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupTagsChanged(stGroup));
	}

	public final nextgen.model.STGroupModel stGroup;

	public STGroupTagsChanged(nextgen.model.STGroupModel stGroup) {
		this.stGroup = stGroup;
	}
}