package nextgen.events;

public final class NewSTModel {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTModel.class);

	public static void post(nextgen.st.model.STModel model, nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STTemplate template) {
		log.info("post NewSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTModel(model, stGroup, template));
	}

	public final nextgen.st.model.STModel model;
	public final nextgen.st.domain.STGroupModel stGroup;
	public final nextgen.st.domain.STTemplate template;

	public NewSTModel(nextgen.st.model.STModel model, nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STTemplate template) {
		this.model = model;
		this.stGroup = stGroup;
		this.template = template;
	}
}