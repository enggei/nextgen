package nextgen.events;

public final class CanvasSTModelNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CanvasSTModelNodeClicked.class);

	public static void post(nextgen.model.STModel stModel) {
		System.out.println("CanvasSTModelNodeClicked" + " stModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new CanvasSTModelNodeClicked(stModel));
	}

	public final nextgen.model.STModel stModel;

	public CanvasSTModelNodeClicked(nextgen.model.STModel stModel) {
		this.stModel = stModel;
	}
}