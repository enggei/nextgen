package nextgen.events;

public final class STGroupTagsChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupTagsChanged.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup) {
		log.info("post STGroupTagsChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupTagsChanged(stGroup));
	}

	public final nextgen.st.domain.STGroupModel stGroup;

	public STGroupTagsChanged(nextgen.st.domain.STGroupModel stGroup) {
		this.stGroup = stGroup;
	}
}