package nextgen.events;

public final class NewSTGroup {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTGroup.class);

	public static void post(nextgen.st.model.STGroupModel group) {
		log.info("post NewSTGroup");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTGroup(group));
	}

	public final nextgen.st.model.STGroupModel group;

	public NewSTGroup(nextgen.st.model.STGroupModel group) {
		this.group = group;
	}
}