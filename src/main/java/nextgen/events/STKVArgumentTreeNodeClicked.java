package nextgen.events;

public final class STKVArgumentTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STKVArgumentTreeNodeClicked.class);

	public static void post(nextgen.model.STArgumentKV kv) {
		log.info("STKVArgumentTreeNodeClicked" + " kv");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STKVArgumentTreeNodeClicked(kv));
	}

	public final nextgen.model.STArgumentKV kv;

	public STKVArgumentTreeNodeClicked(nextgen.model.STArgumentKV kv) {
		this.kv = kv;
	}
}