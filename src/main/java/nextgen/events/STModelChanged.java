package nextgen.events;

public final class STModelChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelChanged.class);

	public static void post(nextgen.model.STModel sTModel) {
		log.info("STModelChanged" + " sTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STModelChanged(sTModel));
	}

	public final nextgen.model.STModel sTModel;

	public STModelChanged(nextgen.model.STModel sTModel) {
		this.sTModel = sTModel;
	}
}  