package nextgen.events;

public final class STGroupActionChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupActionChanged.class);

	public static void post(nextgen.model.STGroupAction model) {
		log.info("STGroupActionChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupActionChanged(model));
	}

	public final nextgen.model.STGroupAction model;

	public STGroupActionChanged(nextgen.model.STGroupAction model) {
		this.model = model;
	}
}  