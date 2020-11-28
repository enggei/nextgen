package nextgen.events;

public final class ModelNavigatorSTModelTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorSTModelTreeNodeClicked.class);

	public static void post(nextgen.model.STTemplate stTemplate, nextgen.model.STModel stModel) {
		//log.info("post ModelNavigatorSTModelTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorSTModelTreeNodeClicked(stTemplate, stModel));
	}

	public final nextgen.model.STTemplate stTemplate;
	public final nextgen.model.STModel stModel;

	public ModelNavigatorSTModelTreeNodeClicked(nextgen.model.STTemplate stTemplate, nextgen.model.STModel stModel) {
		this.stTemplate = stTemplate;
		this.stModel = stModel;
	}
}