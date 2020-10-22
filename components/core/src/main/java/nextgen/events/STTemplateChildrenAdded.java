package nextgen.events;

public final class STTemplateChildrenAdded {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateChildrenAdded.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STTemplate stTemplate, java.util.Set<nextgen.st.domain.STTemplate> children) {
		log.info("post STTemplateChildrenAdded");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateChildrenAdded(stGroup, stTemplate, children));
	}

	public final nextgen.st.domain.STGroupModel stGroup;
	public final nextgen.st.domain.STTemplate stTemplate;
	public final java.util.Set<nextgen.st.domain.STTemplate> children;

	public STTemplateChildrenAdded(nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STTemplate stTemplate, java.util.Set<nextgen.st.domain.STTemplate> children) {
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
		this.children = children;
	}
}