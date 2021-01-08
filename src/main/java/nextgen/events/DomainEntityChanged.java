package nextgen.events;

public final class DomainEntityChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainEntityChanged.class);

	public static void post(nextgen.model.DomainEntity value) {
		log.info("DomainEntityChanged" + " value");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainEntityChanged(value));
	}

	public final nextgen.model.DomainEntity value;

	public DomainEntityChanged(nextgen.model.DomainEntity value) {
		this.value = value;
	}
}