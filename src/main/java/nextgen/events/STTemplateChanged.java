package nextgen.events;

public final class STTemplateChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateChanged.class);

	public static void post(nextgen.model.STTemplate sTTemplate) {
		log.info("STTemplateChanged" + " sTTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STTemplateChanged(sTTemplate));
	}

	public final nextgen.model.STTemplate sTTemplate;

	public STTemplateChanged(nextgen.model.STTemplate sTTemplate) {
		this.sTTemplate = sTTemplate;
	}
}  