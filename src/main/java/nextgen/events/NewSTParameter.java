package nextgen.events;

public final class NewSTParameter {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NewSTParameter.class);

	public static void post(nextgen.model.STParameter stParameter, nextgen.model.STTemplate stTemplate) {
		log.info("NewSTParameter" + " stParameter" + " stTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTParameter(stParameter, stTemplate));
	}

	public final nextgen.model.STParameter stParameter;
	public final nextgen.model.STTemplate stTemplate;

	public NewSTParameter(nextgen.model.STParameter stParameter, nextgen.model.STTemplate stTemplate) {
		this.stParameter = stParameter;
		this.stTemplate = stTemplate;
	}
}