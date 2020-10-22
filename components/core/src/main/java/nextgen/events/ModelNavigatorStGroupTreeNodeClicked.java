package nextgen.events;

public final class ModelNavigatorStGroupTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorStGroupTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STGroupModel stGroup) {
		log.info("post ModelNavigatorStGroupTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorStGroupTreeNodeClicked(stGroup));
	}

	public final nextgen.st.domain.STGroupModel stGroup;

	public ModelNavigatorStGroupTreeNodeClicked(nextgen.st.domain.STGroupModel stGroup) {
		this.stGroup = stGroup;
	}
}