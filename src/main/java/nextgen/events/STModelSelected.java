package nextgen.events;

public final class STModelSelected {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelSelected.class);

	public static void post(nextgen.model.STModel stModel) {
		log.info("STModelSelected" + " stModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STModelSelected(stModel));
	}

	public final nextgen.model.STModel stModel;

	public STModelSelected(nextgen.model.STModel stModel) {
		this.stModel = stModel;
	}
}