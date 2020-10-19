package nextgen.events;

public final class NewSTArgumentKV {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(nextgen.events.NewSTArgumentKV.class);

	public static void post(nextgen.st.model.STArgumentKV model) {
		log.info("post NewSTArgumentKV");
		org.greenrobot.eventbus.EventBus.getDefault().post(new nextgen.events.NewSTArgumentKV(model));
	}

	public final nextgen.st.model.STArgumentKV model;

	public NewSTArgumentKV(nextgen.st.model.STArgumentKV model) {
		this.model = model;
	}
}