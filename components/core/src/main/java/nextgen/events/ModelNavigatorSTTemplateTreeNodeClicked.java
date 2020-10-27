package nextgen.events;

public final class ModelNavigatorSTTemplateTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorSTTemplateTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STTemplate stTemplate) {
		log.info("post ModelNavigatorSTTemplateTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorSTTemplateTreeNodeClicked(stTemplate));
	}

	public final nextgen.st.domain.STTemplate stTemplate;

	public ModelNavigatorSTTemplateTreeNodeClicked(nextgen.st.domain.STTemplate stTemplate) {
		this.stTemplate = stTemplate;
	}
}