package nextgen.events;

public final class ShowSTModelInCanvas {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ShowSTModelInCanvas.class);

	public static void post(nextgen.model.STModel stModel) {
		//log.info("post ShowSTModelInCanvas");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ShowSTModelInCanvas(stModel));
	}

	public final nextgen.model.STModel stModel;

	public ShowSTModelInCanvas(nextgen.model.STModel stModel) {
		this.stModel = stModel;
	}
}