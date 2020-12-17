package nextgen.events;

public final class NewSTGroup {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTGroup.class);

	public static void post(nextgen.model.STGroupModel group) {
		System.out.println("NewSTGroup" + " group");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTGroup(group));
	}

	public final nextgen.model.STGroupModel group;

	public NewSTGroup(nextgen.model.STGroupModel group) {
		this.group = group;
	}
}