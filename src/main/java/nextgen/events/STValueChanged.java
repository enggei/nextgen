package nextgen.events;

public final class STValueChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STValueChanged.class);

	public static void post(nextgen.model.STValue sTValue) {
		log.info("STValueChanged" + " sTValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STValueChanged(sTValue));
	}

	public final nextgen.model.STValue sTValue;

	public STValueChanged(nextgen.model.STValue sTValue) {
		this.sTValue = sTValue;
	}
}  