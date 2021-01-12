package nextgen.events;

public final class NewDomainVisitor {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewDomainVisitor.class);

	public static void post(nextgen.model.Domain domain, nextgen.model.DomainVisitor visitor) {
		log.info("NewDomainVisitor" + " domain" + " visitor");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewDomainVisitor(domain, visitor));
	}

	public final nextgen.model.Domain domain;
	public final nextgen.model.DomainVisitor visitor;

	public NewDomainVisitor(nextgen.model.Domain domain, nextgen.model.DomainVisitor visitor) {
		this.domain = domain;
		this.visitor = visitor;
	}
}