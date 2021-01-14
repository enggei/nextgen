package nextgen.events;

public final class STEnumChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STEnumChanged.class);

	public static void post(nextgen.model.STEnum model) {
		log.info("STEnumChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STEnumChanged(model));
	}

	public final nextgen.model.STEnum model;

	public STEnumChanged(nextgen.model.STEnum model) {
		this.model = model;
	}
}  