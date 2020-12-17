package nextgen.events;

public final class NewSTProjectSTValue {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTProjectSTValue.class);

	public static void post(nextgen.model.STValue value, nextgen.model.STProject project) {
		System.out.println("NewSTProjectSTValue" + " value" + " project");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTProjectSTValue(value, project));
	}

	public final nextgen.model.STValue value;
	public final nextgen.model.STProject project;

	public NewSTProjectSTValue(nextgen.model.STValue value, nextgen.model.STProject project) {
		this.value = value;
		this.project = project;
	}
}