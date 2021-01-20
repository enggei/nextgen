package nextgen.events;

public final class STEnumChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STEnumChanged.class);

	public static void post(nextgen.model.STEnum sTEnum) {
		log.info("STEnumChanged" + " sTEnum");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STEnumChanged(sTEnum));
	}

	public final nextgen.model.STEnum sTEnum;

	public STEnumChanged(nextgen.model.STEnum sTEnum) {
		this.sTEnum = sTEnum;
	}
}  