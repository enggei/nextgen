package nextgen.events;

public final class STParameterChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STParameterChanged.class);

	public static void post(nextgen.model.STParameter model) {
		log.info("STParameterChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STParameterChanged(model));
	}

	public final nextgen.model.STParameter model;

	public STParameterChanged(nextgen.model.STParameter model) {
		this.model = model;
	}
}  