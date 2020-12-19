package nextgen.events;

public final class NewSTGroupTemplate {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTGroupTemplate.class);

	public static void post(nextgen.model.STTemplate template, nextgen.model.STGroupModel parent) {
		log.info("NewSTGroupTemplate" + " template" + " parent");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTGroupTemplate(template, parent));
	}

	public final nextgen.model.STTemplate template;
	public final nextgen.model.STGroupModel parent;

	public NewSTGroupTemplate(nextgen.model.STTemplate template, nextgen.model.STGroupModel parent) {
		this.template = template;
		this.parent = parent;
	}
}