package nextgen.events;

public final class DomainEntityChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainEntityChanged.class);

	public static void post(nextgen.model.DomainEntity domainEntity) {
		log.info("DomainEntityChanged" + " domainEntity");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainEntityChanged(domainEntity));
	}

	public final nextgen.model.DomainEntity domainEntity;

	public DomainEntityChanged(nextgen.model.DomainEntity domainEntity) {
		this.domainEntity = domainEntity;
	}
}  