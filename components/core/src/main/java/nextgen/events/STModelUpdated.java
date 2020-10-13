package nextgen.events;

public final class STModelUpdated {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelUpdated.class);

	public static void post(nextgen.st.model.STModel model) {
		log.info("post STModelUpdated");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STModelUpdated(model));
	}

	public final nextgen.st.model.STModel model;

	public STModelUpdated(nextgen.st.model.STModel model) {
		this.model = model;
	}
}