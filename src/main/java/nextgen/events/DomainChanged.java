package nextgen.events;

public final class DomainChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainChanged.class);

	public static void post(nextgen.model.Domain model) {
		log.info("DomainChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainChanged(model));
	}

	public final nextgen.model.Domain model;

	public DomainChanged(nextgen.model.Domain model) {
		this.model = model;
	}
}  