package nextgen.events;

public final class STModelEditorSTParameterTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelEditorSTParameterTreeNodeClicked.class);

	public static void post() {
		log.info("post STModelEditorSTParameterTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STModelEditorSTParameterTreeNodeClicked());
	}


	public STModelEditorSTParameterTreeNodeClicked() {
	}
}