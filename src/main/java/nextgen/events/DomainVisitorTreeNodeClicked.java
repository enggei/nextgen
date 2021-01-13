package nextgen.events;

public final class DomainVisitorTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainVisitorTreeNodeClicked.class);

	public static void post(nextgen.model.DomainVisitor domainVisitor) {
		log.info("DomainVisitorTreeNodeClicked" + " domainVisitor");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainVisitorTreeNodeClicked(domainVisitor));
	}

	public final nextgen.model.DomainVisitor domainVisitor;

	public DomainVisitorTreeNodeClicked(nextgen.model.DomainVisitor domainVisitor) {
		this.domainVisitor = domainVisitor;
	}
}