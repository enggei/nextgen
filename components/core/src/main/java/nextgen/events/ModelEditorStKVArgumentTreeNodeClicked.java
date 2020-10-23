package nextgen.events;

public final class ModelEditorStKVArgumentTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelEditorStKVArgumentTreeNodeClicked.class);

	public static void post(nextgen.st.model.STArgumentKV kv) {
		log.info("post ModelEditorStKVArgumentTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelEditorStKVArgumentTreeNodeClicked(kv));
	}

	public final nextgen.st.model.STArgumentKV kv;

	public ModelEditorStKVArgumentTreeNodeClicked(nextgen.st.model.STArgumentKV kv) {
		this.kv = kv;
	}
}