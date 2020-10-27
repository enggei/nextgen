package nextgen.events;

public final class ModelNavigatorSTGroupTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorSTGroupTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup) {
		log.info("post ModelNavigatorSTGroupTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorSTGroupTreeNodeClicked(stGroup));
	}

	public final nextgen.st.domain.STGroupModel stGroup;

	public ModelNavigatorSTGroupTreeNodeClicked(nextgen.st.domain.STGroupModel stGroup) {
		this.stGroup = stGroup;
	}
}