package nextgen.events;

public final class STGroupModelChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupModelChanged.class);

	public static void post(nextgen.model.STGroupModel model) {
		log.info("STGroupModelChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupModelChanged(model));
	}

	public final nextgen.model.STGroupModel model;

	public STGroupModelChanged(nextgen.model.STGroupModel model) {
		this.model = model;
	}
}  