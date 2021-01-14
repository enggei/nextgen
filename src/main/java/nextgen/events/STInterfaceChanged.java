package nextgen.events;

public final class STInterfaceChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STInterfaceChanged.class);

	public static void post(nextgen.model.STInterface model) {
		log.info("STInterfaceChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STInterfaceChanged(model));
	}

	public final nextgen.model.STInterface model;

	public STInterfaceChanged(nextgen.model.STInterface model) {
		this.model = model;
	}
}  