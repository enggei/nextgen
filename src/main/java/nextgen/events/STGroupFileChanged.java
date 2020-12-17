package nextgen.events;

public final class STGroupFileChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupFileChanged.class);

	public static void post(nextgen.model.STGroupFile stGroupFile) {
		System.out.println("STGroupFileChanged" + " stGroupFile");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupFileChanged(stGroupFile));
	}

	public final nextgen.model.STGroupFile stGroupFile;

	public STGroupFileChanged(nextgen.model.STGroupFile stGroupFile) {
		this.stGroupFile = stGroupFile;
	}
}