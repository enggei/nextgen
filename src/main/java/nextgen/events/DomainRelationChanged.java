package nextgen.events;

public final class DomainRelationChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainRelationChanged.class);

	public static void post(nextgen.model.DomainRelation model) {
		log.info("DomainRelationChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainRelationChanged(model));
	}

	public final nextgen.model.DomainRelation model;

	public DomainRelationChanged(nextgen.model.DomainRelation model) {
		this.model = model;
	}
}  