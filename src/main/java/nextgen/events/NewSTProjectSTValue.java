package nextgen.events;

public final class NewSTProjectSTValue {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTProjectSTValue.class);

	public static void post(nextgen.st.model.STValue value, nextgen.st.model.STProject project) {
		//log.info("post NewSTProjectSTValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTProjectSTValue(value, project));
	}

	public final nextgen.st.model.STValue value;
	public final nextgen.st.model.STProject project;

	public NewSTProjectSTValue(nextgen.st.model.STValue value, nextgen.st.model.STProject project) {
		this.value = value;
		this.project = project;
	}
}