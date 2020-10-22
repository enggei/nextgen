package nextgen.events;

public final class STTemplateParameterTypesChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateParameterTypesChanged.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STTemplate stTemplate) {
		log.info("post STTemplateParameterTypesChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateParameterTypesChanged(stGroup, stTemplate));
	}

	public final nextgen.st.domain.STGroupModel stGroup;
	public final nextgen.st.domain.STTemplate stTemplate;

	public STTemplateParameterTypesChanged(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STTemplate stTemplate) {
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
	}
}