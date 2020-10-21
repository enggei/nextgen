package nextgen.events;

public final class NewSTTemplate {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTTemplate.class);

	public static void post(nextgen.st.domain.STTemplate template, Object parent) {
		log.info("post NewSTTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTTemplate(template, parent));
	}

	public final nextgen.st.domain.STTemplate template;
	public final Object parent;

	public NewSTTemplate(nextgen.st.domain.STTemplate template, Object parent) {
		this.template = template;
		this.parent = parent;
	}
}