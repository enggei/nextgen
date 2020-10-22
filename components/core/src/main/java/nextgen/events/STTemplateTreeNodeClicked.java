package nextgen.events;

public final class STTemplateTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STTemplate parentTemplate, nextgen.st.domain.STTemplate stTemplate) {
		log.info("post STTemplateTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateTreeNodeClicked(stGroup, parentTemplate, stTemplate));
	}

	public final nextgen.st.domain.STGroupModel stGroup;
	public final nextgen.st.domain.STTemplate parentTemplate;
	public final nextgen.st.domain.STTemplate stTemplate;

	public STTemplateTreeNodeClicked(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STTemplate parentTemplate, nextgen.st.domain.STTemplate stTemplate) {
		this.stGroup = stGroup;
		this.parentTemplate = parentTemplate;
		this.stTemplate = stTemplate;
	}
}