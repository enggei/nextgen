package nextgen.events;

public final class TemplateNavigatorSTGroupActionTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateNavigatorSTGroupActionTreeNodeClicked.class);

	public static void post(nextgen.model.STGroupAction action) {
		System.out.println("TemplateNavigatorSTGroupActionTreeNodeClicked" + " action");
		org.greenrobot.eventbus.EventBus.getDefault().post(new TemplateNavigatorSTGroupActionTreeNodeClicked(action));
	}

	public final nextgen.model.STGroupAction action;

	public TemplateNavigatorSTGroupActionTreeNodeClicked(nextgen.model.STGroupAction action) {
		this.action = action;
	}
}