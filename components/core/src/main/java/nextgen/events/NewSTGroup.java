package nextgen.events;

public final class NewSTGroup {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTGroup.class);

	public static void post(nextgen.st.domain.STGroupModel model) {
		log.info("post NewSTGroup");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTGroup(model));
	}

	public final nextgen.st.domain.STGroupModel model;

	public NewSTGroup(nextgen.st.domain.STGroupModel model) {
		this.model = model;
	}
}