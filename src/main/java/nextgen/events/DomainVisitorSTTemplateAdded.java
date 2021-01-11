package nextgen.events;

public final class DomainVisitorSTTemplateAdded {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainVisitorSTTemplateAdded.class);

	public static void post(nextgen.model.DomainVisitor domainVisitor, nextgen.model.STTemplate stTemplate) {
		log.info("DomainVisitorSTTemplateAdded" + " domainVisitor" + " stTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DomainVisitorSTTemplateAdded(domainVisitor, stTemplate));
	}

	public final nextgen.model.DomainVisitor domainVisitor;
	public final nextgen.model.STTemplate stTemplate;

	public DomainVisitorSTTemplateAdded(nextgen.model.DomainVisitor domainVisitor, nextgen.model.STTemplate stTemplate) {
		this.domainVisitor = domainVisitor;
		this.stTemplate = stTemplate;
	}
}