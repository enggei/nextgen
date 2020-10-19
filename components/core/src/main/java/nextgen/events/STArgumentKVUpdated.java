package nextgen.events;

public final class STArgumentKVUpdated {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STArgumentKVUpdated.class);

	public static void post(nextgen.st.model.STArgumentKV model) {
		log.info("post STArgumentKVUpdated");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STArgumentKVUpdated(model));
	}

	public final nextgen.st.model.STArgumentKV model;

	public STArgumentKVUpdated(nextgen.st.model.STArgumentKV model) {
		this.model = model;
	}
}