package nextgen.events;

public final class TemplateNavigatorSTGroupTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateNavigatorSTGroupTreeNodeClicked.class);

	public static void post(nextgen.model.STGroupModel stGroup) {
		log.info("TemplateNavigatorSTGroupTreeNodeClicked" + " stGroup");
		org.greenrobot.eventbus.EventBus.getDefault().post(new TemplateNavigatorSTGroupTreeNodeClicked(stGroup));
	}

	public final nextgen.model.STGroupModel stGroup;

	public TemplateNavigatorSTGroupTreeNodeClicked(nextgen.model.STGroupModel stGroup) {
		this.stGroup = stGroup;
	}
}