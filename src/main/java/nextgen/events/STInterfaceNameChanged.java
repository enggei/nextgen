package nextgen.events;

public final class STInterfaceNameChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STInterfaceNameChanged.class);

	public static void post(nextgen.model.STGroupModel stGroup, nextgen.model.STInterface stInterface) {
		//log.info("post STInterfaceNameChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STInterfaceNameChanged(stGroup, stInterface));
	}

	public final nextgen.model.STGroupModel stGroup;
	public final nextgen.model.STInterface stInterface;

	public STInterfaceNameChanged(nextgen.model.STGroupModel stGroup, nextgen.model.STInterface stInterface) {
		this.stGroup = stGroup;
		this.stInterface = stInterface;
	}
}