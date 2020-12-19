package nextgen.events;

public final class NewSTInterface {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTInterface.class);

	public static void post(nextgen.model.STGroupModel stGroup, nextgen.model.STInterface stInterface) {
		log.info("NewSTInterface" + " stGroup" + " stInterface");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTInterface(stGroup, stInterface));
	}

	public final nextgen.model.STGroupModel stGroup;
	public final nextgen.model.STInterface stInterface;

	public NewSTInterface(nextgen.model.STGroupModel stGroup, nextgen.model.STInterface stInterface) {
		this.stGroup = stGroup;
		this.stInterface = stInterface;
	}
}