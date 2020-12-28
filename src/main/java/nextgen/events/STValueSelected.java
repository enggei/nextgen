package nextgen.events;

public final class STValueSelected {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STValueSelected.class);

	public static void post(nextgen.model.STValue stValue) {
		log.info("STValueSelected" + " stValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STValueSelected(stValue));
	}

	public final nextgen.model.STValue stValue;

	public STValueSelected(nextgen.model.STValue stValue) {
		this.stValue = stValue;
	}
}