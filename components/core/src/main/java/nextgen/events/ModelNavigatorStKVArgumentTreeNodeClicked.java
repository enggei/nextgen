package nextgen.events;

public final class ModelNavigatorStKVArgumentTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorStKVArgumentTreeNodeClicked.class);

	public static void post(nextgen.st.model.STArgumentKV kv) {
		log.info("post ModelNavigatorStKVArgumentTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorStKVArgumentTreeNodeClicked(kv));
	}

	public final nextgen.st.model.STArgumentKV kv;

	public ModelNavigatorStKVArgumentTreeNodeClicked(nextgen.st.model.STArgumentKV kv) {
		this.kv = kv;
	}
}