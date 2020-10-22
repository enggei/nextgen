package nextgen.events;

public final class ModelNavigatorStTemplateTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorStTemplateTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STTemplate stTemplate) {
		log.info("post ModelNavigatorStTemplateTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorStTemplateTreeNodeClicked(stTemplate));
	}

	public final nextgen.st.domain.STTemplate stTemplate;

	public ModelNavigatorStTemplateTreeNodeClicked(nextgen.st.domain.STTemplate stTemplate) {
		this.stTemplate = stTemplate;
	}
}