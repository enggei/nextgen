package nextgen.events;

public final class NewDomainDomainEntity {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewDomainDomainEntity.class);

	public static void post(nextgen.model.DomainEntity domainEntity, nextgen.model.Domain domain) {
		log.info("NewDomainDomainEntity" + " domainEntity" + " domain");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewDomainDomainEntity(domainEntity, domain));
	}

	public final nextgen.model.DomainEntity domainEntity;
	public final nextgen.model.Domain domain;

	public NewDomainDomainEntity(nextgen.model.DomainEntity domainEntity, nextgen.model.Domain domain) {
		this.domainEntity = domainEntity;
		this.domain = domain;
	}
}