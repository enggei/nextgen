package nextgen.events;

public final class STModelChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelChanged.class);

	public static void post(nextgen.st.model.STModel model) {
		//log.info("post STModelChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STModelChanged(model));
	}

	public final nextgen.st.model.STModel model;

	public STModelChanged(nextgen.st.model.STModel model) {
		this.model = model;
	}
}