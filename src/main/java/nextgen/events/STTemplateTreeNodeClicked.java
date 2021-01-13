package nextgen.events;

public final class STTemplateTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateTreeNodeClicked.class);

	public static void post(nextgen.model.STTemplate stTemplate) {
		log.info("STTemplateTreeNodeClicked" + " stTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateTreeNodeClicked(stTemplate));
	}

	public final nextgen.model.STTemplate stTemplate;

	public STTemplateTreeNodeClicked(nextgen.model.STTemplate stTemplate) {
		this.stTemplate = stTemplate;
	}
}