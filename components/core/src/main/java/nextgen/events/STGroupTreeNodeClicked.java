package nextgen.events;

public final class STGroupTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup) {
		log.info("post STGroupTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupTreeNodeClicked(stGroup));
	}

	public final nextgen.st.domain.STGroupModel stGroup;

	public STGroupTreeNodeClicked(nextgen.st.domain.STGroupModel stGroup) {
		this.stGroup = stGroup;
	}
}