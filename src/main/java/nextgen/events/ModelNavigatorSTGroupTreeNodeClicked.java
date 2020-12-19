package nextgen.events;

public final class ModelNavigatorSTGroupTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorSTGroupTreeNodeClicked.class);

	public static void post(nextgen.model.STGroupModel stGroup) {
		log.info("ModelNavigatorSTGroupTreeNodeClicked" + " stGroup");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorSTGroupTreeNodeClicked(stGroup));
	}

	public final nextgen.model.STGroupModel stGroup;

	public ModelNavigatorSTGroupTreeNodeClicked(nextgen.model.STGroupModel stGroup) {
		this.stGroup = stGroup;
	}
}