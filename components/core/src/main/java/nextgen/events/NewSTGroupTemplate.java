package nextgen.events;

public final class NewSTGroupTemplate {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTGroupTemplate.class);

	public static void post(nextgen.st.model.STTemplate template, nextgen.st.model.STGroupModel parent) {
		log.info("post NewSTGroupTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTGroupTemplate(template, parent));
	}

	public final nextgen.st.model.STTemplate template;
	public final nextgen.st.model.STGroupModel parent;

	public NewSTGroupTemplate(nextgen.st.model.STTemplate template, nextgen.st.model.STGroupModel parent) {
		this.template = template;
		this.parent = parent;
	}
}