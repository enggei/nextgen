package nextgen.events;

public final class STEnumTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STEnumTreeNodeClicked.class);

	public static void post(nextgen.model.STGroupModel stGroup, nextgen.model.STEnum stEnum) {
		log.info("STEnumTreeNodeClicked" + " stGroup" + " stEnum");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STEnumTreeNodeClicked(stGroup, stEnum));
	}

	public final nextgen.model.STGroupModel stGroup;
	public final nextgen.model.STEnum stEnum;

	public STEnumTreeNodeClicked(nextgen.model.STGroupModel stGroup, nextgen.model.STEnum stEnum) {
		this.stGroup = stGroup;
		this.stEnum = stEnum;
	}
}