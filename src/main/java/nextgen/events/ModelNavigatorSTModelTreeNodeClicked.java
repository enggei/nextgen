package nextgen.events;

public final class ModelNavigatorSTModelTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorSTModelTreeNodeClicked.class);

	public static void post(nextgen.model.STModel stModel) {
		log.info("ModelNavigatorSTModelTreeNodeClicked" + " stModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorSTModelTreeNodeClicked(stModel));
	}

	public final nextgen.model.STModel stModel;

	public ModelNavigatorSTModelTreeNodeClicked(nextgen.model.STModel stModel) {
		this.stModel = stModel;
	}
}