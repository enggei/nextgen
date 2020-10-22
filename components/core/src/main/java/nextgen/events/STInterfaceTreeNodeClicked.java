package nextgen.events;

public final class STInterfaceTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STInterfaceTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STInterface stInterface) {
		log.info("post STInterfaceTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STInterfaceTreeNodeClicked(stGroup, stInterface));
	}

	public final nextgen.st.domain.STGroupModel stGroup;
	public final nextgen.st.domain.STInterface stInterface;

	public STInterfaceTreeNodeClicked(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STInterface stInterface) {
		this.stGroup = stGroup;
		this.stInterface = stInterface;
	}
}