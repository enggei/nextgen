package nextgen.events;

public final class NewSTTemplateChild {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTTemplateChild.class);

	public static void post(nextgen.model.STTemplate template, nextgen.model.STTemplate parent) {
		System.out.println("NewSTTemplateChild" + " template" + " parent");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTTemplateChild(template, parent));
	}

	public final nextgen.model.STTemplate template;
	public final nextgen.model.STTemplate parent;

	public NewSTTemplateChild(nextgen.model.STTemplate template, nextgen.model.STTemplate parent) {
		this.template = template;
		this.parent = parent;
	}
}