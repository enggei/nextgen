package nextgen.events;

public final class NewSTProjectDomain {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTProjectDomain.class);

	public static void post(nextgen.model.Domain domain, nextgen.model.STProject stProject) {
		log.info("NewSTProjectDomain" + " domain" + " stProject");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTProjectDomain(domain, stProject));
	}

	public final nextgen.model.Domain domain;
	public final nextgen.model.STProject stProject;

	public NewSTProjectDomain(nextgen.model.Domain domain, nextgen.model.STProject stProject) {
		this.domain = domain;
		this.stProject = stProject;
	}
}