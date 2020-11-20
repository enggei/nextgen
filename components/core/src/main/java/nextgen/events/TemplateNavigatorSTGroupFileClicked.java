package nextgen.events;

public final class TemplateNavigatorSTGroupFileClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateNavigatorSTGroupFileClicked.class);

	public static void post(nextgen.st.model.STGroupFile stGroupFile) {
		log.info("post TemplateNavigatorSTGroupFileClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new TemplateNavigatorSTGroupFileClicked(stGroupFile));
	}

	public final nextgen.st.model.STGroupFile stGroupFile;

	public TemplateNavigatorSTGroupFileClicked(nextgen.st.model.STGroupFile stGroupFile) {
		this.stGroupFile = stGroupFile;
	}
}