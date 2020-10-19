package nextgen.events;

public final class STFileUpdated {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STFileUpdated.class);

	public static void post(nextgen.st.model.STFile model) {
		log.info("post STFileUpdated");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STFileUpdated(model));
	}

	public final nextgen.st.model.STFile model;

	public STFileUpdated(nextgen.st.model.STFile model) {
		this.model = model;
	}
}