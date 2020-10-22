package nextgen.events;

public final class ModelNavigatorStModelTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorStModelTreeNodeClicked.class);

	public static void post(nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STModel stModel) {
		log.info("post ModelNavigatorStModelTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorStModelTreeNodeClicked(stTemplate, stModel));
	}

	public final nextgen.st.domain.STTemplate stTemplate;
	public final nextgen.st.model.STModel stModel;

	public ModelNavigatorStModelTreeNodeClicked(nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STModel stModel) {
		this.stTemplate = stTemplate;
		this.stModel = stModel;
	}
}