package nextgen.events;

public final class ModelNavigatorSTKVArgumentTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorSTKVArgumentTreeNodeClicked.class);

	public static void post(nextgen.model.STArgumentKV kv) {
		log.info("ModelNavigatorSTKVArgumentTreeNodeClicked" + " kv");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorSTKVArgumentTreeNodeClicked(kv));
	}

	public final nextgen.model.STArgumentKV kv;

	public ModelNavigatorSTKVArgumentTreeNodeClicked(nextgen.model.STArgumentKV kv) {
		this.kv = kv;
	}
}