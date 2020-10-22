package nextgen.events;

public final class STTemplateInterfaceRemoved {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateInterfaceRemoved.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STTemplate stTemplate, String interfaceName) {
		log.info("post STTemplateInterfaceRemoved");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateInterfaceRemoved(stGroup, stTemplate, interfaceName));
	}

	public final nextgen.st.domain.STGroupModel stGroup;
	public final nextgen.st.domain.STTemplate stTemplate;
	public final String interfaceName;

	public STTemplateInterfaceRemoved(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STTemplate stTemplate, String interfaceName) {
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
		this.interfaceName = interfaceName;
	}
}