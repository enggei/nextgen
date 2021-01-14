package nextgen.events;

public final class STTemplateChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateChanged.class);

	public static void post(nextgen.model.STTemplate model) {
		log.info("STTemplateChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateChanged(model));
	}

	public final nextgen.model.STTemplate model;

	public STTemplateChanged(nextgen.model.STTemplate model) {
		this.model = model;
	}
}  