package nextgen.events;

public final class NewSTModel {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTModel.class);

	public static void post(nextgen.st.model.STModel model) {
		log.info("post NewSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTModel(model));
	}

	public final nextgen.st.model.STModel model;

	public NewSTModel(nextgen.st.model.STModel model) {
		this.model = model;
	}
}