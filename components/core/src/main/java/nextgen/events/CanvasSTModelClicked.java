package nextgen.events;

public final class CanvasSTModelClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CanvasSTModelClicked.class);

	public static void post(nextgen.st.model.STModel stModel) {
		log.info("post CanvasSTModelClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new CanvasSTModelClicked(stModel));
	}

	public final nextgen.st.model.STModel stModel;

	public CanvasSTModelClicked(nextgen.st.model.STModel stModel) {
		this.stModel = stModel;
	}
}