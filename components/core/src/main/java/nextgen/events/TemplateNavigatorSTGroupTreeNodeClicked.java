package nextgen.events;

public final class TemplateNavigatorSTGroupTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateNavigatorSTGroupTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup) {
		log.info("post TemplateNavigatorSTGroupTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new TemplateNavigatorSTGroupTreeNodeClicked(stGroup));
	}

	public final nextgen.st.domain.STGroupModel stGroup;

	public TemplateNavigatorSTGroupTreeNodeClicked(nextgen.st.domain.STGroupModel stGroup) {
		this.stGroup = stGroup;
	}
}