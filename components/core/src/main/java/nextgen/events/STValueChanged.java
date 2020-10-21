package nextgen.events;

public final class STValueChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STValueChanged.class);

	public static void post(nextgen.st.model.STValue value) {
		log.info("post STValueChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STValueChanged(value));
	}

	public final nextgen.st.model.STValue value;

	public STValueChanged(nextgen.st.model.STValue value) {
		this.value = value;
	}
}