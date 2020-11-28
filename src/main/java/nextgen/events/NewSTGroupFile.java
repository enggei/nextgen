package nextgen.events;

public final class NewSTGroupFile {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTGroupFile.class);

	public static void post(nextgen.st.model.STGroupModel stGroupModel, nextgen.st.model.STGroupFile stGroupFile) {
		//log.info("post NewSTGroupFile");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTGroupFile(stGroupModel, stGroupFile));
	}

	public final nextgen.st.model.STGroupModel stGroupModel;
	public final nextgen.st.model.STGroupFile stGroupFile;

	public NewSTGroupFile(nextgen.st.model.STGroupModel stGroupModel, nextgen.st.model.STGroupFile stGroupFile) {
		this.stGroupModel = stGroupModel;
		this.stGroupFile = stGroupFile;
	}
}