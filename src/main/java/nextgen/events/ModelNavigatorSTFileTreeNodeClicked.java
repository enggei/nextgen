package nextgen.events;

public final class ModelNavigatorSTFileTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorSTFileTreeNodeClicked.class);

	public static void post(nextgen.model.STFile stFile) {
		System.out.println("ModelNavigatorSTFileTreeNodeClicked" + " stFile");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorSTFileTreeNodeClicked(stFile));
	}

	public final nextgen.model.STFile stFile;

	public ModelNavigatorSTFileTreeNodeClicked(nextgen.model.STFile stFile) {
		this.stFile = stFile;
	}
}