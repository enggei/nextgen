package nextgen.events;

public final class STValueTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STValueTreeNodeClicked.class);

	public static void post(nextgen.model.STValue stValue) {
		log.info("STValueTreeNodeClicked" + " stValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STValueTreeNodeClicked(stValue));
	}

	public final nextgen.model.STValue stValue;

	public STValueTreeNodeClicked(nextgen.model.STValue stValue) {
		this.stValue = stValue;
	}
}