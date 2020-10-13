package nextgen.events;

public final class NewSTInterface {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTInterface.class);

	public static void post(nextgen.st.domain.STInterface model) {
		log.info("post NewSTInterface");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTInterface(model));
	}

	public final nextgen.st.domain.STInterface model;

	public NewSTInterface(nextgen.st.domain.STInterface model) {
		this.model = model;
	}
}