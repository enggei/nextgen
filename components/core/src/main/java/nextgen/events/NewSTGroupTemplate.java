package nextgen.events;

public final class NewSTGroupTemplate {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTGroupTemplate.class);

	public static void post(nextgen.st.domain.STTemplate template, nextgen.st.domain.STGroupModel parent) {
		log.info("post NewSTGroupTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTGroupTemplate(template, parent));
	}

	public final nextgen.st.domain.STTemplate template;
	public final nextgen.st.domain.STGroupModel parent;

	public NewSTGroupTemplate(nextgen.st.domain.STTemplate template, nextgen.st.domain.STGroupModel parent) {
		this.template = template;
		this.parent = parent;
	}
}