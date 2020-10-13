package nextgen.events;

public final class NewSTTemplate {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTTemplate.class);

	public static void post(nextgen.st.domain.STTemplate model, Object parent) {
		log.info("post NewSTTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTTemplate(model, parent));
	}

	public final nextgen.st.domain.STTemplate model;
	public final Object parent;

	public NewSTTemplate(nextgen.st.domain.STTemplate model, Object parent) {
		this.model = model;
		this.parent = parent;
	}
}