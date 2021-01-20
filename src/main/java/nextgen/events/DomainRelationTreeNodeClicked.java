package nextgen.events;

public final class DomainRelationTreeNodeClicked {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainRelationTreeNodeClicked.class);

	public static void post(nextgen.model.DomainRelation domainRelation) {
		log.info("DomainRelationTreeNodeClicked" + " domainRelation");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainRelationTreeNodeClicked(domainRelation));
	}

	public final nextgen.model.DomainRelation domainRelation;

	public DomainRelationTreeNodeClicked(nextgen.model.DomainRelation domainRelation) {
		this.domainRelation = domainRelation;
	}
}