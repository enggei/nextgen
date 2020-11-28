package nextgen.events;

public final class STEnumChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STEnumChanged.class);

	public static void post(nextgen.st.model.STEnum stEnum) {
		//log.info("post STEnumChanged");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STEnumChanged(stEnum));
	}

	public final nextgen.st.model.STEnum stEnum;

	public STEnumChanged(nextgen.st.model.STEnum stEnum) {
		this.stEnum = stEnum;
	}
}