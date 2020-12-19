package nextgen.events;

public final class STTemplateInterfacesChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateInterfacesChanged.class);

	public static void post(nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate stTemplate) {
		log.info("STTemplateInterfacesChanged" + " stGroup" + " stTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateInterfacesChanged(stGroup, stTemplate));
	}

	public final nextgen.model.STGroupModel stGroup;
	public final nextgen.model.STTemplate stTemplate;

	public STTemplateInterfacesChanged(nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate stTemplate) {
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
	}
}