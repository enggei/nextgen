package nextgen.events;

public final class STValueElementEditorEnabled {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STValueElementEditorEnabled.class);

	public static void post(nextgen.model.STValue stValue) {
		System.out.println("STValueElementEditorEnabled" + " stValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STValueElementEditorEnabled(stValue));
	}

	public final nextgen.model.STValue stValue;

	public STValueElementEditorEnabled(nextgen.model.STValue stValue) {
		this.stValue = stValue;
	}
}