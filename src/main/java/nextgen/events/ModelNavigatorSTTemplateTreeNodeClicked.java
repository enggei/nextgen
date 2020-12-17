package nextgen.events;

public final class ModelNavigatorSTTemplateTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorSTTemplateTreeNodeClicked.class);

	public static void post(nextgen.model.STTemplate stTemplate) {
		System.out.println("ModelNavigatorSTTemplateTreeNodeClicked" + " stTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorSTTemplateTreeNodeClicked(stTemplate));
	}

	public final nextgen.model.STTemplate stTemplate;

	public ModelNavigatorSTTemplateTreeNodeClicked(nextgen.model.STTemplate stTemplate) {
		this.stTemplate = stTemplate;
	}
}