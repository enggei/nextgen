package nextgen.events;

public final class STInterfaceNameChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STInterfaceNameChanged.class);

	public static void post(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STInterface stInterface) {
		log.info("post STInterfaceNameChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STInterfaceNameChanged(stGroup, stInterface));
	}

	public final nextgen.st.model.STGroupModel stGroup;
	public final nextgen.st.model.STInterface stInterface;

	public STInterfaceNameChanged(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STInterface stInterface) {
		this.stGroup = stGroup;
		this.stInterface = stInterface;
	}
}