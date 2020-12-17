package nextgen.events;

public final class STValueChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STValueChanged.class);

	public static void post(nextgen.model.STValue value) {
		System.out.println("STValueChanged" + " value");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STValueChanged(value));
	}

	public final nextgen.model.STValue value;

	public STValueChanged(nextgen.model.STValue value) {
		this.value = value;
	}
}