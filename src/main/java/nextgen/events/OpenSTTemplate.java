package nextgen.events;

public final class OpenSTTemplate {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(OpenSTTemplate.class);

	public static void post(nextgen.st.model.STTemplate template) {
		//log.info("post OpenSTTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenSTTemplate(template));
	}

	public final nextgen.st.model.STTemplate template;

	public OpenSTTemplate(nextgen.st.model.STTemplate template) {
		this.template = template;
	}
}