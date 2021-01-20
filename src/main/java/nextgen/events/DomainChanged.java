package nextgen.events;

public final class DomainChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainChanged.class);

	public static void post(nextgen.model.Domain domain) {
		log.info("DomainChanged" + " domain");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainChanged(domain));
	}

	public final nextgen.model.Domain domain;

	public DomainChanged(nextgen.model.Domain domain) {
		this.domain = domain;
	}
}  