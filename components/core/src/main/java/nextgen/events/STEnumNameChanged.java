package nextgen.events;

public final class STEnumNameChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STEnumNameChanged.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STEnum stEnum) {
		log.info("post STEnumNameChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STEnumNameChanged(stGroup, stEnum));
	}

	public final nextgen.st.domain.STGroupModel stGroup;
	public final nextgen.st.domain.STEnum stEnum;

	public STEnumNameChanged(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STEnum stEnum) {
		this.stGroup = stGroup;
		this.stEnum = stEnum;
	}
}