package nextgen.events;

public final class NewDomainDomainProperty {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewDomainDomainProperty.class);

	public static void post(nextgen.model.Domain domain, nextgen.model.DomainProperty domainProperty) {
		log.info("NewDomainDomainProperty" + " domain" + " domainProperty");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewDomainDomainProperty(domain, domainProperty));
	}

	public final nextgen.model.Domain domain;
	public final nextgen.model.DomainProperty domainProperty;

	public NewDomainDomainProperty(nextgen.model.Domain domain, nextgen.model.DomainProperty domainProperty) {
		this.domain = domain;
		this.domainProperty = domainProperty;
	}
}