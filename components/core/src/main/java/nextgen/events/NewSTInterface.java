package nextgen.events;

public final class NewSTInterface {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTInterface.class);

	public static void post(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STInterface stInterface) {
		log.info("post NewSTInterface");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTInterface(stGroup, stInterface));
	}

	public final nextgen.st.model.STGroupModel stGroup;
	public final nextgen.st.model.STInterface stInterface;

	public NewSTInterface(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STInterface stInterface) {
		this.stGroup = stGroup;
		this.stInterface = stInterface;
	}
}