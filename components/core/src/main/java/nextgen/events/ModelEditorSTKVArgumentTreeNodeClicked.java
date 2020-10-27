package nextgen.events;

public final class ModelEditorSTKVArgumentTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelEditorSTKVArgumentTreeNodeClicked.class);

	public static void post(nextgen.st.model.STArgumentKV kv) {
		log.info("post ModelEditorSTKVArgumentTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelEditorSTKVArgumentTreeNodeClicked(kv));
	}

	public final nextgen.st.model.STArgumentKV kv;

	public ModelEditorSTKVArgumentTreeNodeClicked(nextgen.st.model.STArgumentKV kv) {
		this.kv = kv;
	}
}