package nextgen.events;

public final class STEnumNameChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STEnumNameChanged.class);

	public static void post(nextgen.model.STGroupModel stGroup, nextgen.model.STEnum stEnum) {
		//log.info("post STEnumNameChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STEnumNameChanged(stGroup, stEnum));
	}

	public final nextgen.model.STGroupModel stGroup;
	public final nextgen.model.STEnum stEnum;

	public STEnumNameChanged(nextgen.model.STGroupModel stGroup, nextgen.model.STEnum stEnum) {
		this.stGroup = stGroup;
		this.stEnum = stEnum;
	}
}