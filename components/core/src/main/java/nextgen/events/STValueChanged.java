package nextgen.events;

public final class STValueChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STValueChanged.class);

	public static void post(nextgen.st.model.STValue stValue) {
		log.info("post STValueChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STValueChanged(stValue));
	}

	public final nextgen.st.model.STValue stValue;

	public STValueChanged(nextgen.st.model.STValue stValue) {
		this.stValue = stValue;
	}
}