package nextgen.events;

public final class OpenSTModel {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(OpenSTModel.class);

	public static void post(nextgen.st.model.STModel model) {
		log.info("post OpenSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenSTModel(model));
	}

	public final nextgen.st.model.STModel model;

	public OpenSTModel(nextgen.st.model.STModel model) {
		this.model = model;
	}
}