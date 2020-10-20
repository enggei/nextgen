package nextgen.events;

public final class STInterfaceDeleted {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STInterfaceDeleted.class);

	public static void post(nextgen.st.domain.STInterface stInterface) {
		log.info("post STInterfaceDeleted");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STInterfaceDeleted(stInterface));
	}

	public final nextgen.st.domain.STInterface stInterface;

	public STInterfaceDeleted(nextgen.st.domain.STInterface stInterface) {
		this.stInterface = stInterface;
	}
}