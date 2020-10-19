package nextgen.events;

public final class STValueUpdated {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STValueUpdated.class);

	public static void post(nextgen.st.model.STValue model) {
		log.info("post STValueUpdated");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STValueUpdated(model));
	}

	public final nextgen.st.model.STValue model;

	public STValueUpdated(nextgen.st.model.STValue model) {
		this.model = model;
	}
}