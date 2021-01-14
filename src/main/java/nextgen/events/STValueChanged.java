package nextgen.events;

public final class STValueChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STValueChanged.class);

	public static void post(nextgen.model.STValue model) {
		log.info("STValueChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STValueChanged(model));
	}

	public final nextgen.model.STValue model;

	public STValueChanged(nextgen.model.STValue model) {
		this.model = model;
	}
}  