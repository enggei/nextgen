package nextgen.events;

public final class TemplateNavigatorSTTemplateTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateNavigatorSTTemplateTreeNodeClicked.class);

	public static void post(nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate parentTemplate, nextgen.model.STTemplate stTemplate) {
		System.out.println("TemplateNavigatorSTTemplateTreeNodeClicked" + " stGroup" + " parentTemplate" + " stTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new TemplateNavigatorSTTemplateTreeNodeClicked(stGroup, parentTemplate, stTemplate));
	}

	public final nextgen.model.STGroupModel stGroup;
	public final nextgen.model.STTemplate parentTemplate;
	public final nextgen.model.STTemplate stTemplate;

	public TemplateNavigatorSTTemplateTreeNodeClicked(nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate parentTemplate, nextgen.model.STTemplate stTemplate) {
		this.stGroup = stGroup;
		this.parentTemplate = parentTemplate;
		this.stTemplate = stTemplate;
	}
}