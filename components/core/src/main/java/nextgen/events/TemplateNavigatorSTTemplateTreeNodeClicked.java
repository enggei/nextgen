package nextgen.events;

public final class TemplateNavigatorSTTemplateTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateNavigatorSTTemplateTreeNodeClicked.class);

	public static void post(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STTemplate parentTemplate, nextgen.st.model.STTemplate stTemplate) {
		log.info("post TemplateNavigatorSTTemplateTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new TemplateNavigatorSTTemplateTreeNodeClicked(stGroup, parentTemplate, stTemplate));
	}

	public final nextgen.st.model.STGroupModel stGroup;
	public final nextgen.st.model.STTemplate parentTemplate;
	public final nextgen.st.model.STTemplate stTemplate;

	public TemplateNavigatorSTTemplateTreeNodeClicked(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STTemplate parentTemplate, nextgen.st.model.STTemplate stTemplate) {
		this.stGroup = stGroup;
		this.parentTemplate = parentTemplate;
		this.stTemplate = stTemplate;
	}
}