package nextgen.events;

public final class DomainEntityChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainEntityChanged.class);

	public static void post(nextgen.model.DomainEntity model) {
		log.info("DomainEntityChanged" + " model");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainEntityChanged(model));
	}

	public final nextgen.model.DomainEntity model;

	public DomainEntityChanged(nextgen.model.DomainEntity model) {
		this.model = model;
	}
}  