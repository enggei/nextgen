package nextgen.events;

public final class STParameterKeyChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STParameterKeyChanged.class);

	public static void post(nextgen.model.STParameterKey model) {
		log.info("STParameterKeyChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STParameterKeyChanged(model));
	}

	public final nextgen.model.STParameterKey model;

	public STParameterKeyChanged(nextgen.model.STParameterKey model) {
		this.model = model;
	}
}  