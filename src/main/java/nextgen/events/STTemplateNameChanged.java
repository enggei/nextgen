package nextgen.events;

public final class STTemplateNameChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateNameChanged.class);

	public static void post(nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate stTemplate) {
		System.out.println("STTemplateNameChanged" + " stGroup" + " stTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateNameChanged(stGroup, stTemplate));
	}

	public final nextgen.model.STGroupModel stGroup;
	public final nextgen.model.STTemplate stTemplate;

	public STTemplateNameChanged(nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate stTemplate) {
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
	}
}