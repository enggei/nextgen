package nextgen.events;

public final class STEnumValueChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STEnumValueChanged.class);

	public static void post(nextgen.model.STEnumValue sTEnumValue) {
		log.info("STEnumValueChanged" + " sTEnumValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STEnumValueChanged(sTEnumValue));
	}

	public final nextgen.model.STEnumValue sTEnumValue;

	public STEnumValueChanged(nextgen.model.STEnumValue sTEnumValue) {
		this.sTEnumValue = sTEnumValue;
	}
}  