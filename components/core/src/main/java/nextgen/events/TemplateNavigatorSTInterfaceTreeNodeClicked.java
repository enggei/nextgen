package nextgen.events;

public final class TemplateNavigatorSTInterfaceTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateNavigatorSTInterfaceTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STInterface stInterface) {
		log.info("post TemplateNavigatorSTInterfaceTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new TemplateNavigatorSTInterfaceTreeNodeClicked(stGroup, stInterface));
	}

	public final nextgen.st.domain.STGroupModel stGroup;
	public final nextgen.st.domain.STInterface stInterface;

	public TemplateNavigatorSTInterfaceTreeNodeClicked(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STInterface stInterface) {
		this.stGroup = stGroup;
		this.stInterface = stInterface;
	}
}