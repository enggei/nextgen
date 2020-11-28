package nextgen.events;

public final class STModelChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelChanged.class);

	public static void post(nextgen.model.STModel model) {
		//log.info("post STModelChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STModelChanged(model));
	}

	public final nextgen.model.STModel model;

	public STModelChanged(nextgen.model.STModel model) {
		this.model = model;
	}
}