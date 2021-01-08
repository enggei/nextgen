package nextgen.events;

public final class DomainChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainChanged.class);

	public static void post(nextgen.model.Domain value) {
		log.info("DomainChanged" + " value");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainChanged(value));
	}

	public final nextgen.model.Domain value;

	public DomainChanged(nextgen.model.Domain value) {
		this.value = value;
	}
}