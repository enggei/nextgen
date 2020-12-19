package nextgen.events;

public final class STTemplateParameterTypesChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateParameterTypesChanged.class);

	public static void post(nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate stTemplate) {
		log.info("STTemplateParameterTypesChanged" + " stGroup" + " stTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateParameterTypesChanged(stGroup, stTemplate));
	}

	public final nextgen.model.STGroupModel stGroup;
	public final nextgen.model.STTemplate stTemplate;

	public STTemplateParameterTypesChanged(nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate stTemplate) {
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
	}
}