package nextgen.events;

public final class STParameterChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STParameterChanged.class);

	public static void post(nextgen.model.STParameter sTParameter) {
		log.info("STParameterChanged" + " sTParameter");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STParameterChanged(sTParameter));
	}

	public final nextgen.model.STParameter sTParameter;

	public STParameterChanged(nextgen.model.STParameter sTParameter) {
		this.sTParameter = sTParameter;
	}
}  