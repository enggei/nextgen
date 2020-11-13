package nextgen.events;

public final class STTemplateNameChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateNameChanged.class);

	public static void post(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STTemplate stTemplate) {
		log.info("post STTemplateNameChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateNameChanged(stGroup, stTemplate));
	}

	public final nextgen.st.model.STGroupModel stGroup;
	public final nextgen.st.model.STTemplate stTemplate;

	public STTemplateNameChanged(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STTemplate stTemplate) {
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
	}
}