package nextgen.events;

public final class STInterfaceNameChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STInterfaceNameChanged.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STInterface stInterface) {
		log.info("post STInterfaceNameChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STInterfaceNameChanged(stGroup, stInterface));
	}

	public final nextgen.st.domain.STGroupModel stGroup;
	public final nextgen.st.domain.STInterface stInterface;

	public STInterfaceNameChanged(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STInterface stInterface) {
		this.stGroup = stGroup;
		this.stInterface = stInterface;
	}
}