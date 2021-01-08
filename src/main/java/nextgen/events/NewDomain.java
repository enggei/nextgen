package nextgen.events;

public final class NewDomain {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewDomain.class);

	public static void post(nextgen.model.Domain domain) {
		log.info("NewDomain" + " domain");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewDomain(domain));
	}

	public final nextgen.model.Domain domain;

	public NewDomain(nextgen.model.Domain domain) {
		this.domain = domain;
	}
}