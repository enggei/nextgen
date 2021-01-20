package nextgen.events;

public final class DomainEntityTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainEntityTreeNodeClicked.class);

	public static void post(nextgen.model.DomainEntity domainEntity) {
		log.info("DomainEntityTreeNodeClicked" + " domainEntity");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainEntityTreeNodeClicked(domainEntity));
	}

	public final nextgen.model.DomainEntity domainEntity;

	public DomainEntityTreeNodeClicked(nextgen.model.DomainEntity domainEntity) {
		this.domainEntity = domainEntity;
	}
}