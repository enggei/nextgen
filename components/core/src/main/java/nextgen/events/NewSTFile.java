package nextgen.events;

public final class NewSTFile {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(nextgen.events.NewSTFile.class);

	public static void post(nextgen.st.model.STFile model) {
		log.info("post NewSTFile");
		org.greenrobot.eventbus.EventBus.getDefault().post(new nextgen.events.NewSTFile(model));
	}

	public final nextgen.st.model.STFile model;

	public NewSTFile(nextgen.st.model.STFile model) {
		this.model = model;
	}
}