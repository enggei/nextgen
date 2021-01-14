package nextgen.events;

public final class STEnumValueChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STEnumValueChanged.class);

	public static void post(nextgen.model.STEnumValue model) {
		log.info("STEnumValueChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STEnumValueChanged(model));
	}

	public final nextgen.model.STEnumValue model;

	public STEnumValueChanged(nextgen.model.STEnumValue model) {
		this.model = model;
	}
}  