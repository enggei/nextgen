package nextgen.events;

public final class NewSTTemplateChild {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTTemplateChild.class);

	public static void post(nextgen.st.domain.STTemplate template, nextgen.st.domain.STTemplate parent) {
		log.info("post NewSTTemplateChild");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTTemplateChild(template, parent));
	}

	public final nextgen.st.domain.STTemplate template;
	public final nextgen.st.domain.STTemplate parent;

	public NewSTTemplateChild(nextgen.st.domain.STTemplate template, nextgen.st.domain.STTemplate parent) {
		this.template = template;
		this.parent = parent;
	}
}