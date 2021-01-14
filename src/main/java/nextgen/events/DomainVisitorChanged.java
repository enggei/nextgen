package nextgen.events;

public final class DomainVisitorChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainVisitorChanged.class);

	public static void post(nextgen.model.DomainVisitor model) {
		log.info("DomainVisitorChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainVisitorChanged(model));
	}

	public final nextgen.model.DomainVisitor model;

	public DomainVisitorChanged(nextgen.model.DomainVisitor model) {
		this.model = model;
	}
}  