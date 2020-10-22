package nextgen.events;

public final class NewSTInterface {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTInterface.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STInterface stInterface) {
		log.info("post NewSTInterface");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTInterface(stGroup, stInterface));
	}

	public final nextgen.st.domain.STGroupModel stGroup;
	public final nextgen.st.domain.STInterface stInterface;

	public NewSTInterface(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STInterface stInterface) {
		this.stGroup = stGroup;
		this.stInterface = stInterface;
	}
}