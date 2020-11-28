package nextgen.events;

public final class STTemplateInterfacesChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateInterfacesChanged.class);

	public static void post(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STTemplate stTemplate) {
		//log.info("post STTemplateInterfacesChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateInterfacesChanged(stGroup, stTemplate));
	}

	public final nextgen.st.model.STGroupModel stGroup;
	public final nextgen.st.model.STTemplate stTemplate;

	public STTemplateInterfacesChanged(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STTemplate stTemplate) {
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
	}
}