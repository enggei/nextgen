package nextgen.events;

public final class STArgumentKVChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STArgumentKVChanged.class);

	public static void post(nextgen.model.STArgumentKV model) {
		log.info("STArgumentKVChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STArgumentKVChanged(model));
	}

	public final nextgen.model.STArgumentKV model;

	public STArgumentKVChanged(nextgen.model.STArgumentKV model) {
		this.model = model;
	}
}  