package nextgen.events;

public final class STParameterKeyChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STParameterKeyChanged.class);

	public static void post(nextgen.model.STParameterKey sTParameterKey) {
		log.info("STParameterKeyChanged" + " sTParameterKey");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STParameterKeyChanged(sTParameterKey));
	}

	public final nextgen.model.STParameterKey sTParameterKey;

	public STParameterKeyChanged(nextgen.model.STParameterKey sTParameterKey) {
		this.sTParameterKey = sTParameterKey;
	}
}  