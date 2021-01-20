package nextgen.events;

public final class STArgumentKVChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STArgumentKVChanged.class);

	public static void post(nextgen.model.STArgumentKV sTArgumentKV) {
		log.info("STArgumentKVChanged" + " sTArgumentKV");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STArgumentKVChanged(sTArgumentKV));
	}

	public final nextgen.model.STArgumentKV sTArgumentKV;

	public STArgumentKVChanged(nextgen.model.STArgumentKV sTArgumentKV) {
		this.sTArgumentKV = sTArgumentKV;
	}
}  