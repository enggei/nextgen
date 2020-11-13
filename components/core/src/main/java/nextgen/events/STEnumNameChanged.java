package nextgen.events;

public final class STEnumNameChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STEnumNameChanged.class);

	public static void post(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STEnum stEnum) {
		log.info("post STEnumNameChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STEnumNameChanged(stGroup, stEnum));
	}

	public final nextgen.st.model.STGroupModel stGroup;
	public final nextgen.st.model.STEnum stEnum;

	public STEnumNameChanged(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STEnum stEnum) {
		this.stGroup = stGroup;
		this.stEnum = stEnum;
	}
}