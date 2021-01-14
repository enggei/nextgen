package nextgen.events;

public final class STArgumentChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STArgumentChanged.class);

	public static void post(nextgen.model.STArgument model) {
		log.info("STArgumentChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STArgumentChanged(model));
	}

	public final nextgen.model.STArgument model;

	public STArgumentChanged(nextgen.model.STArgument model) {
		this.model = model;
	}
}  