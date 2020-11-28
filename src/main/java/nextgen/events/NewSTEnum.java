package nextgen.events;

public final class NewSTEnum {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTEnum.class);

	public static void post(nextgen.model.STGroupModel stGroup, nextgen.model.STEnum stEnum) {
		//log.info("post NewSTEnum");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTEnum(stGroup, stEnum));
	}

	public final nextgen.model.STGroupModel stGroup;
	public final nextgen.model.STEnum stEnum;

	public NewSTEnum(nextgen.model.STGroupModel stGroup, nextgen.model.STEnum stEnum) {
		this.stGroup = stGroup;
		this.stEnum = stEnum;
	}
}