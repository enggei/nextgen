package nextgen.events;

public final class TemplateNavigatorSTGroupActionTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateNavigatorSTGroupActionTreeNodeClicked.class);

	public static void post(nextgen.st.model.STGroupAction action) {
		log.info("post TemplateNavigatorSTGroupActionTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new TemplateNavigatorSTGroupActionTreeNodeClicked(action));
	}

	public final nextgen.st.model.STGroupAction action;

	public TemplateNavigatorSTGroupActionTreeNodeClicked(nextgen.st.model.STGroupAction action) {
		this.action = action;
	}
}