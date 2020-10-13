package nextgen.events;

public final class OpenSTValue {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(OpenSTValue.class);

	public static void post(nextgen.st.model.STValue model) {
		log.info("post OpenSTValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenSTValue(model));
	}

	public final nextgen.st.model.STValue model;

	public OpenSTValue(nextgen.st.model.STValue model) {
		this.model = model;
	}
}