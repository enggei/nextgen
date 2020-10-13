package nextgen.events;

public final class NewSTValue {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTValue.class);

	public static void post(nextgen.st.model.STValue model) {
		log.info("post NewSTValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTValue(model));
	}

	public final nextgen.st.model.STValue model;

	public NewSTValue(nextgen.st.model.STValue model) {
		this.model = model;
	}
}