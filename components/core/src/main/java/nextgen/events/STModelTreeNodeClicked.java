package nextgen.events;

public final class STModelTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelTreeNodeClicked.class);

	public static void post(nextgen.st.model.STModel model) {
		log.info("post STModelTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STModelTreeNodeClicked(model));
	}

	public final nextgen.st.model.STModel model;

	public STModelTreeNodeClicked(nextgen.st.model.STModel model) {
		this.model = model;
	}
}