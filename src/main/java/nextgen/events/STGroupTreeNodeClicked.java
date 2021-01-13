package nextgen.events;

public final class STGroupTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupTreeNodeClicked.class);

	public static void post(nextgen.model.STGroupModel stGroup) {
		log.info("STGroupTreeNodeClicked" + " stGroup");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupTreeNodeClicked(stGroup));
	}

	public final nextgen.model.STGroupModel stGroup;

	public STGroupTreeNodeClicked(nextgen.model.STGroupModel stGroup) {
		this.stGroup = stGroup;
	}
}