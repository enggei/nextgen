package nextgen.events;

public final class NewSTGroupFile {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTGroupFile.class);

	public static void post(nextgen.model.STGroupModel stGroupModel, nextgen.model.STGroupFile stGroupFile) {
		System.out.println("NewSTGroupFile" + " stGroupModel" + " stGroupFile");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTGroupFile(stGroupModel, stGroupFile));
	}

	public final nextgen.model.STGroupModel stGroupModel;
	public final nextgen.model.STGroupFile stGroupFile;

	public NewSTGroupFile(nextgen.model.STGroupModel stGroupModel, nextgen.model.STGroupFile stGroupFile) {
		this.stGroupModel = stGroupModel;
		this.stGroupFile = stGroupFile;
	}
}