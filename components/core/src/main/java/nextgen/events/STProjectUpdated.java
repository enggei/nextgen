package nextgen.events;

public final class STProjectUpdated {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STProjectUpdated.class);

	public static void post(nextgen.st.model.STProject model) {
		log.info("post STProjectUpdated");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STProjectUpdated(model));
	}

	public final nextgen.st.model.STProject model;

	public STProjectUpdated(nextgen.st.model.STProject model) {
		this.model = model;
	}
}