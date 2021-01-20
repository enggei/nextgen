package nextgen.events;

public final class DomainEntityTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainEntityTreeNodeClicked.class);

	public static void post(nextgen.model.DomainEntity domainVisitor) {
		log.info("DomainEntityTreeNodeClicked" + " domainVisitor");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainEntityTreeNodeClicked(domainVisitor));
	}

	public final nextgen.model.DomainEntity domainVisitor;

	public DomainEntityTreeNodeClicked(nextgen.model.DomainEntity domainVisitor) {
		this.domainVisitor = domainVisitor;
	}
}