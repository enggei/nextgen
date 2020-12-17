package nextgen.events;

public final class TemplateNavigatorSTInterfaceTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateNavigatorSTInterfaceTreeNodeClicked.class);

	public static void post(nextgen.model.STGroupModel stGroup, nextgen.model.STInterface stInterface) {
		System.out.println("TemplateNavigatorSTInterfaceTreeNodeClicked" + " stGroup" + " stInterface");
		org.greenrobot.eventbus.EventBus.getDefault().post(new TemplateNavigatorSTInterfaceTreeNodeClicked(stGroup, stInterface));
	}

	public final nextgen.model.STGroupModel stGroup;
	public final nextgen.model.STInterface stInterface;

	public TemplateNavigatorSTInterfaceTreeNodeClicked(nextgen.model.STGroupModel stGroup, nextgen.model.STInterface stInterface) {
		this.stGroup = stGroup;
		this.stInterface = stInterface;
	}
}