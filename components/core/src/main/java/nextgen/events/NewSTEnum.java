package nextgen.events;

public final class NewSTEnum {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTEnum.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STEnum stEnum) {
		log.info("post NewSTEnum");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTEnum(stGroup, stEnum));
	}

	public final nextgen.st.domain.STGroupModel stGroup;
	public final nextgen.st.domain.STEnum stEnum;

	public NewSTEnum(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STEnum stEnum) {
		this.stGroup = stGroup;
		this.stEnum = stEnum;
	}
}