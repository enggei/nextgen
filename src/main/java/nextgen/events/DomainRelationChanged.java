package nextgen.events;

public final class DomainRelationChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainRelationChanged.class);

	public static void post(nextgen.model.DomainRelation value) {
		log.info("DomainRelationChanged" + " value");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainRelationChanged(value));
	}

	public final nextgen.model.DomainRelation value;

	public DomainRelationChanged(nextgen.model.DomainRelation value) {
		this.value = value;
	}
}