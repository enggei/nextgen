package nextgen.events;

public final class TemplateNavigatorSTGroupFileClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemplateNavigatorSTGroupFileClicked.class);

	public static void post(nextgen.model.STGroupFile stGroupFile) {
		log.info("TemplateNavigatorSTGroupFileClicked" + " stGroupFile");
		org.greenrobot.eventbus.EventBus.getDefault().post(new TemplateNavigatorSTGroupFileClicked(stGroupFile));
	}

	public final nextgen.model.STGroupFile stGroupFile;

	public TemplateNavigatorSTGroupFileClicked(nextgen.model.STGroupFile stGroupFile) {
		this.stGroupFile = stGroupFile;
	}
}