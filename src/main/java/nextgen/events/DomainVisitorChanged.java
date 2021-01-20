package nextgen.events;

public final class DomainVisitorChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainVisitorChanged.class);

	public static void post(nextgen.model.DomainVisitor domainVisitor) {
		log.info("DomainVisitorChanged" + " domainVisitor");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainVisitorChanged(domainVisitor));
	}

	public final nextgen.model.DomainVisitor domainVisitor;

	public DomainVisitorChanged(nextgen.model.DomainVisitor domainVisitor) {
		this.domainVisitor = domainVisitor;
	}
}  