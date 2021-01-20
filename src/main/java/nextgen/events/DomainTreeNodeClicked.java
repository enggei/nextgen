package nextgen.events;

public final class DomainTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainTreeNodeClicked.class);

	public static void post(nextgen.model.Domain domain) {
		log.info("DomainTreeNodeClicked" + " domain");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainTreeNodeClicked(domain));
	}

	public final nextgen.model.Domain domain;

	public DomainTreeNodeClicked(nextgen.model.Domain domain) {
		this.domain = domain;
	}
}