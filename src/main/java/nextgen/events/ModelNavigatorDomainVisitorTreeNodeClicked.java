package nextgen.events;

public final class ModelNavigatorDomainVisitorTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ModelNavigatorDomainVisitorTreeNodeClicked.class);

	public static void post(nextgen.model.DomainVisitor domainVisitor) {
		log.info("ModelNavigatorDomainVisitorTreeNodeClicked" + " domainVisitor");
		org.greenrobot.eventbus.EventBus.getDefault().post(new ModelNavigatorDomainVisitorTreeNodeClicked(domainVisitor));
	}

	public final nextgen.model.DomainVisitor domainVisitor;

	public ModelNavigatorDomainVisitorTreeNodeClicked(nextgen.model.DomainVisitor domainVisitor) {
		this.domainVisitor = domainVisitor;
	}
}