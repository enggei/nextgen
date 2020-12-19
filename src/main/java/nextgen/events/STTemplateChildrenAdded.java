package nextgen.events;

public final class STTemplateChildrenAdded {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateChildrenAdded.class);

	public static void post(nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate stTemplate, java.util.Set<nextgen.model.STTemplate> children) {
		log.info("STTemplateChildrenAdded" + " stGroup" + " stTemplate" + " children");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateChildrenAdded(stGroup, stTemplate, children));
	}

	public final nextgen.model.STGroupModel stGroup;
	public final nextgen.model.STTemplate stTemplate;
	public final java.util.Set<nextgen.model.STTemplate> children;

	public STTemplateChildrenAdded(nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate stTemplate, java.util.Set<nextgen.model.STTemplate> children) {
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
		this.children = children;
	}
}