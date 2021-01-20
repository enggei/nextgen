package nextgen.events;

public final class STGroupActionChanged {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGroupActionChanged.class);

	public static void post(nextgen.model.STGroupAction sTGroupAction) {
		log.info("STGroupActionChanged" + " sTGroupAction");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STGroupActionChanged(sTGroupAction));
	}

	public final nextgen.model.STGroupAction sTGroupAction;

	public STGroupActionChanged(nextgen.model.STGroupAction sTGroupAction) {
		this.sTGroupAction = sTGroupAction;
	}
}  