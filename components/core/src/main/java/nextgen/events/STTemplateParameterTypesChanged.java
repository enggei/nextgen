package nextgen.events;

public final class STTemplateParameterTypesChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateParameterTypesChanged.class);

	public static void post(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STTemplate stTemplate) {
		log.info("post STTemplateParameterTypesChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateParameterTypesChanged(stGroup, stTemplate));
	}

	public final nextgen.st.model.STGroupModel stGroup;
	public final nextgen.st.model.STTemplate stTemplate;

	public STTemplateParameterTypesChanged(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STTemplate stTemplate) {
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
	}
}