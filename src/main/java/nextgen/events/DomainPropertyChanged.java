package nextgen.events;

public final class DomainPropertyChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainPropertyChanged.class);

	public static void post(nextgen.model.DomainProperty value) {
		log.info("DomainPropertyChanged" + " value");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainPropertyChanged(value));
	}

	public final nextgen.model.DomainProperty value;

	public DomainPropertyChanged(nextgen.model.DomainProperty value) {
		this.value = value;
	}
}