package nextgen.events;

public final class STEnumChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STEnumChanged.class);

	public static void post(nextgen.model.STEnum stEnum) {
		System.out.println("STEnumChanged" + " stEnum");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STEnumChanged(stEnum));
	}

	public final nextgen.model.STEnum stEnum;

	public STEnumChanged(nextgen.model.STEnum stEnum) {
		this.stEnum = stEnum;
	}
}