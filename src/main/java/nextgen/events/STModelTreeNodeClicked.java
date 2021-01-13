package nextgen.events;

public final class STModelTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelTreeNodeClicked.class);

	public static void post(nextgen.model.STModel stModel) {
		log.info("STModelTreeNodeClicked" + " stModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STModelTreeNodeClicked(stModel));
	}

	public final nextgen.model.STModel stModel;

	public STModelTreeNodeClicked(nextgen.model.STModel stModel) {
		this.stModel = stModel;
	}
}