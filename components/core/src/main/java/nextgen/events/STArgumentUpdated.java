package nextgen.events;

public final class STArgumentUpdated {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STArgumentUpdated.class);

	public static void post(nextgen.st.model.STArgument model) {
		log.info("post STArgumentUpdated");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STArgumentUpdated(model));
	}

	public final nextgen.st.model.STArgument model;

	public STArgumentUpdated(nextgen.st.model.STArgument model) {
		this.model = model;
	}
}