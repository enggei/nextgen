package nextgen.events;

public final class OpenSTTemplate {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(OpenSTTemplate.class);

	public static void post(nextgen.model.STTemplate template) {
		System.out.println("OpenSTTemplate" + " template");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenSTTemplate(template));
	}

	public final nextgen.model.STTemplate template;

	public OpenSTTemplate(nextgen.model.STTemplate template) {
		this.template = template;
	}
}