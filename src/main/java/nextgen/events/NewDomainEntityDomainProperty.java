package nextgen.events;

public final class NewDomainEntityDomainProperty {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewDomainEntityDomainProperty.class);

	public static void post(nextgen.model.DomainEntity domainEntity, nextgen.model.DomainProperty domainProperty) {
		log.info("NewDomainEntityDomainProperty" + " domainEntity" + " domainProperty");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewDomainEntityDomainProperty(domainEntity, domainProperty));
	}

	public final nextgen.model.DomainEntity domainEntity;
	public final nextgen.model.DomainProperty domainProperty;

	public NewDomainEntityDomainProperty(nextgen.model.DomainEntity domainEntity, nextgen.model.DomainProperty domainProperty) {
		this.domainEntity = domainEntity;
		this.domainProperty = domainProperty;
	}
}