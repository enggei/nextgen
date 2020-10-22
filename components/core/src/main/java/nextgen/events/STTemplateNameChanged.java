package nextgen.events;

public final class STTemplateNameChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateNameChanged.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STTemplate stTemplate) {
		log.info("post STTemplateNameChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateNameChanged(stGroup, stTemplate));
	}

	public final nextgen.st.domain.STGroupModel stGroup;
	public final nextgen.st.domain.STTemplate stTemplate;

	public STTemplateNameChanged(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STTemplate stTemplate) {
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
	}
}