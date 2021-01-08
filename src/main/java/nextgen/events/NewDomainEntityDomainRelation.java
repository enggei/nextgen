package nextgen.events;

public final class NewDomainEntityDomainRelation {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewDomainEntityDomainRelation.class);

	public static void post(nextgen.model.DomainEntity domainEntity, nextgen.model.DomainRelation domainRelation) {
		log.info("NewDomainEntityDomainRelation" + " domainEntity" + " domainRelation");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewDomainEntityDomainRelation(domainEntity, domainRelation));
	}

	public final nextgen.model.DomainEntity domainEntity;
	public final nextgen.model.DomainRelation domainRelation;

	public NewDomainEntityDomainRelation(nextgen.model.DomainEntity domainEntity, nextgen.model.DomainRelation domainRelation) {
		this.domainEntity = domainEntity;
		this.domainRelation = domainRelation;
	}
}