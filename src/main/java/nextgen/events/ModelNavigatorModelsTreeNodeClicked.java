package nextgen.events;

public final class ModelNavigatorModelsTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorModelsTreeNodeClicked.class);

	public static void post() {
		//log.info("post ModelNavigatorModelsTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorModelsTreeNodeClicked());
	}


	public ModelNavigatorModelsTreeNodeClicked() {
	}
}