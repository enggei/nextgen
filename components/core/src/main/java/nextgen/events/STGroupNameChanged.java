package nextgen.events;

public final class STGroupNameChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupNameChanged.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup) {
		log.info("post STGroupNameChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupNameChanged(stGroup));
	}

	public final nextgen.st.domain.STGroupModel stGroup;

	public STGroupNameChanged(nextgen.st.domain.STGroupModel stGroup) {
		this.stGroup = stGroup;
	}
}