package nextgen.events;

public final class DomainRelationChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainRelationChanged.class);

	public static void post(nextgen.model.DomainRelation domainRelation) {
		log.info("DomainRelationChanged" + " domainRelation");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainRelationChanged(domainRelation));
	}

	public final nextgen.model.DomainRelation domainRelation;

	public DomainRelationChanged(nextgen.model.DomainRelation domainRelation) {
		this.domainRelation = domainRelation;
	}
}  