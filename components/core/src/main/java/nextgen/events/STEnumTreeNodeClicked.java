package nextgen.events;

public final class STEnumTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STEnumTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STEnum stEnum) {
		log.info("post STEnumTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STEnumTreeNodeClicked(stGroup, stEnum));
	}

	public final nextgen.st.domain.STGroupModel stGroup;
	public final nextgen.st.domain.STEnum stEnum;

	public STEnumTreeNodeClicked(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STEnum stEnum) {
		this.stGroup = stGroup;
		this.stEnum = stEnum;
	}
}