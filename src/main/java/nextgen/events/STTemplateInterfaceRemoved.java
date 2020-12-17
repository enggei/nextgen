package nextgen.events;

public final class STTemplateInterfaceRemoved {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateInterfaceRemoved.class);

	public static void post(nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate stTemplate, String interfaceName) {
		System.out.println("STTemplateInterfaceRemoved" + " stGroup" + " stTemplate" + " interfaceName");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateInterfaceRemoved(stGroup, stTemplate, interfaceName));
	}

	public final nextgen.model.STGroupModel stGroup;
	public final nextgen.model.STTemplate stTemplate;
	public final String interfaceName;

	public STTemplateInterfaceRemoved(nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate stTemplate, String interfaceName) {
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
		this.interfaceName = interfaceName;
	}
}