package nextgen.events;

public final class OpenSTTemplate {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(OpenSTTemplate.class);

	public static void post(nextgen.st.domain.STTemplate model) {
		log.info("post OpenSTTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenSTTemplate(model));
	}

	public final nextgen.st.domain.STTemplate model;

	public OpenSTTemplate(nextgen.st.domain.STTemplate model) {
		this.model = model;
	}
}