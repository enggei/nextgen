package nextgen.events;

public final class TemplateNavigatorSTInterfaceTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateNavigatorSTInterfaceTreeNodeClicked.class);

	public static void post(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STInterface stInterface) {
		log.info("post TemplateNavigatorSTInterfaceTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new TemplateNavigatorSTInterfaceTreeNodeClicked(stGroup, stInterface));
	}

	public final nextgen.st.model.STGroupModel stGroup;
	public final nextgen.st.model.STInterface stInterface;

	public TemplateNavigatorSTInterfaceTreeNodeClicked(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STInterface stInterface) {
		this.stGroup = stGroup;
		this.stInterface = stInterface;
	}
}