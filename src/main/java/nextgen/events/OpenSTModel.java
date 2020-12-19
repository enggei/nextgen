package nextgen.events;

public final class OpenSTModel {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(OpenSTModel.class);

	public static void post(nextgen.model.STModel model) {
		log.info("OpenSTModel" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenSTModel(model));
	}

	public final nextgen.model.STModel model;

	public OpenSTModel(nextgen.model.STModel model) {
		this.model = model;
	}
}